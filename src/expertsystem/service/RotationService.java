
package expertsystem.service;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Вращается")) {
			getEnviroment().eval("(assert (rotation-state engine rotates))");
			getEnviroment().eval("(assert (spark-state engine irregular-spark))");
			return "ContactsPage";
		} else if (currentState.equals("Не вращается")) {
			getEnviroment().eval("(assert (rotation-state engine does-not-rotate))");
			getEnviroment().eval("(assert (spark-state engine does-not-spark))");
			return "BatteryChargePage";
		}
		
		return null;
	}

}
