package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.WelcomePage;
import io.datafx.controller.ViewController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.util.VetoException;
import java.net.URL;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;


@ViewController(value = "/expertsystem/welcomePage.fxml")
public class WelcomePageController extends AbstractController{
	
	@PostConstruct
    public void initButtons() {
		
//        getBackButton().setDisable(true);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("asdf");
	}

	@Override
	protected EntityPage createEntityPage() {
		return new WelcomePage();
	}

//	@Override
//	public void onNext() throws VetoException, FlowException, ClassNotFoundException {
//		flowHandler = WizardController.getFlow();
//		String className = getEntityPage().getNextPageId() + "Controller";
//		flowHandler.navigateTo(PowerPageController.class);
//		
//		if (flowHandler.getCurrentViewControllerClass().equals(RepairPageController.class)) {
//			backButton.setDisable(true);
//			nextButton.setDisable(true);
//			finishButton.setDisable(false);
//		} else {
//			backButton.setDisable(false);
//		}
//
//	}
}