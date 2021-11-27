Feature: Searching Functionality Testing
  Background:
    Given Home page is opened

  Scenario: Successful
    Given Search 'query' filled with 'sweater'
    When Search Button clicked
    Then 't-shirt result found!' search result message shown

  Scenario Outline: Unsuccessful
    Given Search '<field>' filled with '<parameter>'
    When Search Button clicked
    Then '<msg>' search error message shown

    Examples:
      |field| parameter|msg|
      |query|          |Empty field!|
      |query| top      |No results for "top"!|