package expertsystem.controller;

import expertsystem.page.EnginePage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


@ViewController("/expertsystem/enginePage.fxml")
public class EnginePageController extends AbstractController{
	
	EnginePage page = new EnginePage();

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