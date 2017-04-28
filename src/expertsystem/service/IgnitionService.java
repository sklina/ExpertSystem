package expertsystem.service;

import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Ignition;
import expertsystem.page.EntityPage;
import static expertsystem.entity.Ignition.State.NORM;
import static expertsystem.entity.Ignition.State.NOT_REGULAR;
import static expertsystem.entity.Ignition.State.NO_SPARK;
import expertsystem.entity.Repair;
import expertsystem.page.KnockInTheEnginePage;
import expertsystem.page.RepairPage;
import static expertsystem.entity.Repair.State.ADJUST_CONTACTS;
import expertsystem.entity.Rotation;
/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		
		if (currentState.equals(NO_SPARK.getValue())) {
			fact = addFact(ADJUST_CONTACTS.getFact());
			getEnviroment().eval(fact);
			setRecommendation(ADJUST_CONTACTS.getValue());
//			getDetailsMap().add(Repair.NAME + ADJUST_CONTACTS.getValue());
//			getEnviroment().eval("(assert (repair \"Point gap adjustment.\"))");
			fact = addFact(NOT_REGULAR.getFact());
			getEnviroment().eval(fact);
			getDetailsMap().put(Ignition.NAME , NOT_REGULAR.getValue());
			
			return RepairPage.ID;
		}
		return KnockInTheEnginePage.ID;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
