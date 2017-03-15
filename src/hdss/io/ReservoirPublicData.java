package hdss.io;

public class ReservoirPublicData implements WaterResourceTypePublicData {

	private String myName;
	private float maxCapacity;
	
	public ReservoirPublicData (String name, float max)
	{
		myName = name;
		maxCapacity = max;
	}

	public String getMyName() {
		return myName;
	}

	public float getMaxCapacity() {
		return maxCapacity;
	}
	
}
