package expertsystem.controller;

import expertsystem.page.BatteryChargePage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


@ViewController(value = "/expertsystem/batteryChargePage.fxml")
public class BatteryChargePageController extends AbstractController{

	BatteryChargePage page = new BatteryChargePage();

	@Override
	public void initComboBox() {
        ObservableList obList = FXCollections.observableList(page.getEntity().getStates());
        comboBox.getItems().clear();
        comboBox.setItems(obList);
		comboBox.setPromptText("Выберите ответ");
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	public void initImageView() {
		imageView.setImage(new Image(page.getImageUrl()));
	}

	@Override
	public void initQuestionLabel() {
		questionLabel.setText(page.getQuestion());
	}
}
