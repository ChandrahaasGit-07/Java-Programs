/** Questions :
  1 : Write a Java program to create a class known as Person with methods called getFirstName() and getLastName(). 
    Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include 
    the employee's job title.

    1.1: Write a Java program where the "Employee" subclass generates an email ID based on name and job title.
    1.2: Write a Java program where the "Person" class allows name changes under certain conditions.
    1.3 : Write a Java program where the "Employee" subclass includes a method to calculate annual leave balance.
*/
	  
class Person
{
    String fname;
    String lname;
    
    Person(String fname, String lname)
    {
        this.fname = fname;
        this.lname = lname;
    }
    void getFirstName()
    {
        System.out.println("The first name is :" + fname);
    }
    
    String getLastName()
    {
        return lname;
    }

  //fuc to set fname
    void setFirstName(String fname)
    {
        if(fname != null && fname.length() >=3)
        {
            this.fname = fname;
            System.out.println("First name successfully updated");
        }
        else
        {
            System.out.println("First name is not updated");
        }
    }
    
  //fuc to set lname
  void setLastName(String lname)
    {
        if(lname != null & lname.length() >= 3)
        {
            this.lname = lname;
            System.out.println("Last Name successfully updated");
        }
        else
        {
            System.out.println("Last name not updated");
        }
    }
}

class Employee extends Person
{
    int id;
    String jobTitle;
    int leaveTaken;
    static final int TOTAL_LEAVES = 20; // setting to final as the leave balance is fixed for all the employee
    
    
    Employee(String fname, String lname, int id, String jobTitle, int leaveTaken)
    {
        super(fname, lname);
        this.id = id;
        this.jobTitle = jobTitle;
        this.leaveTaken = leaveTaken;
    }
    void getEmployeeId()
    {
        System.out.println("The employee id is :" + id);
    }
    
    // fuc returns total emp last name + job title as string, because string always returns the value
    public String getLastName()   
    {
        return "last name "+ super.getLastName() + ", Job Title "+jobTitle;
    }

  //fuc to create a email id using "fname" and "lname"
	void generateEmailId()
	{
	    System.out.println(super.fname +"."+ super.lname+"@gmail.com");
	}

  //fuc to calculate the leave balance
	int leaveBalance()
	{
	    int balance = TOTAL_LEAVES - leaveTaken;
	    if(leaveTaken <= 0) balance = 0;
	    
	    return balance;
	}
    
}
public class Main
{
	public static void main(String[] args) {
		Employee emp = new Employee("Abc", "XYZ", 10, "HR", 5);
		// employee name
		emp.getFirstName();
		// last name
		System.out.println("Employee " + emp.getLastName());
		// id
		emp.getEmployeeId();
		emp.generateEmailId();
		
		//after updating the fname and lname
		System.out.println("updating fname and lname \n\n");
		
		emp.setFirstName("DEF");
		emp.setLastName("UVW");
		
		emp.getFirstName();
		System.out.println("Employee updated details :"+ emp.getLastName());
		emp.getEmployeeId();
		emp.generateEmailId();
		
		//leave taken
		System.out.println("Tota leave balance is :"+emp.leaveBalance());
	}
}
