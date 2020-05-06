package fisdom;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import org.junit.Assert;

public class booking {

	bean bean = fisdom.bean.getInstance();
//////Creation of booking//////////
	public void createBooking() throws Throwable{
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		String response = given().log().all().header("Content-Type", "application/json")
				.body("{\r\n" + "    \"firstname\" : \""+bean.getFirstName()+"\",\r\n" + "    \"lastname\" : \""+bean.getLastName()+"\",\r\n"
						+ "    \"totalprice\" : "+bean.getTotalPrice()+",\r\n" + "    \"depositpaid\" : "+bean.getDepositPaid()+",\r\n"
						+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \""+bean.getCheckIn()+"\",\r\n"
						+ "        \"checkout\" : \""+bean.getCheckOut()+"\"\r\n" + "    },\r\n"
						+ "    \"additionalneeds\" : \""+bean.getAdditionalNeed()+"\"\r\n" + "}")
				.when().post("booking")
				.then().assertThat().statusCode(200).header("Server", equalTo("Cowboy"))
				.extract().response().asString();
		
		bean.setResponse(response);
		
	}
	
	
	public void validateBooking() throws Throwable{
		String response = bean.getResponse();
		System.out.println("Response is :" + response);

		JsonPath js = new JsonPath(response);
		String name = js.get("booking.firstname");
		Assert.assertTrue(name.equals(bean.getFirstName()));
		String lname = js.get("booking.lastname");
		Assert.assertTrue(lname.equals(bean.getLastName()));
		int totalPrice = js.getInt("booking.totalprice");
		Assert.assertTrue(totalPrice == bean.getTotalPrice());

		String checkInDate = js.get("booking.bookingdates.checkin");
		Assert.assertTrue(checkInDate.equals(bean.getCheckIn()));

	}
	
		
/////////// Update Booking //////////////////////////////
		public void updateBooking() throws Throwable{

			RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/3";
			String updateResponse = given().log().all().header("Content-Type", "application/json").auth().preemptive()
					.basic("admin", "password123")
					.body("{\r\n" + "    \"firstname\" : \"Akash\",\r\n" + "    \"lastname\" : \"Akash\",\r\n"
							+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
							+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
							+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
							+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
					.when().log().all().put()
					.then().assertThat().statusCode(200)
					.extract().response().asString();
			bean.setResponse(updateResponse);
			
		}
		
		public void validateUpdateBooking() throws Throwable{
			String updateResponse= bean.getResponse();
			System.out.println(updateResponse);
			JsonPath jsInUpdate = new JsonPath(updateResponse);
			String lnameAfterUpdate = jsInUpdate.getString("lastname");
			Assert.assertTrue(lnameAfterUpdate.equals("Akash"));

			String checkInDateAfterUpdate = jsInUpdate.get("bookingdates.checkin");
			Assert.assertTrue(checkInDateAfterUpdate.equals("2018-01-01"));
		}
		
		
		public void createPayloadForFetch() throws Throwable{
			RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/2";
			String Response = given().log().all().header("Content-Type", "application/json")
					.when().log().all().get().
					then().assertThat().statusCode(200)
					.extract().response().asString();
			bean.setResponse(Response);
		}
		
		public void validateFetchedBooking() throws Throwable{
			String response = bean.getResponse();
			System.out.println(response);
			JsonPath js = new JsonPath(response);
			String fname = js.getString("firstname");
			Assert.assertTrue(fname.equals("Jim"));
			String checkIn = js.get("bookingdates.checkin");
			Assert.assertTrue(checkIn.equals("2017-06-30"));
			int total = js.getInt("totalprice");
			Assert.assertTrue(total==636);
		}
		
		
		public void createBookingWithInvalidData() throws Throwable{
			RestAssured.baseURI = "https://restful-booker.herokuapp.com";
			String response = given().log().all().header("Content-Type", "application/json")
					.body("{\r\n" + 
							"    \"lastname\" : \"Kumar\",\r\n" + 
							"    \"totalprice\" : 111,\r\n" + 
							"    \"depositpaid\" : true,\r\n" + 
							"    \"bookingdates\" : {\r\n" + 
							"        \"checkin\" : \"2018-01-01\",\r\n" + 
							"        \"checkout\" : \"2019-01-01\"\r\n" + 
							"    },\r\n" + 
							"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
							"}")
					.when().post("booking")
					.then().header("Server", equalTo("Cowboy"))
					.extract().response().asString();
			
			bean.setResponse(response);
			System.out.println(response);
		}

		public void validateResponseWithInternalServerError() throws Throwable{
			String response = bean.getResponse();
			Assert.assertTrue(response.equals("Internal Server Error"));
		}
		
		public void createPayloadUpdateWOAuth() throws Throwable{
			RestAssured.baseURI = "https://restful-booker.herokuapp.com/booking/3";
			String updateResponse = given().log().all().header("Content-Type", "application/json").auth().preemptive()
					.basic("admin1", "password123")
					.body("{\r\n" + "    \"firstname\" : \"Akash\",\r\n" + "    \"lastname\" : \"Akash\",\r\n"
							+ "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n"
							+ "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
							+ "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n"
							+ "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}")
					.when().log().all().put()
					.then()
					.extract().response().asString();
			bean.setResponse(updateResponse);
		}
		
		
		public void validateForbiddenErrorResponse() throws Throwable{
			String response = bean.getResponse();
			Assert.assertTrue(response.equals("Forbidden"));
		}
}
