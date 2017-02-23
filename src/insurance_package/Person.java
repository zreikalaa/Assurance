package insurance_package;

public class Person {
	private String fname;
	private String lname;
	private String motherName;
	private String fatherName;
	private String birthdate;
	private String birthplace;
	private String address;
	private String tel;
	
	public Person(String fn,String ln,String mn,String fan,String bd,String bp,String ad,String tl){
		this.fname = fn;
		this.lname = ln;
		this.motherName = mn;
		this.fatherName = fan;
		this.birthdate = bd;
		this.birthplace = bp;
		this.address = ad;
		this.tel = tl;
		
	}
	
	public String getfName(){
		return this.fname;
	}
	
	public String getlName(){
		return this.lname;
	}
	
	public String getmName(){
		return this.motherName;
	}
	
	public String getfaName(){
		return this.fatherName;
	}
	
	public String getBirthdate(){
		return this.birthdate;
	}
	
	public String getBirthplace(){
		return this.birthplace;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getTel(){
		return this.tel;
	}
	
}
