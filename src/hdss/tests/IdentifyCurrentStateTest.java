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

import hdss.io.ScenarioPublicData;

public class IdentifyCurrentStateTest {

	private WatershedManagerInterface manager;

	/* Test case: HDSS-FN2-TC-1
	 * Equivalence class: HDSS-FN2-EQ-2, HDSS-FN2-EQ-3, HDSS-FN2-EQ-6, HDSS-FN2-EQ-8,
	 * HDSS-FN2-EQ-9, HDSS-FN2-EQ-13, HDSS-FN2-EQ-16, HDSS-FN2-EQ-18, HDSS-FN2-EQ-19,
	 * HDSS-FN2-EQ-23, HDSS-FN2-EQ-24, HDSS-FN2-EQ-25, HDSS-FN2-EQ-26, HDSS-FN2-EQ-30,
	 * HDSS-FN2-EQ-32, HDSS-FN2-EQ-34, HDSS-FN2-EQ-36, HDSS-FN2-EQ-39, HDSS-FN2-EQ-40,
	 * HDSS-FN2-EQ-42, HDSS-FN2-EQ-44, HDSS-FN2-EQ-48, HDSS-FN2-EQ-51, HDSS-FN2-EQ-52,
	 * HDSS-FN2-EQ-2
	 * Testing technique: Equivalence Classes Analysis
	 * Expected value:
	 */
	 @Test
	 public void inputBasicValidTest() throws HydricDSSException {
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validRegisterHydricResourcesCase.json");

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

	/* Test case: HDSS-FN2-TC-2
	 * Equivalence class: HDSS-FN2-EQ-42, HDSS-FN2-EQ-44, HDSS-FN2-EQ-48, HDSS-FN2-EQ-51,
	 * HDSS-FN2-EQ-52, HDSS-FN2-EQ-53, HDSS-FN2-EQ-54, HDSS-FN2-EQ-58, HDSS-FN2-EQ-59,
	 * HDSS-FN2-EQ-60, HDSS-FN2-EQ-61, HDSS-FN2-EQ-65
	 * Testing technique: Equivalence Classes Analysis
	 * Expected value:
	 */

	/* Test case: HDSS-FN2-TC-2
 	 * Equivalence class: HDSS-FN2-EQ-1
 	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "An input data file is not found"
 	*/
 	@Test
 	public void notFoundFileTest() {
 		try {
 			manager.RegisterHydricResources("nonexists.json");
 			fail("An input can not be found but no exception was risen");
 		} catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "An input data file is not found");
 		}
 	}

 	/* Test case: HDSS-FN2-TC-3
 	 * Equivalence class: HDSS-FN2-BL-7
 	 * Testing technique: Boundary Limit Analysis
     * Expected value: hdss-rf01-expectedCapacityZero.json
 	 */
 	@Test
 	public void zeroCapacityBasinTest() throws HydricDSSException {
 		WatershedsListPublicData result;
 		result = manager.RegisterHydricResources("data/RF01/hdss-rf01-capacityZero.json");

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

 	 /* Test case: HDSS-FN2-TC-4
 	 * Equivalence class: HDSS-FN2-EQ-4
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
 	@Test
  	public void invalidJSONFormatTest() {
  		try {
  			manager.RegisterHydricResources("data/RF01/hdss-rf01-invalidJson.json");
 			fail("Equivalence class test HDSS-FN2-EQ-4 failed");
  		} catch (HydricDSSException e) {
  			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
  		}
  	}

 	 /* Test case: HDSS-FN2-TC-5
     * Equivalence class: HDSS-FN2-EQ-5
	 * Testing technique: Equivalence Classes Analysis
	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
	 */
 	@Test
 	public void emptyFileTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-empty.json");
 			fail("Equivalence class test HDSS-FN2-EQ-5 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-6
  	 * Equivalence class: HDSS-FN2-EQ-7
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "Tried to record an irrigation basin with an existing name"
  	 */
 	@Test
 	public void existingIrrigationBasinTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-existingIrrigationBasinName.json");
 			fail("Equivalence class test HDSS-FN2-EQ-7 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "Tried to record an irrigation basin with an existing name");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-7
  	 * Equivalence class: HDSS-FN2-EQ-10
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void longIrrigationBasinNameTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-longIrrigationBasinName.json");
 			fail("Equivalence class test HDSS-FN2-EQ-10 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-8
  	 * Equivalence class: HDSS-FN2-EQ-11
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void noIrrigationBasinNameTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-noIrrigationBasinName.json");
 			fail("Equivalence class test HDSS-FN2-EQ-11 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-9
  	 * Equivalence class: HDSS-FN2-EQ-12
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void severalIrrigationBasinNamesTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-severalIrrigationBasinNames.json");
 			fail("Equivalence class test HDSS-FN2-EQ-12 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-10
  	 * Equivalence class: HDSS-FN2-EQ-14
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void noResourcesListTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-noResourcesList.json");
 			fail("Equivalence class test HDSS-FN2-EQ-14 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-11
  	 * Equivalence class: HDSS-FN2-EQ-15
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void severalResourcesListsTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-severalResourcesLists.json");
 			fail("Equivalence class test HDSS-FN2-EQ-15 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-12
  	 * Equivalence class: HDSS-FN2-EQ-17
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "Tried to record a resource basin with an existing name"
  	 */
 	@Test
 	public void existingResourceNameTest() {
 		manager.RegisterHydricResources("data/RF01/hdss-rf01-validRegisterHydricResourcesCase.json");
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-validRegisterHydricResourcesCase.json");
 			fail("Equivalence class test HDSS-FN2-EQ-17 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "Tried to record a resource basin with an existing name");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-13
  	 * Equivalence class: HDSS-FN2-EQ-20
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void longResourceNameTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-longResourceName.json");
 			fail("Equivalence class test HDSS-FN2-EQ-20 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-14
  	 * Equivalence class: HDSS-FN2-EQ-21
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void noResourceNameTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-noResourceName.json");
 			fail("Equivalence class test HDSS-FN2-EQ-21 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-15
  	 * Equivalence class: HDSS-FN2-EQ-22
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void severalResourceNamesTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-severalResourceNames.json");
 			fail("Equivalence class test HDSS-FN2-EQ-22 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-16
  	 * Equivalence class: HDSS-FN2-EQ-27
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void invalidResourceTypeTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-invalidResourceType.json");
 			fail("Equivalence class test HDSS-FN2-EQ-27 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-17
  	 * Equivalence class: HDSS-FN2-EQ-28
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void noResourceTypeTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-noResourceType.json");
 			fail("Equivalence class test HDSS-FN2-EQ-28 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-18
  	 * Equivalence class: HDSS-FN2-EQ-29
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void severalResourceTypesTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-severalResourceTypes.json");
 			fail("Equivalence class test HDSS-FN2-EQ-29 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-19
  	 * Equivalence class: HDSS-FN2-EQ-31
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void negativeResourceCapacityTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-negativeResourceCapacity.json");
 			fail("Equivalence class test HDSS-FN2-EQ-31 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-20
  	 * Equivalence class: HDSS-FN2-EQ-33
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void notValidResourceCapacityTest() {
 		try {
 			manager.RegisterHydricResources("data/RF01/hdss-rf01-invalidResourceCapacity.json");
 			fail("Equivalence class test HDSS-FN2-EQ-33 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

 	 /* Test case: HDSS-FN2-TC-21
  	 * Equivalence class: HDSS-FN2-EQ-35
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */
 	@Test
 	public void notValidResourceCapacityDecimalFormatTest() {
  		try {
  			manager.RegisterHydricResources("data/RF01/hdss-rf01-notValidResourceCapacityDecimalFormat.json");
  			fail("Equivalence class test HDSS-FN2-EQ-35 failed");
  		}catch (HydricDSSException e) {
  			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
  		}
  	}

 	 /* Test case: HDSS-FN2-TC-22
  	 * Equivalence class: HDSS-FN2-EQ-37
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */

 	 /* Test case: HDSS-FN2-TC-23
  	 * Equivalence class: HDSS-FN2-EQ-38
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */

 	 /* Test case: HDSS-FN2-TC-24
  	 * Equivalence class: HDSS-FN2-EQ-41
  	 * Testing technique: Equivalence Classes Analysis
  	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
  	 */

}
