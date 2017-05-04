
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Рабочее состояние двигателя
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWork extends Entity {
	public static final String NAME = "Рабочее состояние двигателя";
	
	public enum State {
		NORMAL("Нормально", "working-state engine normal"), BAD("Неудовлетворительно", "working-state engine unsatisfactory");
		
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
