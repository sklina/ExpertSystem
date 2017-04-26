
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Fuel;
import expertsystem.service.FuelService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelPage extends EntityPage {

	FuelService service = new FuelService();
	
	public FuelPage() {
		setId("FuelPage");
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
