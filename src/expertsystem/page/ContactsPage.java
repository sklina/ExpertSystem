
package expertsystem.page;

import expertsystem.entity.Contacts;
import expertsystem.entity.Entity;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsPage extends EntityPage{

	public ContactsPage() {
		setId("ContactsPage");
		setTitle("Контакты");
		setQuestion("Какое состояние поверхности контактов?");
		setImageUrl("expertsystem/img/contact.jpg");
	}

	
	@Override
	protected Entity createEntity() {
		return new Contacts();
	}

	@Override
	public String getNextPageId() {
		return "BatteryChargePage";
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
