
package expertsystem.service;

/**
 * Состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineService extends AbstractService{

	@Override
	public String addFacts(String currentState) {
		
		if (currentState.equals("Да")) {
			setEngineStart(true);
			return "EngineWorkPage";
		} else if (currentState.equals("Нет")) {
			setEngineStart(false);
			getEnviroment().eval("(assert (working-state engine does-not-start)) ");
			return "RotationPage";
		}

		return null;
	}
	
}
