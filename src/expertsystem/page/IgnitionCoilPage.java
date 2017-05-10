
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.IgnitionCoil;
import expertsystem.service.EntityService;
import expertsystem.service.IgnitionCoilService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilPage extends EntityPage {

	public static final String ID = "IgnitionCoilPage";
	
	public IgnitionCoilPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Катушка зажигания проводит ток?");
		setImageUrl("expertsystem/img/katushka.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new IgnitionCoil();
	}

	@Override
	protected EntityService createService() {
		return new IgnitionCoilService();
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
