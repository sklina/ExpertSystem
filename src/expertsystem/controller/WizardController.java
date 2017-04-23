package expertsystem.controller;
import expertsystem.page.EntityPage;
import expertsystem.page.WelcomePage;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.container.AnimatedFlowContainer;
import io.datafx.controller.flow.container.ContainerAnimations;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;

import javax.annotation.PostConstruct;

@ViewController("/expertsystem/wizard.fxml")
public class WizardController {

    @FXML
    private StackPane centerPane;
	
	public static FlowHandler f;
	
//	/** Навигация. */
//	@FXML @ActionTrigger("back")
//	public static Button backButton;
//	@FXML @ActionTrigger("finish")
//	public static Button finishButton;
//	@FXML @ActionTrigger("next")
//	public static Button nextButton;

	
    @PostConstruct
    public void init() throws FlowException {
        Flow flow = new Flow(WelcomePageController.class);

        f = flow.createHandler();
        centerPane.getChildren().add(f.start(new AnimatedFlowContainer(Duration.millis(320), ContainerAnimations.SWIPE_LEFT)));
    }

	
	public static FlowHandler getFlow() {
		return f;
	}
}
