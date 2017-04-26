
package expertsystem.service;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Да")) {
			getEnviroment().eval("(assert (repair \"Repair the distributor lead wire.\"))");
			return "RepairPage";
		} else if (currentState.equals("Нет")) {
			getEnviroment().eval("(assert (repair \"Replace the ignition coil.\"))");
			return "RepairPage";
		}
		
		return null;
	}

}
