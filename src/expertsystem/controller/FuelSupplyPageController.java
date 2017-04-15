package expertsystem.controller;

import expertsystem.page.EntityPage;
import expertsystem.page.FuelSupplyPage;
import io.datafx.controller.ViewController;
import java.net.URL;
import java.util.ResourceBundle;


@ViewController("/expertsystem/fuelSupply1Page.fxml")
public class FuelSupplyPageController extends AbstractController{
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		initQuestionLabel();
		initComboBox();
		initImageView();
	}

	@Override
	protected EntityPage createEntityPage() {
		return new FuelSupplyPage();}
}