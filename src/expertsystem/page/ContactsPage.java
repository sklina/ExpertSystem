
package expertsystem.page;

import expertsystem.entity.Contacts;
import expertsystem.entity.Entity;
import expertsystem.service.EntityService;
import expertsystem.service.ContactsService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class ContactsPage extends EntityPage{

	public static final String ID = "ContactsPage";
	
	public ContactsPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Какое состояние поверхности контактов?");
		setImageUrl("expertsystem/img/contact.jpg");
	}

	
	@Override
	protected Entity createEntity() {
		return new Contacts();
	}
	
	@Override
	protected EntityService createService() {
		return new ContactsService();
	}

	@Override
	public String getNextPageId() {
		return getService().getNextPageId(this);
	}

	@Override
	public void getPreviousPageId() {
		getService().getPrevPageId(this);
	}
	
}
