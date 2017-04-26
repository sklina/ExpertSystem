package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.RotationPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;

@ViewController(value = "/expertsystem/rotationPage.fxml", title = "Вращение двигателя")
public class RotationPageController extends AbstractController {

	@PostConstruct
	public void initButtons() {
		getNextButton().setDisable(true);
		getFinishButton().setDisable(true);
		getBackButton().setDisable(true);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new RotationPage();
	}
}
