
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.Entity;
import expertsystem.service.EngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EnginePage extends EntityPage {

	public static final String ID = "EnginePage";
	
	EngineService service = new EngineService();
	
	public EnginePage() {
		setName("Состояние двигателя");
		setQuestion("Заводится ли двигатель?");
		setImageUrl("expertsystem/img/dvigatel.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Engine();
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
