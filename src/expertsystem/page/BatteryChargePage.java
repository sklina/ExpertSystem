package expertsystem.page;


import expertsystem.entity.BatteryCharge;
import expertsystem.entity.Entity;
import expertsystem.service.EntityService;
import expertsystem.service.BatteryChargeService;



public class BatteryChargePage extends EntityPage{

	public static final String ID = "BatteryChargePage";
	
	public BatteryChargePage() {
		setTitle(getEntity().getEntityName());
		setQuestion("Заряжен ли аккумулятор?");
		setImageUrl("expertsystem/img/akkum.jpg");
	}

	@Override
	protected Entity createEntity() {
		return new BatteryCharge();
	}
	
	@Override
	protected EntityService createService() {
		return new BatteryChargeService();
	}

	@Override
	public String getNextPageId() {
		return getService().getNextPageId(this);
	}

	@Override
	public void getPreviousPageId() {
		getService().getPrevPageId(this);
	}

}