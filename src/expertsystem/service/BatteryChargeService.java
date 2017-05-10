package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.BatteryCharge.State.CHARGE;
import static expertsystem.entity.BatteryCharge.State.NOT_CHARGE;
import static expertsystem.entity.Repair.State.CHARGE_BATTERY;
import expertsystem.page.BatteryChargePage;
import expertsystem.page.IgnitionCoilPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class BatteryChargeService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		if (currentState.equals(CHARGE.getValue())) {
			addQuestionFact(BatteryChargePage.ID, CHARGE.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("charge-state battery charged");
			return IgnitionCoilPage.ID;
		} else if (currentState.equals(NOT_CHARGE.getValue())) {
			addQuestionFact(BatteryChargePage.ID, NOT_CHARGE.getFact());
			getEnviroment().run(1);

			arrayOfFacts.add("charge-state battery dead");
			arrayOfFacts.add("repair \"Charge the battery.\"");
			setRecommendation(CHARGE_BATTERY.getValue());
			return RepairPage.ID;
		}
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		
	}
}
