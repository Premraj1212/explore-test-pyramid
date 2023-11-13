@shopme @e2e
Feature: To purchase a product from the application
  In order to purchase a products
  As a user
  I should be able to view the product and purchase

  Scenario: User is able to order a product as guest user
    Given user launches the application
    When user finds a product in Calvin Klein
    And user add a product to cart
    And checkout the product
    Then user should able to make order successfully
