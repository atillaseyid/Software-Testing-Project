Feature:  Newsletter Subscription Testing

  Background:
    Given Home page is opened
    And SignIn link is clicked

  Scenario Outline:
    Given Newsletter subscription '<field>' is filled with '<parameter>'
    When Newsletter button clicked
    Then '<msg>' message is shown
    Examples:
    |field| parameter| msg|
    |newsletter-input| | Newsletter : Invalid email address.|
    |newsletter-input|invalid.gmail.com| Newsletter : Invalid email address.                           |
    |newsletter-input|valid@gmail.com|Newsletter : This email address is already registered.|