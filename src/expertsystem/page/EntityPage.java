
package expertsystem.page;

import expertsystem.entity.Entity;
import java.util.Map;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class EntityPage {
	private String id;
	private String title;
	private String question;
	private String imageUrl;
	
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

	protected final void setId(String id) {
		this.id = id;
	}

	protected final void setTitle(String title) {
		this.title = title;
	}

	protected final void setQuestion(String question) {
		this.question = question;
	}

	protected final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	
	
	public Map<String, Entity> getBuffer() {
		return buffer;
	}
	
	public abstract String getNextPageId();
	public abstract String getPreviousPageId();
	public abstract String getFinishPageId();

}
