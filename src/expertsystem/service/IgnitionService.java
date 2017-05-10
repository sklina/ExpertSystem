package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.Ignition.State.NO_SPARK;
import expertsystem.page.KnockInTheEnginePage;
import expertsystem.page.RepairPage;
import static expertsystem.entity.Repair.State.ADJUST_CONTACTS;
import expertsystem.page.IgnitionPage;
/**
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class IgnitionService extends EntityService {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		
		if (currentState.equals(NO_SPARK.getValue())) {
			addQuestionFact(IgnitionPage.ID, NO_SPARK.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("spark-state engine irregular-spark");
			arrayOfFacts.add("repair \"Point gap adjustment.");
			setRecommendation(ADJUST_CONTACTS.getValue());
			return RepairPage.ID;
		}
		return KnockInTheEnginePage.ID;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
