package expertsystem.page;


import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Entity;



public class BatteryChargePage extends WizardPage{

	public BatteryChargePage() {
		id = "BatteryChargePage";
		question = "Заряжен ли аккумулятор?";
		imageUrl = "expertsystem/img/akkum.jpg";
	}
	

	@Override
	protected Entity createEntity() {
		
		return new BatteryCharge();
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