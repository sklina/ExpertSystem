package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.Fuel.State.YES;
import static expertsystem.entity.Fuel.State.NO;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.MECHANIC;
import static expertsystem.entity.Repair.State.ADD_GASS;
import expertsystem.page.RepairPage;

/**
 * сосотояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		if (currentState.equals(YES.getValue())) {
			fact = addFact(MECHANIC.getFact());
			getEnviroment().eval(fact);
			setRecommendation(MECHANIC.getValue());
//			getDetailsMap().add(Repair.NAME + MECHANIC.getValue());
//			getEnviroment().eval("(assert (repair \"Take your car to a mechanic.\"))");//
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			fact = addFact(ADD_GASS.getFact());
			getEnviroment().eval(fact);
			setRecommendation(ADD_GASS.getValue());
//			getDetailsMap().add(Repair.NAME + ADD_GASS.getValue());
//			getEnviroment().eval("(assert (repair \"Add g a s . \" ))");//
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
