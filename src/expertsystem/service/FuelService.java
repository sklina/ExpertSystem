
package expertsystem.service;

/**
 * сосотояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		getEnviroment().eval("(facts)");
		if (currentState.equals("Есть")) {
			getEnviroment().eval("(assert (repair \"Take your car to a mechanic.\"))");
			return "RepairPage";
		} else if (currentState.equals("Нет")) {
			getEnviroment().eval("(assert (repair \"Add g a s . \" ))");
			return "RepairPage";
		}
		
		return null;
	}

}
