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
@ViewController("ignitionPage.fxml")
public class IgnitionPageController {
	
	@FXML
	@ActionTrigger("IgnitionNorm")
    private CheckBox cbIgnitionNorm;
	
	@FXML
	@ActionTrigger("SparkNotRegular")
    private CheckBox cbSparkNotRegular;
	
	@FXML
	@ActionTrigger("NoSpark")
    private CheckBox cbNoSpark;
	
	@ActionMethod("IgnitionNorm")
    public void onIgnitionNorm() throws VetoException, FlowException {
		if (cbIgnitionNorm.isSelected()) {
			cbSparkNotRegular.setSelected(false);
			cbNoSpark.setSelected(false);
		}
	}
	
	@ActionMethod("SparkNotRegular")
    public void onSparkNotRegular() throws VetoException, FlowException {
		if (cbSparkNotRegular.isSelected()) {
			cbIgnitionNorm.setSelected(false);
			cbNoSpark.setSelected(false);
		}
	}
	
	@ActionMethod("NoSpark")
    public void onNoSpark() throws VetoException, FlowException {
		if (cbNoSpark.isSelected()) {
			cbIgnitionNorm.setSelected(false);
			cbSparkNotRegular.setSelected(false);
		}
	}
	
}