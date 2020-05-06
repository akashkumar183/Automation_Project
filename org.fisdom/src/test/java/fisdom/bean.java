package fisdom;

import java.io.Serializable;

public class bean implements Serializable {
		   /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String response = null;
		private String firstName = null;
		private String lastName = null;
		private int totalPrice = 0;
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getTotalPrice() {
			return totalPrice;
		}

		public void setTotalPrice(int totalPrice) {
			this.totalPrice = totalPrice;
		}

		public String getDepositPaid() {
			return depositPaid;
		}

		public void setDepositPaid(String depositPaid) {
			this.depositPaid = depositPaid;
		}

		public String getCheckIn() {
			return checkIn;
		}

		public void setCheckIn(String checkIn) {
			this.checkIn = checkIn;
		}

		public String getCheckOut() {
			return checkOut;
		}

		public void setCheckOut(String checkOut) {
			this.checkOut = checkOut;
		}

		public String getAdditionalNeed() {
			return additionalNeed;
		}

		public void setAdditionalNeed(String additionalNeed) {
			this.additionalNeed = additionalNeed;
		}

		private String depositPaid = null;
		private String checkIn = null;
		private String checkOut = null;
		private String additionalNeed = null;
		private static bean myobj=null;
		
		public static bean getInstance() {
			if (myobj == null) {
				myobj = new bean();
			}
			return myobj;
		}
		
		
		

		   public String getResponse() {
			return response;
		}

		public void setResponse(String response) {
			this.response = response;
		}

		public bean() {
		   }
		   
		 
		}
