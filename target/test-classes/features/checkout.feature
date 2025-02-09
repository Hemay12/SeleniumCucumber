Feature: Checkout process

  Scenario: User completes the checkout successfully using credit card
    Given the user is logged in
    When User searches for product and adds it into the cart
    And User navigates to cart page and proceeds to checkout
    And User enters payment details and confirms the order
    Then Order should be placed successfully
