
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.Rotation;
import expertsystem.service.RotationService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class RotationPage extends EntityPage {

	public static final String ID = "RotationPage";
	
	RotationService service = new RotationService();
	
	public RotationPage() {
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
		return service.getNextPageId(this);
	}

	@Override
	public String getPreviousPageId() {
		service.getPrevPageId(this);
		return "";
	}


}
