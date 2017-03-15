package hdss.io;

public class HourlyIrrigationSchedulePublicData {
	private String myHour;
	private float amount;
	
	public HourlyIrrigationSchedulePublicData (String hour, float value)
	{
		myHour = hour;
		amount = value;
	}

	public String getMyHour() {
		return myHour;
	}

	public float getAmount() {
		return amount;
	}
}
