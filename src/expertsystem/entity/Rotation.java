
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Вращение двигателя
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Rotation extends Entity {
	enum State {
		Rotate("Вращается"), NoRotate("Не вращается");
		
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