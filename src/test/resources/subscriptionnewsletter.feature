Feature:  Newsletter Subscription Testing

  Background:
    Given Home page is opened
    And SignIn link is clicked

  Scenario Outline:
    Given Newsletter subscription '<field>' is filled with '<parameter>'
    When Newsletter button clicked
    Then '<msg>' error message is shown
    Examples:
    |field| parameter| msg|
    |newsletter_input|| Newsletter : Invalid email address.|
    |newsletter_input|valid@gmail.com|Newsletter : You have successfully subscribed to this newsletter.|
    |newsletter_input|invalid.gmail.com| Newsletter : Invalid email address.                           |