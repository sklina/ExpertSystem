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
@ViewController("enginePage.fxml")
public class EnginePageController {
	@FXML
	@ActionTrigger("Yes")
    private CheckBox cbYes;
	
	@FXML
	@ActionTrigger("No")
    private CheckBox cbNo;
	
	@ActionMethod("Yes")
    public void onYes() throws VetoException, FlowException {
		if (cbYes.isSelected()) cbNo.setSelected(false);
		
	}
	
	@ActionMethod("No")
    public void onNo() throws VetoException, FlowException {
		if (cbNo.isSelected()) cbYes.setSelected(false);
	}
}