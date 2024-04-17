Feature: To check MB Advice functionality

#Scenario for Validating show trend button with valid input
#Scenario-1
@RatesandTrends_Valid
Scenario: to validate show trends button with valid Location
Given User is on Rates and Trends webpage
When User enter input
|thane|
And User select option from dropdown
And Click on show trends button
Then It should display the trends for entered location


#Scenario for Validating show trend button with invalid input
#Scenario-2
@RatesandTrends_Invalid
Scenario: to validate show trends button with invalid location 
Given User is on Rates and Trends page
When User enter invalid input
|tkhane|
And Click on show the trends button
Then It should give error message


#Scenario for validating Compare localities functionality
#Scenario-3
@compareLocalities
Scenario Outline: to validate compare localities and project feature
Given User is on compare localities page
When User click on compare option 
And User clicks on radio button
And User enters "<Project1>" and "<Project2>"
And Clicks on compare button
Then User gets redirected to Compare page

Examples:
| Project1 | Project2 |
| Oberoi | Blu |


#Scenario for validating new projects in mumbai functionality
#Scenario-4
@newProject_Filter
Scenario: to validate new project functionality
Given User is on new projects page
When User scrolls down the page
And Clicks on the filters option available
And Select city from dropdown list
And Select hotspot
And Select budget using scrollbar
And Select BHK option
And Select possesion year 
And Click on View Project
Then Projects are displayed with selected filter


#Scenario for validating defect in Findpincode functionality
#Scenario-5
@FindPincode_Defect
Scenario: to validate find pincode functionality
Given User is on find pincode page
When User Scroll down page
And User Select state from dropdown
And Select City from dropdown
And User does not select locality dropdown
And Click on search button 
Then It should display an error message

