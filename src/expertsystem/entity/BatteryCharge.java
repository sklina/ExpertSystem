
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Заряд аккумулятора
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class BatteryCharge extends Entity{

	public static final String NAME = "Заряд аккумулятора";
	public enum State {
		CHARGE("Заряжен", "charge-state battery charged"), NOT_CHARGE("Не заряжен","charge-state battery dead");
		
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
