@SkipThisFeature
Feature: Ahyush.com Application - Validations on HomePage
Description: To confirm the UI validations on the home page

# Gherkin steps start with a preposition (And, But) or Adverb (Given, When, Then). 

Scenario: CONFIRM THE PRESENCE OF COMPANY LOGO ON HOMEPAGE 

Then Confirm the logo 
And Take screenshot of the "Homepage"

#@RunThis
Scenario: CHECK THE VIDEO FUNCTIONALITY 

#When User clicks on Watch video button
When User clicks on "videoButton"
Then Video opens in an iframe
And Take screenshot of the "Video Window"
Then User switches to iframe
#When User clicks on play button
When User clicks on "playVideoButton"
Then Video plays
And Take screenshot of the "Video playing"
#When User Clicks on mute button
When User clicks on "muteVideoButton"
Then Video is muted
And Take screenshot of the "Video muted"
#When User clicks on unmute button
When User clicks on "unmuteVideoButton"
Then Video is unmuted
And Take screenshot of the "Video unmuted"
#When User clicks on pause button
When User clicks on "stopVideoButton"
Then Video is stopped
And Take screenshot of the "Video stopped"
When User navigates back to main frame
#And User clicks on close button
When User clicks on "exitVideoButton"
Then the video window is closed. 

Scenario: SELECT A COUNTRY FROM THE DROP DOWN

When User clicks on the country drop down button
#When User clicks on "countryDropDown"
Then Country options are displayed
And Take screenshot of the "Country dropdown"
And User selects a country
Then Selected country is displayed on the homepage
And User confirms the country
And Take screenshot of the "Country selected"

Scenario: CHECK ABOUT US FEATURE

#When User clicks on About Us link
When User clicks on "aboutUs"
Then About us page is rendered
And Take screenshot of the "About Us page"
Then User navigates back to homepage
