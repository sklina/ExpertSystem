package expertsystem.page;


import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Entity;



public class BatteryChargePage extends AbstractWizardPage{

	public BatteryChargePage() {
		id = "BatteryChargePage";
		title = "Заряд аккумулятора";
		question = "Заряжен ли аккумулятор?";
		imageUrl = "expertsystem/img/akkum.jpg";
	}
	

	@Override
	protected Entity createEntity() {
		
		return new BatteryCharge();
	}

	@Override
	public String getNextPageId() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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