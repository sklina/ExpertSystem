
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.Entity;
import expertsystem.service.Service;
import expertsystem.service.EngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EnginePage extends EntityPage {

	public static final String ID = "EnginePage";

	
	public EnginePage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Заводится ли двигатель?");
		setImageUrl("expertsystem/img/dvigatel.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Engine();
	}
	
	@Override
	protected Service createService() {
		return new EngineService();
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
