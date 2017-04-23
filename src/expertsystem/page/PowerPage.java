
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Power;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class PowerPage extends EntityPage {

	public PowerPage() {
		setId("PowerPage");
		setTitle("Мощность");
		setQuestion("Какая мощность у двигателя?");
		setImageUrl("expertsystem/img/power3.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Power();
	}

	@Override
	public String getNextPageId() {
		return "KnockInTheEnginePage";
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
