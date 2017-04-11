package expertsystem;

import expertsystem.page.IgnitionPage;
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

/**
 * View controller for a view in the wizard. This class is only needed to define the binding between the class and the
 * fxml file.
 * @see WizardController
 * @see io.datafx.controller.ViewController
 */
@ViewController("ignitionPage.fxml")
public class IgnitionPageController implements Initializable{

	@FXML
	Label question;
	
	@FXML
	ImageView imageView;
	
	@FXML
	ComboBox<String> cbIgnition;
	
	IgnitionPage page = new IgnitionPage();

	public void createComboBox() {
        ObservableList obList = FXCollections.observableList(page.getEntity().getStates());
        cbIgnition.getItems().clear();
        cbIgnition.setItems(obList);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		imageView.setImage(new Image(page.getImageUrl()));
		question.setText(page.getQuestion());
		createComboBox();
	}
	
}