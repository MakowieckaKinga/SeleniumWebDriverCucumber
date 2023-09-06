Feature: Add new address

  Scenario Outline: User adds first address to the account
    Given the user logs in to the MyStore website
    When the user goes to the Addresses section
    When the user clicks on Create new address
    When the user fills out the form with the following  <alias> <address> <city> <postalCode> <phone>
    When the user submits the form

    Examples:
      | alias | address     | city        | postalCode | phone     |
      | ABC   | 123 Main St | Gotham      | 54321      | 555917654 |
      | DEF   | 456 Elm St  | Springfield | 12345      | 123789012 |