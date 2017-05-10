package expertsystem.entity;

import java.util.List;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class Entity {
	
	private String currentState;
	private String entityName;
	
	public abstract List<String> getStates();

	public String getCurrentState() {
		return currentState;
	}

	public final void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public String getEntityName() {
		return entityName;
	}

	protected final void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
}
