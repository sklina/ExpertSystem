
package expertsystem.controller;

import expertsystem.page.EntityPage;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.flow.context.ActionHandler;
import io.datafx.controller.flow.context.FlowActionHandler;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractController implements Initializable{
 
	@FXML
    @ActionTrigger("back")
    private Button backButton;	
    @FXML
    @ActionTrigger("finish")
    private Button finishButton;	
    @FXML
    @ActionTrigger("next")
    private Button nextButton;
	
 	@FXML
	Label questionLabel;	
	@FXML
	ImageView imageView;
	@FXML
	ComboBox<String> comboBox;
	
	@ActionHandler
	public FlowActionHandler actionHandler;
	
	private EntityPage entityPage;
	
	protected abstract EntityPage createEntityPage();
	
	@Override
	public abstract void initialize(URL location, ResourceBundle resources);

	protected void initComboBox() {
        ObservableList obList = FXCollections.observableList(getEntityPage().getEntity().getStates());
        comboBox.getItems().clear();
        comboBox.setItems(obList);
		comboBox.setPromptText("Выберите ответ");
	}
	
	protected void initImageView() {
		imageView.setImage(new Image(getEntityPage().getImageUrl()));
	}

	protected void initQuestionLabel() {
		questionLabel.setText(getEntityPage().getQuestion());
	}
	
	
	protected EntityPage getEntityPage() {
		if (entityPage == null)
			entityPage = createEntityPage();
		return entityPage;
	}
	
	public Button getBackButton() {
        return backButton;
    }

    public Button getFinishButton() {
        return finishButton;
    }

    public Button getNextButton() {
        return nextButton;
    }
}
