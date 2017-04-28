package expertsystem.service;

import expertsystem.entity.Engine;
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
public class EngineService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		if (currentState.equals(YES.getValue())) {
			setEngineStart(true);
			
//			getEnviroment().eval("(facts)");

			getEnviroment().assertString("(engine (state start))");
//			getEnviroment().eval("(facts)");
			
			return EngineWorkPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			setEngineStart(false);
			getEnviroment().assertString("(engine (state does-not-start))");
			fact = addFact(NO.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(Engine.NAME, NO.getValue());
			
			return RotationPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		for (int i = 0; i < getDetailsMap().size(); i++) {
			getDetailsMap().remove(Engine.NAME);
		}
	}
}
