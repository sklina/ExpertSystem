package expertsystem.service;

import static expertsystem.entity.Contacts.State.BURNED;
import static expertsystem.entity.Contacts.State.CLEAR;
import static expertsystem.entity.Contacts.State.DIRTY;
import static expertsystem.entity.Repair.State.CLEAR_CONTACTS;
import static expertsystem.entity.Repair.State.REPLACE_CONTACTS;
import expertsystem.page.ContactsPage;
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
public class ContactsService extends EntityService {


    @Override
    public String getNextPageId(EntityPage page) {
        String currentState = page.getEntity().getCurrentState();
        String engineState = getEngineState();

        //если двигатель заводится
        if (engineState.equals("start") && currentState.equals(CLEAR.getValue())) {
            return FuelSupplyPage.ID;
        } else if (engineState.equals("does-not-start") && currentState.equals(CLEAR.getValue())) {
            return FuelPage.ID;
        } else if (currentState.equals(BURNED.getValue())) {
            addQuestionFact(ContactsPage.ID, BURNED.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("repair \"Replace the points.\"");
            setRecommendation(REPLACE_CONTACTS.getValue());
            return RepairPage.ID;
        } else if (currentState.equals(DIRTY.getValue())) {
            addQuestionFact(ContactsPage.ID, DIRTY.getFact());
			getEnviroment().run(1);

			arrayOfFacts.add("repair \"Clean the points.\"");
            setRecommendation(CLEAR_CONTACTS.getValue());
            return RepairPage.ID;
        }

        return null;
    }

    @Override
    public void getPrevPageId(EntityPage page) {

    }
    
    
    private String getEngineState() {
        String engineState = "";
        MultifieldValue mv = (MultifieldValue) getEnviroment().eval("(find-fact ((?f engine)) TRUE)");
        FactAddressValue factEngine = (FactAddressValue) mv.multifieldValue().get(0);

        try {
            engineState = factEngine.getFactSlot("state").toString();
            System.out.println("Engine state is " + engineState);
        } catch (Exception ex) {
            Logger.getLogger(EngineService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return engineState;
    }
}
