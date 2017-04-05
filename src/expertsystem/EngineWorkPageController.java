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
@ViewController("engineWorkPage.fxml")
public class EngineWorkPageController {
	@FXML
	@ActionTrigger("Normal")
    private CheckBox cbNormal;
	
	@FXML
	@ActionTrigger("Bad")
    private CheckBox cbBad;
	
	@ActionMethod("Normal")
    public void onNormal() throws VetoException, FlowException {
		if (cbNormal.isSelected()) cbBad.setSelected(false);
	}
	
	@ActionMethod("Bad")
    public void onBad() throws VetoException, FlowException {
		if (cbBad.isSelected()) cbNormal.setSelected(false);
	}
}