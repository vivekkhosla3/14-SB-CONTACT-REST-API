package in.ashokit.binding;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer contactId=1;
	private String contactName;
	private String contactEmail;
	private String contactNumber;
	private String activeSw;
	
	
	public Contact() {
	}


	public Contact(Integer contactId, String contactName, String contactEmail, String contactNumber, String activeSw) {
		super();
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactEmail = contactEmail;
		this.contactNumber = contactNumber;
		this.activeSw = activeSw;
	}


	public Integer getContactId() {
		return contactId;
	}


	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}


	public String getContactName() {
		return contactName;
	}


	public void setContactName(String contactName) {
		this.contactName = contactName;
	}


	public String getContactEmail() {
		return contactEmail;
	}


	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	public String getactiveSw() {
		return activeSw;
	}


	public void setactiveSw(String activeSw) {
		this.activeSw = activeSw;
	}



	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactEmail=" + contactEmail
				+ ", contactNumber=" + contactNumber + ", getContactId()=" + getContactId() + ", getContactName()="
				+ getContactName() + ", getContactEmail()=" + getContactEmail() + ", getContactNumber()="
				+ getContactNumber() + ", activeSw()="
						+ getactiveSw()+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}	

}
