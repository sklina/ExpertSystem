
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Power;
import expertsystem.service.EntityService;
import expertsystem.service.BatteryChargeService;
import expertsystem.service.PowerService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerPage extends EntityPage {

	public static final String ID = "PowerPage";
	
	public PowerPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Какая мощность у двигателя?");
		setImageUrl("expertsystem/image/power3.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Power();
	}

	@Override
	protected EntityService createService() {
		return new PowerService();
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
