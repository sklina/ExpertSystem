
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Fuel;
import expertsystem.service.EntityService;
import expertsystem.service.FuelService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelPage extends EntityPage {

	public static final String ID = "FuelPage";
	
	public FuelPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Есть ли в баке бензин?");
		setImageUrl("expertsystem/image/benz1.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Fuel();
	}

	@Override
	protected EntityService createService() {
		return  new FuelService();
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
