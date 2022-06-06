Feature: Client requests diferent services

  @success
  Scenario: Request get service
    Given The data is used
    |statuscode|items|
    |200|Tiger Nixon|
    When the client requests a employees service
    Then the response is a employees list
