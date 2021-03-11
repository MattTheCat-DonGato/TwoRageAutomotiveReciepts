package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class Customer 
{
    private String name;
    private String address;
    private String phone;
    private String city;
    private String state;
    private String zip;
    
    /*
        Empty constructor for Customer
    */
    public Customer()
    {
    }
    
    public Customer(String name, String address, String phone, String city, String state, String zip)
    {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String GetName() 
    {
        return name;
    }

    public void SetName(String name) 
    {
        this.name = name;
    }

    public String GetAddress() 
    {
        return address;
    }

    public void SetAddress(String address) 
    {
        this.address = address;
    }

    public String GetPhone() 
    {
        return phone;
    }

    public void SetPhone(String phone) 
    {
        this.phone = phone;
    }

    public String GetCity() 
    {
        return city;
    }

    public void SetCity(String city) 
    {
        this.city = city;
    }

    public String GetState() 
    {
        return state;
    }

    public void SetState(String state) 
    {
        this.state = state;
    }

    public String GetZip() 
    {
        return zip;
    }

    public void SetZip(String zip) 
    {
        this.zip = zip;
    }       
}
