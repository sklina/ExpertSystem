
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyPage extends WizardPage {

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
