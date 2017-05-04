package expertsystem.controller;

import javafx.application.Application;
import javafx.stage.Stage;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;


public class ExpertSystem  extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Flow flow  = new Flow(WizardController.class);

        FlowHandler flowHandler = flow.createHandler();
        StackPane pane = flowHandler.start(new DefaultFlowContainer());
        primaryStage.setScene(new Scene(pane));
        primaryStage.show();
    }
}
