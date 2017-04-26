package expertsystem.service;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;
import net.sf.clipsrules.jni.PrimitiveValue;

/**
 * состояние
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsService extends AbstractService {

	@Override
	public String addFacts(String currentState) {

		
		if (!isEngineStart() && currentState.equals("Чистые")) {
			return "FuelPage";
		} else if (!isEngineStart() && currentState.equals("Опаленные")) {
			getEnviroment().eval("(assert (repair \"Replace the points.\"))");
			return "RepairPage";
		} else if (!isEngineStart() && currentState.equals("Грязные")) {
			getEnviroment().eval("(assert (repair \"Clean the points.\"))");
			return "RepairPage";
		}
		
		//если двигатель заводится
		if (isEngineStart() && currentState.equals("Чистые")) {
			return "FuelSupplyPage";
		} else if (isEngineStart() && currentState.equals("Опаленные")) {
			getEnviroment().eval("(assert (repair \"Replace the points.\"))");
			return "RepairPage";
		} else if (isEngineStart() && currentState.equals("Грязные")) {
			getEnviroment().eval("(assert (repair \"Clean the points.\"))");
			return "RepairPage";
		}
		
		return null;
	}

}
