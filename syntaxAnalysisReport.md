# Syntax analysis
## HDSS-RF-01
### Grammar
- **File::=** Init_Object Body End_Object
- **Body::=** Irrigation_Basin_Name Label_Value_Separator Resources

- **Irrigation_Basin_Name::=** Quotes Irrigation_Basin_Name_Value Quotes
- **Resources::=** Init_Array 0{Resource_Object Fields_Separator}n 0{Resource_Object}1 End_Array

- **Irrigation_Basin_Name_Value::==** 1{Character}50

- **Resource_Object::=** Init_Object Resource_Name Fields_Separator Resource_Type Fields_Separator Resource_Capacity End_Object

- **Resource_Name::=** Quotes Resource_Name_Label Quotes Label_Value_Separator Quotes Resource_Name_Value Quotes
- **Resource_Type::=** Quotes Resource_Type_Label Quotes Label_Value_Separator Quotes Resource_Type_Value Quotes
- **Resource_Capacity::=** Quotes Resource_Capacity_Label Quotes Label_Value_Separator Resource_Capacity_Value

- **Resource_Name_Label::=** 'Name'
- **Resource_Type_Label::=** 'Type'
- **Resource_Capacity_Label::=** 'Capacity'

- **Resource_Name_Value::=** 1{Character}50
- **Resource_Type_Value::=** 'Reservoir'|'Desalination plant'|'Aquifer'
- **Resource_Capacity_Value::=** 1{Number}n 0{Point 0{Number}2 }1

- **Init_Object::=**'{'
- **End_Object::=**'}'
- **Label_Value_Separator::=**':'
- **Init_Array::=**'['
- **End_Array::=**']'
- **Fields_Separator::=**','
- **Quotes::=**'"'

- **Character::=**'a'|'b'|'c'|...|'z'
- **Point::=**'.'
- **Number::=**'0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'

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

### Test cases
#### HDSS-FN1-S-TC-1
- Type of case: Node omission
- Input: hdss-rf01-syntaxError1.json
- Expected value: Error: "Empty file"

#### HDSS-FN1-S-TC-2
- Type of case: Node omission
- Input: hdss-rf01-syntaxError2.json
- Expected value: Error: "Missing {"

#### HDSS-FN1-S-TC-3
- Type of case: Node omission
- Input: hdss-rf01-syntaxError3.json
- Expected value: Error: "Missing body"

#### HDSS-FN1-S-TC-4
- Type of case: Node omission
- Input: hdss-rf01-syntaxError4.json
- Expected value: Error: "Missing }"

#### HDSS-FN1-S-TC-5
- Type of case: Node omission
- Input: hdss-rf01-syntaxError5.json
- Expected value: Error: "Missing irrigation_basin_name"

#### HDSS-FN1-S-TC-6
- Type of case: Node omission
- Input: hdss-rf01-syntaxError6.json
- Expected value: Error: "Missing :"

#### HDSS-FN1-S-TC-7
- Type of case: Node omission
- Input: hdss-rf01-syntaxError7.json
- Expected value: Error: "Missing resource array"

#### HDSS-FN1-S-TC-8
- Type of case: Node omission
- Input: hdss-rf01-syntaxError8.json
- Expected value: Error: "Missing ["

#### HDSS-FN1-S-TC-9
- Type of case: Node omission
- Input: hdss-rf01-syntaxError9.json
- Expected value: Error: "Missing ]"

#### HDSS-FN1-S-TC-10
- Type of case: Node omission
- Input: hdss-rf01-syntaxError10.json
- Expected value: Error: "Missing resource name field"

#### HDSS-FN1-S-TC-11
- Type of case: Node omission
- Input: hdss-rf01-syntaxError11.json
- Expected value: Error: "Missing resource type field"

#### HDSS-FN1-S-TC-12
- Type of case: Node omission
- Input: hdss-rf01-syntaxError12.json
- Expected value: Error: "Missing resource capacity field"

#### HDSS-FN1-S-TC-13
- Type of case: Node omission
- Input: hdss-rf01-syntaxError13.json
- Expected value: Error: "Missing resource label"

#### HDSS-FN1-S-TC-14
- Type of case: Node omission
- Input: hdss-rf01-syntaxError14.json
- Expected value: Error: "Missing resource value"

#### HDSS-FN1-S-TC-15
- Type of case: Node omission
- Input: hdss-rf01-syntaxError15.json
- Expected value: Error: "Missing capacity value"

#### HDSS-FN1-S-TC-16
- Type of case: Node omission
- Input: hdss-rf01-syntaxError16.json
- Expected value: Error: "Missing ."

#### HDSS-FN1-S-TC-17
- Type of case: Node omission
- Input: hdss-rf01-syntaxError17.json
- Expected value: Error: "Missing ,"

#### HDSS-FN1-S-TC-18
- Type of case: Node omission
- Input: hdss-rf01-syntaxError18.json
- Expected value: Error: "Missing resource name value"

#### HDSS-FN1-S-TC-19
- Type of case: Node omission
- Input: hdss-rf01-syntaxError19.json
- Expected value: Error: "Missing left quotes"

#### HDSS-FN1-S-TC-20
- Type of case: Node omission
- Input: hdss-rf01-syntaxError20.json
- Expected value: Error: "Missing right quotes"

#### HDSS-FN1-S-TC-21
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError21.json
- Expected value: Error: "Repetition of {"

#### HDSS-FN1-S-TC-22
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError22.json
- Expected value: Error: "Repetition of }"

#### HDSS-FN1-S-TC-23
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError23.json
- Expected value: Error: "Repetition of file"

#### HDSS-FN1-S-TC-24
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError24.json
- Expected value: Error: "Repetition of body"

#### HDSS-FN1-S-TC-25
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError25.json
- Expected value: Error: "Repetition of irrigation_basin_name"

#### HDSS-FN1-S-TC-26
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError26.json
- Expected value: Error: "Repetition of :"

#### HDSS-FN1-S-TC-27
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError27.json
- Expected value: Error: "Repetition of resources array"

#### HDSS-FN1-S-TC-28
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError28.json
- Expected value: Error: "Repetition of ["

#### HDSS-FN1-S-TC-29
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError29.json
- Expected value: Error: "Repetition of ]"

#### HDSS-FN1-S-TC-30
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError30.json
- Expected value: Error: "Repetition of resource name"

#### HDSS-FN1-S-TC-31
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError31.json
- Expected value: Error: "Repetition of resource label"

#### HDSS-FN1-S-TC-32
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError32.json
- Expected value: Error: "Repetition of resource value"

#### HDSS-FN1-S-TC-33
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError33.json
- Expected value: Error: "Repetition of resource capacity value"

#### HDSS-FN1-S-TC-34
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError34.json
- Expected value: Error: "Repetition of ."

#### HDSS-FN1-S-TC-35
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError35.json
- Expected value: Error: "Repetition of ,"

#### HDSS-FN1-S-TC-36
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError36.json
- Expected value: Error: "Repetition of left quotes"

#### HDSS-FN1-S-TC-37
- Type of case: Node repetition
- Input: hdss-rf01-syntaxError37.json
- Expected value: Error: "Repetition of right quotes"

#### HDSS-FN1-S-TC-38
- Type of case: Node modification
- Input: hdss-rf01-syntaxError38.json
- Expected value: Error: "Modification of {"

#### HDSS-FN1-S-TC-39
- Type of case: Node modification
- Input: hdss-rf01-syntaxError39.json
- Expected value: Error: "Modification of }"

#### HDSS-FN1-S-TC-40
- Type of case: Node modification
- Input: hdss-rf01-syntaxError40.json
- Expected value: Error: "Modification of body"

#### HDSS-FN1-S-TC-41
- Type of case: Node modification
- Input: hdss-rf01-syntaxError41.json
- Expected value: Error: "Modification of :"

#### HDSS-FN1-S-TC-42
- Type of case: Node modification
- Input: hdss-rf01-syntaxError42.json
- Expected value: Error: "Modification of ["

#### HDSS-FN1-S-TC-43
- Type of case: Node modification
- Input: hdss-rf01-syntaxError43.json
- Expected value: Error: "Modification of ]"

#### HDSS-FN1-S-TC-44
- Type of case: Node modification
- Input: hdss-rf01-syntaxError44.json
- Expected value: Error: "Modification of left quotes"

#### HDSS-FN1-S-TC-45
- Type of case: Node modification
- Input: hdss-rf01-syntaxError45.json
- Expected value: Error: "Modification of right quotes"

#### HDSS-FN1-S-TC-46
- Type of case: Node modification
- Input: hdss-rf01-syntaxError46.json
- Expected value: Error: "Modification of name resource label"

#### HDSS-FN1-S-TC-47
- Type of case: Node modification
- Input: hdss-rf01-syntaxError47.json
- Expected value: Error: "Modification of type resource label"

#### HDSS-FN1-S-TC-48
- Type of case: Node modification
- Input: hdss-rf01-syntaxError48.json
- Expected value: Error: "Modification of type resource value"

#### HDSS-FN1-S-TC-49
- Type of case: Node modification
- Input: hdss-rf01-syntaxError49.json
- Expected value: Error: "Modification of capacity resource label"

#### HDSS-FN1-S-TC-50
- Type of case: Node modification
- Input: hdss-rf01-syntaxError50.json
- Expected value: Error: "Modification of ."

#### HDSS-FN1-S-TC-51
- Type of case: Node modification
- Input: hdss-rf01-syntaxError51.json
- Expected value: Error: "Modification of ,"

#### HDSS-FN1-S-TC-52
- Type of case: Valid case
- Input: hdss-rf01-correctFile.json
- Expected value: Error: "Valid file"

## HDSS-RF-03
### Grammar
- **File::=** Init_Object Body End_Object
- **Body::=** Drainage_Basin Fields_Separator Requester Fields_Separator State Fields_Separator Amount Fields_Separator Irrigation_Date
- **Drainage_Basin::=** Quotes Drainage_Basin_Label Quotes Label_Value_Separator Quotes Drainage_Basin_Value Quotes
- **Requester::=** Quotes Requester_Label Quotes Label_Value_Separator Quotes Requester_Value Quotes
- **State::=** Quotes State_Label Quotes Label_Value_Separator Quotes State_Value Quotes
- **Amount::=** Quotes Amount_Label Quotes Label_Value_Separator Amount_Value
- **Irrigation_Date::=** Quotes Irrigation_Date_Label Quotes Label_Value_Separator Quotes Irrigation_Date_Value Quotes
- **Drainage_Basin_Label::=** 'Drainage Basin'
- **Requester_Label::=** 'Requester'
- **State_Label::=** 'State'
- **Amount_Label::=** 'Amount'
- **Irrigation_Date_Label::=** 'Irrigation Date'
- **Drainage_Basin_Value::=** 1[Character]50
- **Requester_Value::=** 1{Character}50
- **State_Value::=** 'PLENTY'|'NORMALITY'|'SHORTAGE'
- **Amount_Value::=** 1{Number}n Point 2{Number}2
- **Irrigation_Date_Value::=** Date Hyphen Hour

- **Date::=** '0'|'1'|'2'|'3' Number Bar '0'|'1' Number Bar 2{Number}2
- **Hour::=** '0'|'1'|'2' Number Label_Value_Separator '0'|'1'|'2'|'3'|'4'|'5' Number

- **Fields_Separator::=**','
- **Label_Value_Separator::=**':'
- **Init_Object::=**'{'
- **End_Object::=**'}'

- **Quotes::=** '"'
- **Bar::=** '/'
- **Hyphen::=** '-'
- **Point::=** '.'

- **Character::=**'a'|'b'|'c'|...|'z'
- **Number::=**'0'|'1'|'2'|'3'|'4'|'5'|'6'|'7'|'8'|'9'

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

### Test cases
#### HDSS-FN3-S-TC-1
- Type of case: Node omission
- Input: hdss-rf03-syntaxError1.json
- Expected value: Error: "Missing {"

#### HDSS-FN3-S-TC-2
- Type of case: Node omission
- Input: hdss-rf03-syntaxError2.json
- Expected value: Error: "Missing }"

#### HDSS-FN3-S-TC-3
- Type of case: Node omission
- Input: hdss-rf03-syntaxError3.json
- Expected value: Error: "Missing body"

#### HDSS-FN3-S-TC-4
- Type of case: Node omission
- Input: hdss-rf03-syntaxError4.json
- Expected value: Error: "Missing drainage basin field"

#### HDSS-FN3-S-TC-5
- Type of case: Node omission
- Input: hdss-rf03-syntaxError5.json
- Expected value: Error: "Missing drainage basin field"

#### HDSS-FN3-S-TC-6
- Type of case: Node omission
- Input: hdss-rf03-syntaxError6.json
- Expected value: Error: "Missing requester field"
 
#### HDSS-FN3-S-TC-7
- Type of case: Node omission
- Input: hdss-rf03-syntaxError7.json
- Expected value: Error: "Missing state field"

#### HDSS-FN3-S-TC-8
- Type of case: Node omission
- Input: hdss-rf03-syntaxError8.json
- Expected value: Error: "Missing amount field"

#### HDSS-FN3-S-TC-9
- Type of case: Node omission
- Input: hdss-rf03-syntaxError9.json
- Expected value: Error: "Missing irrigation date field"

#### HDSS-FN3-S-TC-10
- Type of case: Node omission
- Input: hdss-rf03-syntaxError10.json
- Expected value: Error: "Missing drainage basin value"

#### HDSS-FN3-S-TC-11
- Type of case: Node omission
- Input: hdss-rf03-syntaxError11.json
- Expected value: Error: "Missing drainage basin label"

#### HDSS-FN3-S-TC-12
- Type of case: Node omission
- Input: hdss-rf03-syntaxError12.json
- Expected value: Error: "Missing ,"

#### HDSS-FN3-S-TC-13
- Type of case: Node omission
- Input: hdss-rf03-syntaxError13.json
- Expected value: Error: "Missing :"

#### HDSS-FN3-S-TC-14
- Type of case: Node omission
- Input: hdss-rf03-syntaxError14.json
- Expected value: Error: "Missing ."

#### HDSS-FN3-S-TC-15
- Type of case: Node omission
- Input: hdss-rf03-syntaxError15json
- Expected value: Error: "Empty drainage basin value"

#### HDSS-FN3-S-TC-16
- Type of case: Node omission
- Input: hdss-rf03-syntaxError16.json
- Expected value: Error: "Empty drainage basin label"

#### HDSS-FN3-S-TC-17
- Type of case: Node omission
- Input: hdss-rf03-syntaxError17.json
- Expected value: Error: "Missing right \" in value"

#### HDSS-FN3-S-TC-18
- Type of case: Node omission
- Input: hdss-rf03-syntaxError18.json
- Expected value: Error: "Missing left \" in value"

#### HDSS-FN3-S-TC-19
- Type of case: Node omission
- Input: hdss-rf03-syntaxError19.json
- Expected value: Error: "Missing right \" in label"

#### HDSS-FN3-S-TC-20
- Type of case: Node omission
- Input: hdss-rf03-syntaxError20.json
- Expected value: Error: "Missing left \" in label"
 
#### HDSS-FN3-S-TC-21
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError21.json
- Expected value: Error: "Repetition of file"
 
#### HDSS-FN3-S-TC-22
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError22.json
- Expected value: Error: "Repetition of {"

#### HDSS-FN3-S-TC-23
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError23.json
- Expected value: Error: "Repetition of }"

#### HDSS-FN3-S-TC-24
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError24.json
- Expected value: Error: "Repetition of body"

#### HDSS-FN3-S-TC-25
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError25.json
- Expected value: Error: "Repetition of drainage basin label"

#### HDSS-FN3-S-TC-26
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError26.json
- Expected value: Error: "Repetition of left \" in label"

#### HDSS-FN3-S-TC-27
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError27.json
- Expected value: Error: "Repetition of right \" in label"

#### HDSS-FN3-S-TC-28
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError28.json
- Expected value: Error: "Repetition of left \" in value"

#### HDSS-FN3-S-TC-29
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError29.json
- Expected value: Error: "Repetition of right \" in value"

#### HDSS-FN3-S-TC-30
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError30.json
- Expected value: Error: "Repetition of : "

#### HDSS-FN3-S-TC-31
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError31.json
- Expected value: Error: "Repetition of value"

#### HDSS-FN3-S-TC-32
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError32.json
- Expected value: Error: "Repetition of ,"

#### HDSS-FN3-S-TC-33
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError33.json
- Expected value: Error: "Repetition of field"

#### HDSS-FN3-S-TC-34
- Type of case: Node repetition
- Input: hdss-rf03-syntaxError34.json
- Expected value: Error: "Repetition of ."

#### HDSS-FN3-S-TC-35
- Type of case: Node modification
- Input: hdss-rf03-syntaxError35.json
- Expected value: Error: "Modification of drainage basin label"

#### HDSS-FN3-S-TC-37
- Type of case: Node modification
- Input: hdss-rf03-syntaxError37.json
- Expected value: Error: "Modification of {"

#### HDSS-FN3-S-TC-38
- Type of case: Node modification
- Input: hdss-rf03-syntaxError38.json
- Expected value: Error: "Modification of }"

#### HDSS-FN3-S-TC-39
- Type of case: Node modification
- Input: hdss-rf03-syntaxError39.json
- Expected value: Error: "Modification of amount type value"

#### HDSS-FN3-S-TC-40
- Type of case: Node modification
- Input: hdss-rf03-syntaxError40.json
- Expected value: Error: "Modification of \""

#### HDSS-FN3-S-TC-41
- Type of case: Node modification
- Input: hdss-rf03-syntaxError41.json
- Expected value: Error: "Modification of ."
 
#### HDSS-FN3-S-TC-42
- Type of case: Node modification
- Input: hdss-rf03-syntaxError42.json
- Expected value: Error: "Modification of state value"
 
#### HDSS-FN3-S-TC-43
- Type of case: Node modification
- Input: hdss-rf03-syntaxError43.json
- Expected value: Error: "Modification of ,"
 
#### HDSS-FN3-S-TC-44
- Type of case: Node modification
- Input: hdss-rf03-syntaxError44.json
- Expected value: Error: "Modification of drainage basin value"

#### HDSS-FN3-S-TC-45
- Type of case: Node modification
- Input: hdss-rf03-syntaxError45.json
- Expected value: Error: "Modification of requester label"

#### HDSS-FN3-S-TC-46
- Type of case: Node modification
- Input: hdss-rf03-syntaxError46.json
- Expected value: Error: "Modification of irrigation date label"

#### HDSS-FN3-S-TC-47
- Type of case: Valid case
- Input: hdss-rf03-correctFile.json
- Expected value: "Syntactically Valid File"

