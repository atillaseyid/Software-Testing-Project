Feature: Shopping Cart
  Background: 
    Given Home page is opened
  Scenario: 
    When Shopping Cart link clicked
    Then "Shopping cart is empty!" shopping cart error message shown