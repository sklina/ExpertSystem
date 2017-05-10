
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Мощность двигателя
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Power extends Entity {

	public Power() {
		setEntityName("Мощность");
	}
	
	public enum State {
		LOW("Низкая", "Yes"), NORMAL("Нормальная", "No");
		
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
