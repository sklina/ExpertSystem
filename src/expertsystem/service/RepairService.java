package expertsystem.service;

import expertsystem.page.EntityPage;
import java.util.Map.Entry;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairService extends AbstractService {

	@Override
	public String getNextPageId(EntityPage page) {
		StringBuilder stringBuilder = new StringBuilder();
		int num = 1;
		 for(Entry<String,String> entry: getDetailsMap().entrySet()){
			 stringBuilder
					 .append(num++)
					 .append(". ")
					 .append(entry.getKey())
					 .append(" -> ")
					 .append(entry.getValue())
					 .append("\n");
		 }
				
		setDescription(stringBuilder.toString());
		runClips();

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
