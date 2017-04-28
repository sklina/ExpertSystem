package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.FuelSupply.State.INERT;
import static expertsystem.entity.FuelSupply.State.IDK;
import expertsystem.entity.Power;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.CLEAR_FUEL_LINE;
import expertsystem.page.IgnitionPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		if (currentState.equals(INERT.getValue())) {
			fact = addFact(CLEAR_FUEL_LINE.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(CLEAR_FUEL_LINE.getValue());
//			getDetailsMap().add(Repair.NAME + CLEAR_FUEL_LINE.getValue());
//			getEnviroment().eval("(assert (repair \"Clean the fuel line.\"))");//
			return RepairPage.ID;
		} else if (currentState.equals(IDK.getValue())) {
			return IgnitionPage.ID;
		}
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(Power.NAME);
	}
}
