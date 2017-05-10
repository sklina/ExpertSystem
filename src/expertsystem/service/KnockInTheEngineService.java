package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.KnockInTheEngine.State.YES;
import static expertsystem.entity.KnockInTheEngine.State.NO;
import static expertsystem.entity.Repair.State.ADJUST_IGNITION;
import static expertsystem.entity.Repair.State.MECHANIC;
import expertsystem.page.KnockInTheEnginePage;
import expertsystem.page.RepairPage;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEngineService extends Service {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		
		if (currentState.equals(YES.getValue())) {
			addQuestionFact(KnockInTheEnginePage.ID, YES.getFact());
			getEnviroment().run(1);

			arrayOfFacts.add("repair \"Timing adjustment.\"");
			setRecommendation(ADJUST_IGNITION.getValue());
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {

			arrayOfFacts.add("repair \"Take your car to a mechanic.\"");
			setRecommendation(MECHANIC.getValue());
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
