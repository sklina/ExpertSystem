package expertsystem.page;


import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Entity;
import expertsystem.service.BatteryChargeService;



public class BatteryChargePage extends EntityPage{

	public static final String ID = "BatteryChargePage";
	
	BatteryChargeService service = new BatteryChargeService();
	
	public BatteryChargePage() {
		setName("Заряд аккумулятора");
		setQuestion("Заряжен ли аккумулятор?");
		setImageUrl("expertsystem/img/akkum.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new BatteryCharge();
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