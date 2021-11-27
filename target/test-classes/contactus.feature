Feature: Contact Us Page Testing

  Background:
    Given Home page is opened
    And Contact Us Link clicked

  Scenario Outline:
    Given Contact Us '<field1>' is filled with '<parameter1>'
    Given Contact Us '<field2>' is filled with '<parameter2>'
    When Send button clicked
    Then '<msg>' contact us error message is shown

    Examples:
      |field1 | parameter1| field2 | parameter2 | msg |
      | email |           | message|            |Invalid email address.|
      |email  |valid@gmail.com| message|        |The message cannot be blank.|
      |email  |valid@gmail.com| message|somemsg |Please select a subject from the list provided.|
