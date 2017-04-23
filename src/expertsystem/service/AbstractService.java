
package expertsystem.service;

import net.sf.clipsrules.jni.Environment;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractService {
	Environment clips;
	public static final String PATH = "F:\\AUTOEXPERT.CLP";
	public AbstractService() {
		clips = new Environment();
		clips.load(PATH);
		clips.reset();
//		clips.run();
				
		
	}

	public abstract String addFacts(String currentState);
}
