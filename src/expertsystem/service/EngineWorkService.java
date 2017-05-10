package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.EngineWork.State.NORMAL;
import static expertsystem.entity.EngineWork.State.BAD;
import static expertsystem.entity.Repair.State.NO_REPAIR;
import expertsystem.page.EngineWorkPage;
import expertsystem.page.PowerPage;
import expertsystem.page.RepairPage;

/**
 * Рабочее состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		if (currentState.equals(NORMAL.getValue())) {
			addQuestionFact(EngineWorkPage.ID, NORMAL.getFact());
			getEnviroment().run(1);
			setRecommendation(NO_REPAIR.getValue());
			
			arrayOfFacts.add("working-state engine normal");
			arrayOfFacts.add("charge-state battery charged");
			arrayOfFacts.add("rotation-state engine rotates");
			arrayOfFacts.add("repair \"No repair needed.\"");
			return RepairPage.ID;
		} else if (currentState.equals(BAD.getValue())) {
			addQuestionFact(EngineWorkPage.ID, BAD.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("working-state engine unsatisfactory");
			return PowerPage.ID;
		}
		
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {

	}
}
