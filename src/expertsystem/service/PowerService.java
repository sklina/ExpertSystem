
package expertsystem.service;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Низкая")) {
			getEnviroment().eval("(assert (symptom engine low-output))");
			return "ContactsPage";
		} else if (currentState.equals("Нормальная")) {
			getEnviroment().eval("(assert (symptom engine not-low-output))");
			return "FuelSupplyPage";
		}
		
		return null;
	}

}
