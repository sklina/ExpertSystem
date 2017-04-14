package expertsystem.controller;

import expertsystem.page.IgnitionCoilPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


@ViewController("/expertsystem/ignitionCoilPage.fxml")
public class IgnitionCoilPageController extends AbstractController{
	
	IgnitionCoilPage page = new IgnitionCoilPage();

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