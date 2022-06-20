@AddAddress
Feature: Address module API automation

  Scenario Outline: TC_1 User should add address
    Given User should add headers
    And User should add  "<first_name>" , "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>"and"<address_type>"
    When User should send "POST" request for address endpoint
    Then User verify the status code is 200
    And User should verify the response body message present as "Address added successfully" and get the address Id saved

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address            | address_type |
      | Raj        | Khundra   | 1234567898 | apartment |    33 | 3378 |     101 |  202020 | 64/63 partap nagar | home         |

  @UpdateAddress
  Scenario Outline: TC_2 User should update the address
    Given User should add header
    And User should add required data for updating the address "<address_id>", "<first_name>" , "<last_name>", "<mobile>", "<apartment>", "<state>", "<city>", "<country>", "<zipcode>", "<address>"and "<address_type>"
    When User should send "PUT" request for AddAddress endpoint
    Then User verify the status code is 200
    And User should verify the response body update address message present as "Address updated successfully"

    Examples: 
      | first_name | last_name | mobile     | apartment | state | city | country | zipcode | address                          | address_type |
      | Vetri      | Hani      | 8220260322 | apartment |   105 |   52 |     102 |  624765 | 20, Driftwood Drive, san Antonio | Home         |

  @GetAddress
  Scenario: TC_3 User should get the addresses
    Given User should add header
    And User should enter addressId to get the addresses
    When User should send "GET" request for UpdateAddress endpoint
    Then User verify the status code is 200
    And User should verify the response body Addaddress message present as "OK"

  @DeleteAddress
  Scenario: TC_4 User should delete the address
    Given User should add header
    And User should enter "<address_id>" for deleting the address
    When User should send "DELETE" request for login endpoint
    Then User verify the status code is 200
    And User should verify the response body delete address message present as "Address deleted Successfully"
