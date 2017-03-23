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
 	 * Expected value: hdss-rf01-expectedValidRegisterHydricResourcesCase.json
	 */
	@Test
	public void basicValidtest() throws HydricDSSException {
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

	/* Test case: HDSS-FN1-TC-2
	 * Equivalence class: HDSS-FN1-EQ-1
	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "An input data file is not found"
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
	 * Testing technique: Boundary Limit Analysis
 	 * Expected value: hdss-rf01-expectedCapacityZero.json
	 */
	@Test
	public void zeroCapacityBasinTest() throws HydricDSSException {
		WatershedsListPublicData result;
		result = manager.RegisterHydricResources("data/hdss-rf01-capacityZero.json");

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

	/* Test case: HDSS-FN1-TC-4
	 * Equivalence class: HDSS-FN1-EQ-4
	 * Testing technique: Equivalence Classes Analysis
	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
	 */
	@Test
 	public void invalidJSONFormatTest() {
 		try {
 			manager.RegisterHydricResources("data/hdss-rf01-invalidJson.json");
			fail("Equivalence class test HDSS-FN1-EQ-4 failed");
 		} catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

	 /* Test case: HDSS-FN1-TC-5
 	 * Equivalence class: HDSS-FN1-EQ-5
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void emptyFileTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-empty.json");
			fail("Equivalence class test HDSS-FN1-EQ-5 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-6
 	 * Equivalence class: HDSS-FN1-EQ-7
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "Tried to record an irrigation basin with an existing name"
 	 */
	@Test
	public void existingIrrigationBasinTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-existingIrrigationBasinName.json");
			fail("Equivalence class test HDSS-FN1-EQ-7 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "Tried to record an irrigation basin with an existing name");
		}
	}

	 /* Test case: HDSS-FN1-TC-7
 	 * Equivalence class: HDSS-FN1-EQ-10
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void longIrrigationBasinNameTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-longIrrigationBasinName.json");
			fail("Equivalence class test HDSS-FN1-EQ-10 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-8
 	 * Equivalence class: HDSS-FN1-EQ-11
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void noIrrigationBasinNameTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-noIrrigationBasinName.json");
			fail("Equivalence class test HDSS-FN1-EQ-11 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-9
 	 * Equivalence class: HDSS-FN1-EQ-12
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void severalIrrigationBasinNamesTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-severalIrrigationBasinNames.json");
			fail("Equivalence class test HDSS-FN1-EQ-12 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-10
 	 * Equivalence class: HDSS-FN1-EQ-14
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void noResourcesListTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-noResourcesList.json");
			fail("Equivalence class test HDSS-FN1-EQ-14 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-11
 	 * Equivalence class: HDSS-FN1-EQ-15
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void severalResourcesListsTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-severalResourcesLists.json");
			fail("Equivalence class test HDSS-FN1-EQ-15 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-12
 	 * Equivalence class: HDSS-FN1-EQ-17
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "Tried to record a resource basin with an existing name"
 	 */
	@Test
	public void existingResourceNameTest() {
		manager.RegisterHydricResources("data/hdss-rf01-validRegisterHydricResourcesCase.json");
		try {
			manager.RegisterHydricResources("data/hdss-rf01-validRegisterHydricResourcesCase.json");
			fail("Equivalence class test HDSS-FN1-EQ-17 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "Tried to record a resource basin with an existing name");
		}
	}

	 /* Test case: HDSS-FN1-TC-13
 	 * Equivalence class: HDSS-FN1-EQ-20
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void longResourceNameTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-longResourceName.json");
			fail("Equivalence class test HDSS-FN1-EQ-20 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-14
 	 * Equivalence class: HDSS-FN1-EQ-21
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void noResourceNameTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-noResourceName.json");
			fail("Equivalence class test HDSS-FN1-EQ-21 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-15
 	 * Equivalence class: HDSS-FN1-EQ-22
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void severalResourceNamesTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-severalResourceNames.json");
			fail("Equivalence class test HDSS-FN1-EQ-22 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-16
 	 * Equivalence class: HDSS-FN1-EQ-27
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void invalidResourceTypeTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-invalidResourceType.json");
			fail("Equivalence class test HDSS-FN1-EQ-27 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-17
 	 * Equivalence class: HDSS-FN1-EQ-28
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void noResourceTypeTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-noResourceType.json");
			fail("Equivalence class test HDSS-FN1-EQ-28 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-18
 	 * Equivalence class: HDSS-FN1-EQ-29
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void severalResourceTypesTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-severalResourceTypes.json");
			fail("Equivalence class test HDSS-FN1-EQ-29 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-19
 	 * Equivalence class: HDSS-FN1-EQ-31
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void negativeResourceCapacityTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-negativeResourceCapacity.json");
			fail("Equivalence class test HDSS-FN1-EQ-31 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-20
 	 * Equivalence class: HDSS-FN1-EQ-33
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void notValidResourceCapacityTest() {
		try {
			manager.RegisterHydricResources("data/hdss-rf01-invalidResourceCapacity.json");
			fail("Equivalence class test HDSS-FN1-EQ-33 failed");
		}catch (HydricDSSException e) {
			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
		}
	}

	 /* Test case: HDSS-FN1-TC-21
 	 * Equivalence class: HDSS-FN1-EQ-35
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */
	@Test
	public void notValidResourceCapacityDecimalFormatTest() {
 		try {
 			manager.RegisterHydricResources("data/hdss-rf01-notValidResourceCapacityDecimalFormat.json");
 			fail("Equivalence class test HDSS-FN1-EQ-35 failed");
 		}catch (HydricDSSException e) {
 			assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
 		}
 	}

	 /* Test case: HDSS-FN1-TC-22
 	 * Equivalence class: HDSS-FN1-EQ-37
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */

	 /* Test case: HDSS-FN1-TC-23
 	 * Equivalence class: HDSS-FN1-EQ-38
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */

	 /* Test case: HDSS-FN1-TC-24
 	 * Equivalence class: HDSS-FN1-EQ-41
 	 * Testing technique: Equivalence Classes Analysis
 	 * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
 	 */

	 /* Test case: HDSS-FN1-TC-25
 	 * Boundary limit:  HDSS-FN1-BL-1
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidIrrigationBasinName49.json
     */
	 @Test
	 public void validIrrigationBasinName49charTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validIrrigationBasinName49.json");

		 List<WatershedPublicData> watershedList;
		 watershedList = result.getWatershedList();

		 assertEquals(watershedList.size(), 1);

		 WatershedPublicData watershed;
		 watershed = watershedList.get(0);

		 assertEquals(watershed.getName(), "reallyreallyreallyreallyreallyreallyreallyLongNam");
		 assertEquals(watershed.getName().getLength(), 49, 0.01);

	 }

	 /* Test case: HDSS-FN1-TC-26
 	 * Boundary limit:  HDSS-FN1-BL-2
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidIrrigationBasinName50.json
     */
	 @Test
	 public void validIrrigationBasinName50charTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validIrrigationBasinName50.json");

		 List<WatershedPublicData> watershedList;
		 watershedList = result.getWatershedList();

		 assertEquals(watershedList.size(), 1);

		 WatershedPublicData watershed;
		 watershed = watershedList.get(0);

		 assertEquals(watershed.getName(), "reallyreallyreallyreallyreallyreallyreallyLongName");
		 assertEquals(watershed.getName().getLength(), 50, 0.01);
	 }

	 /* Test case: HDSS-FN1-TC-27
 	 * Boundary limit:  HDSS-FN1-BL-3
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: Throws exception. Error message: "The input file has no data or doesn’t match the expected format”
     */
	 @Test
	 public void invalidIrrigationBasinNameTest(){
		 try {
			 manager.RegisterHydricResources("data/hdss-rf01-invalidIrrigationBasinName.json");
			 fail("Boundary limit class test HDSS-FN1-BL-3 failed")
		 }catch (HydricDSSException e){
			 assertEquals(e.getMessage(), "The input file has no data or doesn’t match the expected format");
		 }
	 }

	 /* Test case: HDSS-FN1-TC-28
 	 * Boundary limit:  HDSS-FN1-BL-4
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidResourceName49.json
     */
	 @Test
	 public void validResourceName49charTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validResourceName49.json");

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

		 assertEquals(reservoir.getMyName(), "reallyreallyreallyreallyreallyreallyreallyLongNam");
		 assertEquals(reservoir.getMyName().getLength(), 49, 0.001);
	 }

	 /* Test case: HDSS-FN1-TC-29
 	 * Boundary limit:  HDSS-FN1-BL-5
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidResourceName50.json
     */
	 @Test
	 public void validResourceName50charTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validResourceName50.json");

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

		 assertEquals(reservoir.getMyName(), "reallyreallyreallyreallyreallyreallyreallyLongName");
		 assertEquals(reservoir.getMyName().getLength(), 50, 0.001);
	 }

	 /* Test case: HDSS-FN1-TC-30
 	 * Boundary limit:  HDSS-FN1-BL-6
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: Throws exception. Error message: "The input file has no data or doesn’t match the expected format”
     */
	 @Test
	 public void invalidResourceNameTest(){
		 try {
			 manager.RegisterHydricResources("data/hdss-rf01-invalidResourceName.json");
			 fail("Boundary limit class test HDSS-FN1-BL-6 failed")
		 }catch (HydricDSSException e){
			 assertEquals(e.getMessage(), "The input file has no data or doesn’t match the expected format");
		 }
	 }

	 /* Test case: HDSS-FN1-TC-32
 	 * Boundary limit:  HDSS-FN1-BL-8
 	 * Testing technique: Boundary Limit Analysis
 	 * Expected value: hdss-rf01-expectedValidResourceCapacity0_01.json
     */
	 @Test
	 public void validResourceCapacityTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validResourceCapacity0_01.json");

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
		 assertEquals(reservoir.getMaxCapacity(), 0.01, 0.001);
	 }

	 /* Test case: HDSS-FN1-TC-33
 	 * Boundary limit:  HDSS-FN1-BL-9
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: Throws exception. Error message: "The input file has no data or doesn’t match the expected format”
     */
	 @Test
	 public void invalidResourceCapacity(){
		 try {
			 manager.RegisterHydricResources("data/hdss-rf01-invalidResourceCapacity.json");
			 fail("Boundary limit class test HDSS-FN1-BL-9 failed")
		 }catch (HydricDSSException e){
			 assertEquals(e.getMessage(), "The input file has no data or doesn’t match the expected format");
		 }
	 }

	 /* Test case: HDSS-FN1-TC-34
 	 * Boundary limit:  HDSS-FN1-BL-10
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidResourceCapacityTwoDecimals.json
     */
	 @Test
	 public void validResourceCapacityTwoDecimalsTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validResourceCapacityTwoDecimals.json");

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
	 }

	 /* Test case: HDSS-FN1-TC-35
 	 * Boundary limit:  HDSS-FN1-BL-11
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidResourceCapacityOneDecimal.json
     */
	 @Test
	 public void validResourceCapacityOneDecimalTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("data/hdss-rf01-validResourceCapacityOneDecimal.json");

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
		 assertEquals(reservoir.getMaxCapacity(), 2.2, 0.001);
	 }

	 /* Test case: HDSS-FN1-TC-36
 	 * Boundary limit:  HDSS-FN1-BL-12
 	 * Testing technique: Boundary Values Limits
 	 * Expected value: hdss-rf01-expectedValidResourceCapacityZeroDecimals.json
     */
	 @Test
	 public void validResourceCapacityZeroDecimalsTest() throws HydricDSSException{
		 WatershedsListPublicData result;
		 result = manager.RegisterHydricResources("hdss-rf01-validResourceCapacityZeroDecimals.json");

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
		 assertEquals(reservoir.getMaxCapacity(), 2, 0.001);
	 }

	 /* Test case: HDSS-FN1-TC-37
 	 * Boundary limit:  HDSS-FN1-BL-13
 	 * Testing technique: Boundary Limit Analysis
 	 * Expected value: Throws exception. Error message: "The input file has no data or doesn’t match the expected format”
     */
	 @Test
	 public void invalidResourceCapacityThreeDecimalsTest(){
		 try {
			 manager.RegisterHydricResources("data/hdss-rf01-invalidResourceCapacityThreeDecimals.json");
			 fail("Boundary limit class test HDSS-FN1-BL-13 failed")
		 }catch (HydricDSSException e){
			 assertEquals(e.getMessage(), "The input file has no data or doesn’t match the expected format");
		 }
	 }

}
