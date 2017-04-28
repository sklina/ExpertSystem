
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.FuelSupply;
import expertsystem.service.FuelSupplyService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyPage extends EntityPage {

	public static final String ID = "FuelSupplyPage";
	
	FuelSupplyService service = new FuelSupplyService();
	
	public FuelSupplyPage() {
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
		return service.getNextPageId(this);
	}

	@Override
	public String getPreviousPageId() {
		service.getPrevPageId(this);
		return "";
	}


}
