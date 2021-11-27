Feature: Registration Page Testing

  Background:
    Given Home page is opened
    And SignIn link is clicked
    And Create an account 'email_create' is filled with 'atillaseyid87@gmail.com'
    And Create an account button is clicked

  Scenario Outline:
    Given Registration '<field>' is filled with '<parameter>'
    Given Registration '<field2>' is filled with '<parameter2>'
    Given Registration '<field3>' is filled with '<parameter3>'
    When Register button is clicked
    Then '<msg>' registration error message is shown

    Examples:
    | field | parameter| field2 | parameter2| field3| parameter3| msg |
    | first_name|      | last_name|         | password|         | empty firstname/lastname/password!!!|
    | first_name| Atilla| last_name|        | password|         | empty lastname/password!!!         |
    | first_name| Atilla| last_name| Seyid  | password|         | empty password!!!                  |
    | first_name| Atilla| last_name| Seyid  | password| asdfghj | |