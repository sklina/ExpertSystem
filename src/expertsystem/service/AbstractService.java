
package expertsystem.service;

import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.PrimitiveValue;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractService {
	public static final String PATH = "F:\\AUTOEXPERT.CLP";
	
	private static Environment enviroment = new Environment();
	
	private static boolean engineStart;


	public AbstractService() {
		
		enviroment.load(PATH);
	}

	public abstract String addFacts(String currentState);
	
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
	
}
