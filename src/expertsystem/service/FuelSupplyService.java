package expertsystem.service;

import expertsystem.page.EntityPage;
import static expertsystem.entity.FuelSupply.State.INERT;
import static expertsystem.entity.FuelSupply.State.IDK;
import static expertsystem.entity.Repair.State.CLEAR_FUEL_LINE;
import expertsystem.page.FuelSupplyPage;
import expertsystem.page.IgnitionPage;
import expertsystem.page.RepairPage;

/**
 * состояние
 *
 * @author Alina Skorokhodova <alina.skorokhodova@vistar.su>
 */
public class FuelSupplyService extends Service {

	@Override
	public String getNextPageId(EntityPage page) {
		String currentState = page.getEntity().getCurrentState();
		if (currentState.equals(INERT.getValue())) {
			addQuestionFact(FuelSupplyPage.ID, INERT.getFact());
			getEnviroment().run(1);

			arrayOfFacts.add("repair \"Clean the fuel line.\"");
			setRecommendation(CLEAR_FUEL_LINE.getValue());
			return RepairPage.ID;
		} else if (currentState.equals(IDK.getValue())) {
			return IgnitionPage.ID;
		}
		return null;
	}

	@Override
	public void getPrevPageId(EntityPage page) {
	}
}
