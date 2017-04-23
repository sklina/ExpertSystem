package expertsystem.controller;

import expertsystem.page.EnginePage;
import expertsystem.page.EntityPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javax.annotation.PostConstruct;


@ViewController("/expertsystem/enginePage.fxml")
public class EnginePageController extends AbstractController {

	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
		
	}

	@Override
	protected EntityPage createEntityPage() {
		return new EnginePage();
	}
}
