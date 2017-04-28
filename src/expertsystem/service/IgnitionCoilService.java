package expertsystem.service;

import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Ignition;
import expertsystem.page.EntityPage;
import static expertsystem.entity.IgnitionCoil.State.YES;
import static expertsystem.entity.IgnitionCoil.State.NO;
import expertsystem.entity.Power;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.REPLACE_WIRES;
import static expertsystem.entity.Repair.State.REPLACE_COIL;
import expertsystem.page.RepairPage;
import static expertsystem.service.AbstractService.getDetailsMap;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		
		String currentState = page.getEntity().getCurrentState();
		String fact;
		if (currentState.equals(YES.getValue())) {
			fact = addFact(REPLACE_WIRES.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(REPLACE_WIRES.getValue());
//			getDetailsMap().add(Repair.NAME + REPLACE_WIRES.getValue());
//			getEnviroment().eval("(assert (repair \"Repair the distributor lead wire.\"))");//
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			fact = addFact(REPLACE_COIL.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(REPLACE_COIL.getValue());
//			getDetailsMap().add(Repair.NAME + REPLACE_COIL.getValue());
//			getEnviroment().eval("(assert (repair \"Replace the ignition coil.\"))");//
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(BatteryCharge.NAME);
	}
}
