Feature: SignIn page test

  Background:
    Given Home page is opened
    And SignIn link is clicked

  Scenario Outline:
    Given '<field>' is filled with '<parameter>'
    When SignIn button is clicked
    Then '<msg>' error msg is shown
    Examples:
      | field | parameter | msg |
      | email |           | An email address required. |
      | email | invalid.email.com| Invalid email address.|
      | email | valid@email.com  | Password is required.|

