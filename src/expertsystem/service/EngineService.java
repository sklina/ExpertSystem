package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.Engine.State.YES;
import static expertsystem.entity.Engine.State.NO;
import expertsystem.page.EngineWorkPage;
import expertsystem.page.RotationPage;

/**
 * Состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();	
		if (currentState.equals(YES.getValue())) {
			//set engine state
			getEnviroment().assertString("(engine (state start))");
			
			return EngineWorkPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			//set engine state
			getEnviroment().assertString("(engine (state does-not-start))");
			getEnviroment().assertString("(working-state engine does-not-start)");
			
			arrayOfFacts.add("working-state engine does-not-start");
			return RotationPage.ID;
		}
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
