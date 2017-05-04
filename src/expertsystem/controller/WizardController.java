package expertsystem.controller;
import io.datafx.controller.ViewController;
import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.AnimatedFlowContainer;
import io.datafx.controller.flow.container.ContainerAnimations;

import javax.annotation.PostConstruct;

@ViewController("/expertsystem/wizard.fxml")
public class WizardController {

    @FXML
    private StackPane centerPane;
	
	public static FlowHandler fh;

	
    @PostConstruct
    public void init() throws FlowException {
        Flow flow = new Flow(WelcomePageController.class);

        fh = flow.createHandler();
        centerPane.getChildren().add(fh.start(new AnimatedFlowContainer(Duration.millis(320), ContainerAnimations.SWIPE_LEFT)));
    }

	
	public static FlowHandler getFlow() {
		return fh;
	}
}
