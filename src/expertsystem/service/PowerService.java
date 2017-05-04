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
import static expertsystem.service.AbstractService.getDetailsMap;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		
		if (currentState.equals(LOW.getValue())) {
			fact = addFact(LOW.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(Power.NAME , LOW.getValue());
			
			return ContactsPage.ID;
		} else if (currentState.equals(NORMAL.getValue())) {
			fact = addFact(NORMAL.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(Power.NAME , NORMAL.getValue());
			
			return FuelSupplyPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(Rotation.NAME);
		getDetailsMap().remove(BatteryCharge.NAME);
		getDetailsMap().remove(Ignition.NAME);
		getDetailsMap().remove(EngineWork.NAME);
	}
}
