@e2e
Feature: Filter products based on product type in the application
  In order to filter a products
  As a user
  I should be able to view all products related to them

  Scenario: User filters desired product and view them
    Given user launches the application
    When user tries to filter for specific product:
      |perfume|
    Then user should see all products related to the search:
      |perfume|

