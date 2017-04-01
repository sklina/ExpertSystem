package expertsystem;
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
@ViewController("wizard.fxml")
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
        Flow flow = new Flow(WizardView1Controller.class).
                withLink(WizardView1Controller.class, "next", WizardView2Controller.class).
                withLink(WizardView2Controller.class, "next", WizardView3Controller.class).
                withLink(WizardView3Controller.class, "next", WizardView4Controller.class).
				withLink(WizardView4Controller.class, "next", WizardView5Controller.class).
				withLink(WizardView5Controller.class, "next", WizardView6Controller.class).
                withLink(WizardView6Controller.class, "next", WizardView7Controller.class).
                withLink(WizardView7Controller.class, "next", WizardView8Controller.class).
				withLink(WizardView8Controller.class, "next", WizardView9Controller.class).
				withLink(WizardView9Controller.class, "next", WizardView10Controller.class).
                withLink(WizardView10Controller.class, "next", WizardView11Controller.class).
                withLink(WizardView11Controller.class, "next", WizardView12Controller.class).
				withLink(WizardView12Controller.class, "next", WizardView13Controller.class);

        flowHandler = flow.createHandler();
        centerPane.getChildren().add(flowHandler.start(new AnimatedFlowContainer(Duration.millis(320), ContainerAnimations.SWIPE_LEFT)));

        backButton.setDisable(true);
        finishButton.setDisable(true);
		
    }

    @ActionMethod("back")
    public void onBack() throws VetoException, FlowException {
        flowHandler.navigateBack();
        if(flowHandler.getCurrentViewControllerClass().equals(WizardView1Controller.class)) {
            backButton.setDisable(true);
        } else {
            backButton.setDisable(false);
        }
    }

    @ActionMethod("next")
    public void onNext() throws VetoException, FlowException {
        flowHandler.handle("next");
        if(flowHandler.getCurrentViewControllerClass().equals(WizardView13Controller.class)) {
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
