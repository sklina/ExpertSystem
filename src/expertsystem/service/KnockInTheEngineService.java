
package expertsystem.service;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEngineService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		getEnviroment().eval("(facts)");
		if (currentState.equals("Да")) {
			getEnviroment().eval("(assert (repair \"Timing adjustment.\"))");
			return "RepairPage";
		} else if (currentState.equals("Нет")) {
			getEnviroment().eval("(assert (repair \"Take your car to a mechanic.\"))");
			return "RepairPage";
		}
		
		return null;
	}

}
