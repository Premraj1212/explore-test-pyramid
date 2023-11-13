@e2e
Feature: To retrieve cars based on model type
  In order to retrieve cars
  As a user
  I should be able to provide car model to be retrieved

  Scenario Outline: User is able to retrieve cars based on different model type
    Given showroom service is active
    When the user query for cars using <model_type>
    Then validate all details presented by car service
    Examples:
      | model_type |
      | Hatchback  |
      | Saloon     |
      | Suv        |

  Scenario Outline: User should not receive any car model if the type is invalid
    Given showroom service is active
    When the user trigger for car service using incorrect <model_type>
    Then showroom service should not return any car type with <httpStatus>
    Examples:
      | model_type | httpStatus|
      | XXXXXXXXX  | 404       |

