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
                {"data/RF01_syntax/hdss-rf01-syntaxError1.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError2.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError3.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError4.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError5.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError6.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError7.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError8.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError9.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError10.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError11.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError12.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError13.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError14.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError15.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError16.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError17.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError18.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError19.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError20.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError21.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError22.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError23.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError24.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError25.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError26.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError27.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError28.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError29.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError30.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError31.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError32.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError33.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError34.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError35.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError36.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError37.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError38.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError39.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError40.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError41.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError42.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError43.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError44.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError45.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},
                {"data/RF01_syntax/hdss-rf01-syntaxError46.json", "Empty file", "HDSS-RF-03 Syntax Error: Omission of nodes"},

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
