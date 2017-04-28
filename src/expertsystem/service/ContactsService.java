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
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;

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
		
		MultifieldValue mv = (MultifieldValue) getEnviroment().eval("(find-fact ((?f engine)) TRUE)");
		FactAddressValue factEngine = (FactAddressValue) mv.multifieldValue().get(0);
		String engineState = "";
		try {
			engineState = factEngine.getFactSlot("state").toString();
			System.out.println("Engine state is " + engineState);
		} catch (Exception ex) {
			Logger.getLogger(EngineService.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		//если двигатель заводится
		if (engineState.equals("start") && currentState.equals(CLEAR.getValue())) {
			return FuelSupplyPage.ID;
		} else if (engineState.equals("does-not-start") && currentState.equals(CLEAR.getValue())) {
			return FuelPage.ID;
		} else if (currentState.equals(BURNED.getValue())) {
			fact = addFact(REPLACE_CONTACTS.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(REPLACE_CONTACTS.getValue());
//			getDetailsMap().add(Repair.NAME + REPLACE_CONTACTS.getValue());
//			getEnviroment().eval("(assert (repair \"Replace the points.\"))");
			getEnviroment().assertString("(recom (value \"Replace the points.\"))");
			return RepairPage.ID;
		} else if (currentState.equals(DIRTY.getValue())) {
			fact = addFact(CLEAR_CONTACTS.getFact());
			getEnviroment().assertString(fact);
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
