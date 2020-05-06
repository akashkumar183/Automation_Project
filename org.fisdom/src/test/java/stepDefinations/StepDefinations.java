package stepDefinations;

import cucumber.api.java.en.Then;
import fisdom.booking;
import fisdom.bean;

public class StepDefinations {

	booking b = new booking();
	bean bean = fisdom.bean.getInstance();
	
	
	
	@Then("^user create payload for \"(.*)\" for FirstName creation$")
	public void user_create_payloadFname(String var) throws Throwable {
		bean.setFirstName(var);
	}
	
	@Then("^user create payload for \"(.*)\" for LastName creation$")
	public void user_create_payloadlname(String var) throws Throwable {
		bean.setLastName(var);
	}
	
	@Then("^user create payload for \"(.*)\" for TotalPrice creation$")
	public void user_create_payloadTotal(int var) throws Throwable {
		bean.setTotalPrice(var);
	}
	
	@Then("^user create payload for \"(.*)\" for DepositPaid creation$")
	public void user_create_payloadDeposit(String var) throws Throwable {
		bean.setDepositPaid(var);
	}
	
	@Then("^user create payload for \"(.*)\" for CheckIn creation$")
	public void user_create_payloadCheckIn(String var) throws Throwable {
		bean.setCheckIn(var);
	}
	
	@Then("^user create payload for \"(.*)\" for CheckOut creation$")
	public void user_create_payloadCheckOut(String var) throws Throwable {
		bean.setCheckOut(var);
	}
	
	@Then("^user create payload for \"(.*)\" for AdditionalNeeds creation$")
	public void user_create_payloadAdditional(String var) throws Throwable {
		bean.setAdditionalNeed(var);
	}
	
	
	@Then("^create payload for booking creation$")
	public void user_create_payload() throws Throwable {
		b.createBooking();
	}
	
	
	
	@Then("^user create payload for booking updation$")
	public void user_create_payload_Update() throws Throwable {
		b.updateBooking();
	}

	@Then("^user validate the response of create booking$")
	public void user_validate_the_response_of_create_booking() throws Throwable {
		b.validateBooking();
	}
	
	@Then("^user validate the response of update booking$")
	public void user_validate_the_response_of_update_booking() throws Throwable {
		b.validateUpdateBooking();
	}
	
	@Then("^user create payload for fetching the booking details$")
	public void createPayloadForFetch() throws Throwable {
		b.createPayloadForFetch();
	}
	
	@Then("^user validate the response for booking details$")
	public void validateFetchedBooking() throws Throwable {
		b.validateFetchedBooking();
	}
	
	@Then("^user create payload with invalid data for booking creation$")
	public void createBookingWithInvalidData() throws Throwable {
		b.createBookingWithInvalidData();
	}
	
	
	@Then("^user validate the response with Internal Server Error$")
	public void validateResponseWithInternalServerError() throws Throwable {
		b.validateResponseWithInternalServerError();
	}
	
	@Then("^user create payload with invalid authentication for booking updation$")
	public void createPayloadUpdateWOAuth() throws Throwable {
		b.createPayloadUpdateWOAuth();
	}
	
	@Then("^user validate the forbidden error response$")
	public void validateForbiddenErrorResponse() throws Throwable {
		b.validateForbiddenErrorResponse();
	}
	
}
