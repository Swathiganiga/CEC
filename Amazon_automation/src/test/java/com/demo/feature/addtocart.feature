Feature: add to cart


@test1
Scenario: add an item from cart
Given Im on Amazon signinpage
When I enter valid username and password
Then I search  product
Then I select paricular product from list
Then I add it to the cart
Then I asserting successful msg

@test2
Scenario: delete an item from the cart
Given Im on Amazon signinpage
When I enter valid username and password
Then i click add to cart button
Then i delete particular product from the  cart

