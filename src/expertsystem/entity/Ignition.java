package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Система зажигания
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Ignition extends Entity{

	public Ignition() {
		setEntityName("Система зажигания");
	}

	public enum State {
		NORM("Зажигание в порядке", ""), 
		NOT_REGULAR("Искра нерегулярна", ""), 
		NO_SPARK("Искры нет", "Yes");

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
