Feature: Contact Us Page Testing

  Background:
    Given Home page is opened
    And Contact Us Link clicked

   Scenario: Successful
     Given Contact Us 'email' is filled with 'valid@gmail.com'
     And  Contact Us 'id_contact' is filled with 'Customer Service'
     And Contact Us 'message' is filled with 'somemsg'
     When Send button clicked
     Then 'Your message has been successfully sent to our team.' ContactUs message is shown


  Scenario Outline: Unsuccessful
    Given Contact Us '<field1>' is filled with '<parameter1>'
    Given Contact Us '<field2>' is filled with '<parameter2>'
    Given Contact Us '<field3>' is filled with '<parameter3>'
    When Send button clicked
    Then '<msg>' contact us error message is shown

    Examples:
      |field1 | parameter1|field2|parameter2| field3 | parameter3 | msg |
      | email |           |id_contact     |          | message|            |Invalid email address.|
      |email  |valid@gmail.com|id_contact |          | message|        |The message cannot be blank.|
      |email  |valid@gmail.com|id_contact |          | message|somemsg |Please select a subject from the list provided.|


