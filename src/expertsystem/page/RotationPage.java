
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Rotation;
import expertsystem.service.RotationService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationPage extends EntityPage {

	RotationService service = new RotationService();
	
	public RotationPage() {
		setId("RotationPage");
		setTitle("Вращение двигателя");
		setQuestion("Вращается ли двигатель?");
		setImageUrl("expertsystem/img/DvigVraw.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Rotation();
	}

	@Override
	public String getNextPageId() {
		return service.addFacts(getEntity().getCurrentState());
	}

	@Override
	public String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
