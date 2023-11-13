@e2e
Feature: To add products to cart that are in sale in the application
  In order to add products in sale
  As a user
  I should be able to view all products in sale and add to cart

  Scenario: User is able to add available product that are in sale in the cart
    Given user launches the application
    When user finds a product in Calvin Klein
    And user add a product to cart
    Then user should see all products in the cart

