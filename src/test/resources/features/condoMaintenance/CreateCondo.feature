Feature: Add Condo Maintainence

  @CM
  Scenario Outline: Add a Condo maintainence with all fields and View the information
    Creation of condo maintainence with all the fields

    And user clicks on "<Menu name>" tab
    And user clicks on "<sub menu name>" tab
    And user clicks on "<addbutton>" button
    And user enter code in "<condoCode>"
    And user enter description in "<condoDescription>"
    And user enter phase in "<condoPhase>"
    And user selects "<dropdownOption>" from area code dropdown
    And user enter town in "<tCode>"
    And user enter direction in "<tdirection>"
    And user enter range in "<condorange>"
    And user enter rangedirection in "<rdirection>"
    And user enter liber in "<condoliber>"
    And user enter page in "<condopage>"
    And user selects active checkbox
    And user clicks on "<Savebutton>" button
    And user verified the success message "<message>"
    #Perform Search operation in Grid View Screen
    And user enter Id in Condo Maintenance ID Filter Input field
    And user clicks on condo ID link
    #Performing EDIT - Updating the condo maintainenece information
    And user clicks on "Edit" button
    And user enter code in "<condoCode>"
    And user enter description in "<condoDescription>"
    And user selects "<dropdownOption2>" from area code dropdown
    And user clicks on "<Savebutton>" button
    And user verified the success message "<updateMessage>"
    #Validation of history
    And user clicks on "History" tab in condo
    And user clicks on "Master Info" tab in condo
    And user clicks on "History" tab in condo
    And verify "CondoMaintenanceCreated" is displayed
    And verify "CondoMaintenanceUpdated" is displayed
    And verify "CondoMaintenance" is displayed
    And verify "thirumalai@test.com" is displayed
    #Adding a new comment
    And user clicks on "Comments" tab in condo
    And user enter comments 
    And user clicks on "<Addbutton>" button
    And user verified the success message "<commentMessage>"
    #Validating the added comment
    And verify "thirumalai@test.com" is displayed
    And verify comments is displayed in comment section
    And verify the edit delete buttons displayed in comments section
    #Editing comment
    And user clicks on edit icon
    And user enter comments 
    And user clicks on "<Savebutton>" button
    And user verified the success message "Comment updated successfully"
    And verify comments is displayed in comment section
    And user clicks on delete icon
    And user clicks on "Yes, delete" button  
    And user verified the success message "Comment deleted successfully"
    #And user clicks on "<Savebutton>"
    #Validating the edited comment
    #And verify comments is displayed in comment section
    #Deletion of a comment
    #And user click on delete icon
    #And user verify commentdeleted
    
    Examples: 
      | Menu name            | sub menu name     | addbutton | condoCode | condoDescription | condoPhase | dropdownOption | tCode    | tdirection    | condorange | rdirection     | condoliber | condopage | Savebutton | message                    | dropdownOption2 | updateMessage              | Addbutton | Editbutton | commentMessage             |
      | Document/Codes Admin | Condo Maintenance | Add New   | code      | description      | phase      | HOLLY          | townCode | townDirection | range      | rangeDirection | liber      | page      | Save       | Condo created successfully | MILLER          | Condo updated successfully | Add       | Edit       | Comment created successfully |
