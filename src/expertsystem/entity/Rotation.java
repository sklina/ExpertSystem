
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Вращение двигателя
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Rotation extends Entity {
	public static final String NAME = "Вращение двигателя";
	
	public enum State {
		ROTATE("Вращается", "rotation-state engine rotates"), 
		NO_ROTATE("Не вращается", "rotation-state engine does-not-rotate");
		
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
