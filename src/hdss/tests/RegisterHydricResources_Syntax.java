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
public class RegisterHydricResources_Syntax {

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] {
			{"data/RF01_syntax/hdss-rf01-correctFile.json", "Valid file", "HDSS-RF-01 Syntactically Valid File "},
			{"data/RF01_syntax/hdss-rf01-syntaxError1.json", "Empty file", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError2.json", "Missing {", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError3.json", "Missing body", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError4.json", "Missing }", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError5.json", "Missing irrigation_basin_name", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError6.json", "Missing :", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError7.json", "Missing resource array", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError8.json", "Missing [", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError9.json", "Missing ]", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError10.json", "Missing resource name field", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError11.json", "Missing resource type field", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError12.json", "Missing resource capacity field", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError13.json", "Missing resource label", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError14.json", "Missing resource value", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError15.json", "Missing capacity value", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError16.json", "Missing .", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError17.json", "Missing ,", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError18.json", "Missing resource name value", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError19.json", "Missing left quotes", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError20.json", "Missing right quotes", "HDSS-RF-01 Syntax Error: Omission of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError21.json", "Repetition of {", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError22.json", "Repetition of }", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError23.json", "Repetition of file", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError24.json", "Repetition of body", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError25.json", "Repetition of irrigation_basin_name", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError26.json", "Repetition of :", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError27.json", "Repetition of resources array", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError28.json", "Repetition of [", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError29.json", "Repetition of ]", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError30.json", "Repetition of resource name", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError31.json", "Repetition of resource label", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError32.json", "Repetition of resource value", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError33.json", "Repetition of resource capacity value", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError34.json", "Repetition of .", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError35.json", "Repetition of ,", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError36.json", "Repetition of left quotes", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError37.json", "Repetition of right quotes", "HDSS-RF-01 Syntax Error: Repetition of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError38.json", "Modification of {", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError39.json", "Modification of }", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError40.json", "Modification of body", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError41.json", "Modification of :", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError42.json", "Modification of [", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError43.json", "Modification of ]", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError44.json", "Modification of left quotes", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError45.json", "Modification of right quotes", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError46.json", "Modification of name resource label", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError47.json", "Modification of type resource label", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError48.json", "Modification of type resource value", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError49.json", "Modification of capacity resource label", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError50.json", "Modification of .", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"},
			{"data/RF01_syntax/hdss-rf01-syntaxError51.json", "Modification of ,", "HDSS-RF-01 Syntax Error: HDSS-RF-01 Syntax Error: Modification of nodes"}
		});
	}

	private WatershedManagerInterface manager = new WatershedManager();

	private String filepath;
	private String expectedErrorMessage;
	private String helpingFailMessage;

	public RegisterHydricResources_Syntax(String filepath, String expectedErrorMessage, String helpingFailMessage) {
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
		try{
			manager.RegisterHydricResources(filepath);
			fail(helpingFailMessage);
		}catch(HydricDSSException e){
			assertEquals(e.getMessage(), expectedErrorMessage);
		}
	}

}
