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
@ViewController("wizardView7.fxml")
public class WizardView7Controller {
	@FXML
	@ActionTrigger("Low")
    private CheckBox cbLow;
	
	@FXML
	@ActionTrigger("Normal")
    private CheckBox cbNormal;
	
	@ActionMethod("Low")
    public void onLow() throws VetoException, FlowException {
		if (cbLow.isSelected()) cbNormal.setSelected(false);
	}
	
	@ActionMethod("Normal")
    public void onNormal() throws VetoException, FlowException {
		if (cbNormal.isSelected()) cbLow.setSelected(false);
	}
}