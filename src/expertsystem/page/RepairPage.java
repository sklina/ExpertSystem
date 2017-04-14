
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Repair;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairPage extends AbstractWizardPage {

	public RepairPage() {
		id = "RepairPage";
		title = "Рекомендация";
		question = "";
		imageUrl = "expertsystem/img/remont2.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new Repair();
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
