
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.KnockInTheEngine;
import expertsystem.service.KnockInTheEngineService;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEnginePage extends EntityPage {

	KnockInTheEngineService service = new KnockInTheEngineService();
	
	public KnockInTheEnginePage() {
		setId("KnockInTheEnginePage");
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
