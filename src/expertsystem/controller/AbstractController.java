package expertsystem.controller;

import expertsystem.page.EntityPage;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.FlowHandler;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.util.VetoException;
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
import javafx.stage.Stage;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractController implements Initializable {

	/** Навигация. */
	
	@FXML @ActionTrigger("back")
	public Button backButton;
	@FXML @ActionTrigger("finish")
	public Button finishButton;
	@FXML @ActionTrigger("next")
	public Button nextButton;
	
	
	/** Элементы окна. */
	@FXML
	Label questionLabel;
	@FXML
	ImageView imageView;
	@FXML @ActionTrigger("combobox")
	ComboBox<String> comboBox;

	
	/** Навигатор по страницам. Обработчик потока */
	public FlowHandler flowHandler = WizardController.getFlow();

	private EntityPage entityPage;
	
	protected abstract EntityPage createEntityPage();
	
	protected final EntityPage getEntityPage() {
		if (entityPage == null) {
			entityPage = createEntityPage();
		}
		return entityPage;
	}

	public final Button getBackButton() { return backButton; }
	public final Button getFinishButton() {	return finishButton;}
	public final Button getNextButton() { return nextButton; }
	
	
	/** Обработка событий. */
	
	@FXML
	private void onComboBox() throws VetoException, FlowException {
		if (comboBox.getSelectionModel().getSelectedItem() != null) {
			backButton.setDisable(false);
			getEntityPage().getEntity().setCurrentState(comboBox.getSelectionModel().getSelectedItem());
			entityPage.getNextPageId();
		}
	}
	@FXML
	@ActionMethod("back")
	public void onBack() throws VetoException, FlowException {
		flowHandler.navigateBack();
		if (flowHandler.getCurrentViewControllerClass().equals(WelcomePageController.class)) {
			getBackButton().setDisable(true);
		} else {
			getBackButton().setDisable(false);
		}
	}

	@FXML
	@ActionMethod("next")
	public void onNext() throws VetoException, FlowException, ClassNotFoundException {
		String className = "expertsystem.controller." + getEntityPage().getNextPageId() + "Controller";
		flowHandler.navigateTo(Class.forName(className));
		getNextButton().setDisable(true);
		if (flowHandler.getCurrentViewControllerClass().equals(RepairPageController.class)) {
			getBackButton().setDisable(true);
			getNextButton().setDisable(true);
			getFinishButton().setDisable(false);
		} else {
			getBackButton().setDisable(false);
		}

	}

	@FXML
	@ActionMethod("finish")
	public void onFinish() throws VetoException, FlowException {
		Stage stage = (Stage) getNextButton().getScene().getWindow();
		flowHandler.navigateTo(RepairPageController.class);
		getBackButton().setDisable(true);
		getNextButton().setDisable(true);
//		stage.close();
	}

	/** Инициализация элементов окна. */
	
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

		@Override
	public abstract void initialize(URL location, ResourceBundle resources);

	
}
