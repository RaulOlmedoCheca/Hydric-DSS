# Guided exercise 3 - Hydric-DSS
## HDSS-RF-01
### Equivalence classes
-Equivalence class: HDSS-FN1-EQ-1
Input:  Non existing filename
Result: Error. “An input data file is not found”

-Equivalence class: HDSS-FN1-EQ-2
Input: Valid filename “validRegisterHydricResourcesCase.json”
Result: valid case

-Equivalence class: HDSS-FN1-EQ-3
Input: Valid JSON file
Result: valid case

Equivalence class: HDSS-FN1-EQ-4
Input: Non JSON format
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-5
Input: Empty file
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-6 Input: Non empty file
Result: valid case

Equivalence class: HDSS-FN1-EQ-7
Input: Existing irrigation basin name
Result: Error. “Tried to record an irrigation basin with an existing name”

Equivalence class: HDSS-FN1-EQ-8
Input: Non existing irrigation basin name
Result: valid case

Equivalence class: HDSS-FN1-EQ-9
Input: Under 50 chars irrigation basin name “shortName”
Result: valid case

Equivalence class: HDSS-FN1-EQ-10
Input: Over 50 chars irrigation basin name “reallyreallyreallyreallyreallyreallyreallyreallyLongName”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-11
Input: No irrigation basin name found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-12
Input: Two or more irrigation basin names found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-13
Input: One irrigation basin name found
Result: Valid case

Equivalence class: HDSS-FN1-EQ-14
Input: No resources list found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-15
Input: Two or more resources lists found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-16
Input: One resources list found
Result: Valid case

Equivalence class: HDSS-FN1-EQ-17
Input: Existing resource name
Result: Error. “Tried to record a resource basin with an existing name”

Equivalence class: HDSS-FN1-EQ-18
Input: Non existing resource name
Result: valid case

Equivalence class: HDSS-FN1-EQ-19
Input: Under 50 chars resource basin name “shortName”
Result: valid case

Equivalence class: HDSS-FN1-EQ-20
Input: Over 50 chars resource name “reallyreallyreallyreallyreallyreallyreallyreallyLongName”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-21
Input: No resource name found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-22
Input: Two or more resource names found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-23
Input: One resource basin name found
Result: Valid case

Equivalence class: HDSS-FN1-EQ-24
Input: Resource type value = “Reservoir”
Result: Valid case

Equivalence class: HDSS-FN1-EQ-25
Input: Resource type value = “Desalination plant”
Result: Valid case

Equivalence class: HDSS-FN1-EQ-26
Input: Resource type value = “Aquifer”
Result: Valid case

Equivalence class: HDSS-FN1-EQ-27
Input: Resource type value = “My mom”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-28
Input: No resource type found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-29
Input: Two or more resource types found
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-30
Input: One resource basin type found
Result: Valid case

Equivalence class: HDSS-FN1-EQ-31
Input: Negative capacity
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-32
Input: Positive capacity
Result: Valid case

Equivalence class: HDSS-FN1-EQ-33
Input: Capacity values is not a number “2,23”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-34
Input: Capacity values is a number “2.23”
Result: Error: Valid case

Equivalence class: HDSS-FN1-EQ-35
Input: Capacity values is a number with more than 2 decimals “2.231”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-36
Input: Capacity values is a number with 2 or less decimals “2.23”
Result: Error: valid case

Equivalence class: HDSS-FN1-EQ-37
Input: No resource type found and resource type is not “aquifer”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-38
Input: Two or more resource types found and resource type is not “aquifer”
Result: Error: “The input file has no data or doesn’t match the expected format”

Equivalence class: HDSS-FN1-EQ-39
Input: One resource basin type found and resource type is not “aquifer”
Result: Valid case

Equivalence class: HDSS-FN1-EQ-40
Input: No resource type found and resource type is “aquifer”
Result: Valid case

Equivalence class: HDSS-FN1-EQ-41
Input: One or more resource types found and resource type is not “aquifer”
Result: Error: “The input file has no data or doesn’t match the expected format”
