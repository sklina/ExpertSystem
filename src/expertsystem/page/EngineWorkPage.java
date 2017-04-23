
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.EngineWork;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkPage extends EntityPage {

	public EngineWorkPage() {
		setId("EngineWorkPage");
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
		return "EnginePage";
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
