Feature: Falabella shopping cart

  @smokeTest @shoppingCart @checkTotalPrice
  Scenario: Add an item to shopping card and check total price
    Given I am on falabella.com
    And Close promotions modal if is visible
    When I search product code "15477697"
    And Add the product to shopping cart
    Then I choose the option go to shopping cart
    And check if total price is correct