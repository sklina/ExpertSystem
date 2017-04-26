
package expertsystem.service;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyService extends AbstractService {

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Подача топлива инертна")) {
			getEnviroment().eval("(assert (repair \"Clean the fuel line.\"))");
			return "RepairPage";
		} else if (currentState.equals("Затрудняюсь ответить")) {
			return "IgnitionPage";
		}
		
		return null;
	}

}
