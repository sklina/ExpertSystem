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
@ViewController("wizardView4.fxml")
public class WizardView4Controller {
	@FXML
	@ActionTrigger("Rotate")
    private CheckBox cbRotate;
	
	@FXML
	@ActionTrigger("NoRotate")
    private CheckBox cbNoRotate;
	
		
	@ActionMethod("Rotate")
    public void onRotate() throws VetoException, FlowException {
		if (cbRotate.isSelected()) cbNoRotate.setSelected(false);
	}
	
	@ActionMethod("NoRotate")
    public void onNoRotate() throws VetoException, FlowException {
		if (cbNoRotate.isSelected()) cbRotate.setSelected(false);
	}
}