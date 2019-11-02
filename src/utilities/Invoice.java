package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class Invoice
{
    // data
    private String cName;
    private String cPhone;
    private String cAddress;
    private String cCity;
    private String cState;
    private String cZip;
    private String cDate_Time;
    private int cOrderNumber;
    private String cVehicleYear;
    private String cVehicleMake;
    private String cVehicleModel;
    private String cSerialVIN;
    private String cLicenseNumber;
    private int cOdometer;
    private String cSlot_1;
    private double cSlotCost_1;
    private String cSlot_2;
    private double cSlotCost_2;
    private String cSlot_3;
    private double cSlotCost_3;
    private String cSlot_4;
    private double cSlotCost_4;
    private String cSlot_5;
    private double cSlotCost_5;
    private String cSlot_6;
    private double cSlotCost_6;
    private double cLabor;
    private double cTotal;

    //constructors
    /*
        Empty Invoice Constructor
    */
    public Invoice()
    {   
    }
    
    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }

    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, String cSlot_2, double cSlotCost_2, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cSlot_2 = cSlot_2;
        this.cSlotCost_2 = cSlotCost_2;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }
    /*
        This constuctor stores customer information and vehicle information. Also handles up to three valid work order slots.
    */
    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, String cSlot_2, double cSlotCost_2, String cSlot_3, double cSlotCost_3, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cSlot_2 = cSlot_2;
        this.cSlotCost_2 = cSlotCost_2;
        this.cSlot_3 = cSlot_3;
        this.cSlotCost_3 = cSlotCost_3;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }

    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, String cSlot_2, double cSlotCost_2, String cSlot_3, double cSlotCost_3, String cSlot_4, double cSlotCost_4, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cSlot_2 = cSlot_2;
        this.cSlotCost_2 = cSlotCost_2;
        this.cSlot_3 = cSlot_3;
        this.cSlotCost_3 = cSlotCost_3;
        this.cSlot_4 = cSlot_4;
        this.cSlotCost_4 = cSlotCost_4;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }

    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, String cSlot_2, double cSlotCost_2, String cSlot_3, double cSlotCost_3, String cSlot_4, double cSlotCost_4, String cSlot_5, double cSlotCost_5, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cSlot_2 = cSlot_2;
        this.cSlotCost_2 = cSlotCost_2;
        this.cSlot_3 = cSlot_3;
        this.cSlotCost_3 = cSlotCost_3;
        this.cSlot_4 = cSlot_4;
        this.cSlotCost_4 = cSlotCost_4;
        this.cSlot_5 = cSlot_5;
        this.cSlotCost_5 = cSlotCost_5;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }

    public Invoice(String cName, String cPhone, String cAddress, String cCity, String cState, String cZip, String cDate_Time, int cOrderNumber, String cVehicleYear, String cVehicleMake, String cVehicleModel, String cSerialVIN, String cLicenseNumber, int cOdometer, String cSlot_1, double cSlotCost_1, String cSlot_2, double cSlotCost_2, String cSlot_3, double cSlotCost_3, String cSlot_4, double cSlotCost_4, String cSlot_5, double cSlotCost_5, String cSlot_6, double cSlotCost_6, double cLabor, double cTotal)
    {
        this.cName = cName;
        this.cPhone = cPhone;
        this.cAddress = cAddress;
        this.cCity = cCity;
        this.cState = cState;
        this.cZip = cZip;
        this.cDate_Time = cDate_Time;
        this.cOrderNumber = cOrderNumber;
        this.cVehicleYear = cVehicleYear;
        this.cVehicleMake = cVehicleMake;
        this.cVehicleModel = cVehicleModel;
        this.cSerialVIN = cSerialVIN;
        this.cLicenseNumber = cLicenseNumber;
        this.cOdometer = cOdometer;
        this.cSlot_1 = cSlot_1;
        this.cSlotCost_1 = cSlotCost_1;
        this.cSlot_2 = cSlot_2;
        this.cSlotCost_2 = cSlotCost_2;
        this.cSlot_3 = cSlot_3;
        this.cSlotCost_3 = cSlotCost_3;
        this.cSlot_4 = cSlot_4;
        this.cSlotCost_4 = cSlotCost_4;
        this.cSlot_5 = cSlot_5;
        this.cSlotCost_5 = cSlotCost_5;
        this.cSlot_6 = cSlot_6;
        this.cSlotCost_6 = cSlotCost_6;
        this.cLabor = cLabor;
        this.cTotal = cTotal;
    }  
    
    //properties
    /**
     * @return the cName
     */
    public String GetcName()
    {
        return cName;
    }

    /**
     * @param cName the cName to set
     */
    public void SetcName(String cName)
    {
        this.cName = cName;
    }

    /**
     * @return the cPhone
     */
    public String GetcPhone()
    {
        return cPhone;
    }

    /**
     * @param cPhone the cPhone to set
     */
    public void SetcPhone(String cPhone)
    {
        this.cPhone = cPhone;
    }

    /**
     * @return the cAddress
     */
    public String GetcAddress()
    {
        return cAddress;
    }

    /**
     * @param cAddress the cAddress to set
     */
    public void SetcAddress(String cAddress)
    {
        this.cAddress = cAddress;
    }

    /**
     * @return the cCity
     */
    public String GetcCity()
    {
        return cCity;
    }

    /**
     * @param cCity the cCity to set
     */
    public void SetcCity(String cCity)
    {
        this.cCity = cCity;
    }
    
    /**
     * @return the cState
     */
    public String GetcState()
    {
        return cState;
    }

    /**
     * @param cState the cState to set
     */
    public void SetcState(String cState)
    {
        this.cState = cState;
    }
    
    /**
     * @return the cZip
     */
    public String GetcZip()
    {
        return cZip;
    }

    /**
     * @param cZip the cZip to set
     */
    public void SetcZip(String cZip)
    {
        this.cZip = cZip;
    }

    /**
     * @return the cDate_Time
     */
    public String GetcDate_Time()
    {
        return cDate_Time;
    }

    /**
     * @param cDate_Time the cDate_Time to set
     */
    public void SetcDate_Time(String cDate_Time)
    {
        this.cDate_Time = cDate_Time;
    }

    /**
     * @return the cOrderNumber
     */
    public int GetcOrderNumber()
    {
        return cOrderNumber;
    }

    /**
     * @param cOrderNumber the cOrderNumber to set
     */
    public void SetcOrderNumber(int cOrderNumber)
    {
        this.cOrderNumber = cOrderNumber;
    }

    /**
     * @return the cVehicleYear
     */
    public String GetcVehicleYear()
    {
        return cVehicleYear;
    }

    /**
     * @param cVehicleYear the cVehicleYear to set
     */
    public void SetcVehicleYear(String cVehicleYear)
    {
        this.cVehicleYear = cVehicleYear;
    }

    /**
     * @return the cVehicleMake
     */
    public String GetcVehicleMake()
    {
        return cVehicleMake;
    }

    /**
     * @param cVehicleMake the cVehicleMake to set
     */
    public void SetcVehicleMake(String cVehicleMake)
    {
        this.cVehicleMake = cVehicleMake;
    }

    /**
     * @return the cVehicleModel
     */
    public String GetcVehicleModel()
    {
        return cVehicleModel;
    }

    /**
     * @param cVehicleModel the cVehicleModel to set
     */
    public void SetcVehicleModel(String cVehicleModel)
    {
        this.cVehicleModel = cVehicleModel;
    }

    /**
     * @return the cSerialVIN
     */
    public String GetcSerialVIN()
    {
        return cSerialVIN;
    }

    /**
     * @param cSerialVIN the cSerialVIN to set
     */
    public void SetcSerialVIN(String cSerialVIN)
    {
        this.cSerialVIN = cSerialVIN;
    }

    /**
     * @return the cLicenseNumber
     */
    public String GetcLicenseNumber()
    {
        return cLicenseNumber;
    }

    /**
     * @param cLicenseNumber the cLicenseNumber to set
     */
    public void SetcLicenseNumber(String cLicenseNumber)
    {
        this.cLicenseNumber = cLicenseNumber;
    }

    /**
     * @return the cOdometer
     */
    public int GetcOdometer()
    {
        return cOdometer;
    }

    /**
     * @param cOdometer the cOdometer to set
     */
    public void SetcOdometer(int cOdometer)
    {
        this.cOdometer = cOdometer;
    }

    /**
     * @return the cSlot_1
     */
    public String GetcSlot_1()
    {
        return cSlot_1;
    }

    /**
     * @param cSlot_1 the cSlot_1 to set
     */
    public void SetcSlot_1(String cSlot_1)
    {
        this.cSlot_1 = cSlot_1;
    }

    /**
     * @return the cSlot_2
     */
    public String GetcSlot_2()
    {
        return cSlot_2;
    }

    /**
     * @param cSlot_2 the cSlot_2 to set
     */
    public void SetcSlot_2(String cSlot_2)
    {
        this.cSlot_2 = cSlot_2;
    }

    /**
     * @return the cSlot_3
     */
    public String GetcSlot_3()
    {
        return cSlot_3;
    }

    /**
     * @param cSlot_3 the cSlot_3 to set
     */
    public void SetcSlot_3(String cSlot_3)
    {
        this.cSlot_3 = cSlot_3;
    }

    /**
     * @return the cSlot_4
     */
    public String GetcSlot_4()
    {
        return cSlot_4;
    }

    /**
     * @param cSlot_4 the cSlot_4 to set
     */
    public void SetcSlot_4(String cSlot_4)
    {
        this.cSlot_4 = cSlot_4;
    }

    /**
     * @return the cSlot_5
     */
    public String GetcSlot_5()
    {
        return cSlot_5;
    }

    /**
     * @param cSlot_5 the cSlot_5 to set
     */
    public void SetcSlot_5(String cSlot_5)
    {
        this.cSlot_5 = cSlot_5;
    }

    /**
     * @return the cSlot_6
     */
    public String GetcSlot_6()
    {
        return cSlot_6;
    }

    /**
     * @param cSlot_6 the cSlot_6 to set
     */
    public void SetcSlot_6(String cSlot_6)
    {
        this.cSlot_6 = cSlot_6;
    }

    /**
     * @return the cLabor
     */
    public double GetcLabor()
    {
        return cLabor;
    }

    /**
     * @param cLabor the cLabor to set
     */
    public void SetcLabor(int cLabor)
    {
        this.cLabor = cLabor;
    }

    /**
     * @return the cTotal
     */
    public double GetcTotal()
    {
        return cTotal;
    }

    /**
     * @param cTotal the cTotal to set
     */
    public void SetcTotal(int cTotal)
    {
        this.cTotal = cTotal;
    }

    /**
     * @return the cSlotCost_1
     */
    public double GetcSlotCost_1()
    {
        return cSlotCost_1;
    }

    /**
     * @param cSlotCost_1 the cSlotCost_1 to set
     */
    public void SetcSlotCost_1(double cSlotCost_1)
    {
        this.cSlotCost_1 = cSlotCost_1;
    }

    /**
     * @return the cSlotCost_2
     */
    public double GetcSlotCost_2()
    {
        return cSlotCost_2;
    }

    /**
     * @param cSlotCost_2 the cSlotCost_2 to set
     */
    public void SetcSlotCost_2(double cSlotCost_2)
    {
        this.cSlotCost_2 = cSlotCost_2;
    }

    /**
     * @return the cSlotCost_3
     */
    public double GetcSlotCost_3()
    {
        return cSlotCost_3;
    }

    /**
     * @param cSlotCost_3 the cSlotCost_3 to set
     */
    public void SetcSlotCost_3(double cSlotCost_3)
    {
        this.cSlotCost_3 = cSlotCost_3;
    }

    /**
     * @return the cSlotCost_4
     */
    public double GetcSlotCost_4()
    {
        return cSlotCost_4;
    }

    /**
     * @param cSlotCost_4 the cSlotCost_4 to set
     */
    public void SetcSlotCost_4(double cSlotCost_4)
    {
        this.cSlotCost_4 = cSlotCost_4;
    }

    /**
     * @return the cSlotCost_5
     */
    public double GetcSlotCost_5()
    {
        return cSlotCost_5;
    }

    /**
     * @param cSlotCost_5 the cSlotCost_5 to set
     */
    public void SetcSlotCost_5(double cSlotCost_5)
    {
        this.cSlotCost_5 = cSlotCost_5;
    }

    /**
     * @return the cSlotCost_6
     */
    public double GetcSlotCost_6()
    {
        return cSlotCost_6;
    }

    /**
     * @param cSlotCost_6 the cSlotCost_6 to set
     */
    public void SetcSlotCost_6(double cSlotCost_6)
    {
        this.cSlotCost_6 = cSlotCost_6;
    }
}