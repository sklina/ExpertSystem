package expertsystem.service;

import expertsystem.page.EntityPage;
import java.util.List;
import net.sf.clipsrules.jni.FactAddressValue;
import net.sf.clipsrules.jni.MultifieldValue;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairService extends Service {

	@Override
	public String getNextPageId(EntityPage page) {

		System.out.println();

		getEnviroment().run();
		deleteFacts();
		
		StringBuilder stringBuilder = new StringBuilder();
		for(int i = 0; i < arrayOfFacts.size(); i++) {		
			stringBuilder
					.append((i+1)).append(". ")
					.append(arrayOfFacts.get(i))
					.append("\n");
		}
		setDescription(stringBuilder.toString());
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		throw new UnsupportedOperationException("Repair page should not have a Previous Page.");
	}

	public void deleteFacts() {		
		long index;
		MultifieldValue value = (MultifieldValue) getEnviroment()
				.eval("(find-all-facts((?f question)) TRUE)");
		List<FactAddressValue> list = value
				.multifieldValue();
		for (FactAddressValue fact : list) {
			index = fact.getFactIndex();
			getEnviroment()
					.eval("(retract " + index + ")");
		}

		value = (MultifieldValue) getEnviroment()
				.eval("(find-fact((?f engine)) TRUE)");
		index = ((FactAddressValue) value.get(0)).getFactIndex();
		getEnviroment()
				.eval("(retract " + index + ")");
		value = (MultifieldValue) getEnviroment()
				.eval("(find-fact((?f recom)) TRUE)");
		index = ((FactAddressValue) value.get(0)).getFactIndex();
			getEnviroment()
				.eval("(retract " + index + ")");

	}
}
