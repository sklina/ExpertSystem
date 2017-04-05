package expertsystem;

import io.datafx.controller.ViewController;
import io.datafx.controller.flow.FlowException;
import io.datafx.controller.flow.action.ActionMethod;
import io.datafx.controller.flow.action.ActionTrigger;
import io.datafx.controller.util.VetoException;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

/**
 * View controller for a view in the wizard. This class is only needed to define the binding between the class and the
 * fxml file.
 * @see WizardController
 * @see io.datafx.controller.ViewController
 */
@ViewController("fuelSupply1Page.fxml")
public class FuelSupplyPageController {
	
	@FXML
	@ActionTrigger("Inert")
    private CheckBox cbInert;
	
	@FXML
	@ActionTrigger("IDK")
    private CheckBox cbIDK;
	
	@ActionMethod("Inert")
    public void onInert() throws VetoException, FlowException {
		if (cbInert.isSelected()) cbIDK.setSelected(false);
	}
	
	@ActionMethod("IDK")
    public void onIDK() throws VetoException, FlowException {
		if (cbIDK.isSelected()) cbInert.setSelected(false);
	}
}