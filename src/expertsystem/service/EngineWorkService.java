
package expertsystem.service;

/**
 * Рабочее состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Нормально")) {
			
			getEnviroment().eval("(assert (working-state engine normal) )");
			getEnviroment().eval("(assert (repair \"No repair needed.\"))");
			getEnviroment().eval("(assert (spark-state engine normal))");
			getEnviroment().eval("(assert (charge-state battery charged))");
			getEnviroment().eval("(assert (rotation-state engine rotates))");
			return "RepairPage";
		} else if (currentState.equals("Неудовлетворительно")) {
			getEnviroment().eval("(assert (working-state engine unsatisfactory) )");
			getEnviroment().eval("(assert (charge-state battery charged))");
			getEnviroment().eval("(assert (rotation-state engine rotates))");
			return "PowerPage";
		}
		
		return null;
	}

}
