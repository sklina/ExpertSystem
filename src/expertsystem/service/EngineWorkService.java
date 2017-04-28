package expertsystem.service;

import expertsystem.entity.BatteryCharge;
import expertsystem.page.EntityPage;
import static expertsystem.entity.EngineWork.State.NORMAL;
import static expertsystem.entity.EngineWork.State.BAD;
import static expertsystem.entity.BatteryCharge.State.CHARGE;
import expertsystem.entity.Engine;
import static expertsystem.entity.Engine.State.NO;
import expertsystem.entity.EngineWork;
import expertsystem.entity.Ignition;
import static expertsystem.entity.Rotation.State.ROTATE;
import static expertsystem.entity.Ignition.State.NORM;
import expertsystem.entity.Repair;
import static expertsystem.entity.Repair.State.NO_REPAIR;
import expertsystem.entity.Rotation;
import expertsystem.page.PowerPage;
import expertsystem.page.RepairPage;
import static expertsystem.service.AbstractService.getDetailsMap;

/**
 * Рабочее состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		String fact;
		fact = addFact(CHARGE.getFact());
		getEnviroment().assertString(fact);
		getDetailsMap().put(BatteryCharge.NAME , CHARGE.getValue());
		fact = addFact(ROTATE.getFact());
		getEnviroment().assertString(fact);
		getDetailsMap().put(Rotation.NAME, ROTATE.getValue());
		if (currentState.equals(NORMAL.getValue())) {
			fact = addFact(NORMAL.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(EngineWork.NAME , NORMAL.getValue());
			
			fact = addFact(NO_REPAIR.getFact());
			getEnviroment().assertString(fact);
			setRecommendation(NO_REPAIR.getValue());
//			getDetailsMap().add(Repair.NAME + NO_REPAIR.getValue());
//			getEnviroment().eval("(assert (repair \"No repair needed.\"))");//
			fact = addFact(NORM.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(Ignition.NAME , NORM.getValue());
			return RepairPage.ID;
		} else if (currentState.equals(BAD.getValue())) {
			fact = addFact(BAD.getFact());
			getEnviroment().assertString(fact);
			getDetailsMap().put(EngineWork.NAME , BAD.getValue());
			return PowerPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		
	}
}
