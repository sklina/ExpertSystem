package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.PowerPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController("/expertsystem/powerPage.fxml")
public class PowerPageController extends AbstractController{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
		System.out.println(getEntityPage().getNextPageId());
	}

	@Override
	protected EntityPage createEntityPage() {
		return new PowerPage();
	}
}