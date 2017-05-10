
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;
import expertsystem.service.EntityService;
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
		setImageUrl("expertsystem/image/benz.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new FuelSupply();
	}

	@Override
	protected EntityService createService() {
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
