package hdss.io;

public class AquiferPublicData implements WaterResourceTypePublicData {

	private String myName;
	private float currentHeight;

	public AquiferPublicData (String name, float current)
	{
		myName = name;
		currentHeight = current;
	}

	public String getMyName() {
		return myName;
	}
}
