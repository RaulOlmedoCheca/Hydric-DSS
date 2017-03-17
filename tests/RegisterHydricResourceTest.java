package hdss.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import hdss.WatershedManagerInterface;
import hdss.exceptions.HydricDSSException;
import hdss.io.AquiferPublicData;
import hdss.io.DesalinationPlantPublicData;
import hdss.io.ReservoirPublicData;
import hdss.io.WatershedPublicData;
import hdss.io.WatershedsListPublicData;

public class RegisterHydricResourceTest {

	private WatershedManagerInterface manager;

	/* Test case: HDSS-FN1-TC-1
	 * Equivalence class: HDSS-FN1-EQ-2, HDSS-FN1-EQ-3, HDSS-FN1-EQ-6, HDSS-FN1-EQ-8, HDSS-FN1-EQ-9, HDSS-FN1-EQ-13,
	 * HDSS-FN1-EQ-16, HDSS-FN1-EQ-18, HDSS-FN1-EQ-19, HDSS-FN1-EQ-23, HDSS-FN1-EQ-24, HDSS-FN1-EQ-25, HDSS-FN1-EQ-26,
	 * HDSS-FN1-EQ-30, HDSS-FN1-EQ-32, HDSS-FN1-EQ-34, HDSS-FN1-EQ-36, HDSS-FN1-EQ-39, HDSS-FN1-EQ-40
	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: validRegisterHydricResourcesCase.json
	*/
	@Test
	public void basicValidtest() throws HydricDSSException {
		WatershedsListPublicData result;
		result = manager.RegisterHydricResources("data/validRegisterHydricResourcesCase.json");

		List<WatershedPublicData> watershedList;
		watershedList = result.getWatershedList();

		assertEquals(watershedList.size(), 1);

		WatershedPublicData watershed;
		watershed = watershedList.get(0);

		assertEquals(watershed.getName(), "shortName");

		List<ReservoirPublicData> reservoirList;
		reservoirList = watershed.getReservoirList();

		assertEquals(reservoirList.size(), 1);

		ReservoirPublicData reservoir = reservoirList.get(0);

		assertEquals(reservoir.getMyName(), "shortName");
		assertEquals(reservoir.getMaxCapacity(), 2.23, 0.001);

		List<DesalinationPlantPublicData> plantList;
		plantList = watershed.getDesalinationPlantList();

		assertEquals(plantList.size(), 1);

		DesalinationPlantPublicData plant = plantList.get(0);

		assertEquals(plant.getMyName(), "plant1");
		assertEquals(plant.getMaxCapacity(), 23.46, 0.001);

		List<AquiferPublicData> aquiferList;
		aquiferList = watershed.getAquiferList();

		assertEquals(aquiferList.size(), 1);

		AquiferPublicData aquifer = aquiferList.get(0);

		assertEquals(aquifer.getMyName(),"aquifer1");
	}

	/* Test case: HDSS-FN1-TC-2
	 * Equivalence class: HDSS-FN1-EQ-1
	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: �An input data file is not found�
	*/
	@Test
	public void notFoundFiletest() {
		try {
			manager.RegisterHydricResources("nonexists.json");
			fail("An input can not be found but no exception was risen");
		} catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "An input data file is not found");
		}
	}

	/* Test case: HDSS-FN1-TC-3
	 * Equivalence class: HDSS-FN1-BL-7
	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value:
	 	 {
		  "zero-capacity-basin" :
		  { "resources": [
		    {"reservoirs": {
		        "amount": 1,
		        "capacity": 0.00,
		        "list" : [
		          {
		            "name" : "zero-capacity-reservoir",
		            "capacity" : 0.00
		          }
		        ]
		      }
		    }
		  ]}
		}
	*/
	@Test
	public void zeroCapacityBasinTest() throws HydricDSSException {
		WatershedsListPublicData result;
		result = manager.RegisterHydricResources("capacity-zero.json");

		List<WatershedPublicData> watershedList;
		watershedList = result.getWatershedList();

		assertEquals(watershedList.size(), 1);

		WatershedPublicData watershed;
		watershed = watershedList.get(0);

		assertEquals(watershed.getName(), "zero-capacity-basin");

		List<ReservoirPublicData> reservoirList;
		reservoirList = watershed.getReservoirList();

		assertEquals(reservoirList.size(), 1);

		ReservoirPublicData reservoir = reservoirList.get(0);

		assertEquals(reservoir.getMyName(), "zero-capacity-reservoir");
		assertEquals(reservoir.getMaxCapacity(), 0.00, 0.001);
	}

}
