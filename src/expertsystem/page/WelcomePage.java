
package expertsystem.page;

import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class WelcomePage extends EntityPage {

	public WelcomePage() {
		setId("WelcomePage");
		setTitle("AutoExpert. Приветствие");

	}

	
	@Override
	protected Entity createEntity() {
		return null;
	}

	@Override
	public String getNextPageId() {
		return "RotationPage";
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
