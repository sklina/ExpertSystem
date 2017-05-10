package expertsystem.service;

import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Engine;
import expertsystem.entity.EngineWork;
import expertsystem.entity.Ignition;
import expertsystem.entity.Power;
import expertsystem.page.EntityPage;
import static expertsystem.entity.Power.State.NORMAL;
import static expertsystem.entity.Power.State.LOW;
import expertsystem.entity.Rotation;
import expertsystem.page.ContactsPage;
import expertsystem.page.FuelSupplyPage;
import expertsystem.page.PowerPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		
		if (currentState.equals(LOW.getValue())) {
			addQuestionFact(PowerPage.ID, LOW.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("symptom engine low-output");
			return ContactsPage.ID;
		} else if (currentState.equals(NORMAL.getValue())) {
			addQuestionFact(PowerPage.ID, NORMAL.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("symptom engine not-low-output");
			return FuelSupplyPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
