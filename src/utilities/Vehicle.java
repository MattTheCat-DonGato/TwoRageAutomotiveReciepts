/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 *
 * @author Matthew Rodriguez
 */
public class Vehicle 
{
    private String year;
    private String make;
    private String model;
    private String vin;
    
    /*
        Empty Vehicle Constructor
    */
    public Vehicle()
    {
    }
    
    public Vehicle(String year, String make, String model, String vin)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.vin = vin;
    }

    public String GetYear() 
    {
        return year;
    }

    public void SetYear(String year) 
    {
        this.year = year;
    }

    public String GetMake() 
    {
        return make;
    }

    public void SetMake(String make) 
    {
        this.make = make;
    }

    public String GetModel() 
    {
        return model;
    }

    public void SetModel(String model) 
    {
        this.model = model;
    }

    public String GetVin() 
    {
        return vin;
    }

    public void SetVin(String vin) 
    {
        this.vin = vin;
    }
}
