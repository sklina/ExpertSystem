
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyPage extends AbstractWizardPage {

	public FuelSupplyPage() {
		id = "FuelSupplyPage";
		title = "Подача топлива";
		question = "Двигатель не сразу реагирует на подачу топлива?";
		imageUrl = "expertsystem/img/benz.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new FuelSupply();
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
