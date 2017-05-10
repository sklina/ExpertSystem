
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.service.Service;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class WelcomePage extends EntityPage {

	public static final String ID = "WelcomePage";
	
	public WelcomePage() {
		setTitle("AutoExpert. Приветствие");
	}

	@Override
	protected Entity createEntity() {
		throw new UnsupportedOperationException("Welcome page should not have an Entity object.");
	}

	@Override
	public String getNextPageId() {
		return "EnginePage";
	}

	@Override
	public void getPreviousPageId() {
		throw new UnsupportedOperationException("Welcome page should not have a Previous Page."); 
	}

	@Override
	protected Service createService() {
		throw new UnsupportedOperationException("Welcome page should not have a Service.");
	}

}
