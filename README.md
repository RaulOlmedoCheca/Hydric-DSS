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

### Syntax analysis
**File::=** Init_Object Body End_Object
**Body::=** Irrigation_Basin_Name Label_Value_Separator Resources

**Irrigation_Basin_Name::=** Quotes Irrigation_Basin_Name_Value Quotes
**Resources::=** Init_Array 0{Resource_Object Fields_Separator}n 0{Resource_Object}1 End_Array

**Irrigation_Basin_Name_Value::==** 1{Character}50

**Resource_Object::=** Init_Object Resource_Name Fields_Separator Resource_Type Fields_Separator Resource_Capacity End_Object

**Resource_Name::=** Quotes Resource_Name_Label Quotes Label_Value_Separator Quotes Resource_Name_Value Quotes
**Resource_Type::=** Quotes Resource_Type_Label Quotes Label_Value_Separator Quotes Resource_Type_Value Quotes
**Resource_Capacity::=** Quotes Resource_Capacity_Label Quotes Label_Value_Separator Resource_Capacity_Value

**Resource_Name_Label::=** 'Name'
**Resource_Type_Label::=** 'Type'
**Resource_Capacity_Label::=** 'Capacity'

**Resource_Name_Value::=** 1{Character}50
**Resource_Type_Value::=** 'Reservoir'|'Desalination plant'|'Aquifer'
**Resource_Capacity_Value::=** 1{Number}n 0{Point 0{Number}2 }1

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

### Derivation trees
#### Derivation tree 1
![](img/FN1/DerivationTreeFN1-01.png?raw=true)
#### Derivation tree 2
![](img/FN1/DerivationTreeFN1-02.png?raw=true)
#### Derivation tree 3
![](img/FN1/DerivationTreeFN1-03.png?raw=true)
#### Derivation tree 4
![](img/FN1/DerivationTreeFN1-04.png?raw=true)
#### Derivation tree 5
![](img/FN1/DerivationTreeFN1-05.png?raw=true)
#### Derivation tree 6
![](img/FN1/DerivationTreeFN1-06.png?raw=true)
#### Derivation tree 7
![](img/FN1/DerivationTreeFN1-07.png?raw=true)
#### Derivation tree 8
![](img/FN1/DerivationTreeFN1-08.png?raw=true)
#### Derivation tree 9
![](img/FN1/DerivationTreeFN1-09.png?raw=true)
#### Derivation tree 10
![](img/FN1/DerivationTreeFN1-10.png?raw=true)


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
- Equivalence class considered: HDSS-FN2-EQ-43
- Input:
  - Filename "hdss-rf02-notExistingDrainageBasin.json"
  - Expected output: Throws exception. Error message: "The drainage basin does not exist"

#### HDSS-FN2-TC-26
- Equivalence class considered: HDSS-FN2-EQ-45
- Input:
  - Filename "hdss-rf02-longDrainageBasin.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-27
- Equivalence class considered: HDSS-FN2-EQ-46
- Input:
  - Filename "hdss-rf02-noDrainageBasin.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-28
- Equivalence class considered: HDSS-FN2-EQ-47
- Input:
  - Filename "hdss-rf02-severalDrainageBasin.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-29
- Equivalence class considered: HDSS-FN2-EQ-49
- Input:
  - Filename "hdss-rf02-noDate.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-30
- Equivalence class considered: HDSS-FN2-EQ-50
- Input:
  - Filename "hdss-rf02-severalDates.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-31
- Equivalence class considered: HDSS-FN2-EQ-55
- Input:
  - Filename "hdss-rf02-invalidScope.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-32
- Equivalence class considered: HDSS-FN2-EQ-56
- Input:
  - Filename "hdss-rf02-noScope.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-33
- Equivalence class considered: HDSS-FN2-EQ-57
- Input:
  - Filename "hdss-rf02-severalScopes.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-34
- Equivalence class considered: HDSS-FN2-EQ-62
- Input:
  - Filename "hdss-rf02-invalidState.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-35
- Equivalence class considered: HDSS-FN2-EQ-63
- Input:
  - Filename "hdss-rf02-noState.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-36
- Equivalence class considered: HDSS-FN2-EQ-64
- Input:
  - Filename "hdss-rf02-severalStates.json"
  - Expected output: Throws exception. Error message: "The output file has no data or does not match the expected format"

#### HDSS-FN2-TC-37
- Boundary limit considered: HDSS-FN2-BL-1
- Input:
    - Filename "hdss-rf02-validIrrigationBasinName49.json"
    - Expected output: "hdss-rf02-expectedValidIrrigationBasinName49.json"

#### HDSS-FN2-TC-38
- Boundary limit considered: HDSS-FN2-BL-2
- Input:
    - Filename "hdss-rf02-validIrrigationBasinName50.json"
    - Expected output: "hdss-rf02-expectedValidIrrigationBasinName50.json"

#### HDSS-FN2-TC-39
- Boundary limit considered: HDSS-FN2-BL-3
- Input:
    - Filename "hdss-rf02-invalidIrrigationBasinName.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-40
- Boundary limit considered: HDSS-FN2-BL-4
- Input:
    - Filename "hdss-rf02-validResourceName49.json"
    - Expected output: "hdss-rf02-expectedValidResourceName49.json"

#### HDSS-FN2-TC-41
- Boundary limit considered: HDSS-FN2-BL-5
- Input:
    - Filename "hdss-rf02-validResourceName50.json"
    - Expected output: "hdss-rf02-expectedValidResourceName50.json"

#### HDSS-FN2-TC-42
- Boundary limit considered: HDSS-FN2-BL-6
- Input:
    - Filename "hdss-rf02-invalidResourceName.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-43
- Boundary limit considered: HDSS-FN2-BL-8
- Input:
    - Filename "hdss-rf02-validResourceCapacity0_01.json"
    - Expected output: "hdss-rf02-expectedValidResourceCapacity0_01.json"

#### HDSS-FN2-TC-44
- Boundary limit considered: HDSS-FN2-BL-9
- Input:
    - Filename "hdss-rf02-invalidResourceCapacity.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

#### HDSS-FN2-TC-45
- Boundary limit considered: HDSS-FN2-BL-10
- Input:
    - Filename "hdss-rf02-validResourceCapacityTwoDecimals.json"
    - Expected output: "hdss-rf02-expectedValidResourceCapacityTwoDecimals.json"

#### HDSS-FN2-TC-46
- Boundary limit considered: HDSS-FN2-BL-11
- Input:
    - Filename "hdss-rf02-validResourceCapacityOneDecimal.json"
    - Expected output: "hdss-rf02-expectedValidResourceCapacityOneDecimal.json"

#### HDSS-FN2-TC-47
- Boundary limit considered: HDSS-FN2-BL-12
- Input:
    - Filename "hdss-rf02-validResourceCapacityZeroDecimals.json"
    - Expected output: "hdss-rf02-expectedValidResourceCapacityZeroDecimals.json"

#### HDSS-FN2-TC-48
- Boundary limit considered: HDSS-FN2-BL-13
- Input:
    - Filename "hdss-rf02-invalidResourceCapacityThreeDecimals.json"
    - Expected output: Throws Exception. Error message: "The input file has no data or does not match the expected format"

## HDSS-RF-03
### Syntax analysis
**File::=** Init_Object Body End_Object

**Body::=** Drainage_Basin Fields_Separator Requester Fields_Separator State Fields_Separator Amount Fields_Separator Irrigation_Date

**Drainage_Basin::=** Quotes Drainage_Basin_Label Quotes Label_Value_Separator Quotes Drainage_Basin_Value Quotes
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
**Requester_Value::=** 1{Character}50
**State_Value::=** 'PLENTY'|'NORMALITY'|'SHORTAGE'
**Amount_Value::=** 1{Number}n Point 2{Number}2
**Irrigation_Date_Value::=** Date Hyphen Hour

**Date::=** '0'|'1'|'2'|'3' Number Bar '0'|'1' Number Bar 2{Number}2
**Hour::=** '0'|'1'|'2' Number Label_Value_Separator '0'|'1'|'2'|'3'|'4'|'5' Number

**Fields_Separator::=**','
**Label_Value_Separator::=**':'
**Init_Object::=**'{'
**End_Object::=**'}'

**Quotes::=** '"'
**Bar::=** '/'
**Hyphen::=** '-'
**Point::=** '.'

**Character::=**'a'|'b'|'c'|...|'z'
**Number::=**'0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'

### Derivation trees
#### Derivation tree 1
![](img/FN3/DerivationTreeFN3-01.png?raw=true)
#### Derivation tree 2
![](img/FN3/DerivationTreeFN3-02.png?raw=true)
#### Derivation tree 3
![](img/FN3/DerivationTreeFN3-03.png?raw=true)
#### Derivation tree 4
![](img/FN3/DerivationTreeFN3-04.png?raw=true)
#### Derivation tree 5
![](img/FN3/DerivationTreeFN3-05.png?raw=true)
#### Derivation tree 6
![](img/FN3/DerivationTreeFN3-06.png?raw=true)
#### Derivation tree 7
![](img/FN3/DerivationTreeFN3-07.png?raw=true)
#### Derivation tree 8
![](img/FN3/DerivationTreeFN3-08.png?raw=true)
