
package expertsystem.service;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineService extends AbstractService{

	@Override
	public String addFacts(String currentState) {
		if (currentState.equals("Да"))
			clips.eval("(assert (working-state engine normal) )");
		else if (currentState.equals("Нет"))
			clips.eval("(assert (symptom engine low-output))");
		clips.run();
		String buf = clips.getInputBuffer();
		System.out.println(buf);
		return "EngineWorkPage";
	}
	
}
