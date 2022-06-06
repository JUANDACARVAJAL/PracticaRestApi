Feature: Client requests diferent services

  @success
  Scenario Outline: Request get service
    Given The data is used
    |statuscode|id|message|employee_name|
    |<statuscode>|<id>|<message>|<employee_name>|
    When the client requests data for a employee
    Then the client can see the information employees

    Examples:
      |statuscode|id|message|employee_name|
      |200|1|Successfully! Record has been fetched.|Tiger Nixon|
      |200|2|Successfully! Record has been fetched.|Garrett Winters|
