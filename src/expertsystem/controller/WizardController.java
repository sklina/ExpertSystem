package expertsystem.controller;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.container.AnimatedFlowContainer;
import io.datafx.controller.flow.container.ContainerAnimations;
import io.datafx.controller.util.VetoException;
import javafx.stage.Stage;

import javax.annotation.PostConstruct;

/**
 * This class defines the main controller of the wizard. The complete action toolbar is managed here. In addition a
 * flow that contains all the custom views of the wizard is added to the view. The navigation for this internal flow
 * is managed here.
 */
@ViewController("/expertsystem/wizard.fxml")
public class WizardController {

    @FXML
    @ActionTrigger("back")
    private Button backButton;
    @FXML
    @ActionTrigger("finish")
    private Button finishButton;
    @FXML
    @ActionTrigger("next")
    private Button nextButton;

    @FXML
    private StackPane centerPane;

    private FlowHandler flowHandler;

    @PostConstruct
    public void init() throws FlowException {
        Flow flow = new Flow(WelcomePageController.class).
                withLink(WelcomePageController.class, "next", EnginePageController.class).
                withLink(EnginePageController.class, "next", EngineWorkPageController.class).
                withLink(EngineWorkPageController.class, "next", RotationPageController.class).
				withLink(RotationPageController.class, "next", IgnitionPageController.class).
				withLink(IgnitionPageController.class, "next", BatteryChargePageController.class).
                withLink(BatteryChargePageController.class, "next", PowerPageController.class).
                withLink(PowerPageController.class, "next", FuelPageController.class).
				withLink(FuelPageController.class, "next", ContactsPageController.class).
				withLink(ContactsPageController.class, "next", IgnitionCoilPageController.class).
                withLink(IgnitionCoilPageController.class, "next", FuelSupplyPageController.class).
                withLink(FuelSupplyPageController.class, "next", KnockInTheEnginePageController.class).
				withLink(KnockInTheEnginePageController.class, "next", RepairPageController.class);

        flowHandler = flow.createHandler();
        centerPane.getChildren().add(flowHandler.start(new AnimatedFlowContainer(Duration.millis(320), ContainerAnimations.SWIPE_LEFT)));

        backButton.setDisable(true);
        finishButton.setDisable(true);
		
    }

    @ActionMethod("back")
    public void onBack() throws VetoException, FlowException {
        flowHandler.navigateBack();
        if(flowHandler.getCurrentViewControllerClass().equals(WelcomePageController.class)) {
            backButton.setDisable(true);
        } else {
            backButton.setDisable(false);
        }
    }

    @ActionMethod("next")
    public void onNext() throws VetoException, FlowException {
        flowHandler.handle("next");
        if(flowHandler.getCurrentViewControllerClass().equals(RepairPageController.class)) {
			backButton.setDisable(true);
            nextButton.setDisable(true);
            finishButton.setDisable(false);
        } else {
			backButton.setDisable(false);
        }
        
    }

    @ActionMethod("finish")
    public void onFinish() throws VetoException, FlowException {
		Stage stage = (Stage)nextButton.getScene().getWindow();
		stage.close();
	}
}
