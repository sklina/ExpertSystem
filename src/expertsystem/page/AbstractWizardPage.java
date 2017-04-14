
package expertsystem.page;

import expertsystem.entity.Entity;
import java.util.Map;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class AbstractWizardPage {
	public String id;
	public String title;
	public String question;
	public String imageUrl;
	
	private Entity entity;
	Map<String, Entity> buffer;
	
	
	protected abstract Entity createEntity();

	public Entity getEntity() {
		if (entity == null)
			entity = createEntity();
		
		return entity;
	}

	public String getId() {
		return id;
	}

	public String getQuestion() {
		return question;
	}

	public String getTitle() {
		return title;
	}

	public String getImageUrl() {
		return imageUrl;
	}
	
	
	public Map<String, Entity> getBuffer() {
		return buffer;
	}
	
	abstract String getNextPageId();
	abstract String getPreviousPageId();
	abstract String getFinishPageId();

}
