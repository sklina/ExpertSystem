package expertsystem.service;

import expertsystem.entity.Entity;
import expertsystem.page.EntityPage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.sf.clipsrules.jni.Environment;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractService {

	public static final String PATH = "F:\\AUTOEXPERT.CLP";
	private static Environment enviroment = new Environment();
	private static boolean engineStart;
	public static ArrayList<String> facts = new ArrayList<>();
	public static Map<String, String> details = new HashMap<>();
	
	private static String recommendation;
	private String description;

	public static Map<String, String> getDetailsMap() {
		return details;
	}
	
	public static ArrayList<String> getFactsArray() {
		return facts;
	}

	public AbstractService() {

		enviroment.load(PATH);
	}
	
	public final void deleteLastFact() {
		
	}

	public final String addFact(String fact) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder
				.append("(assert (")
				.append(fact)
				.append("))");
		facts.add(stringBuilder.toString());
		
		return stringBuilder.toString();
	}

	public abstract String getNextPageId(EntityPage page);
	public abstract void getPrevPageId(EntityPage page);

	protected void runClips() {
		enviroment.run();
	}

	public Environment getEnviroment() {
		return enviroment;
	}

	public boolean isEngineStart() {
		return engineStart;
	}

	public void setEngineStart(boolean engineStart) {
		this.engineStart = engineStart;
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
	
}
