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
@ViewController("wizardView6.fxml")
public class WizardView6Controller {
	
	@FXML
	@ActionTrigger("Charged")
    private CheckBox cbCharged;
	
	@FXML
	@ActionTrigger("NotCharged")
    private CheckBox cbNotCharged;
	
	@ActionMethod("Charged")
    public void onCharged() throws VetoException, FlowException {
		if (cbCharged.isSelected()) cbNotCharged.setSelected(false);
	}
	
	@ActionMethod("NotCharged")
    public void onNotCharged() throws VetoException, FlowException {
		if (cbNotCharged.isSelected()) cbCharged.setSelected(false);
	}
}