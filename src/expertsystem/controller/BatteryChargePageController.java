package expertsystem.controller;

import expertsystem.page.BatteryChargePage;
import expertsystem.page.EntityPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;

@ViewController(value = "/expertsystem/batteryChargePage.fxml")
public class BatteryChargePageController extends AbstractController {

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
		return new BatteryChargePage();
	}
}
