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
		StringBuilder sb = new StringBuilder();
		 for(Entry<String,String> entry: getDetailsMap().entrySet()){
			 sb.append(entry.getKey()).append(entry.getValue()).append("\n");
		 }
		
		
		setDescription(sb.toString());
		runClips();

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
