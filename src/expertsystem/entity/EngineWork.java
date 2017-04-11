
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Двигатель
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWork extends Entity {
	enum State {
		Normal("Нормально"), Bad("Неудовлетворительно");
		
		private String value;
		
	    private State(String value) {
			this.value = value;
		} 
		
		public String getValue() {
			return this.value;
		}
	}
	
	@Override
	public List<String> getStates() {
		return Stream.of(State.values()).map(s -> s.getValue()).collect(Collectors.toList());
	}
}