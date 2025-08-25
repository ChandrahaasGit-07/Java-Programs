/*Write a Java program to create a class known as Person with methods called getFirstName() and getLastName(). 
Create a subclass called Employee that adds a new method named getEmployeeId() and overrides the getLastName() method to include 
the employee's job title.*/


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
}

class Employee extends Person
{
    int id;
    String jobTitle;
    
    Employee(String fname, String lname, int id, String jobTitle)
    {
        super(fname, lname);
        this.id = id;
        this.jobTitle = jobTitle;
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
    
    public static void main(String[] args) {
		Employee emp = new Employee("Abc", "XYZ", 10, "HR");
		// employee name
		emp.getFirstName();
		// last name
		System.out.println("Employee " + emp.getLastName());
		// id
		emp.getEmployeeId();
	}
    
}
