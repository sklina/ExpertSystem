package expertsystem.service;

import static expertsystem.entity.Contacts.State.BURNED;
import static expertsystem.entity.Contacts.State.CLEAR;
import static expertsystem.entity.Contacts.State.DIRTY;
import expertsystem.entity.Ignition;
import expertsystem.entity.Power;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.CLEAR_CONTACTS;
import static expertsystem.entity.Repair.State.REPLACE_CONTACTS;
import expertsystem.entity.Rotation;
import expertsystem.page.EntityPage;
import expertsystem.page.FuelPage;
import expertsystem.page.FuelSupplyPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		//если двигатель заводится
		if (isEngineStart() && currentState.equals(CLEAR.getValue())) {
			return FuelSupplyPage.ID;
		} else if (!isEngineStart() && currentState.equals(CLEAR.getValue())) {
			return FuelPage.ID;
		} else if (currentState.equals(BURNED.getValue())) {
			fact = addFact(REPLACE_CONTACTS.getFact());
			getEnviroment().eval(fact);
			setRecommendation(REPLACE_CONTACTS.getValue());
//			getDetailsMap().add(Repair.NAME + REPLACE_CONTACTS.getValue());
//			getEnviroment().eval("(assert (repair \"Replace the points.\"))");
			
			return RepairPage.ID;
		} else if (currentState.equals(DIRTY.getValue())) {
			fact = addFact(CLEAR_CONTACTS.getFact());
			getEnviroment().eval(fact);
			setRecommendation(CLEAR_CONTACTS.getValue());
//			getDetailsMap().add(Repair.NAME + CLEAR_CONTACTS.getValue());
//			getEnviroment().eval("(assert (repair \"Clean the points.\"))");
			
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(Power.NAME);
		getDetailsMap().remove(Rotation.NAME);
		getDetailsMap().remove(Ignition.NAME);
		
	}
}
