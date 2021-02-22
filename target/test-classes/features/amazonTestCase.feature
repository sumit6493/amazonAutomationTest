Feature: Amazon page case

  Scenario: Search for a product add to cart and verify the same in cart page
    Given user is in onBoarding screen
    When user login with valid user credentials
    And user navigates to home page after successful login
    And search for 65 inch TV
    And select any random result from searched list
    And click on Add to cart from product detail page
    And user navigates to cart page
    Then user can see same product in cart page

  Scenario: Login with invalid mobile number and verify the error message.
    Given user is in onBoarding screen
    And user navigates to Sign In Screen
    When user enter invalid mobile number
    And click on Continue button
    Then user can see incorrect phone number error message

  Scenario: Login with vaild mobile number and invalid password and verify the error message.
    Given user is in onBoarding screen
    And user navigates to Sign In Screen
    When user enter valid mobile number
    And click on Continue button
    And enters invalid password
    And click on Sign In button
    Then user can see incorrect password error message

#   Note: Tried valid and invalid login cases with Scenario outline as well but the feature file didin't look effective
#  as the App has userName and password text fields in seperate pages and different errors appears during run time,
#  Hence used only Scenarios with valid and invalid logins

  Scenario: Login with valid mobile number add product to cart and logout
    Given user is in onBoarding screen
    And user navigates to Sign In Screen
    And user enter valid mobile number
    And click on Continue button
    And enters valid password
    And click on Sign In button
    And user navigates to home page after successful login
    And search for TV
    And select any random result from searched list
    And click on Add to cart from product detail page
    And user selects settings through hamburger menu
    And user select Sign out through Settings
    And user click on Confirm Sign Out
    Then User is logged out from app

