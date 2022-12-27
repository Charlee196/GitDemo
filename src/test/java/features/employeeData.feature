Feature: Verify the APIs of Employee DataBase

Scenario Outline: Verify the POST Employee API
Given "createEmployee" payload with <name>, <salary>, <age>
When user calls "createEmployee" with "Post" http request
Then the API call got success with status code 200
And "status" in response body is "success"


Examples:
|name      |salary   |age    |
|Sam       |35000    |30     |


Scenario Outline: Verify the GET Employee API
Given pass the employee <id> to "get" the employee record
When user calls "getEmployee" with "get" http request
Then the API call got success with status code 200
And "message" in response body is "Successfully! Record has been fetched."

Examples:

|id  |
|400 |





Scenario Outline: Verify the PUT Employee API
Given updateEmployee payload with <name>, <salary>, <age> and Pass <id> to update the employee
When user calls "updateEmployee" with "Put" http request
Then the API call got success with status code 200
And "status" in response body is "success"
And "message" in response body is "Successfully! Record has been updated."

Examples:
|name    |salary   |age    |id  |
|Mangu   |340000   |28     |400 |


Scenario Outline: Verify the DELETE Employee API
Given pass the employee <id> to "delete" the employee record
When user calls "deleteEmployee" with "delete" http request
Then the API call got success with status code 200
And "message" in response body is "Successfully! Record has been deleted"

Examples:
|id |
|300|


