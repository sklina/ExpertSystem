
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Repair;
import expertsystem.service.EntityService;
import expertsystem.service.RepairService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairPage extends EntityPage {

	public static final String ID = "RepairPage";
	
	public RepairPage() {
		setTitle(getEntity().getEntityName());
		setImageUrl("expertsystem/img/remont2.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Repair();
	}
	
	@Override
	protected EntityService createService() {
		return new RepairService();
	}

	@Override
	public String getNextPageId() {
		String res = getService().getNextPageId(this);
		setDescription(getService().getDescription());
		setQuestion(getService().getRecommendation());
		return res;
	}

	@Override
	public void getPreviousPageId() {
		throw new UnsupportedOperationException("Repair page should not have a Previous Page.");
	}

}
