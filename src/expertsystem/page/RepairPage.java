
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Repair;
import expertsystem.service.RepairService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairPage extends EntityPage {

	RepairService service = new RepairService();
	
	public RepairPage() {
		setId("RepairPage");
		setTitle("Рекомендация");
		setQuestion("");
		setImageUrl("expertsystem/img/remont2.jpg");
	}
	
	

	@Override
	protected Entity createEntity() {
		return new Repair();
	}

	@Override
	public String getNextPageId() {
		return service.addFacts(getEntity().getCurrentState());
	}

	@Override
	public String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
