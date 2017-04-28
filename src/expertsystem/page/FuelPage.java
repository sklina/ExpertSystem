
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Fuel;
import expertsystem.service.FuelService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelPage extends EntityPage {

	public static final String ID = "FuelPage";
	
	FuelService service = new FuelService();
	
	public FuelPage() {
		setTitle("Топливо");
		setQuestion("Есть ли в баке бензин?");
		setImageUrl("expertsystem/img/benz1.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Fuel();
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
