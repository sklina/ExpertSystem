
package expertsystem.page;

import expertsystem.entity.Entity;
import java.util.Map;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class EntityPage {
	private String name;
	private String question;
	private String imageUrl;
	private String description;
	private Entity entity;
	Map<String, Entity> buffer;
	
	
	protected abstract Entity createEntity();

	public Entity getEntity() {
		if (entity == null)
			entity = createEntity();
		
		return entity;
	}


	public String getQuestion() {
		return question;
	}

	public String getName() {
		return name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public String getDescription() {
		return description;
	}
	

	protected final void setName(String name) {
		this.name = name;
	}

	protected final void setQuestion(String question) {
		this.question = question;
	}

	protected final void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
	public Map<String, Entity> getBuffer() {
		return buffer;
	}
	
	public abstract String getNextPageId();
	public abstract String getPreviousPageId();

}
