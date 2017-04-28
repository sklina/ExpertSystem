
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Repair;
import expertsystem.service.RepairService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairPage extends EntityPage {

	public static final String ID = "RepairPage";
	
	RepairService service = new RepairService();
	
	public RepairPage() {
		setName("Рекомендация");
		
		setImageUrl("expertsystem/img/remont2.jpg");
	}

	

	@Override
	protected Entity createEntity() {
		return new Repair();
	}

	@Override
	public String getNextPageId() {
		String res = service.getNextPageId(this);
		setDescription(service.getDescription());
		setQuestion(service.getRecommendation());
		return res;
	}

	@Override
	public String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


}
