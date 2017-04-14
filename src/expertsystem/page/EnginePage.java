
package expertsystem.page;

import expertsystem.entity.Engine;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class EnginePage extends AbstractWizardPage {

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
	public String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
