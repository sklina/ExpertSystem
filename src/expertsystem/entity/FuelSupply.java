
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Подача топлива
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupply extends Entity {
	public static final String NAME = "Подача топлива";
	
	public enum State {
		INERT("Подача топлива инертна", ""), IDK("Затрудняюсь ответить", "");
		
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
