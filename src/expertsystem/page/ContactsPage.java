
package expertsystem.page;

import expertsystem.entity.Contacts;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsPage extends AbstractWizardPage{

	public ContactsPage() {
		id = "ContactsPage";
		title = "Контакты";
		question = "Какое состояние поверхности контактов?";
		imageUrl = "expertsystem/img/contact.jpg";
	}

	
	@Override
	protected Entity createEntity() {
		return new Contacts();
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
