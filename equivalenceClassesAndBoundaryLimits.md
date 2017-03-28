# Equivalence class and boundary limits analysis
## HDSS-RF-01
### Equivalence classes
- Equivalence class: HDSS-FN1-EQ-1
  - Input:  Non existing filename
  - Result: Error. "An input data file is not found"

- Equivalence class: HDSS-FN1-EQ-2
  - Input: Valid filename "validRegisterHydricResourcesCase.json"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-3
  - Input: Valid JSON file
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-4
  - Input: Non JSON format
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-5
  - Input: Empty file
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-6
  - Input: Non empty file
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-7
  - Input: Existing irrigation basin name
  - Result: Error. "Tried to record an irrigation basin with an existing name"

- Equivalence class: HDSS-FN1-EQ-8
  - Input: Non existing irrigation basin name
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-9
  - Input: Under 50 chars irrigation basin name "shortName"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-10
  - Input: Over 50 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-11
  - Input: No irrigation basin name found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-12
  - Input: Two or more irrigation basin names found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-13
  - Input: One irrigation basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-14
  - Input: No resources list found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-15
  - Input: Two or more resources lists found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-16
  - Input: One resources list found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-17
  - Input: Existing resource name
  - Result: Error. "Tried to record a resource basin with an existing name"

- Equivalence class: HDSS-FN1-EQ-18
  - Input: Non existing resource name
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-19
  - Input: Under 50 chars resource basin name "shortName"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-20
  - Input: Over 50 chars resource name "reallyreallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-21
  - Input: No resource name found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-22
  - Input: Two or more resource names found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-23
  - Input: One resource basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-24
  - Input: Resource type value = "Reservoir"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-25
  - Input: Resource type value = "Desalination plant"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-26
  - Input: Resource type value = "Aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-27
  - Input: Resource type value = "My mom"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-28
  - Input: No resource type found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-29
  - Input: Two or more resource types found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-30
  - Input: One resource basin type found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-31
  - Input: Negative capacity
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-32
  - Input: Positive capacity
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-33
  - Input: Capacity values is not a number "2.23"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-34
  - Input: Capacity values is a number "2.23"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-35
  - Input: Capacity values is a number with more than 2 decimals "2.231"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-36
  - Input: Capacity values is a number with 2 or less decimals "2.23"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-37
  - Input: No capacity found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-38
  - Input: Two or more capacity values found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-39
  - Input: One capacity value found and resource type is not "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-40
  - Input: No capacity found and resource type is "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-41
  - Input: One or more capacity values found and resource type is "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

### Boundary limits
- Boundary limit: HDSS-FN1-BL-1
  - Input: 49 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongNam"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-2
  - Input: 50 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-3
  - Input: 51 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongNamee"
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN1-BL-4
  - Input: 49 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongNam"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-5
  - Input: 50 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-6
  - Input: 51 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongNamee"
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN1-BL-7
  - Input: Capacity value 0.00
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-8
  - Input: Capacity value 0.01
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-9
  - Input: Capacity value -0.01
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN1-BL-10
  - Input capacity: capacity with 2 decimals "2.23"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-11
  - Input capacity: capacity with 1 decimal "2.2"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-12
  - Input capacity: capacity with no decimals "2"
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-13
  - Input capacity: capacity with 3 decimal "2.223"
  - Result: Error: "The input file has no data or does not match the expected format"

### Test cases
#### HDSS-FN1-TC-1
- Equivalence classes considered:   HDSS-FN1-EQ-2, HDSS-FN1-EQ-3, HDSS-FN1-EQ-6, HDSS-FN1-EQ-8, HDSS-FN1-EQ-9, HDSS-FN1-EQ-13, HDSS-FN1-EQ-16, HDSS-FN1-EQ-18, HDSS-FN1-EQ-19, HDSS-FN1-EQ-23, HDSS-FN1-EQ-24, HDSS-FN1-EQ-25, HDSS-FN1-EQ-26, HDSS-FN1-EQ-30, HDSS-FN1-EQ-32, HDSS-FN1-EQ-34, HDSS-FN1-EQ-36, HDSS-FN1-EQ-39, HDSS-FN1-EQ-40
- Input:
  - Filename: "hdss-rf01-validRegisterHydricResourcesCase.json"
  - Expected output: "hdss-rf01-expectedValidRegisterHydricResourcesCase.json"

#### HDSS-FN1-TC-2
- Equivalence class considered: HDSS-FN1-EQ-1
- Input:
  - Filename "nonexists.json"
  - Expected output: Throws Exception. Error message: "An input data file is not found"

#### HDSS-FN1-TC-3
- Boundary limit considered: HDSS-FN1-BL-7
- Input:
  - Filename "hdss-rf01-capacityZero.json"
  - Expected output: "hdss-rf01-expectedCapacityZero.json"

#### HDSS-FN1-TC-4
- Equivalence class considered: HDSS-FN1-EQ-4
- Input:
  - Filename "hdss-rf01-invalidJson.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-5
- Equivalence class considered: HDSS-FN1-EQ-5
- Input:
  - Filename "hdss-rf01-empty.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-6
- Equivalence class considered: HDSS-FN1-EQ-7
- Input:
  - Filename "hdss-rf01-existingIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "Tried to record an irrigation basin with an existing name"

#### HDSS-FN1-TC-7
- Equivalence class considered: HDSS-FN1-EQ-10
- Input:
  - Filename "hdss-rf01-longIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-8
- Equivalence class considered: HDSS-FN1-EQ-11
- Input:
  - Filename "hdss-rf01-noIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-9
- Equivalence class considered: HDSS-FN1-EQ-12
- Input:
  - Filename "hdss-rf01-severalIrrigationBasinNames.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-10
- Equivalence class considered: HDSS-FN1-EQ-14
- Input:
  - Filename "hdss-rf01-noResourcesList.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-11
- Equivalence class considered: HDSS-FN1-EQ-15
- Input:
  - Filename "hdss-rf01-severalResourcesLists.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-12
- Equivalence class considered: HDSS-FN1-EQ-17
- Input:
  - Filename "hdss-rf01-existingResourceName.json"
  - Expected output: Throws Exception. Error message: "Tried to record a resource basin with an existing name"

#### HDSS-FN1-TC-13
- Equivalence class considered: HDSS-FN1-EQ-20
- Input:
  - Filename "hdss-rf01-longResourceName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-14
- Equivalence class considered: HDSS-FN1-EQ-21
- Input:
  - Filename "hdss-rf01-noResourceName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-15
- Equivalence class considered: HDSS-FN1-EQ-22
- Input:
  - Filename "hdss-rf01-severalResourceNames.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-16
- Equivalence class considered: HDSS-FN1-EQ-27
- Input:
  - Filename "hdss-rf01-invalidResourceType.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-17
- Equivalence class considered: HDSS-FN1-EQ-28
- Input:
  - Filename "hdss-rf01-noResourceType.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-18
- Equivalence class considered: HDSS-FN1-EQ-29
- Input:
  - Filename "hdss-rf01-severalResourceTypes.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-19
- Equivalence class considered: HDSS-FN1-EQ-31
- Input:
  - Filename "hdss-rf01-negativeResourceCapacity.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-20
- Equivalence class considered: HDSS-FN1-EQ-33
- Input:
  - Filename "hdss-rf01-notValidResourceCapacity.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-21
- Equivalence class considered: HDSS-FN1-EQ-35
- Input:
  - Filename "hdss-rf01-notValidResourceCapacityDecimalFormat.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-22
- Equivalence class considered: HDSS-FN1-EQ-37
- Input:
  - Filename "hdss-rf01-noCapacityNotAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-23
- Equivalence class considered: HDSS-FN1-EQ-38
- Input:
  - Filename "hdss-rf01-severalCapacityValuesNotAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-24
- Equivalence class considered: HDSS-FN1-EQ-41
- Input:
  - Filename "hdss-rf01-capacityFoundAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-25
- Boundary limit considered: HDSS-FN1-BL-1
- Input:
    - Filename "hdss-rf01-validIrrigationBasinName49.json"
    - Expected output: "hdss-rf01-expectedValidIrrigationBasinName49.json"

#### HDSS-FN1-TC-26
- Boundary limit considered: HDSS-FN1-BL-2
- Input:
    - Filename "hdss-rf01-validIrrigationBasinName50.json"
    - Expected output: "hdss-rf01-expectedValidIrrigationBasinName50.json"

#### HDSS-FN1-TC-27
- Boundary limit considered: HDSS-FN1-BL-3
- Input:
    - Filename "hdss-rf01-invalidIrrigationBasinName.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-28
- Boundary limit considered: HDSS-FN1-BL-4
- Input:
    - Filename "hdss-rf01-validResourceName49.json"
    - Expected output: "hdss-rf01-expectedValidResourceName49.json"

#### HDSS-FN1-TC-29
- Boundary limit considered: HDSS-FN1-BL-5
- Input:
    - Filename "hdss-rf01-validResourceName50.json"
    - Expected output: "hdss-rf01-expectedValidResourceName50.json"

#### HDSS-FN1-TC-30
- Boundary limit considered: HDSS-FN1-BL-6
- Input:
    - Filename "hdss-rf01-invalidResourceName.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-31
- Boundary limit considered: HDSS-FN1-BL-8
- Input:
    - Filename "hdss-rf01-validResourceCapacity0_01.json"
    - Expected output: "hdss-rf01-expectedValidResourceCapacity0_01.json"

#### HDSS-FN1-TC-32
- Boundary limit considered: HDSS-FN1-BL-9
- Input:
    - Filename "hdss-rf01-invalidResourceCapacity.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-33
- Boundary limit considered: HDSS-FN1-BL-10
- Input:
    - Filename "hdss-rf01-validResourceCapacityTwoDecimals.json"
    - Expected output: "hdss-rf01-expectedValidResourceCapacityTwoDecimals.json"

#### HDSS-FN1-TC-34
- Boundary limit considered: HDSS-FN1-BL-11
- Input:
    - Filename "hdss-rf01-validResourceCapacityOneDecimal.json"
    - Expected output: "hdss-rf01-expectedValidResourceCapacityOneDecimal.json"

#### HDSS-FN1-TC-35
- Boundary limit considered: HDSS-FN1-BL-12
- Input:
    - Filename "hdss-rf01-validResourceCapacityZeroDecimals.json"
    - Expected output: "hdss-rf01-expectedValidResourceCapacityZeroDecimals.json"

#### HDSS-FN1-TC-36
- Boundary limit considered: HDSS-FN1-BL-13
- Input:
    - Filename "hdss-rf01-invalidResourceCapacityThreeDecimals.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"


## HDSS-RF-02
### Equivalence classes
- Equivalence class: HDSS-FN2-EQ-1
  - Input:  Non existing filename
  - Result: Error. "An input data file is not found"

- Equivalence class: HDSS-FN2-EQ-2
  - Input: Valid filename "validRegisterHydricResourcesCase.json"
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-3
  - Input: Valid JSON file
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-4
  - Input: Non JSON format
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-5
  - Input: Empty file
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-6
  - Input: Non empty file
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-7
  - Input: Existing irrigation basin name
  - Result: Error. "Tried to record an irrigation basin with an existing name"

- Equivalence class: HDSS-FN2-EQ-8
  - Input: Non existing irrigation basin name
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-9
  - Input: Under 50 chars irrigation basin name "shortName"
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-10
  - Input: Over 50 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-11
  - Input: No irrigation basin name found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-12
  - Input: Two or more irrigation basin names found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-13
  - Input: One irrigation basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-14
  - Input: No resources list found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-15
  - Input: Two or more resources lists found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-16
  - Input: One resources list found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-17
  - Input: Existing resource name
  - Result: Error. "Tried to record a resource basin with an existing name"

- Equivalence class: HDSS-FN2-EQ-18
  - Input: Non existing resource name
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-19
  - Input: Under 50 chars resource basin name "shortName"
  - Result: valid case

- Equivalence class: HDSS-FN2-EQ-20
  - Input: Over 50 chars resource name "reallyreallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-21
  - Input: No resource name found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-22
  - Input: Two or more resource names found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-23
  - Input: One resource basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-24
  - Input: Resource type value = "Reservoir"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-25
  - Input: Resource type value = "Desalination plant"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-26
  - Input: Resource type value = "Aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-27
  - Input: Resource type value = "My mom"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-28
  - Input: No resource type found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-29
  - Input: Two or more resource types found
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-30
  - Input: One resource basin type found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-31
  - Input: Negative capacity
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-32
  - Input: Positive capacity
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-33
  - Input: Capacity values is not a number "word"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-34
  - Input: Capacity values is a number "2.23"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-35
  - Input: Capacity values is a number with more than 2 decimals "2.231"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-36
  - Input: Capacity values is a number with 2 or less decimals "2.23"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-37
  - Input: No capacity found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-38
  - Input: Two or more capacity values found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-39
  - Input: One capacity value found and resource type is not "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-40
  - Input: No capacity found and resource type is "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-41
  - Input: One or more capacity values found and resource type is "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-42
  - Input: One "reservoir" resource over 90% of capacity (PLENTY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-43
  - Input: One "desalination plant" resource over 90% of capacity (PLENTY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-44
  - Input: One "aquifer" resource over sea level capacity (PLENTY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-45
  - Input: One resource of each type with capacities over 90% (PLENTY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-46
  - Input: One "reservoir" resource between 40% and 90% of capacity (NORMALITY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-47
  - Input: One "desalination plant" resource between 40% and 90% of capacity (NORMALITY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-48
  - Input: One "aquifer" resource between -8 meters and sea level (NORMALITY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-49
  - Input: One resource of each type with capacities between 40% and 90% (NORMALITY)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-50
  - Input: One "reservoir" resource with capacity below 40% (SHORTAGE)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-51
  - Input: One "desalination plant" resource with capacity below 40% (SHORTAGE)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-52
  - Input: One "aquifer" resource with level below -8 meters (SHORTAGE)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-53
  - Input: One resource of each type with capacities below 40% (SHORTAGE)
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-54
  - Input: One "reservoir" type with percentage over 100%
  - Result: Error: "The input file has no data or does not match the expected format"

### Boundary limits
- Boundary limit: HDSS-FN2-BL-1
  - Input: 49 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongNam"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-2
  - Input: 50 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-3
  - Input: 51 chars irrigation basin name "reallyreallyreallyreallyreallyreallyreallyLongNamee"
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN2-BL-4
  - Input: 49 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongNam"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-5
  - Input: 50 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-6
  - Input: 51 chars resource name "reallyreallyreallyreallyreallyreallyreallyLongNamee"
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN2-BL-7
  - Input: Capacity value 0.00
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-8
  - Input: Capacity value 0.01
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-9
  - Input: Capacity value -0.01
  - Result: Error: "The input file has no data or does not match the expected format"

- Boundary limit: HDSS-FN2-BL-10
  - Input capacity: capacity with 2 decimals "2.23"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-11
  - Input capacity: capacity with 1 decimal "2.2"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-12
  - Input capacity: capacity with no decimals "2"
  - Result: valid case

- Boundary limit: HDSS-FN2-BL-13
  - Input capacity: capacity with 3 decimal "2.223"
  - Result: Error: "The input file has no data or does not match the expected format"

### Test cases
#### HDSS-FN2-TC-1
- Equivalence classes considered:   HDSS-FN2-EQ-2, HDSS-FN2-EQ-3, HDSS-FN2-EQ-6, HDSS-FN2-EQ-8, HDSS-FN2-EQ-9, HDSS-FN2-EQ-13, HDSS-FN2-EQ-16, HDSS-FN2-EQ-18, HDSS-FN2-EQ-19, HDSS-FN2-EQ-23, HDSS-FN2-EQ-24, HDSS-FN2-EQ-25, HDSS-FN2-EQ-26, HDSS-FN2-EQ-30, HDSS-FN2-EQ-32, HDSS-FN2-EQ-34, HDSS-FN2-EQ-36, HDSS-FN2-EQ-39, HDSS-FN2-EQ-40
- Input:
  - Filename: "hdss-rf02-validRegisterHydricResourcesCase.json"
  - Expected output: "hdss-rf02-expectedValidRegisterHydricResourcesCase.json"

#### HDSS-FN2-TC-2
- Equivalence class considered: HDSS-FN2-EQ-1
- Input:
  - Filename "nonexists.json"
  - Expected output: Throws Exception. Error message: "An input data file is not found"

#### HDSS-FN2-TC-3
- Boundary limit considered: HDSS-FN2-BL-7
- Input:
  - Filename "hdss-rf02-capacityZero.json"
  - Expected output: "hdss-rf02-expectedCapacityZero.json"

#### HDSS-FN2-TC-4
- Equivalence class considered: HDSS-FN2-EQ-4
- Input:
  - Filename "hdss-rf02-invalidJson.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-5
- Equivalence class considered: HDSS-FN2-EQ-5
- Input:
  - Filename "hdss-rf02-empty.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-6
- Equivalence class considered: HDSS-FN2-EQ-7
- Input:
  - Filename "hdss-rf02-existingIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "Tried to record an irrigation basin with an existing name"

#### HDSS-FN2-TC-7
- Equivalence class considered: HDSS-FN2-EQ-10
- Input:
  - Filename "hdss-rf02-longIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-8
- Equivalence class considered: HDSS-FN2-EQ-11
- Input:
  - Filename "hdss-rf02-noIrrigationBasinName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-9
- Equivalence class considered: HDSS-FN2-EQ-12
- Input:
  - Filename "hdss-rf02-severalIrrigationBasinNames.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-10
- Equivalence class considered: HDSS-FN2-EQ-14
- Input:
  - Filename "hdss-rf02-noResourcesList.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-11
- Equivalence class considered: HDSS-FN2-EQ-15
- Input:
  - Filename "hdss-rf02-severalResourcesLists.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-12
- Equivalence class considered: HDSS-FN2-EQ-17
- Input:
  - Filename "hdss-rf02-existingResourceName.json"
  - Expected output: Throws Exception. Error message: "Tried to record a resource basin with an existing name"

#### HDSS-FN2-TC-13
- Equivalence class considered: HDSS-FN2-EQ-20
- Input:
  - Filename "hdss-rf02-longResourceName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-14
- Equivalence class considered: HDSS-FN2-EQ-21
- Input:
  - Filename "hdss-rf02-noResourceName.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-15
- Equivalence class considered: HDSS-FN2-EQ-22
- Input:
  - Filename "hdss-rf02-severalResourceNames.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-16
- Equivalence class considered: HDSS-FN2-EQ-27
- Input:
  - Filename "hdss-rf02-invalidResourceType.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-17
- Equivalence class considered: HDSS-FN2-EQ-28
- Input:
  - Filename "hdss-rf02-noResourceType.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-18
- Equivalence class considered: HDSS-FN2-EQ-29
- Input:
  - Filename "hdss-rf02-severalResourceTypes.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-19
- Equivalence class considered: HDSS-FN2-EQ-31
- Input:
  - Filename "hdss-rf02-negativeResourceCapacity.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-20
- Equivalence class considered: HDSS-FN2-EQ-33
- Input:
  - Filename "hdss-rf02-notValidResourceCapacity.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-21
- Equivalence class considered: HDSS-FN2-EQ-35
- Input:
  - Filename "hdss-rf02-notValidResourceCapacityDecimalFormat.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-22
- Equivalence class considered: HDSS-FN2-EQ-37
- Input:
  - Filename "hdss-rf02-noCapacityNotAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-23
- Equivalence class considered: HDSS-FN2-EQ-38
- Input:
  - Filename "hdss-rf02-severalCapacityValuesNotAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-24
- Equivalence class considered: HDSS-FN2-EQ-41
- Input:
  - Filename "hdss-rf02-capacityFoundAquifer.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-25
- Boundary limit considered: HDSS-FN2-BL-1
- Input:
  - Filename "hdss-rf02-validIrrigationBasinName49.json"
  - Expected output: "hdss-rf02-expectedValidIrrigationBasinName49.json"

#### HDSS-FN2-TC-26
- Boundary limit considered: HDSS-FN2-BL-2
- Input:
   - Filename "hdss-rf02-validIrrigationBasinName50.json"
   - Expected output: "hdss-rf02-expectedValidIrrigationBasinName50.json"

#### HDSS-FN2-TC-27
- Boundary limit considered: HDSS-FN2-BL-3
- Input:
   - Filename "hdss-rf02-invalidIrrigationBasinName.json"
   - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-28
- Boundary limit considered: HDSS-FN2-BL-4
- Input:
   - Filename "hdss-rf02-validResourceName49.json"
   - Expected output: "hdss-rf02-expectedValidResourceName49.json"

#### HDSS-FN2-TC-29
- Boundary limit considered: HDSS-FN2-BL-5
- Input:
   - Filename "hdss-rf02-validResourceName50.json"
   - Expected output: "hdss-rf02-expectedValidResourceName50.json"

#### HDSS-FN2-TC-30
- Boundary limit considered: HDSS-FN2-BL-6
- Input:
   - Filename "hdss-rf02-invalidResourceName.json"
   - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-31
- Boundary limit considered: HDSS-FN2-BL-8
- Input:
   - Filename "hdss-rf02-validResourceCapacity0_01.json"
   - Expected output: "hdss-rf02-expectedValidResourceCapacity0_01.json"

#### HDSS-FN2-TC-32
- Boundary limit considered: HDSS-FN2-BL-9
- Input:
   - Filename "hdss-rf02-invalidResourceCapacity.json"
   - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-33
- Boundary limit considered: HDSS-FN2-BL-10
- Input:
   - Filename "hdss-rf02-validResourceCapacityTwoDecimals.json"
   - Expected output: "hdss-rf02-expectedValidResourceCapacityTwoDecimals.json"

#### HDSS-FN2-TC-34
- Boundary limit considered: HDSS-FN2-BL-11
- Input:
   - Filename "hdss-rf02-validResourceCapacityOneDecimal.json"
   - Expected output: "hdss-rf02-expectedValidResourceCapacityOneDecimal.json"

#### HDSS-FN2-TC-35
- Boundary limit considered: HDSS-FN2-BL-12
- Input:
   - Filename "hdss-rf02-validResourceCapacityZeroDecimals.json"
   - Expected output: "hdss-rf02-expectedValidResourceCapacityZeroDecimals.json"

#### HDSS-FN2-TC-36
- Boundary limit considered: HDSS-FN2-BL-13
- Input:
   - Filename "hdss-rf02-invalidResourceCapacityThreeDecimals.json"
   - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-37
- Equivalence class considered: HDSS-FN2-EQ-42
- Input:
  - Filename "hdss-rf02-validPlentyResources.json"
  - Expected output: "hdss-rf02-expectedValidPlentyReservoir.json"

#### HDSS-FN2-TC-38
- Equivalence class considered: HDSS-FN2-EQ-43
- Input:
  - Filename "hdss-rf02-validPlentyResources.json"
  - Expected output: "hdss-rf02-expectedValidPlentyDesalinationPlant.json"

#### HDSS-FN2-TC-39
- Equivalence class considered: HDSS-FN2-EQ-44
- Input:
  - Filename "hdss-rf02-validPlentyResources.json"
  - Expected output: "hdss-rf02-expectedValidPlentyAquifer.json"

#### HDSS-FN2-TC-40
- Equivalence class considered: HDSS-FN2-EQ-45
- Input:
  - Filename "hdss-rf02-validPlentyResources.json"
  - Expected output: "hdss-rf02-expectedValidPlentyAll.json"

#### HDSS-FN2-TC-41
- Equivalence class considered: HDSS-FN2-EQ-46
- Input:
  - Filename "hdss-rf02-validNormalityResources.json"
  - Expected output: "hdss-rf02-expectedValidNormalityReservoir.json"

#### HDSS-FN2-TC-42
- Equivalence class considered: HDSS-FN2-EQ-47
- Input:
  - Filename "hdss-rf02-validNormalityResources.json"
  - Expected output: "hdss-rf02-expectedValidNormalityDesalinationPlant.json"

#### HDSS-FN2-TC-43
- Equivalence class considered: HDSS-FN2-EQ-48
- Input:
  - Filename "hdss-rf02-validNormalityResources.json"
  - Expected output: "hdss-rf02-expectedValidNormalityAquifer.json"

#### HDSS-FN2-TC-44
- Equivalence class considered: HDSS-FN2-EQ-49
- Input:
  - Filename "hdss-rf02-validNormalityResources.json"
  - Expected output: "hdss-rf02-expectedValidNormalityAll.json"

#### HDSS-FN2-TC-45
- Equivalence class considered: HDSS-FN2-EQ-50
- Input:
  - Filename "hdss-rf02-validShortageResources.json"
  - Expected output: "hdss-rf02-expectedValidShortageReservoir.json"

#### HDSS-FN2-TC-46
- Equivalence class considered: HDSS-FN2-EQ-51
- Input:
  - Filename "hdss-rf02-validShortageResources.json"
  - Expected output: "hdss-rf02-expectedValidShortageDesalinationPlant.json"

#### HDSS-FN2-TC-47
- Equivalence class considered: HDSS-FN2-EQ-52
- Input:
  - Filename "hdss-rf02-validShortageResources.json"
  - Expected output: "hdss-rf02-expectedValidShortageAquifer.json"

#### HDSS-FN2-TC-48
- Equivalence class considered: HDSS-FN2-EQ-53
- Input:
  - Filename "hdss-rf02-validShortageResources.json"
  - Expected output: "hdss-rf02-expectedValidShortageAll.json"

#### HDSS-FN2-TC-49
- Equivalence class considered: HDSS-FN2-EQ-54
- Input:
  - Filename "hdss-rf02-invalidCapacityResources.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"
