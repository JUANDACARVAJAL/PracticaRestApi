Feature: Client requests diferent services

  @success
  Scenario: Request post service create employee
    Given The data is used
    |statuscode|message|
    |200|Successfully! Record has been added.|
    When the client requests a created employee service
    Then the client is added
