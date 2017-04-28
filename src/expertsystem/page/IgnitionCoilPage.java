
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.IgnitionCoil;
import expertsystem.service.IgnitionCoilService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilPage extends EntityPage {

	public static final String ID = "IgnitionCoilPage";
	
	IgnitionCoilService service = new IgnitionCoilService();
	
	public IgnitionCoilPage() {
		setName("Катушка зажигания");
		setQuestion("Катушка зажигания проводит ток?");
		setImageUrl("expertsystem/img/katushka.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new IgnitionCoil();
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
