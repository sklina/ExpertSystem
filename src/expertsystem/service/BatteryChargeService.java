package expertsystem.service;

import expertsystem.entity.BatteryCharge;
import expertsystem.page.EntityPage;
import static expertsystem.entity.BatteryCharge.State.CHARGE;
import static expertsystem.entity.BatteryCharge.State.NOT_CHARGE;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.CHARGE_BATTERY;
import static expertsystem.entity.Repair.State.NO_REPAIR;
import expertsystem.page.IgnitionCoilPage;
import expertsystem.page.IgnitionPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class BatteryChargeService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		if (currentState.equals(CHARGE.getValue())) {
			fact = addFact(CHARGE.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(BatteryCharge.NAME, CHARGE.getValue());

			return IgnitionCoilPage.ID;
		} else if (currentState.equals(NOT_CHARGE.getValue())) {
			fact = addFact(NOT_CHARGE.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(BatteryCharge.NAME, NOT_CHARGE.getValue());
			fact = addFact(CHARGE_BATTERY.getFact());
			getEnviroment().assertString(fact);
//			getDetailsMap().add(Repair.NAME + CHARGE_BATTERY.getValue());
			setRecommendation(CHARGE_BATTERY.getValue());
//			getEnviroment().eval("(assert (repair \"Charge the battery.\"))");

			return RepairPage.ID;
		}
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {

	}
}
