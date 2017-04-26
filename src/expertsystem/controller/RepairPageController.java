package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.RepairPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;

@ViewController("/expertsystem/recommendationToRepairPage.fxml")
public class RepairPageController extends AbstractController {

	@PostConstruct
	public void initButtons() {
		getNextButton().setDisable(true);
		getBackButton().setDisable(true);
		getBackButton().setDisable(true);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getEntityPage().getNextPageId();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new RepairPage();
	}

}
