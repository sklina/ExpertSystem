
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Power;
import expertsystem.service.PowerService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerPage extends EntityPage {

	public static final String ID = "PowerPage";
	
	PowerService service = new PowerService();
	
	public PowerPage() {
		setName("Мощность");
		setQuestion("Какая мощность у двигателя?");
		setImageUrl("expertsystem/img/power3.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Power();
	}

	@Override
	public String getNextPageId() {
		return service.getNextPageId(this);
	}

	@Override
	public String getPreviousPageId() {
		service.getPrevPageId(this);
		return "";
	}


}
