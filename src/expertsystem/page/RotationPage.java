
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Rotation;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationPage extends WizardPage {

	public RotationPage() {
		id = "RotationPage";
		title = "Вращение двигателя";
		question = "Вращается ли двигатель?";
		imageUrl = "expertsystem/img/DvigVraw.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new Rotation();
	}

	@Override
	String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}