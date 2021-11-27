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
      | email |           | message|            |Empty email input!!!|
      |email  |valid@gmail.com| message|        |Empty message!!!    |
      |email  |valid@gmail.com| message|somemsg |Select subject from the list!!!|
