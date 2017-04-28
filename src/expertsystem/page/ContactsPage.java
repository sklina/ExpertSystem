
package expertsystem.page;

import expertsystem.entity.Contacts;
import expertsystem.entity.Entity;
import expertsystem.service.ContactsService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsPage extends EntityPage{

	public static final String ID = "ContactsPage";
	
	ContactsService service = new ContactsService();
	
	public ContactsPage() {
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
		return service.getNextPageId(this);
	}

	@Override
	public String getPreviousPageId() {
		service.getPrevPageId(this);
		return "";
	}


}
