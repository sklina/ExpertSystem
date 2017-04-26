
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.IgnitionCoil;
import expertsystem.service.IgnitionCoilService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilPage extends EntityPage {

	IgnitionCoilService service = new IgnitionCoilService();
	
	public IgnitionCoilPage() {
		setId("IgnitionCoilPage");
		setTitle("Катушка зажигания");
		setQuestion("Катушка зажигания проводит ток?");
		setImageUrl("expertsystem/img/katushka.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new IgnitionCoil();
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
