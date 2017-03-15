package hdss.io;

public class DesalinationPlantPublicData implements WaterResourceTypePublicData {

	private String myName;
	private float maxCapacity;
	
	public DesalinationPlantPublicData (String name, float max)
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
