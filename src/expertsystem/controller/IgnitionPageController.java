package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.IgnitionPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController("/expertsystem/ignitionPage.fxml")
public class IgnitionPageController extends AbstractController{

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new IgnitionPage();
	}

}