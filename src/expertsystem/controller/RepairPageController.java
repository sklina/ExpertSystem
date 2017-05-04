package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.RepairPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javax.annotation.PostConstruct;

@ViewController("/expertsystem/recommendationToRepairPage.fxml")
public class RepairPageController extends AbstractController {
	
	@FXML
	public Label recommendation;
	@FXML
	public Label info;
	
	@PostConstruct
	public void initButtons() {
		getNextButton().setDisable(true);
		getBackButton().setDisable(true);
		getBackButton().setDisable(true);
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getEntityPage().getNextPageId();
		info.setText(getEntityPage().getDescription());
		recommendation.setText(getEntityPage().getQuestion());
	}

	@Override
	protected EntityPage createEntityPage() {
		return new RepairPage();
	}

}
