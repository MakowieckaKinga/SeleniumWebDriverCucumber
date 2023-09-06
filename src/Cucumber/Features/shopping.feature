Feature: Shopping for Hummingbird Printed Sweater

  Scenario: Purchase Hummingbird Printed Sweater with customization options
    Given User is logged in
    When User selects Hummingbird Printed Sweater
    And User selects size M
    And User adds 5 items to the cart
    And User proceeds to checkout
   When User confirms the shipping address
    And User chooses Pick up in store as the delivery method
    And User selects Pay by Check as the payment method
    Then User takes a screenshot of the order confirmation with the amount