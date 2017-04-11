
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.EngineWork;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EngineWorkPage extends WizardPage {

	public EngineWorkPage() {
		id = "EngineWorkPage";
		title = "Рабочее состояние двигателя";
		question = "Как работает двигатель?";
		imageUrl = "expertsystem/img/dvigatRabSost.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new EngineWork();
	}

	@Override
	String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
