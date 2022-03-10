Feature: Falabella sign in

  @smokeTest @signIn
  Scenario: Sign in on falabella.com
    Given I am on falabella.com
    And Close promotions modal if is visible
    And Select sign in menu
    When Complete and submit the login form with the default values
    Then I am logged in