package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.RepairPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;


@ViewController("/expertsystem/recommendationToRepairPage.fxml")
public class RepairPageController extends AbstractController{

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	protected EntityPage createEntityPage() {
		return new RepairPage();
	}
	
	
}