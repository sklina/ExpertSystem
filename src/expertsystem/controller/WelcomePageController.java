package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.PowerPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;


@ViewController(value = "/expertsystem/welcomePage.fxml")
public class WelcomePageController extends AbstractController{
	
	@PostConstruct
    public void initButtons() {
        getBackButton().setDisable(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@Override
	protected EntityPage createEntityPage() {
		return null;
	}
}