
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Fuel;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelPage extends AbstractWizardPage {

	public FuelPage() {
		id = "FuelPage";
		title = "Топливо";
		question = "Есть ли в баке бензин?";
		imageUrl = "expertsystem/img/benz1.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new Fuel();
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
