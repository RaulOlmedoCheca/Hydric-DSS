package hdss.tests;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import hdss.WatershedManagerInterface;
import hdss.WatershedManager;
import hdss.exceptions.HydricDSSException;

@RunWith(Parameterized.class)
public class RegisterIrrigationDemand_Syntax {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"data/RF03_syntax/hdss-rf03-correctFile.json.jsonRF01_syntax/hdss-rf01-syntaxError1.json", "Valid file", "HDSS-RF-03 Syntactically Valid File"},
                {"data/RF03_syntax/hdss-rf03-syntaxError2.json", "Missing {", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError3.json", "Missing }", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError4.json", "Missing body", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError5.json", "Missing drainage basin field", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError6.json", "Missing requester field", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError7.json", "Missing state field", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError8.json", "Missing amount field", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError9.json", "Missing irrigation date field", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError10.json", "Missing drainage basin value", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError11.json", "Missing drainage basin label", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError12.json", "Missing ,", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError13.json", "Missing :", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError14.json", "Missing .", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError15.json", "Empty drainage basin value", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError16.json", "Empty drainage basin label", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError17.json", "Missing right \" in value", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError18.json", "Missing left \" in value", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError19.json", "Missing right \" in label", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError20.json", "Missing left \" in label", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError21.json", "Repetition of file", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError22.json", "Repetition of {", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError23.json", "Repetition of }", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError24.json", "Repetition of body", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError25.json", "Repetition of drainage basin label", "HDSS-RF-03 Syntax Error: "},
                {"data/RF03_syntax/hdss-rf03-syntaxError26.json", "Repetition of left \" in label", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError27.json", "Repetition of right \" in label", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError28.json", "Repetition of left \" in value", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError29.json", "Repetition of right \" in value", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError30.json", "Repetition of : ", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError31.json", "Repetition of value", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError32.json", "Repetition of ,", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError33.json", "Repetition of field", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError34.json", "Repetition of .", "HDSS-RF-03 Syntax Error: Repetition of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError35.json", "Modification of drainage basin label", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError37.json", "Modification of {", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError38.json", "Modification of }", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError39.json", "Modification of amount type value", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError40.json", "Modification of \"", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError41.json", "Modification of .", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError42.json", "Modification of state value", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError43.json", "Modification of ,", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError44.json", "Modification of drainage basin value", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError45.json", "Modification of requester label", "HDSS-RF-03 Syntax Error: Modification of nodes"},
                {"data/RF03_syntax/hdss-rf03-syntaxError46.json", "Modification of irrigation date label", "HDSS-RF-03 Syntax Error: Modification of nodes"},
        });
    }

    private WatershedManagerInterface manager = new WatershedManager();

    private String filepath;
    private String expectedErrorMessage;
    private String helpingFailMessage;

    public RegisterIrrigationDemand_Syntax(String filepath, String expectedErrorMessage, String helpingFailMessage) {
        this.filepath = filepath;
        this.expectedErrorMessage = expectedErrorMessage;
        this.helpingFailMessage = helpingFailMessage;
    }

    /* Test case: PARAMETERIZED TEST SUITE
    * Testing technique: Syntax analysis
    * Expected value: Throws an exception.
    */
    @Test
    public void fallingTest() {
        try {
            manager.RegisterHydricResources(filepath);
            fail(helpingFailMessage);
        } catch (HydricDSSException e) {
            assertEquals(e.getMessage(), expectedErrorMessage);
        }
    }

}
