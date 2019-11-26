
Feature: Hello message

  As a consumer of the hello resource
  I should be able to get a user centric message

  Scenario Outline: Get message using appropriate name
    Given I use the name <name>
    When I request a hello resource
    Then I should get a response with HTTP status code <status>
    And The response should contain the message <message>
    Examples:
      | name    | status | message               |
      | Gecko   | 200    | Hello Gecko, welcome! |
      | Test    | 200    | Hello Test, welcome!  |

  Scenario: Get message using name TEAPOT
    Given I use the name TEAPOT
    When I request a hello resource
    Then I should get a response with HTTP status code 418