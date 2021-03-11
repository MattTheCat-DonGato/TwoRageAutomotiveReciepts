package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class Ownership 
{
    private String name;
    private String year;
    private String make;
    private String model;
    private String vin;
    private String licensePlate;
    private String odometer;
    
    public Ownership()
    {
        
    }
    
    public Ownership(String name, String year, String make, String model, String vin, String licensePlate, String odometer)
    {
        this.name = name;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vin = vin;
        this.licensePlate = licensePlate;
        this.odometer = odometer;
    }

    public String GetName() {
        return name;
    }

    public void SetName(String name) {
        this.name = name;
    }

    public String GetYear() {
        return year;
    }

    public void SetYear(String year) {
        this.year = year;
    }

    public String GetMake() {
        return make;
    }

    public void SetMake(String make) {
        this.make = make;
    }

    public String GetModel() {
        return model;
    }

    public void SetModel(String model) {
        this.model = model;
    }

    public String GetVin() {
        return vin;
    }

    public void SetVin(String vin) {
        this.vin = vin;
    }

    public String GetLicensePlate() {
        return licensePlate;
    }

    public void SetLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String GetOdometer() {
        return odometer;
    }

    public void SetOdometer(String odometer) {
        this.odometer = odometer;
    }
}
