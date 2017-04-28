
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.KnockInTheEngine;
import expertsystem.service.KnockInTheEngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEnginePage extends EntityPage {

	public static final String ID = "KnockInTheEnginePage";
	
	KnockInTheEngineService service = new KnockInTheEngineService();
	
	public KnockInTheEnginePage() {
		setTitle("Стук в двигателе");
		setQuestion("Стучит ли двигатель?");
		setImageUrl("expertsystem/img/DvigStuk.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new KnockInTheEngine();
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
