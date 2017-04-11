package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class Entity {
	
//	private String id;
//	private String question;
	private String currentState;
	
	public abstract List<String> getStates();

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}
	
}