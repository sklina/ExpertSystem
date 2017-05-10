package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.Fuel.State.YES;
import static expertsystem.entity.Fuel.State.NO;
import static expertsystem.entity.Repair.State.MECHANIC;
import static expertsystem.entity.Repair.State.ADD_GASS;
import expertsystem.page.FuelPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelService extends Service {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		if (currentState.equals(YES.getValue())) {
			addQuestionFact(FuelPage.ID, YES.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("repair \"Take your car to a mechanic.\"");
			setRecommendation(MECHANIC.getValue());
			return RepairPage.ID;
		} else if (currentState.equals(NO.getValue())) {
			addQuestionFact(FuelPage.ID, NO.getFact());
			getEnviroment().run(1);
			
			arrayOfFacts.add("repair \"Add g a s . \"");
			setRecommendation(ADD_GASS.getValue());
			return RepairPage.ID;
		}

		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
