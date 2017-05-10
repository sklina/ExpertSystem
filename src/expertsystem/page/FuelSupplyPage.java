
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;
import expertsystem.service.Service;
import expertsystem.service.FuelSupplyService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyPage extends EntityPage {

	public static final String ID = "FuelSupplyPage";
	
	public FuelSupplyPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Двигатель не сразу реагирует на подачу топлива?");
		setImageUrl("expertsystem/img/benz.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new FuelSupply();
	}

	@Override
	protected Service createService() {
		return new FuelSupplyService();
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
