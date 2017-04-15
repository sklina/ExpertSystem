package expertsystem.controller;

import expertsystem.page.ContactsPage;
import expertsystem.page.EntityPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController("/expertsystem/contactsPage.fxml")
public class ContactsPageController extends AbstractController{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}
	
	@Override
	protected EntityPage createEntityPage() {
		return new ContactsPage();
	}
}