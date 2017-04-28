
package expertsystem.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Рекомендация по ремонту
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class Repair extends Entity {
	public static final String NAME = "Рекомендация";
	 
	public enum State {
		MECHANIC("Отвезите Ваш автомобиль к механику", "repair \"Take your car to a mechanic.\""), 
		CHARGE_BATTERY("Вам следует зарядить аккумулятор", "repair \"Charge the battery.\""),
		ADD_GASS("Вам следует заправиться", "repair \"Add g a s . \""), 
		REPLACE_CONTACTS("Вам следует заменить контакты", "repair \"Replace the points.\""),
		CLEAR_CONTACTS("Вам следует очистить контакты", "repair \"Clean the points.\""), 
		REPLACE_COIL("Вам следует заменить катушку зажигания", "repair \"Replace the ignition coil.\""),
		REPLACE_WIRES("Вам следует заменить распределительные провода", "repair \"Repair the distributor lead wire.\""), 
		CLEAR_FUEL_LINE("Вам следует очистить топливную систему", "repair \"Clean the fuel line.\""),
		ADJUST_CONTACTS("Вам следует отрегулировать зазоры между контактами", "repair \"Point gap adjustment.\""), 
		ADJUST_IGNITION("Вам следует отрегулировать положение зажигания", "repair \"Timing adjustment.\""),
		NO_REPAIR("Ремонт не требуется.", "repair \"No repair needed.\"");
		
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
