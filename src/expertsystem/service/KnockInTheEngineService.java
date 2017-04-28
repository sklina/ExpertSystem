package expertsystem.service;

import expertsystem.entity.Ignition;
import expertsystem.page.EntityPage;
import static expertsystem.entity.KnockInTheEngine.State.YES;
import static expertsystem.entity.KnockInTheEngine.State.NO;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.ADJUST_IGNITION;
import static expertsystem.entity.Repair.State.MECHANIC;
import static expertsystem.entity.Repair.State.NO_REPAIR;
import expertsystem.page.RepairPage;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEngineService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		
		if (currentState.equals(YES.getValue())) {
			fact = addFact(ADJUST_IGNITION.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(ADJUST_IGNITION.getValue());
//			getDetailsMap().add(Repair.NAME + ADJUST_IGNITION.getValue());
//			getEnviroment().eval("(assert (repair \"Timing adjustment.\"))");//
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			fact = addFact(MECHANIC.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(MECHANIC.getValue());
//			getDetailsMap().add(Repair.NAME + MECHANIC.getValue());
//			getEnviroment().eval("(assert (repair \"Take your car to a mechanic.\"))");//
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(Ignition.NAME);
	}
}
