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