
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Ignition;
import expertsystem.service.Service;
import expertsystem.service.IgnitionService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionPage extends EntityPage {

	public static final String ID = "IgnitionPage";
	
	public IgnitionPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Нет ли перебоев в системе зажигания?");
		setImageUrl("expertsystem/img/zazhiganie2.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Ignition();
	}
	
	@Override
	protected Service createService() {
		return new IgnitionService();
	}

	@Override
	public String getNextPageId() {
		return getService().getNextPageId(this);
	}

	@Override
	public void getPreviousPageId() {
		getService().getPrevPageId(this);
	}

}
