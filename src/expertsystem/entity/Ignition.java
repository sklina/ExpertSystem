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

	enum State {
		NORM("Зажигание в порядке"), NOT_REGULAR("Искра нерегулярна"), NO_SPARK("Искры нет");

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
