package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.IgnitionCoil.State.YES;
import static expertsystem.entity.IgnitionCoil.State.NO;
import static expertsystem.entity.Repair.State.REPLACE_WIRES;
import static expertsystem.entity.Repair.State.REPLACE_COIL;
import expertsystem.page.IgnitionCoilPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		
		String currentState = page.getEntity().getCurrentState();
		if (currentState.equals(YES.getValue())) {
			addQuestionFact(IgnitionCoilPage.ID, YES.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("repair \"Repair the distributor lead wire.\"");
			setRecommendation(REPLACE_WIRES.getValue());
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			addQuestionFact(IgnitionCoilPage.ID, NO.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("repair \"Replace the ignition coil.\"");
			setRecommendation(REPLACE_COIL.getValue());
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
