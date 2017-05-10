package expertsystem.service;

import expertsystem.page.EntityPage;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import net.sf.clipsrules.jni.Environment;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class EntityService {

	/** WARNING! Путь не должен содержать кириллицу, так как Клипс ее не распознает. */
	public static final String PATH = "F:\\test.CLP";
	private static Environment enviroment;
	public static ArrayList<String> arrayOfFacts = new ArrayList<>();
	public static Map<String, String> mapOfDetais = new HashMap<>();

	private static String recommendation;
	private String description;

	public EntityService() {
		if (enviroment == null) {
			createEnviroment();
		}
	}

	private void createEnviroment() {
		enviroment = new Environment();
		enviroment.load(PATH);
		enviroment.reset();
		enviroment.run(1);

	}

	public final void addFact(String fact) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("(")
				.append(fact)
				.append(")");
		arrayOfFacts.add(stringBuilder.toString());

		//add to clips
		getEnviroment().assertString(stringBuilder.toString());

	}

	public abstract String getNextPageId(EntityPage page);
	public abstract void getPrevPageId(EntityPage page);

	public Environment getEnviroment() {
		return enviroment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRecommendation() {
		return recommendation;
	}

	public void setRecommendation(String recommendation) {
		this.recommendation = recommendation;
	}

	private static final Map<String, String> pageAndNameMap;

	static {
		Map<String, String> aMap = new HashMap<>();
		aMap.put("BatteryChargePage", "Is the battery charged?");
		aMap.put("ContactsPage", "What is the surface state of the points?");
		aMap.put("EngineWorkPage", "Does the engine run normally?");
		aMap.put("FuelPage", "Does the tank have any gas in it?");
		aMap.put("FuelSupplyPage", "Is the engine sluggish?");
		aMap.put("IgnitionCoilPage", "Is the conductivity test for the ignition coil positive?");
		aMap.put("IgnitionPage", "Does the engine misfire?");
		aMap.put("KnockInTheEnginePage", "Does the engine knock?");
		aMap.put("PowerPage", "Is the output of the engine low?");
		aMap.put("RotationPage", "Does the engine rotate?");
		pageAndNameMap = Collections.unmodifiableMap(aMap);
	}

	public void addQuestionFact(String pageId, String value) {
		String val = "(question (text \"" + pageAndNameMap.get(pageId) + "\")(value " + value + "))";
		getEnviroment().assertString(val);
	}

}
