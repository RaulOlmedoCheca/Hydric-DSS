# Guided exercise 3 - Hydric-DSS
## Index
- HDSS-RF-01
  - Equivalence classes
  - Boundary limits
  - Test cases
  - Syntax analysis
- HDSS-RF-02
  - Equivalence classes
  - Boundary limits
  - Test cases
  - Syntax analysis
- HDSS-RF-03
  - Syntax analysis

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
  - Result: Error: valid case

- Equivalence class: HDSS-FN1-EQ-37
  - Input: No resource type found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-38
  - Input: Two or more resource types found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN1-EQ-39
  - Input: One resource basin type found and resource type is not "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-40
  - Input: No resource type found and resource type is "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-41
  - Input: One or more resource types found and resource type is not "aquifer"
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
  - Filename "nonexists.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-23
- Equivalence class considered: HDSS-FN1-EQ-38
- Input:
  - Filename "nonexists.json"
  - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN1-TC-24
- Equivalence class considered: HDSS-FN1-EQ-41
- Input:
  - Filename "nonexists.json"
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

### Syntax analysis
**File::=** Init_Object Body End_Object
**Body::=** Irrigation_Basin_Name Label_Value_Separator Resources

**Irrigation_Basin_Name::=** Quotes Irrigation_Basin_Name_Value Quotes
**Resources::=** Init_Array 0[Resource_Object Fields_Separator]n 0[Resource_Object]1 End_Array

**Resource_Object::=** Init_Object Resource_Name Fields_Separator Resource_Type Fields_Separator Resource_Capacity End_Object

**Resource_Name::=** Quotes Resource_Name_Label Quotes Label_Value_Separator Quotes Resource_Name_Value Quotes
**Resource_Type::=** Quotes Resource_Type_Label Quotes Label_Value_Separator Quotes Resource_Type_Value Quotes
**Resource_Capacity::=** Quotes Resource_Capacity_Label Quotes Label_Value_Separator Resource_Capacity_Value

**Resource_Name_Label::=** 'Name'
**Resource_Type_Label::=** 'Type'
**Resource_Capacity_Label::=** 'Capacity'

**Resource_Name_Value::=** 1[Character]50
**Resource_Type_Value::=** 'Reservoir'|'Desalination plant'|'Aquifer'
**Resource_Capacity_Value::=** 1[Number]n Point 2[Number]2

**Init_Object::=**'{'
**End_Object::=**'}'
**Label_Value_Separator::=**':'
**Init_Array::=**'['
**End_Array::=**']'
**Fields_Separator::=**','
**Quotes::=**'"'

**Character::=**'a'|'b'|'c'|...|'z'
**Point::=**'.'
**Number::=**'0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'


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
  - Input: Capacity values is not a number "2.23"
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
  - Input: No resource type found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-38
  - Input: Two or more resource types found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-39
  - Input: One resource basin type found and resource type is not "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-40
  - Input: No resource type found and resource type is "aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-41
  - Input: One or more resource types found and resource type is not "aquifer"
  - Result: Error: "The input file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-42
  - Input: Existing drainage basin name
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-43
  - Input: Non existing drainage basin name
  - Result: Error: "The drainage basin does not exist"

- Equivalence class: HDSS-FN2-EQ-44
  - Input: Under 50 chars drainage basin name "shortName"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-45
  - Input: Over 50 chars drainage basin name "reallyreallyreallyreallyreallyreallyreallyreallyLongName"
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-46
  - Input: No drainage basin name found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-47
  - Input: Two or more drainage basin names found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-48
  - Input: One drainage basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-49
  - Input: No date found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-50
  - Input: Two or more dates found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-51
  - Input: One date found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-52
  - Input: Scope type value = "Reservoir"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-53
  - Input: Scope type value = "Desalination plant"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-54
  - Input: Scope type value = "Aquifer"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-55
  - Input: Scope type value = "WrongValue"
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-56
  - Input: No scope type found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-57
  - Input: Two or more scope types found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-58
  - Input: One scope type found
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-59
  - Input: State value = "PLENTY"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-60
  - Input: State value = "NORMALITY"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-61
  - Input: State value = "SHORTAGE"
  - Result: Valid case

- Equivalence class: HDSS-FN2-EQ-62
  - Input: State value = "WRONGVALUE"
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-63
  - Input: No state value found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-64
  - Input: Two or more state values found
  - Result: Error: "The output file has no data or does not match the expected format"

- Equivalence class: HDSS-FN2-EQ-65
  - Input: One state value found
  - Result: Valid case

### Boundary limits
### Test cases

## HDSS-RF-03
### Syntax analysis
**File::=** Init_Object Body End_Object

**Body::=** Drainage_Basin Fields_Separator Requester Fields_Separator State Fields_Separator Amount Fields_Separator Irrigation_Date

**Fields_Separator::=**','
**Label_Value_Separator::=**':'
**Init_Object::=**'{'
**End_Object::=**'}'

**Drainage_Basin::=** Quotes Drainage_Basin_Name_Label Quotes Label_Value_Separator Quotes Drainage_Basin_Name_Value Quotes
**Requester::=** Quotes Requester_Label Quotes Label_Value_Separator Quotes Requester_Value Quotes
**State::=** Quotes State_Label Quotes Label_Value_Separator Quotes State_Value Quotes
**Amount::=** Quotes Amount_Label Quotes Label_Value_Separator Amount_Value
**Irrigation_Date::=** Quotes Irrigation_Date_Label Quotes Label_Value_Separator Quotes Irrigation_Date_Value Quotes

**Drainage_Basin_Label::=** 'Drainage Basin'
**Requester_Label::=** 'Requester'
**State_Label::=** 'State'
**Amount_Label::=** 'Amount'
**Irrigation_Date_Label::=** 'Irrigation Date'

**Drainage_Basin_Value::=** 1[Character]50
**Requester_Value::=** 1[Character]50
**State_Value::=** 'PLENTY'|'NORMALITY'|'SHORTAGE'
**Amount_Value::=** 1[Number]n Point 2[Number]2
**Irrigation_Date_Value::=** '0'|'1'|'2'|'3' Number Bar '0'|'1' Number Bar 2[Number]2 Hyphen Hour

**Hour::=** '0'|'1'|'2' Number Colon '0'|'1'|'2'|'3'|'4'|'5' Number

**Quotes::=** '"'
**Bar::=** '/'
**Hyphen::=** '-'
**Colon::=** ':'

**Character::=**'a'|'b'|'c'|...|'z'
**Number::=**'0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'
