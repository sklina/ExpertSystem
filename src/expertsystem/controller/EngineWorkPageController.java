package expertsystem.controller;

import expertsystem.page.EngineWorkPage;
import expertsystem.page.EntityPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController("/expertsystem/engineWorkPage.fxml")
public class EngineWorkPageController extends AbstractController{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new EngineWorkPage();}
}