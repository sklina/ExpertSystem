
package expertsystem.controller;

import io.datafx.controller.flow.FlowHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractController implements Initializable{
 
 	@FXML
	Label questionLabel;
		
	@FXML
	ImageView imageView;
	
	@FXML
	ComboBox<String> comboBox;
	
	public FlowHandler flowHandler;

	abstract public void initComboBox();
	
	abstract public void initImageView();

	abstract public void initQuestionLabel();
	
	@Override
	abstract public void initialize(URL location, ResourceBundle resources);

}
