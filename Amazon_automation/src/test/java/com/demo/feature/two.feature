Feature: add to cart

@test3
Scenario Outline: inputing multiple username and password 
Given Im on Amazon signinpage
Given  i enetr pass
When I input username and passwords with index "<index>"
Examples:
|index|
|1|
|2|



    
