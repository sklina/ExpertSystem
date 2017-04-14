package expertsystem.controller;

import expertsystem.page.RotationPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


@ViewController("/expertsystem/rotationPage.fxml")
public class RotationPageController implements Initializable{
	@FXML
	Label question;
		
	@FXML
	ImageView imageView;
	
	@FXML
	ComboBox<String> comboBox;
	RotationPage page = new RotationPage();

	public void createComboBox() {
        ObservableList obList = FXCollections.observableList(page.getEntity().getStates());
        comboBox.getItems().clear();
        comboBox.setItems(obList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(new Image(page.getImageUrl()));
		question.setText(page.getQuestion());
		createComboBox();
	}
}