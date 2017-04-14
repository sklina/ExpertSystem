
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.IgnitionCoil;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionCoilPage extends AbstractWizardPage {

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
	String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
