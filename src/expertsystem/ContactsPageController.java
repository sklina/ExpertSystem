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
@ViewController("contactsPage.fxml")
public class ContactsPageController {
	@FXML
	@ActionTrigger("Clear")
    private CheckBox cbClear;
	
	@FXML
	@ActionTrigger("Burned")
    private CheckBox cbBurned;
	
	@FXML
	@ActionTrigger("Dirty")
    private CheckBox cbDirty;
	
	@ActionMethod("Clear")
    public void onClear() throws VetoException, FlowException {
		if (cbClear.isSelected()) {
			cbBurned.setSelected(false);
			cbDirty.setSelected(false);
		}
	}
	
	@ActionMethod("Burned")
    public void onBurned() throws VetoException, FlowException {
		if (cbBurned.isSelected()) {
			cbClear.setSelected(false);
			cbDirty.setSelected(false);
		}

	}

	@ActionMethod("Dirty")
    public void onDirty() throws VetoException, FlowException {
		if (cbDirty.isSelected()) {
			cbClear.setSelected(false);
			cbBurned.setSelected(false);
		}

	}
}