
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Контакты
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Contacts extends Entity {

	public Contacts() {
		setEntityName("Контакты");
	}
	
	public enum State {
		CLEAR("Чистые", ""), BURNED("Опаленные", "burned"), DIRTY("Грязные", "contaminated");
		
		private String value;
		private String fact;
		
	    private State(String value, String fact) {
			this.value = value;
			this.fact = fact;
		} 
		
		public String getValue() {
			return this.value;
		}
		
		public String getFact() {
			return this.fact;
		}
	}
	
	@Override
	public List<String> getStates() {
		return Stream.of(State.values()).map(s -> s.getValue()).collect(Collectors.toList());
	}
}
