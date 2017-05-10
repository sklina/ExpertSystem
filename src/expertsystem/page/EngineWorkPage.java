
package expertsystem.page;

import expertsystem.entity.EngineWork;
import expertsystem.entity.Entity;
import expertsystem.service.EntityService;
import expertsystem.service.EngineWorkService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkPage extends EntityPage {

	public static final String ID = "EngineWorkPage";
	
	public EngineWorkPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Как работает двигатель?");
		setImageUrl("expertsystem/image/dvigatRabSost.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new EngineWork();
	}

	@Override
	protected EntityService createService() {
		return new EngineWorkService();
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
