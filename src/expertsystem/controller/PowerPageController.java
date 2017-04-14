package expertsystem.controller;

import expertsystem.page.PowerPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;


@ViewController("/expertsystem/powerPage.fxml")
public class PowerPageController extends AbstractController{
	
	PowerPage page = new PowerPage();

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
		System.out.println(page.getNextPageId());
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