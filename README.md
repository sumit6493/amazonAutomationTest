# amazonAutomationTest

Amazon cucumber assignment automation repo

###### To run tests in local machine

-   Appium Server
-   Android Device

###### Scenario covered for assignment

- Login and search for 65 inch TV and add the product to cart and verify the same in cart page.
- Login with invalid mobile number and verify the error message
- Login with vaild mobile number and invalid password and verify the error message.
- Login with valid mobile number add product to cart and logout

Note: Tried valid and invalid login cases with Scenario outline but the feature file didin't look effective
as the App has userName and password text fields in seperate pages and different errors appears during run time,
Hence used only Scenarios with valid and invalid logins.

###### New Commit included
- Added cases for invalid and valid logins
- Added assertions for invalid username and invalid password verifications.
- Updated scrolling behaviour for clicking on Add to cart buttons.
- Added support to take screen shot and save in target directory.
- Added support to take screenshot and embed with reports
- Added unique xpath with text function and with ui automator  


