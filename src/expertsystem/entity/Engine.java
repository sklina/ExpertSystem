
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Состояние двигателя
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Engine extends Entity {

	public Engine() {
		setEntityName("Состояние двигателя");
	}
	
	public enum State {
		YES("Заводится", "start"), NO("Не заводится", "does-not-start");
		
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
