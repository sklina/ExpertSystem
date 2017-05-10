package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.Rotation.State.ROTATE;
import static expertsystem.entity.Rotation.State.NO_ROTATE;
import expertsystem.page.BatteryChargePage;
import expertsystem.page.ContactsPage;
import expertsystem.page.RotationPage;


/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationService extends Service {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		
		if (currentState.equals(ROTATE.getValue())) {
			addQuestionFact(RotationPage.ID, ROTATE.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("rotation-state engine rotates");
			arrayOfFacts.add("spark-state engine irregular-spark");
			return ContactsPage.ID;
		} else if (currentState.equals(NO_ROTATE.getValue())) {
			addQuestionFact(RotationPage.ID, NO_ROTATE.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("rotation-state does-not-rotate");
			arrayOfFacts.add("spark-state engine  does-not-spark");
			return BatteryChargePage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
