package expertsystem.controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import io.datafx.controller.flow.Flow;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.container.DefaultFlowContainer;
import static javafx.application.Application.launch;


public class ExpertSystem  extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        Flow flow  = new Flow(WizardController.class);
//
//        FlowHandler flowHandler = flow.createHandler();
//        StackPane pane = flowHandler.start(new DefaultFlowContainer());
//        primaryStage.setScene(new Scene(pane));
//        primaryStage.show();
		new Flow(WelcomePageController.class).
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
				withLink(KnockInTheEnginePageController.class, "next", RepairPageController.class).
				withGlobalBackAction("back").
				withGlobalLink("finish", RepairPageController.class).
				startInStage(primaryStage);

    }
}
