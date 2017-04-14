
package expertsystem.page;

import expertsystem.entity.Entity;
import expertsystem.entity.KnockInTheEngine;

/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class KnockInTheEnginePage extends AbstractWizardPage {

	public KnockInTheEnginePage() {
		id = "KnockInTheEnginePage";
		title = "Стук в двигателе";
		question = "Стучит ли двигатель?";
		imageUrl = "expertsystem/img/DvigStuk.jpg";
	}

	@Override
	protected Entity createEntity() {
		return new KnockInTheEngine();
	}

	@Override
	String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getPreviousPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	String getFinishPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
