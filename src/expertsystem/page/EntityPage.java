
package expertsystem.page;

import expertsystem.entity.Entity;
import java.util.Map;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public abstract class EntityPage {
	private String title;
	private String question;
	private String imageUrl;
	private String description;
	private Entity entity;
	
	
	protected abstract Entity createEntity();

	public Entity getEntity() {
		if (entity == null)
			entity = createEntity();
		
		return entity;
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

	public String getDescription() {
		return description;
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

	public void setDescription(String description) {
		this.description = description;
	}
	
	public abstract String getNextPageId();
	public abstract String getPreviousPageId();

}
