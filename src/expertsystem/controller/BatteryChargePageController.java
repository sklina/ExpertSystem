package expertsystem.controller;

import expertsystem.page.BatteryChargePage;
import expertsystem.page.EntityPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController(value = "/expertsystem/batteryChargePage.fxml")
public class BatteryChargePageController extends AbstractController{

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
