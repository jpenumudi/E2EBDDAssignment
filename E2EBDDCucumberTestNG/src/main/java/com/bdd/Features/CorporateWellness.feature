Feature: Ahyush.com Application - Corporate Wellness Validations 
Description: To confirm the UI validations on corporate wellness page


Scenario: CONFIRM THE TITLE OF CORPORATE WELLNESS PAGE

When User clicks on corporate wellness link
#When User clicks on "corporateWellnessLink" on "HomePage"
Then Corporate Wellness page opens
And User gets the title of the corporate wellness page
And Take screenshot of the "Corporate wellness page"


Scenario: GET THE CONTACT DETAILS

Then User gets the title of the home page
When User navigates to Corporate wellness page
Then User gets the url of corporate wellness page
Then User clicks on Contact us link
Then Contact details page renders
Then User gets the heading of the page
And Take screenshot of the "Heading of contacts page"
And User navigates back to the home page
And User confirms that navigation is successful


Scenario: CHECK THE PRIVACY POLICY

Given User on corporate wellness page
When user clicks on privacy policy option
Then User accesses privacy policy page
And Take screenshot of the "Privacy policy page"
And Again user navigates back to corporate wellness page


Scenario: CHECK THE LOGIN FUNCTIONALITY

Given User is on corporate wellness page
When User clicks on login link
Then Login page is displayed
And Take screenshot of the "Login page"
Then User closes the login page
And User is back on the corporate wellness page