Feature: verify the amazon page

  Scenario: Search for a product and verif
    Given user is in onBoarding screen
    When login with valid user credentials
    And user navigates to home page after successful login
    And search for 65 inch TV
    And select any random result from searched list
    And click on Add to cart from product detail page
    And user navigates to cart page
    Then user can see same product in cart page
