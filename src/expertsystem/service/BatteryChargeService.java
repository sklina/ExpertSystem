package expertsystem.service;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class BatteryChargeService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Да")) {
			getEnviroment().eval("(assert (charge-state battery charged))");
			return "IgnitionCoilPage";
		} else if (currentState.equals("Нет")) {
			getEnviroment().eval("(assert (repair \"Charge the battery.\"))");
			getEnviroment().eval("(assert (charge-state battery dead))");
			return "RepairPage";
		}
		return null;
	}

}
