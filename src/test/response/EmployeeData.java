public class EmployeeData {

    private String role;

    private String dob;

    private String name;

    private String company;

    private String id;

    private String age;

    public String getRole ()
    {
        return role;
    }

    public void setRole (String role)
    {
        this.role = role;
    }

    public String getDob ()
    {
        return dob;
    }

    public void setDob (String dob)
    {
        this.dob = dob;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public String getCompany ()
    {
        return company;
    }

    public void setCompany (String company)
    {
        this.company = company;
    }

    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getAge ()
    {
        return age;
    }

    public void setAge (String age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [role = "+role+", dob = "+dob+", name = "+name+", company = "+company+", id = "+id+", age = "+age+"]";
    }
}
