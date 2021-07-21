Feature: Validating Place API's
@Addplace
  Scenario Outline: Verify if place is Being Successfully added using AddPlaceAPI
    Given Add Place  Payload with "<name>" and "<language>" and "<address>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in resposne body is "OK"
    And verify place_id created maps to "<name>" using  "GetPlaceAPI"


    Examples:
    |name     |language|address         |
    |Manali |English |Word Trade Centre|
    #|Downline |Koren   |Sea Facing Centre|

@Deleteplace
  Scenario: Validate that user Can Delete Place
    Given Delete Payload
    When user calls "DeleteplaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in resposne body is "OK"
