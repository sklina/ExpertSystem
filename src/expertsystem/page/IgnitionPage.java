
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Ignition;
import expertsystem.service.IgnitionService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionPage extends EntityPage {

	public static final String ID = "IgnitionPage";
	
	IgnitionService service = new IgnitionService();
	
	public IgnitionPage() {
		setName("Система зажигания");
		setQuestion("Нет ли перебоев в системе зажигания?");
		setImageUrl("expertsystem/img/zazhiganie2.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Ignition();
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
