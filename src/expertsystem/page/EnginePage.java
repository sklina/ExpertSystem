
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.Entity;
import expertsystem.service.EngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EnginePage extends EntityPage {

	EngineService service = new EngineService();
	
	public EnginePage() {
		setId("EnginePage");
		setTitle("Состояние двигателя");
		setQuestion("Заводится ли двигатель?");
		setImageUrl("expertsystem/img/dvigatel.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Engine();
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
