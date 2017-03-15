package hdss.io;

import java.util.*;

public class WatershedPublicData {
	private String name;	
	private List<ReservoirPublicData> reservoirList;
	private List<AquiferPublicData> aquiferList;
	private List<DesalinationPlantPublicData> desalinationPlantList;
	private float maxCapacity;
	
	public WatershedPublicData ()
	{
		name = "";
		reservoirList = null;
		aquiferList = null;
		desalinationPlantList = null;
		maxCapacity = 0.0f;
	}

	public String getName() {
		return name;
	}

	public List<ReservoirPublicData> getReservoirList() {
		return reservoirList;
	}

	public List<AquiferPublicData> getAquiferList() {
		return aquiferList;
	}

	public List<DesalinationPlantPublicData> getDesalinationPlantList() {
		return desalinationPlantList;
	}

	public float getMaxCapacity() {
		return maxCapacity;
	}


}
