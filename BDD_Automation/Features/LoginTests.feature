Feature: Login functionality
  As a customer
  In order to use the application
  I want to login with email and password

  @Login
  Scenario: Logging in with valid credentials
   	Given I am at Login page
    When I fill Email addrress with value "suresh.byregowda@gmail.com"
    And  I fill Password with value "xxxxxyyyyy"
    And  I click on Login button
    Then I should be at the home page 