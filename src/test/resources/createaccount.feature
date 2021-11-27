Feature: AccountCreating page testing
  Background:
    Given Home page is opened
    And SignIn link is clicked

  Scenario Outline:
    Given Create an account '<field>' is filled with '<parameter>'
    When Create an account button is clicked
    Then '<msg>' create account error message shown

    Examples:
      | field| parameter | msg|
      |email_input|         | Empty field!!!|
      |email_input| invalid@gemil.com| Invalid email!!!|
      |email_input| someemail@gmail.com| This email has already registered. Please, sign in or use other email address!!!|
