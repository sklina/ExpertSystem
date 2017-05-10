
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Rotation;
import expertsystem.service.EntityService;
import expertsystem.service.RotationService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationPage extends EntityPage {

	public static final String ID = "RotationPage";
	
	public RotationPage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Вращается ли двигатель?");
		setImageUrl("expertsystem/image/DvigVraw.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new Rotation();
	}
	
	@Override
	protected EntityService createService() {
		return new RotationService();
	}
	
	@Override
	public String getNextPageId() {
		return getService().getNextPageId(this);
	}

	@Override
	public void getPreviousPageId() {
		getService().getPrevPageId(this);
	}

}
