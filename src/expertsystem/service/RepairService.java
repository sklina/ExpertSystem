package expertsystem.service;

import expertsystem.page.EntityPage;
import java.util.List;
import java.util.Map.Entry;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;
import net.sf.clipsrules.jni.PrimitiveValue;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		StringBuilder stringBuilder = new StringBuilder();
		int num = 1;
		for (Entry<String, String> entry : getDetailsMap().entrySet()) {
			stringBuilder
					.append(num++)
					.append(". ")
					.append(entry.getKey())
					.append(" -> ")
					.append(entry.getValue())
					.append("\n");
		}

		for (String s : getFactsArray()){
			System.out.println(s);
		}
		setDescription(stringBuilder.toString());
//		getEnviroment().eval("(facts)");
//		PrimitiveValue val = getEnviroment().eval("(find-all-facts ((?f engine)) TRUE)");
//		FactAddressValue factAddressValue = (FactAddressValue) val.getValue();
//		MultifieldValue currentStateMultifieldValue = (MultifieldValue) getEnviroment()
//				.eval("(find-fact ((?f state)) TRUE)");
//		List<FactAddressValue> currentStateList = currentStateMultifieldValue
//				.multifieldValue();

		runClips();
				getEnviroment().eval("(facts)");
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
