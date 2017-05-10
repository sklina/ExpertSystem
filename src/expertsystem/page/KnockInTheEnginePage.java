
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.KnockInTheEngine;
import expertsystem.service.EntityService;
import expertsystem.service.KnockInTheEngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEnginePage extends EntityPage {

	public static final String ID = "KnockInTheEnginePage";
	
	public KnockInTheEnginePage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Стучит ли двигатель?");
		setImageUrl("expertsystem/img/DvigStuk.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new KnockInTheEngine();
	}

	@Override
	protected EntityService createService() {
		return new KnockInTheEngineService();
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
