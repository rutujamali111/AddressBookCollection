package addressbooksystem;

public class Contact extends Address{
	private String fname;
	private String lname;
	private long phonenumber;
	
	
	
	public long getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	@Override
	public String toString() {
		return "Contact [fname=" + fname + ", lname=" + lname + ", phonenumber=" + phonenumber + ", getCity()="
				+ getCity() + ", getZip()=" + getZip() + ", getState()=" + getState()  + "]";
	}

	

	


}
