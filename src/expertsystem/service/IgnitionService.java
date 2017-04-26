
package expertsystem.service;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Искры нет")) {
			getEnviroment().eval("(assert (repair \"Point gap adjustment.\"))");
			getEnviroment().eval("(assert (spark-state engine irregular-spark))");
			return "RepairPage";
		}
		
		return "KnockInTheEnginePage";
	}

}
