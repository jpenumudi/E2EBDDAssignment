Feature: Ahyush.com Application - Confirm Product Overview
Description: Confirm product information 

Scenario: PRODUCT OVERVIEW PAGE

When User clicks on product overview link
Then Product overview page is displayed
And User confirms Product information image
And Take screenshot of the "Product information image"

Scenario: CONFIRM SUBSCRIBE FEATURE

Given User is on Product overview page
When User enters email address
And User clicks on submit button
Then Successfully subscribed message is displayed
And Take screenshot of the "Successful subscribe message"

Scenario: CHECK CONNECTION TO FACEBOOK FEATURE

Given User is on Product overview page
Then Confirm fblink is visible
And User clicks on facebook link
Then facebook page is opened
And Take screenshot of the "Facebook page"
Then User confirms the url of the landing page and closes it
And User is back on Product Overview page




