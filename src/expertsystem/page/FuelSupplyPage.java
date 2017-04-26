
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;
import expertsystem.service.FuelSupplyService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyPage extends EntityPage {

	FuelSupplyService service = new FuelSupplyService();
	
	public FuelSupplyPage() {
		setId("FuelSupplyPage");
		setTitle("Подача топлива");
		setQuestion("Двигатель не сразу реагирует на подачу топлива?");
		setImageUrl("expertsystem/img/benz.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new FuelSupply();
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
