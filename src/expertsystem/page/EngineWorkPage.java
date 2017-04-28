
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.EngineWork;
import expertsystem.entity.Entity;
import expertsystem.service.EngineWorkService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkPage extends EntityPage {

	public static final String ID = "EngineWorkPage";
	
	EngineWorkService service = new EngineWorkService();
	
	public EngineWorkPage() {
		setTitle("Рабочее состояние двигателя");
		setQuestion("Как работает двигатель?");
		setImageUrl("expertsystem/img/dvigatRabSost.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new EngineWork();
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
