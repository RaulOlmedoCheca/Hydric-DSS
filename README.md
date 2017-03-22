# Guided exercise 3 - Hydric-DSS
## HDSS-RF-01
### Equivalence classes
- Equivalence class: HDSS-FN1-EQ-1
  - Input:  Non existing filename
  - Result: Error. “An input data file is not found”

- Equivalence class: HDSS-FN1-EQ-2
  - Input: Valid filename “validRegisterHydricResourcesCase.json”
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-3
  - Input: Valid JSON file
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-4
  - Input: Non JSON format
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-5
  - Input: Empty file
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-6
  - Input: Non empty file
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-7
  - Input: Existing irrigation basin name
  - Result: Error. “Tried to record an irrigation basin with an existing name”

- Equivalence class: HDSS-FN1-EQ-8
  - Input: Non existing irrigation basin name
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-9
  - Input: Under 50 chars irrigation basin name “shortName”
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-10
  - Input: Over 50 chars irrigation basin name “reallyreallyreallyreallyreallyreallyreallyreallyLongName”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-11
  - Input: No irrigation basin name found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-12
  - Input: Two or more irrigation basin names found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-13
  - Input: One irrigation basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-14
  - Input: No resources list found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-15
  - Input: Two or more resources lists found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-16
  - Input: One resources list found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-17
  - Input: Existing resource name
  - Result: Error. “Tried to record a resource basin with an existing name”

- Equivalence class: HDSS-FN1-EQ-18
  - Input: Non existing resource name
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-19
  - Input: Under 50 chars resource basin name “shortName”
  - Result: valid case

- Equivalence class: HDSS-FN1-EQ-20
  - Input: Over 50 chars resource name “reallyreallyreallyreallyreallyreallyreallyreallyLongName”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-21
  - Input: No resource name found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-22
  - Input: Two or more resource names found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-23
  - Input: One resource basin name found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-24
  - Input: Resource type value = “Reservoir”
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-25
  - Input: Resource type value = “Desalination plant”
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-26
  - Input: Resource type value = “Aquifer”
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-27
  - Input: Resource type value = “My mom”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-28
  - Input: No resource type found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-29
  - Input: Two or more resource types found
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-30
  - Input: One resource basin type found
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-31
  - Input: Negative capacity
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-32
  - Input: Positive capacity
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-33
  - Input: Capacity values is not a number “2,23”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-34
  - Input: Capacity values is a number “2.23”
  - Result: Error: Valid case

- Equivalence class: HDSS-FN1-EQ-35
  - Input: Capacity values is a number with more than 2 decimals “2.231”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-36
  - Input: Capacity values is a number with 2 or less decimals “2.23”
  - Result: Error: valid case

- Equivalence class: HDSS-FN1-EQ-37
  - Input: No resource type found and resource type is not “aquifer”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-38
  - Input: Two or more resource types found and resource type is not “aquifer”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Equivalence class: HDSS-FN1-EQ-39
  - Input: One resource basin type found and resource type is not “aquifer”
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-40
  - Input: No resource type found and resource type is “aquifer”
  - Result: Valid case

- Equivalence class: HDSS-FN1-EQ-41
  - Input: One or more resource types found and resource type is not “aquifer”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

### Boundary limits
- Boundary limit: HDSS-FN1-BL-1
  - Input: 49 chars irrigation basin name “reallyreallyreallyreallyreallyreallyreallyLongNam”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-2
  - Input: 50 chars irrigation basin name “reallyreallyreallyreallyreallyreallyreallyLongName”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-3
  - Input: 51 chars irrigation basin name “reallyreallyreallyreallyreallyreallyreallyLongNamee”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Boundary limit: HDSS-FN1-BL-4
  - Input: 49 chars resource name “reallyreallyreallyreallyreallyreallyreallyLongNam”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-5
  - Input: 50 chars resource name “reallyreallyreallyreallyreallyreallyreallyLongName”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-6
  - Input: 51 chars resource name “reallyreallyreallyreallyreallyreallyreallyLongNamee”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Boundary limit: HDSS-FN1-BL-7
  - Input: Capacity value 0.00
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-8
  - Input: Capacity value 0.01
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-9
  - Input: Capacity value -0.01
  - Result: Error: “The input file has no data or doesn’t match the expected format”

- Boundary limit: HDSS-FN1-BL-10
  - Input capacity: capacity with 2 decimals “2.23”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-11
  - Input capacity: capacity with 1 decimal “2.2”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-12
  - Input capacity: capacity with no decimals “2”
  - Result: valid case

- Boundary limit: HDSS-FN1-BL-13
  - Input capacity: capacity with 3 decimal “2.223”
  - Result: Error: “The input file has no data or doesn’t match the expected format”

## Test classes
### HDSS-FN1-TC-1
- Equivalence classes considered:   HDSS-FN1-EQ-2, HDSS-FN1-EQ-3, HDSS-FN1-EQ-6, HDSS-FN1-EQ-8, HDSS-FN1-EQ-9, HDSS-FN1-EQ-13, HDSS-FN1-EQ-16, HDSS-FN1-EQ-18, HDSS-FN1-EQ-19, HDSS-FN1-EQ-23, HDSS-FN1-EQ-24, HDSS-FN1-EQ-25, HDSS-FN1-EQ-26, HDSS-FN1-EQ-30, HDSS-FN1-EQ-32, HDSS-FN1-EQ-34, HDSS-FN1-EQ-36, HDSS-FN1-EQ-39, HDSS-FN1-EQ-40
- Input:
  - Filename: “validRegisterHydricResourcesCase.json”
  - Content:
```JSON
{
  "irrigation_basin_name" : "shortName",
  "resources": [
    {
      "name" : "shortName",
      "type" : "reservoir",
      "capacity": 2.23
    },
    {
      "name" : "plant1",
      "type" : "desalination plant",
      "capacity" : 23.46
    },
    {
      "name" : "aquifer1",
      "type" : "aquifer"
    }
  ]
}
```
  - Output:
```JSON
{
  "shortName" :
  { "resources": [
     {"reservoirs": {
     "amount": 1,
     "capacity": 2.23,
     "list" : [
           {
           "name" : "shortName",
           "capacity" : 2.23
           }
     ]
     }
     },
     {"plants": {
     "amount": 1,
     "capacity": 23.46,
     "list" : [
           {
           "name" : "plant1",
           "capacity" : 23.46
           }
     ]
     }
     },
     {"aquifers": {
     "amount": 1,
     "list" : [
          {
          "name" : "aquifer1",
          "capacity" : 2.23
         }
] } }
]}
}
```

### HDSS-FN1-TC-2
- Equivalence class considered: HDSS-FN1-EQ-1
- Input:
  - Filename “nonexists.json”
  - Expected output: Throws Exception. Error message: “An input data file is not found”

### HDSS-FN1-TC-3
- Boundary limit considered: HDSS-FN1-BL-7
- Input:
  - Filename “capacity-zero.json”
```JSON  
{
  "irrigation_basin_name" : "zero-capacity-basin",
  "resources" :[
    {
      "name" : "zero-capacity-reservoir",
      "type" : "reservoir",
      "capacity": 0.00
    }
  ]
}
```
- Expected output:
```JSON
{
  "zero-capacity-basin" :
  { "resources": [
     {"reservoirs": {
     "amount": 1,
     "capacity": 0.00,
     "list" : [
           {
           "name" : "zero-capacity-reservoir",
           "capacity" : 0.00
           }
      ]
      }
    }
    ]
  }    
}
```
