
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Repair;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RepairPage extends EntityPage {

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
