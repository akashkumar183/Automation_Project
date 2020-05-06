Feature: Fisdom Assignment
	
@Test	
Scenario Outline: Create Booking
	Then user create payload for "<FirstName>" for FirstName creation
	Then user create payload for "<LastName>" for LastName creation
	Then user create payload for "<TotalPrice>" for TotalPrice creation
	Then user create payload for "<DepositPaid>" for DepositPaid creation
	Then user create payload for "<CheckIn>" for CheckIn creation
	Then user create payload for "<CheckOut>" for CheckOut creation 
	Then user create payload for "<AdditionalNeeds>" for AdditionalNeeds creation
	Then create payload for booking creation 
	Then user validate the response of create booking
	Examples:
	|FirstName|LastName|TotalPrice|DepositPaid|CheckIn|CheckOut|AdditionalNeeds|
	|Akash|Kumar|111|true|2020-01-01|2020-01-01|Breakfast|
	
	
Scenario: Update Booking
	Then user create payload for booking updation
	Then user validate the response of update booking
	
	
Scenario: Fetch booking details
	Then user create payload for fetching the booking details
	And user validate the response for booking details
	
	
Scenario: Create Booking with invalid data
	When user create payload with invalid data for booking creation
	Then user validate the response with Internal Server Error
	

Scenario: Update booking with invalid authentication
	Then user create payload with invalid authentication for booking updation
	Then user validate the forbidden error response
