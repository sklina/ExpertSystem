package expertsystem.service;

import expertsystem.entity.Engine;
import expertsystem.entity.Ignition;
import expertsystem.page.EntityPage;
import static expertsystem.entity.Rotation.State.ROTATE;
import static expertsystem.entity.Rotation.State.NO_ROTATE;
import static expertsystem.entity.Ignition.State.NOT_REGULAR;
import static expertsystem.entity.Ignition.State.NO_SPARK;
import expertsystem.entity.Rotation;
import expertsystem.page.BatteryChargePage;
import expertsystem.page.ContactsPage;
import static expertsystem.service.AbstractService.getDetailsMap;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		
		if (currentState.equals(ROTATE.getValue())) {
			fact = addFact(ROTATE.getFact());
			getEnviroment().eval(fact);
			getDetailsMap().put(Rotation.NAME , ROTATE.getValue());
			fact = addFact(NOT_REGULAR.getFact());
			getEnviroment().eval(fact);
			getDetailsMap().put(Ignition.NAME , NOT_REGULAR.getValue());
			
			return ContactsPage.ID;
		} else if (currentState.equals(NO_ROTATE.getValue())) {
			fact = addFact(NO_ROTATE.getFact());
			getEnviroment().eval(fact);
			getDetailsMap().put(Rotation.NAME , NO_ROTATE.getValue());
			fact = addFact(NO_SPARK.getFact());
			getEnviroment().eval(fact);
			getDetailsMap().put(Ignition.NAME , NO_SPARK.getValue());
			
			return BatteryChargePage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		getDetailsMap().remove(Engine.NAME);
	}
}
