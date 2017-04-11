
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EnginePage extends WizardPage {

	public EnginePage() {
		id = "EnginePage";
		title = "Состояние двигателя";
		question = "Заводится ли двигатель? ";
		imageUrl = "expertsystem/img/dvigatel.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new Engine();
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
