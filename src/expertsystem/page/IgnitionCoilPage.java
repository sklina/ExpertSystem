
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.IgnitionCoil;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilPage extends EntityPage {

	public IgnitionCoilPage() {
		id = "IgnitionCoilPage";
		title = "Катушка зажигания";
		question = "Катушка зажигания проводит ток? ";
		imageUrl = "expertsystem/img/katushka.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new IgnitionCoil();
	}

	@Override
	public String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
