Feature: Book A Hotel in Adactin Website
  Scenario: User try to Book A Hotel Room With Some Details
  Given User Navigated to Book A Hotel Website
    When User enters First And Last Name
    And User enters Billing Address
    And User enters Credit Card Number
    And user selects Credit Card Type
    And User Selects Expiry Month and Year
    And User enters CVV Number
    Then User clicks BookNow Button