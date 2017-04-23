package expertsystem.page;


import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Entity;



public class BatteryChargePage extends EntityPage{

	public BatteryChargePage() {
		setId("BatteryChargePage");
		setTitle("Заряд аккумулятора");
		setQuestion("Заряжен ли аккумулятор?");
		setImageUrl("expertsystem/img/akkum.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new BatteryCharge();
	}

	@Override
	public String getNextPageId() {
		return "RepairPage";
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