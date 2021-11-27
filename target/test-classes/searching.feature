Feature: Searching Functionality Testing
  Background:
    Given Home page is opened

  Scenario: Successful
    Given Search 'search_query_top' filled with 't-shirt'
    When Search Button clicked
    Then '1 result has been found.' search result message shown

  Scenario Outline: Unsuccessful
    Given Search '<field>' filled with '<parameter>'
    When Search Button clicked
    Then '<msg>' search error message shown

    Examples:
      |field| parameter|msg|
      |search_query_top|          |Please enter a search keyword|
      |search_query_top| t     |No results were found for your search "t"|