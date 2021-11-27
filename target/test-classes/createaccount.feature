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
      |email_create|         | Invalid email address.|
      |email_create| invalid.email.com|Invalid email address.|
      |email_create| someemail@gmail.com|An account using this email address has already been registered. Please enter a valid password or request a new one.|
