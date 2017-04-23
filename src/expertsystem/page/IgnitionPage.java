
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Ignition;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionPage extends EntityPage {

	public IgnitionPage() {
		setId("IgnitionPage");
		setTitle("Система зажигания");
		setQuestion("Нет ли перебоев в системе зажигания?");
		setImageUrl("expertsystem/img/zazhiganie2.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Ignition();
	}

	@Override
	public String getNextPageId() {
		return "IgnitionCoilPage";
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
