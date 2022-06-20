$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Feature/TC1_Login.feature");
formatter.feature({
  "name": "Login module API automation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.scenario({
  "name": "Get user logtoken from user login",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@Login"
    }
  ]
});
formatter.step({
  "name": "User add headers",
  "keyword": "Given "
});
formatter.match({
  "location": "LoginStep.user_add_headers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User send \"POST\" request for login endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "LoginStep.user_send_request_for_login_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the response body firstname present as \"VENKATACHALAM R\" and the logtoken saved",
  "keyword": "And "
});
formatter.match({
  "location": "LoginStep.user_verify_the_response_body_firstname_present_as_and_the_logtoken_saved(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/Feature/TC2_Address.feature");
formatter.feature({
  "name": "Address module API automation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@AddAddress"
    }
  ]
});
formatter.scenarioOutline({
  "name": "TC_1 User should add address",
  "description": "",
  "keyword": "Scenario Outline"
});
formatter.step({
  "name": "User should add headers",
  "keyword": "Given "
});
formatter.step({
  "name": "User should add  \"\u003cfirst_name\u003e\" , \"\u003clast_name\u003e\", \"\u003cmobile\u003e\", \"\u003capartment\u003e\", \"\u003cstate\u003e\", \"\u003ccity\u003e\", \"\u003ccountry\u003e\", \"\u003czipcode\u003e\", \"\u003caddress\u003e\"and\"\u003caddress_type\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should send \"POST\" request for address endpoint",
  "keyword": "When "
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "name": "User should verify the response body message present as \"Address added successfully\" and get the address Id saved",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "mobile",
        "apartment",
        "state",
        "city",
        "country",
        "zipcode",
        "address",
        "address_type"
      ]
    },
    {
      "cells": [
        "Raj",
        "Khundra",
        "1234567898",
        "apartment",
        "33",
        "3378",
        "101",
        "202020",
        "64/63 partap nagar",
        "home"
      ]
    }
  ]
});
formatter.scenario({
  "name": "TC_1 User should add address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddAddress"
    }
  ]
});
formatter.step({
  "name": "User should add headers",
  "keyword": "Given "
});
formatter.match({
  "location": "AddressStep.user_should_add_headers()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should add  \"Raj\" , \"Khundra\", \"1234567898\", \"apartment\", \"33\", \"3378\", \"101\", \"202020\", \"64/63 partap nagar\"and\"home\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_add_and(String,String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should send \"POST\" request for address endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "AddressStep.user_should_send_request_for_address_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify the response body message present as \"Address added successfully\" and get the address Id saved",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_verify_the_response_body_message_present_as_and_get_the_address_Id_saved(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenarioOutline({
  "name": "TC_2 User should update the address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@UpdateAddress"
    }
  ]
});
formatter.step({
  "name": "User should add header",
  "keyword": "Given "
});
formatter.step({
  "name": "User should add required data for updating the address  \"\u003cfirst_name\u003e\" , \"\u003clast_name\u003e\", \"\u003cmobile\u003e\", \"\u003capartment\u003e\", \"\u003cstate\u003e\", \"\u003ccity\u003e\", \"\u003ccountry\u003e\", \"\u003czipcode\u003e\", \"\u003caddress\u003e\"and \"\u003caddress_type\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User should send \"PUT\" request for AddAddress endpoint",
  "keyword": "When "
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "name": "User should verify the response body update address message present as \"Address updated successfully\"",
  "keyword": "And "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "first_name",
        "last_name",
        "mobile",
        "apartment",
        "state",
        "city",
        "country",
        "zipcode",
        "address",
        "address_type"
      ]
    },
    {
      "cells": [
        "Vetri",
        "Hani",
        "8220260322",
        "apartment",
        "105",
        "52",
        "102",
        "624765",
        "20, Driftwood Drive, san Antonio",
        "Home"
      ]
    }
  ]
});
formatter.scenario({
  "name": "TC_2 User should update the address",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@AddAddress"
    },
    {
      "name": "@UpdateAddress"
    }
  ]
});
formatter.step({
  "name": "User should add header",
  "keyword": "Given "
});
formatter.match({
  "location": "AddressStep.user_should_add_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should add required data for updating the address  \"Vetri\" , \"Hani\", \"8220260322\", \"apartment\", \"105\", \"52\", \"102\", \"624765\", \"20, Driftwood Drive, san Antonio\"and \"Home\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_add_required_data_for_updating_the_address_and(String,String,String,String,String,String,String,String,String,String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should send \"PUT\" request for AddAddress endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "AddressStep.user_should_send_request_for_AddAddress_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify the response body update address message present as \"Address updated successfully\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_verify_the_response_body_update_address_message_present_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "TC_3 User should get the addresses",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddAddress"
    },
    {
      "name": "@GetAddress"
    }
  ]
});
formatter.step({
  "name": "User should add header",
  "keyword": "Given "
});
formatter.match({
  "location": "AddressStep.user_should_add_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should enter addressId to get the addresses",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_enter_addressId_to_get_the_addresses()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should send \"GET\" request for UpdateAddress endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "AddressStep.user_should_send_request_for_UpdateAddress_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify the response body Addaddress message present as \"OK\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_verify_the_response_body_Addaddress_message_present_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "TC_4 User should delete the address",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@AddAddress"
    },
    {
      "name": "@DeleteAddress"
    }
  ]
});
formatter.step({
  "name": "User should add header",
  "keyword": "Given "
});
formatter.match({
  "location": "AddressStep.user_should_add_header()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should enter addressid for deleting the address",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_enter_addressid_for_deleting_the_address()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should send \"DELETE\" request for login endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "AddressStep.user_should_send_request_for_login_endpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify the response body delete address message present as \"Address deleted Successfully\"",
  "keyword": "And "
});
formatter.match({
  "location": "AddressStep.user_should_verify_the_response_body_delete_address_message_present_as(String)"
});
formatter.result({
  "status": "passed"
});
formatter.uri("src/test/resources/Feature/TC3_ChangeProfile.feature");
formatter.feature({
  "name": "Profile module API Automation",
  "description": "",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@ProfilePic"
    }
  ]
});
formatter.scenario({
  "name": "User should change the profile picture",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@ProfilePic"
    }
  ]
});
formatter.step({
  "name": "User should add the headers",
  "keyword": "Given "
});
formatter.match({
  "location": "ChangeProfileStep.userShouldAddTheHeaders()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should send \"POST\" request for Updateprofilepic endpoint",
  "keyword": "When "
});
formatter.match({
  "location": "ChangeProfileStep.userShouldSendRequestForUpdateprofilepicEndpoint(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User verify the status code is 200",
  "keyword": "Then "
});
formatter.match({
  "location": "CommonStep.user_verify_the_status_code_is(int)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User should verify the response body of update profilepic message present as \"Profile updated Successfully\"",
  "keyword": "And "
});
formatter.match({
  "location": "ChangeProfileStep.userShouldVerifyTheResponseBodyOfUpdateProfilepicMessagePresentAs(String)"
});
formatter.result({
  "status": "passed"
});
});