package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.KnockInTheEnginePage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;

@ViewController("/expertsystem/knockInTheEnginePage.fxml")
public class KnockInTheEnginePageController extends EntityController {

	@PostConstruct
	public void initButtons() {
		getNextButton().setDisable(true);
		getFinishButton().setDisable(true);
		getBackButton().setDisable(false);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new KnockInTheEnginePage();
	}
}
