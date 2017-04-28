
package expertsystem.page;

import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class WelcomePage extends EntityPage {

	public static final String ID = "WelcomePage";
	
	public WelcomePage() {
		setName("AutoExpert. Приветствие");

	}

	
	@Override
	protected Entity createEntity() {
		return null;
	}

	@Override
	public String getNextPageId() {
		return "EnginePage";
	}

	@Override
	public String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}


}
