Feature: Falabella sign up

  @smokeTest @signUp
  Scenario: Validate sign up form
    Given I am on falabella.com
    And Close promotions modal if is visible
    And Select the sign up menu
    When Complete the sign up form with the following values
      | firstName | lastName | document  | phoneNumber | email                      | password       |  |
      | Pedro     | Ibarra   | 174792518 | 948693325   | pedro.test.email@gmail.com | ClaveUnica123* |  |
    And Accept TyC and Data Use
    Then Submit form button is enabled