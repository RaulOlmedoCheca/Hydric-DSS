package hdss.tests;

import static org.junit.Assert.*;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;

import hdss.WatershedManagerInterface;
import hdss.WatershedManager;
import hdss.exceptions.HydricDSSException;

import hdss.io.AquiferPublicData;
import hdss.io.DesalinationPlantPublicData;
import hdss.io.ReservoirPublicData;
import hdss.io.WatershedPublicData;
import hdss.io.WatershedsListPublicData;

import hdss.io.ScenarioPublicData;

public class IdentifyCurrentState_EClasses {

    private WatershedManagerInterface manager = new WatershedManager();

    // PLANTILLA
   /* public void test() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/file.json");
        result = manager.IdentifyCurrentState("data/aquifer.json", "aquifer");
        assertEquals("SHORTAGE", result.getScenarioEvaluation());
    }
    */

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
    public void basicValidTest() throws HydricDSSException {
        WatershedsListPublicData input;
        input = manager.RegisterHydricResources("data/hdss-rf02-validRegisterHydricResourcesCase.json");

        List<WatershedPublicData> watershedList;
        watershedList = input.getWatershedList();

        assertEquals(watershedList.size(), 1);

        WatershedPublicData watershed;
        watershed = watershedList.get(0);
        /*

        ScenarioPublicData result;
        result = manager.IdentifyCurrentState("filepath","scope");

        assertEquals(watershed.getName(), result.getWatershedName());

        Format formatter = new SimpleDateFormat("dd/MM/yy");
        String date = formatter.format(result.getScenarioEvaluationDate());

        assertEquals(date, "04/06/17");

        assertEquals(result.getEvaluationScope(), "scope");

        assertEquals(result.getScenarioEvaluation(),expectedEvalutaion);

        */
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

        assertEquals(aquifer.getMyName(), "aquifer1");

    }

    /* Test case: HDSS-FN2-TC-2
     * Equivalence class: HDSS-FN2-EQ-1
     * Testing technique: Equivalence Classes Analysis
      * Expected value: Throws Exception. Error message: "An input data file is not found"
    */
    @Test
    public void notFoundFileTest() throws HydricDSSException {
        manager.RegisterHydricResources("nonexists.json");
        try {
            manager.IdentifyCurrentState("nonexists.json", "reservoir");
            fail("An input can not be found but no exception was risen");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "An input data file is not found");
        }
    }

    /* Test case: HDSS-FN2-TC-3
     * Equivalence class: HDSS-FN2-BL-7
     * Testing technique: Boundary Limit Analysis
      * Expected value: hdss-rf02-expectedCapacityZero.json
     */
    @Test
    public void zeroCapacityBasinTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-capacityZero.json");

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
    public void invalidJSONFormatTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidJson.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidJson.json", "reservoir");
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
    public void emptyFileTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-emptyFile.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-emptyFile.json","reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-5 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-6
     * Equivalence class: HDSS-FN2-EQ-7
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "Tried to record an irrigation basin with an existing name"
     */
    @Test
    public void existingIrrigationBasinTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-existingIrrigationBasinName1.json");
        manager.IdentifyCurrentState("data/RF02/hdss-rf02-existingIrrigationBasinName1.json","reservoir");
        try {
            manager.RegisterHydricResources("data/RF02/hdss-rf02-existingIrrigationBasinName2.json");
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-existingIrrigationBasinName2.json","reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-7 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "Tried to record an irrigation basin with an existing name");
        }
    }

    /* Test case: HDSS-FN2-TC-7
     * Equivalence class: HDSS-FN2-EQ-10
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void longIrrigationBasinNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-longIrrigationBasinName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-longIrrigationBasinName.json","reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-10 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-8
     * Equivalence class: HDSS-FN2-EQ-11
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void noIrrigationBasinNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-noIrrigationBasinName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-noIrrigationBasinName.json","desalination plant");
            fail("Equivalence class test HDSS-FN2-EQ-11 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-9
     * Equivalence class: HDSS-FN2-EQ-12
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void severalIrrigationBasinNamesTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-severalIrrigationBasinNames.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-severalIrrigationBasinNames.json","reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-12 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-10
     * Equivalence class: HDSS-FN2-EQ-14
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void noResourcesListTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-noResourcesList.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-noResourcesList.json","reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-14 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-11
     * Equivalence class: HDSS-FN2-EQ-15
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void severalResourcesListsTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-severalResourcesLists.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-severalResourcesLists.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-15 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-12
     * Equivalence class: HDSS-FN2-EQ-17
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "Tried to record a resource basin with an existing name"
     */
    @Test
    public void existingResourceNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-existingResourceName.json");
        manager.IdentifyCurrentState("data/RF02/hdss-rf02-existingResourceName.json", "reservoir");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-existingResourceName.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-17 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "Tried to record a resource basin with an existing name");
        }
    }

    /* Test case: HDSS-FN2-TC-13
     * Equivalence class: HDSS-FN2-EQ-20
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void longResourceNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-longResourceName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-longResourceName.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-20 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-14
     * Equivalence class: HDSS-FN2-EQ-21
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void noResourceNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-noResourceName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-noResourceName.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-21 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-15
     * Equivalence class: HDSS-FN2-EQ-22
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void severalResourceNamesTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-severalResourceNames.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-severalResourceNames.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-22 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-16
     * Equivalence class: HDSS-FN2-EQ-27
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void invalidResourceTypeTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidResourceType.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidResourceType.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-27 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-17
     * Equivalence class: HDSS-FN2-EQ-28
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void noResourceTypeTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-noResourceType.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-noResourceType.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-28 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-18
     * Equivalence class: HDSS-FN2-EQ-29
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void severalResourceTypesTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-severalResourceTypes.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-severalResourceTypes.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-29 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-19
     * Equivalence class: HDSS-FN2-EQ-31
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void negativeResourceCapacityTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-negativeResourceCapacity.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-negativeResourceCapacity.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-31 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-20
     * Equivalence class: HDSS-FN2-EQ-33
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void notValidResourceCapacityTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidResourceCapacity.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidResourceCapacity.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-33 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-21
     * Equivalence class: HDSS-FN2-EQ-35
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void notValidResourceCapacityDecimalFormatTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-notValidResourceCapacityDecimalFormat.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-notValidResourceCapacityDecimalFormat.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-35 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-22
     * Equivalence class: HDSS-FN2-EQ-37
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void noCapacityFoundNotAquiferTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-noCapacityNotAquifer.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-noCapacityNotAquifer.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-37 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-23
     * Equivalence class: HDSS-FN2-EQ-38
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void severalCapacityValuesNotAquiferTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-severalCapacityValuesNotAquifer.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-severalCapacityValuesNotAquifer.json", "reservoir");
            fail("Equivalence class test HDSS-FN2-EQ-38 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-24
     * Equivalence class: HDSS-FN2-EQ-41
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws Exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void capacityFoundAquiferTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-capacityFoundAquifer.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-capacityFoundAquifer.json", "aquifer");
            fail("Equivalence class test HDSS-FN2-EQ-41 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-25
     * Boundary limit:  HDSS-FN2-BL-1
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidIrrigationBasinName49.json
    */
    @Test
    public void validIrrigationBasinName49charTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validIrrigationBasinName49.json");

        List<WatershedPublicData> watershedList;
        watershedList = result.getWatershedList();

        assertEquals(watershedList.size(), 1);

        WatershedPublicData watershed;
        watershed = watershedList.get(0);

        assertEquals(watershed.getName(), "reallyreallyreallyreallyreallyreallyreallyLongNam");
        assertEquals(watershed.getName().length(), 49, 0.01);

    }

    /* Test case: HDSS-FN2-TC-26
     * Boundary limit:  HDSS-FN2-BL-2
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidIrrigationBasinName50.json
    */
    @Test
    public void validIrrigationBasinName50charTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validIrrigationBasinName50.json");

        List<WatershedPublicData> watershedList;
        watershedList = result.getWatershedList();

        assertEquals(watershedList.size(), 1);

        WatershedPublicData watershed;
        watershed = watershedList.get(0);

        assertEquals(watershed.getName(), "reallyreallyreallyreallyreallyreallyreallyLongName");
        assertEquals(watershed.getName().length(), 50, 0.01);
    }

    /* Test case: HDSS-FN2-TC-27
     * Boundary limit:  HDSS-FN2-BL-3
     * Testing technique: Boundary Values Limits
     * Expected value: Throws exception. Error message: "The input file has no data or does not match the expected format"
    */
    @Test
    public void invalidIrrigationBasinNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidIrrigationBasinName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidIrrigationBasinName.json", "reservoir");
            fail("Boundary limit class test HDSS-FN2-BL-3 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-28
     * Boundary limit:  HDSS-FN2-BL-4
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidResourceName49.json
    */
    @Test
    public void validResourceName49charTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceName49.json");

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
        assertEquals(reservoir.getMyName().length(), 49, 0.001);
    }

    /* Test case: HDSS-FN2-TC-29
     * Boundary limit:  HDSS-FN2-BL-5
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidResourceName50.json
    */
    @Test
    public void validResourceName50charTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceName50.json");

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
        assertEquals(reservoir.getMyName().length(), 50, 0.001);
    }

    /* Test case: HDSS-FN2-TC-30
     * Boundary limit:  HDSS-FN2-BL-6
     * Testing technique: Boundary Values Limits
     * Expected value: Throws exception. Error message: "The input file has no data or does not match the expected format"
    */
    @Test
    public void invalidResourceNameTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidResourceName.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidResourceName.json", "reservoir");
            fail("Boundary limit class test HDSS-FN2-BL-6 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-31
     * Boundary limit:  HDSS-FN2-BL-8
     * Testing technique: Boundary Limit Analysis
     * Expected value: hdss-rf02-expectedValidResourceCapacity0_01.json
    */
    @Test
    public void validResourceCapacityTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceCapacity0_01.json");

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

    /* Test case: HDSS-FN2-TC-32
     * Boundary limit:  HDSS-FN2-BL-9
     * Testing technique: Boundary Values Limits
     * Expected value: Throws exception. Error message: "The input file has no data or does not match the expected format"
    */
    @Test
    public void invalidResourceCapacityTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidResourceCapacity.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidResourceCapacity.json", "reservoir");
            fail("Boundary limit class test HDSS-FN2-BL-9 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-33
     * Boundary limit:  HDSS-FN2-BL-10
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidResourceCapacityTwoDecimals.json
    */
    @Test
    public void validResourceCapacityTwoDecimalsTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceCapacityTwoDecimals.json");

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

    /* Test case: HDSS-FN2-TC-34
     * Boundary limit:  HDSS-FN2-BL-11
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidResourceCapacityOneDecimal.json
    */
    @Test
    public void validResourceCapacityOneDecimalTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceCapacityOneDecimal.json");

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

    /* Test case: HDSS-FN2-TC-35
     * Boundary limit:  HDSS-FN2-BL-12
     * Testing technique: Boundary Values Limits
     * Expected value: hdss-rf02-expectedValidResourceCapacityZeroDecimals.json
    */
    @Test
    public void validResourceCapacityZeroDecimalsTest() throws HydricDSSException {
        WatershedsListPublicData result;
        result = manager.RegisterHydricResources("data/RF02/hdss-rf02-validResourceCapacityZeroDecimals.json");

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

    /* Test case: HDSS-FN2-TC-36
     * Boundary limit:  HDSS-FN2-BL-13
     * Testing technique: Boundary Limit Analysis
     * Expected value: Throws exception. Error message: "The input file has no data or does not match the expected format"
    */
    @Test
    public void invalidResourceCapacityThreeDecimalsTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidResourceCapacityThreeDecimals.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidResourceCapacityThreeDecimals.json", "reservoir");
            fail("Boundary limit class test HDSS-FN2-BL-13 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }

    /* Test case: HDSS-FN2-TC-37
     * Equivalence class: HDSS-FN2-EQ-42
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidPlentyReservoir.json
     */
    @Test
    public void validPlentyReservoirTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validPlentyResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validPlentyResources.json", "reservoir");
        assertEquals("PLENTY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-38
     * Equivalence class: HDSS-FN2-EQ-43
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidPlentyDesalinationPlant.json
     */
    @Test
    public void validPlentyDesalinationPlantTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validPlentyResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validPlentyResources.json", "desalination plant");
        assertEquals("PLENTY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-39
     * Equivalence class: HDSS-FN2-EQ-44
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidPlentyAquifer.json
     */
    @Test
    public void validPlentyAquiferTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validPlentyResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validPlentyResources.json", "aquifer");
        assertEquals("PLENTY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-40
     * Equivalence class: HDSS-FN2-EQ-45
     * Testing technique: Equivalence Classes Analysis
     * Expected value:
     */
    @Test
    public void validPlentyAllTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validPlentyResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validPlentyResources.json", "all");
        assertEquals("PLENTY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-41
     * Equivalence class: HDSS-FN2-EQ-46
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidNormalityReservoir.json
     */
    @Test
    public void validNormalityReservoirTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validNormalityResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validNormalityResources.json", "reservoir");
        assertEquals("NORMALITY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-42
     * Equivalence class: HDSS-FN2-EQ-47
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidNormalityDesalinationPlant.json
     */
    @Test
    public void validNormalityDesalinationPlantTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validNormalityResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validNormalityResources.json", "desalination plant");
        assertEquals("NORMALITY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-43
     * Equivalence class: HDSS-FN2-EQ-48
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidNormalityAquifer.json
     */
    @Test
    public void validNormalityAquiferTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validNormalityResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validNormalityResources.json", "aquifer");
        assertEquals("NORMALITY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-44
     * Equivalence class: HDSS-FN2-EQ-49
     * Testing technique: Equivalence Classes Analysis
     * Expected value:
     */
    @Test
    public void validNormalityAllTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validNormalityResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validNormalityResources.json", "all");
        assertEquals("NORMALITY", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-45
     * Equivalence class: HDSS-FN2-EQ-50
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidShortageReservoir.json
     */
    @Test
    public void validShortageReservoirTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validShortageResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validShortageResources.json", "reservoir");
        assertEquals("SHORTAGE", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-46
     * Equivalence class: HDSS-FN2-EQ-51
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidShortageDesalinationPlant.json
     */
    @Test
    public void validShortageDesalinationPlantTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validShortageResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validShortageResources.json", "desalination plant");
        assertEquals("SHORTAGE", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-47
     * Equivalence class: HDSS-FN2-EQ-52
     * Testing technique: Equivalence Classes Analysis
     * Expected value: hdss-rf02-expectedValidShortageAquifer.json
     */
    @Test
    public void validShortageAquiferTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validShortageResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validShortageResources.json", "aquifer");
        assertEquals("SHORTAGE", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-48
    * Equivalence class: HDSS-FN2-EQ-53
    * Testing technique: Equivalence Classes Analysis
    * Expected value:
    */
    @Test
    public void validShortageAllTest() throws HydricDSSException {
        ScenarioPublicData result;
        manager.RegisterHydricResources("data/RF02/hdss-rf02-validShortageResources.json");
        result = manager.IdentifyCurrentState("data/RF02/hdss-rf02-validShortageResources.json", "all");
        assertEquals("SHORTAGE", result.getScenarioEvaluation());
    }

    /* Test case: HDSS-FN2-TC-49
     * Equivalence class: HDSS-FN2-EQ-54
     * Testing technique: Equivalence Classes Analysis
     * Expected value: Throws exception. Error message: "The input file has no data or does not match the expected format"
     */
    @Test
    public void invalidCapacityResourcesTest() throws HydricDSSException {
        manager.RegisterHydricResources("data/RF02/hdss-rf02-invalidCapacityResources.json");
        try {
            manager.IdentifyCurrentState("data/RF02/hdss-rf02-invalidCapacityResources.json", "reservoir");
            fail("Boundary limit class test HDSS-FN2-EQ-54 failed");
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), "The input file has no data or does not match the expected format");
        }
    }


}
