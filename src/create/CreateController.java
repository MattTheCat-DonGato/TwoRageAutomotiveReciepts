package create;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import utilities.Invoice;
import utilities.TwoRageError;

/**
 *
 * @author Matthew Rodriguez
 */
public class CreateController
{
    //Set stage ref
    Stage mainStage;
    
    //Scenes
    Scene mainMenuScene;
    
    //Views
    private CreateView createView;
    
    //Models
    CreateModel createModel;
    
    //Data
    int laborSlotCount = 1;
    
    //Constructor
    public CreateController(Stage mainStage, CreateView createView, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.createView = createView;
        this.mainMenuScene = mainMenuScene;
    }
    
    public void attachHandlers()
    {
        // Create A PDF File based on user's input
        GetCreateView().GetCreateForm().getAction1().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                if(laborSlotCount == 1)
                {
                    //Get the Fields, Numerical data will be intialized to 0
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidLabor = true;
                    //Check for any data that is not a number, if found set variable to false for error checking
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }              
                    
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 1 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("###0.00");
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                                            
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                                            
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                                            
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                            total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
                else if (laborSlotCount == 2)
                {
                    //Get the Fields
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String cSlot_2 = createView.GetCreateForm().getcSlot_2TF().getText();
                    String SlotCost2String = createView.GetCreateForm().getcSlot_2LaborCostTF().getText();
                    double cSlotCost_2 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidSlotCost2 = true;
                    boolean isValidLabor = true;
                    
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }
                    try
                    {
                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost2 = false;
                    }
                    
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(isValidSlotCost2)
                                    {
                                        if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 2 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cSlot_2,cSlotCost_2,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("###0.00");
                                        boolean labor1 = false;
                                        boolean labor2 = false;
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_2TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 306);
                                            content.drawString(invoiceData.GetcSlot_2());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            labor1 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_2() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 306);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_2()));
                                            content.endText();
                                            labor2 = true;
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(labor1 && labor2)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                                total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                    }
                                    else
                                    {
                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 2", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                        createView.GetCreateForm().clearSlot2CostTF();
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
                /*************************************************************************************/
                else if (laborSlotCount == 3)
                {
                    //Get the Fields
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String cSlot_2 = createView.GetCreateForm().getcSlot_2TF().getText();
                    String SlotCost2String = createView.GetCreateForm().getcSlot_2LaborCostTF().getText();
                    double cSlotCost_2 = 0;
                    String cSlot_3 = createView.GetCreateForm().getcSlot_3TF().getText();
                    String SlotCost3String = createView.GetCreateForm().getcSlot_3LaborCostTF().getText();
                    double cSlotCost_3 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidSlotCost2 = true;
                    boolean isValidSlotCost3 = true;
                    boolean isValidLabor = true;
                    
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }
                    try
                    {
                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost2 = false;
                    }
                    try
                    {
                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost3 = false;
                    }
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(isValidSlotCost2)
                                    {
                                        if(isValidSlotCost3)
                                        {
                                            if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 3 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cSlot_2,cSlotCost_2,cSlot_3,cSlotCost_3,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("####.00");
                                        boolean labor1 = false;
                                        boolean labor2 = false;
                                        boolean labor3 = false;
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_2TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 306);
                                            content.drawString(invoiceData.GetcSlot_2());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_3TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 284);
                                            content.drawString(invoiceData.GetcSlot_3());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            labor1 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_2() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 306);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_2()));
                                            content.endText();
                                            labor2 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_3() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 284);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_3()));
                                            content.endText();
                                            labor3 = true;
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(labor1 && labor2 && labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3)
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                                total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                        }
                                        else
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 3", "The input entered for Labor Cost 3 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                            createView.GetCreateForm().clearSlot3CostTF();
                                        }
                                    }
                                    else
                                    {
                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 2", "The input entered for Labor Cost 2 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                        createView.GetCreateForm().clearSlot2CostTF();
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
                else if (laborSlotCount == 4)
                {
                    //Get the Fields
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String cSlot_2 = createView.GetCreateForm().getcSlot_2TF().getText();
                    String SlotCost2String = createView.GetCreateForm().getcSlot_2LaborCostTF().getText();
                    double cSlotCost_2 = 0;
                    String cSlot_3 = createView.GetCreateForm().getcSlot_3TF().getText();
                    String SlotCost3String = createView.GetCreateForm().getcSlot_3LaborCostTF().getText();
                    double cSlotCost_3 = 0;
                    String cSlot_4 = createView.GetCreateForm().getcSlot_4TF().getText();
                    String SlotCost4String = createView.GetCreateForm().getcSlot_4LaborCostTF().getText();
                    double cSlotCost_4 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidSlotCost2 = true;
                    boolean isValidSlotCost3 = true;
                    boolean isValidSlotCost4 = true;
                    boolean isValidLabor = true;
                    
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }
                    try
                    {
                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost2 = false;
                    }
                    try
                    {
                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost3 = false;
                    }
                    try
                    {
                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost4 = false;
                    }
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(isValidSlotCost2)
                                    {
                                        if(isValidSlotCost3)
                                        {
                                            if(isValidSlotCost4)
                                            {
                                                if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 4 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cSlot_2,cSlotCost_2,cSlot_3,cSlotCost_3,cSlot_4,cSlotCost_4,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("####.00");
                                        boolean labor1 = false;
                                        boolean labor2 = false;
                                        boolean labor3 = false;
                                        boolean labor4 = false;
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_2TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 306);
                                            content.drawString(invoiceData.GetcSlot_2());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_3TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 284);
                                            content.drawString(invoiceData.GetcSlot_3());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_4TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 262);
                                            content.drawString(invoiceData.GetcSlot_4());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            labor1 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_2() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 306);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_2()));
                                            content.endText();
                                            labor2 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_3() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 284);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_3()));
                                            content.endText();
                                            labor3 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_4() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 262);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_4()));
                                            content.endText();
                                            labor4 = true;
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(labor1 && labor2 && labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4)
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                                total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                            }
                                            else
                                            {
                                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 4", "The input entered for Labor Cost 4 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                createView.GetCreateForm().clearSlot4CostTF();
                                            }
                                        }
                                        else
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 3", "The input entered for Labor Cost 3 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                            createView.GetCreateForm().clearSlot3CostTF();
                                        }
                                    }
                                    else
                                    {
                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 2", "The input entered for Labor Cost 2 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                        createView.GetCreateForm().clearSlot2CostTF();
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
                else if (laborSlotCount == 5)
                {
                    //Get the Fields
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String cSlot_2 = createView.GetCreateForm().getcSlot_2TF().getText();
                    String SlotCost2String = createView.GetCreateForm().getcSlot_2LaborCostTF().getText();
                    double cSlotCost_2 = 0;
                    String cSlot_3 = createView.GetCreateForm().getcSlot_3TF().getText();
                    String SlotCost3String = createView.GetCreateForm().getcSlot_3LaborCostTF().getText();
                    double cSlotCost_3 = 0;
                    String cSlot_4 = createView.GetCreateForm().getcSlot_4TF().getText();
                    String SlotCost4String = createView.GetCreateForm().getcSlot_4LaborCostTF().getText();
                    double cSlotCost_4 = 0;
                    String cSlot_5 = createView.GetCreateForm().getcSlot_5TF().getText();
                    String SlotCost5String = createView.GetCreateForm().getcSlot_5LaborCostTF().getText();
                    double cSlotCost_5 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidSlotCost2 = true;
                    boolean isValidSlotCost3 = true;
                    boolean isValidSlotCost4 = true;
                    boolean isValidSlotCost5 = true;
                    boolean isValidLabor = true;
                    
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }
                    try
                    {
                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost2 = false;
                    }
                    try
                    {
                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost3 = false;
                    }
                    try
                    {
                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost4 = false;
                    }
                    try
                    {
                        cSlotCost_5 = Double.parseDouble(SlotCost5String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost5 = false;
                    }
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(isValidSlotCost2)
                                    {
                                        if(isValidSlotCost3)
                                        {
                                            if(isValidSlotCost4)
                                            {
                                                if(isValidSlotCost5)
                                                {
                                                    if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 5 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                                        cSlotCost_5 = Double.parseDouble(SlotCost5String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cSlot_2,cSlotCost_2,cSlot_3,cSlotCost_3,cSlot_4,cSlotCost_4,cSlot_5,cSlotCost_5,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("###0.00");
                                        boolean labor1 = false;
                                        boolean labor2 = false;
                                        boolean labor3 = false;
                                        boolean labor4 = false;
                                        boolean labor5 = false;
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_2TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 306);
                                            content.drawString(invoiceData.GetcSlot_2());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_3TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 284);
                                            content.drawString(invoiceData.GetcSlot_3());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_4TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 262);
                                            content.drawString(invoiceData.GetcSlot_4());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_5TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 240);
                                            content.drawString(invoiceData.GetcSlot_5());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            labor1 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_2() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 306);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_2()));
                                            content.endText();
                                            labor2 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_3() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 284);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_3()));
                                            content.endText();
                                            labor3 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_4() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 262);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_4()));
                                            content.endText();
                                            labor4 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_5() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 240);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_5()));
                                            content.endText();
                                            labor5 = true;
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(labor1 && labor2 && labor3 && labor4 && labor5) // 1 2 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && labor4 && !labor5) // 1 2 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && labor5) // 1 2 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && labor5) // 1 2 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && labor5) // 1 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && labor5) // 2 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && !labor5) // 1 2 3
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && !labor5) // 1 2 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && labor5) // 1 2 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && !labor5) // 1 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4 && labor5) // 1 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && labor5) // 1 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && !labor5) // 2 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4 && labor5) // 2 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4 && labor5) // 2 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && labor5) // 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && !labor5) // 1 2
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4 && !labor5) // 1 3
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && !labor5) // 1 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && labor5) // 1 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4 && !labor5) // 2 3
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4 && !labor5) // 2 4
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && labor5) // 2 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && !labor5) // 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4 && labor5) // 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && labor5) // 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && !labor5) // 1
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && !labor5) // 2
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4 && !labor5) // 3
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && !labor5) // 4
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && !labor4 && labor5) // 5
                                            {
                                                total = invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                                total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                                }
                                                else
                                                {
                                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 5", "The input entered for Labor Cost 5 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                    createView.GetCreateForm().clearSlot5CostTF();
                                                }
                                            }
                                            else
                                            {
                                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 4", "The input entered for Labor Cost 4 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                createView.GetCreateForm().clearSlot4CostTF();
                                            }
                                        }
                                        else
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 3", "The input entered for Labor Cost 3 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                            createView.GetCreateForm().clearSlot3CostTF();
                                        }
                                    }
                                    else
                                    {
                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 2", "The input entered for Labor Cost 2 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                        createView.GetCreateForm().clearSlot2CostTF();
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
                else
                {
                    //Get the Fields
                    String cName = createView.GetCreateForm().getcNameTF().getText();
                    String cPhone = createView.GetCreateForm().getcPhoneTF().getText();
                    String cAddress = createView.GetCreateForm().getcAddressTF().getText();
                    String cCity = createView.GetCreateForm().getcCityTF().getText();
                    String cState = createView.GetCreateForm().getcStateTF().getText();
                    String cZip = createView.GetCreateForm().getcZipTF().getText();
                    String cDate_Time = createView.GetCreateForm().getcDate_TimeTF().getText();
                    String cOrderNumberString = createView.GetCreateForm().getcOrderNumberTF().getText();
                    int cOrderNumber = 0;
                    String cVehicleYear = createView.GetCreateForm().getcVehicleYearTF().getText();
                    String cVehicleMake = createView.GetCreateForm().getcVehicleMakeTF().getText();
                    String cVehicleModel = createView.GetCreateForm().getcVehicleModelTF().getText();
                    String cSerialVIN = createView.GetCreateForm().getcSerialVINTF().getText();
                    String cLicenseNumber = createView.GetCreateForm().getcLicenseNumberTF().getText();
                    String cOdometerString = createView.GetCreateForm().getcOdometerTF().getText();
                    int cOdometer = 0;
                    String cSlot_1 = createView.GetCreateForm().getcSlot_1TF().getText();
                    String SlotCost1String = createView.GetCreateForm().getcSlot_1LaborCostTF().getText();
                    double cSlotCost_1 = 0;
                    String cSlot_2 = createView.GetCreateForm().getcSlot_2TF().getText();
                    String SlotCost2String = createView.GetCreateForm().getcSlot_2LaborCostTF().getText();
                    double cSlotCost_2 = 0;
                    String cSlot_3 = createView.GetCreateForm().getcSlot_3TF().getText();
                    String SlotCost3String = createView.GetCreateForm().getcSlot_3LaborCostTF().getText();
                    double cSlotCost_3 = 0;
                    String cSlot_4 = createView.GetCreateForm().getcSlot_4TF().getText();
                    String SlotCost4String = createView.GetCreateForm().getcSlot_4LaborCostTF().getText();
                    double cSlotCost_4 = 0;
                    String cSlot_5 = createView.GetCreateForm().getcSlot_5TF().getText();
                    String SlotCost5String = createView.GetCreateForm().getcSlot_5LaborCostTF().getText();
                    double cSlotCost_5 = 0;
                    String cSlot_6 = createView.GetCreateForm().getcSlot_6TF().getText();
                    String SlotCost6String = createView.GetCreateForm().getcSlot_6LaborCostTF().getText();
                    double cSlotCost_6 = 0;
                    String LaborString = createView.GetCreateForm().getcLaborTF().getText();
                    double cLabor = 0;
                    double cTotal = 0;
                    String nameofFile = createView.GetCreateForm().getFileNameTF().getText();
                    // boolean variables for try-catch blocks and branching if statements
                    boolean isValidOrderNumber = true;
                    boolean isValidOdometer = true;
                    boolean isValidSlotCost1 = true;
                    boolean isValidSlotCost2 = true;
                    boolean isValidSlotCost3 = true;
                    boolean isValidSlotCost4 = true;
                    boolean isValidSlotCost5 = true;
                    boolean isValidSlotCost6 = true;
                    boolean isValidLabor = true;
                    
                    try
                    {
                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                    }
                    catch(Exception e)
                    {
                        isValidOrderNumber = false;
                    }
                    try
                    {
                        cOdometer = Integer.parseInt(cOdometerString);
                    }
                    catch(Exception e)
                    {
                        isValidOdometer = false;
                    }
                    try
                    {
                        cLabor = Double.parseDouble(LaborString);
                    }
                    catch(Exception e)
                    {
                        isValidLabor = false;
                    }
                    try
                    {
                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost1 = false;
                    }
                    try
                    {
                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost2 = false;
                    }
                    try
                    {
                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost3 = false;
                    }
                    try
                    {
                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost4 = false;
                    }
                    try
                    {
                        cSlotCost_5 = Double.parseDouble(SlotCost5String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost5 = false;
                    }
                    try
                    {
                        cSlotCost_6 = Double.parseDouble(SlotCost6String);
                    }
                    catch(NumberFormatException | NullPointerException x)
                    {
                        isValidSlotCost6 = false;
                    }
                    // Now we begin our decsent into the depths of programming hell...
                    // Check if the Order Number is valid if so...
                    if(isValidOrderNumber)
                    {
                        // Move to the Odometer next
                        // Check the Odometer is valid if so...
                        if(isValidOdometer)
                        {
                            // Move to the LaborOnly next
                            // Check if the LaborOnly is valid 
                            if(isValidLabor)
                            {
                                // Move to the Slot1Cost next
                                // Check if SlotCost1 is valid if so...
                                if(isValidSlotCost1)
                                {   
                                    if(isValidSlotCost2)
                                    {
                                        if(isValidSlotCost3)
                                        {
                                            if(isValidSlotCost4)
                                            {
                                                if(isValidSlotCost5)
                                                {
                                                    if(isValidSlotCost6)
                                                    {
                                                        if(nameofFile.trim().length() == 0)
                                    {
                                         TwoRageError.ErrorAlert("ERROR", "FileName Empty.", "You cannot leave the file name of the PDF blank. Enter a name for the file.");
                                    }
                                    else
                                    {
                                        //TwoRageError.ErrorAlert("OK", "All Checks Completed For 6 slot Test.", "Now Grabbing Data and Converting to PDF...");
                                        cOrderNumber = Integer.parseInt(cOrderNumberString);
                                        cOdometer = Integer.parseInt(cOdometerString);
                                        cLabor = Double.parseDouble(LaborString);
                                        cSlotCost_1 = Double.parseDouble(SlotCost1String);
                                        cSlotCost_2 = Double.parseDouble(SlotCost2String);
                                        cSlotCost_3 = Double.parseDouble(SlotCost3String);
                                        cSlotCost_4 = Double.parseDouble(SlotCost4String);
                                        cSlotCost_5 = Double.parseDouble(SlotCost5String);
                                        cSlotCost_6 = Double.parseDouble(SlotCost6String);
                                        Invoice invoiceData = new Invoice(cName,cPhone,cAddress,cCity,cState,cZip,cDate_Time,cOrderNumber,cVehicleYear,cVehicleMake,cVehicleModel,cSerialVIN,cLicenseNumber,cOdometer,cSlot_1,cSlotCost_1,cSlot_2,cSlotCost_2,cSlot_3,cSlotCost_3,cSlot_4,cSlotCost_4,cSlot_5,cSlotCost_5,cSlot_6,cSlotCost_6,cLabor,cTotal);
                                        String fileName = nameofFile; // name of the file
                                        String imageName = "cd_checkengine.jpg"; // name of image
                                        Date date = new Date();
                                        DateFormat df = new SimpleDateFormat("MM-dd-yyyy"); // date format from system
                                        double total = 0.0;
                                        DecimalFormat dollar = new DecimalFormat("###0.00");
                                        boolean labor1 = false;
                                        boolean labor2 = false;
                                        boolean labor3 = false;
                                        boolean labor4 = false;
                                        boolean labor5 = false;
                                        boolean labor6 = false;
                                        //If the file name does not end with .pdf then program will add it at the end
                                        if(!fileName.endsWith(".pdf"))
                                        {
                                            fileName = fileName+".pdf"; 
                                        }             
                                        try
                                        {
                                            PDDocument doc = new PDDocument(); // create instance of the pdf doc file
                                            PDPage page = new PDPage();
                                            PDXObjectImage image = new PDJpeg(doc, new FileInputStream(imageName));
                                            doc.addPage(page); // Adding page in pdf doc file
                
                                            PDPageContentStream content = new PDPageContentStream(doc, page); // create stream to write to document
                
                                            content.drawImage(image, 220, 645);
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(230, 620); //set position of text to be written
                                            content.drawString("TwoRage Automotive"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(146, 598); //set position of text to be written
                                            content.drawString("31054 GAMBLE RD SAN BENITO TX 78586"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(254, 576); //set position of text to be written
                                            content.drawString("(956)-241-6886"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(226, 554); //set position of text to be written
                                            content.drawString("godson115@yahoo.com"); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 14);
                                            content.moveTextPositionByAmount(448, 502); //set position of text to be written
                                            content.drawString("Date: " + df.format(date)); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 482); //set position of text to be written
                                            content.drawString("Name: " + invoiceData.GetcName()); // writing text
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 460); //set position of text to be written
                                            content.drawString("Address: " + invoiceData.GetcAddress()); // writing text
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity() + ", " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0 && createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState() + " " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcCityTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcCity()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcStateTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcState()); // writing text
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcZipTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: " + invoiceData.GetcZip()); // writing text
                                            content.endText();
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 438); //set position of text to be written
                                            content.drawString("City, State, Zip: "); // writing text
                                            content.endText();
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 482);
                                            content.drawString("Phone: " + invoiceData.GetcPhone());
                                            content.endText();               
                
                                            content.drawLine(50, 498, 550, 498); // draw top horizontal line at coordinates (xStart,yStart,xEnd,yEnd) of box 1
                                            content.drawLine(50, 498, 50, 432); // draw left vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(550, 498, 550, 432); // draw right vertical line at coordinates (xStart,yStart,xEnd,yEnd)
                                            content.drawLine(50, 476, 550, 476); // draw 2nd horizontal line
                                            content.drawLine(360, 498, 360, 476); // draw vertical line between name and phone section
                                            content.drawLine(50, 454, 550, 454); // draw 3rd horizontal line 
                                            content.drawLine(50, 432, 550, 432); // draw bottom horizontal line of box 1
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 416);
                                            content.drawString("Recieved Date: " + invoiceData.GetcDate_Time());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(342, 416);
                                            content.drawString("Order Number: " + invoiceData.GetcOrderNumber());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleMake());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0 && createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake() + " " + invoiceData.GetcVehicleModel());
                                            content.endText();       
                                            }
                                            else if(createView.GetCreateForm().getcVehicleYearTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleYear());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleMakeTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleMake());
                                            content.endText();   
                                            }
                                            else if(createView.GetCreateForm().getcVehicleModelTF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: " + invoiceData.GetcVehicleModel());
                                            content.endText();    
                                            }
                                            else
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 394);
                                            content.drawString("Year/Make/Model: ");
                                            content.endText();    
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 372);
                                            content.drawString("Serial #/VIN: " + invoiceData.GetcSerialVIN());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 350);
                                            content.drawString("License No.: " + invoiceData.GetcLicenseNumber());
                                            content.endText();
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(302, 350);
                                            content.drawString("Odometer: " + invoiceData.GetcOdometer());
                                            content.endText();
                
                                            if(createView.GetCreateForm().getcSlot_1TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 328);
                                            content.drawString(invoiceData.GetcSlot_1());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_2TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 306);
                                            content.drawString(invoiceData.GetcSlot_2());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_3TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 284);
                                            content.drawString(invoiceData.GetcSlot_3());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_4TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 262);
                                            content.drawString(invoiceData.GetcSlot_4());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_5TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 240);
                                            content.drawString(invoiceData.GetcSlot_5());
                                            content.endText();
                                            }
                                            
                                            if(createView.GetCreateForm().getcSlot_6TF().getText().trim().length() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(52, 218);
                                            content.drawString(invoiceData.GetcSlot_6());
                                            content.endText();
                                            }
                
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_1() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 328);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_1()));
                                            content.endText();
                                            labor1 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_2() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 306);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_2()));
                                            content.endText();
                                            labor2 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_3() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 284);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_3()));
                                            content.endText();
                                            labor3 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_4() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 262);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_4()));
                                            content.endText();
                                            labor4 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_5() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 240);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_5()));
                                            content.endText();
                                            labor5 = true;
                                            }
                                            
                                            //If the value entered was higher than 0, then display it next to the box
                                            if(invoiceData.GetcSlotCost_6() > 0)
                                            {
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(468, 218);
                                            content.drawString("$"+dollar.format(invoiceData.GetcSlotCost_6()));
                                            content.endText();
                                            labor6 = true;
                                            }
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(362, 196);
                                            content.drawString("LABOR ONLY $" + dollar.format(invoiceData.GetcLabor()));
                                            content.endText();
                
                                            if(labor1 && labor2 && labor3 && labor4 && labor5 && labor6) // 1 2 3 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && labor4 && labor5 && !labor6) // 1 2 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && labor4 && !labor5 && labor6) // 1 2 3 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && labor5 && labor6) // 1 2 3 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && labor5 && labor6) // 1 2 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && labor5 && labor6) // 1 3 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && labor5 && labor6) // 2 3 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && labor4 && !labor5 && !labor6) // 1 2 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && labor5 && !labor6) // 1 2 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && !labor5 && labor6) // 1 2 3 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && labor5 && !labor6) // 1 2 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && !labor5 && labor6) // 1 2 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && labor5 && labor6) // 1 2 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && labor5 && !labor6) // 1 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && !labor5 && labor6) // 1 3 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && labor5 && labor6) // 1 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && labor5 && !labor6) // 2 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && !labor5 && labor6) // 2 3 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && labor5 && labor6) // 3 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && labor3 && !labor4 && !labor5 && !labor6) // 1 2 3
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && labor4 && !labor5 && !labor6) // 1 2 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && labor5 && !labor6) // 1 2 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && !labor5 && labor6) // 1 2 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && labor4 && !labor5 && !labor6) // 1 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4 && labor5 && !labor6) // 1 3 5 
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4 && !labor5 && labor6) // 1 3 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && labor5 && !labor6) // 1 4 5 
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && !labor5 && labor6) // 1 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && labor5 && labor6) // 1 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && labor4 && !labor5 && !labor6) // 2 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4 && labor5 && !labor6) // 2 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4 && !labor5 && labor6) // 2 3 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4 && labor5 && !labor6) // 2 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4 && !labor5 && labor6) // 2 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && labor5 && labor6) // 2 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && labor5 && !labor6) // 3 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && !labor5 && labor6) // 3 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && labor5 && labor6) // 4 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && labor2 && !labor3 && !labor4 && !labor5 && !labor6) // 1 2
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && labor3 && !labor4 && !labor5 && !labor6) // 1 3
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && labor4 && !labor5 && !labor6) // 1 4 
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && labor5 && !labor6) // 1 5
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && !labor5 && labor6) // 1 6
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && labor3 && !labor4 && !labor5 && !labor6) // 2 3 
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && labor4 && !labor5 && !labor6) // 2 4
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && labor5 && !labor6) // 2 5
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && !labor5 && labor6) // 2 6
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && labor4 && !labor5 && !labor6) // 3 4
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4 && labor5 && !labor6) // 3 5
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4 && !labor5 && labor6) // 3 6
                                            {
                                                total =  invoiceData.GetcSlotCost_3() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && labor5 && !labor6) // 4 5
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && !labor5 && labor6) // 4 6
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && !labor4 && labor5 && labor6) // 5 6
                                            {
                                                total = invoiceData.GetcSlotCost_5() + invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else if(labor1 && !labor2 && !labor3 && !labor4 && !labor5 && !labor6) // 1
                                            {
                                                total = invoiceData.GetcSlotCost_1() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && labor2 && !labor3 && !labor4 && !labor5 && !labor6) // 2
                                            {
                                                total = invoiceData.GetcSlotCost_2() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && labor3 && !labor4 && !labor5 && !labor6) // 3 
                                            {
                                                total = invoiceData.GetcSlotCost_3() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && labor4 && !labor5 && !labor6) // 4
                                            {
                                                total = invoiceData.GetcSlotCost_4() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && !labor4 && labor5 && !labor6) // 5
                                            {
                                                total = invoiceData.GetcSlotCost_5() + invoiceData.GetcLabor();
                                            }
                                            else if(!labor1 && !labor2 && !labor3 && !labor4 && !labor5 && labor6) // 6
                                            {
                                                total = invoiceData.GetcSlotCost_6() + invoiceData.GetcLabor();
                                            }
                                            else
                                            {
                                                total = invoiceData.GetcLabor();
                                            }
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_BOLD, 16);
                                            content.moveTextPositionByAmount(384, 174);
                                            content.drawString("TOTAL       $"+dollar.format(total));
                                            content.endText();
                
                                            content.drawLine(50, 432, 550, 432); // draw top (1st) horizontal line of box 2
                                            content.drawLine(50, 432, 50, 212); // draw left vertical line of box 2
                                            content.drawLine(550, 432, 550, 168); // draw right vertical line of box 2
                                            content.drawLine(340, 432, 340, 410); // draw line between date/time and order number
                                            content.drawLine(50, 410, 550, 410); // draw 2nd horizontal line   
                                            content.drawLine(50, 388, 550, 388); // draw 3rd horizontal line
                                            content.drawLine(50, 366, 550, 366); // draw 4th horizontal line
                                            content.drawLine(300, 366, 300, 344); // draw line between license no. and odometer
                                            content.drawLine(50, 344, 550, 344); // draw 5th horizontal line
                                            content.drawLine(466, 344, 466, 168); // draw line between quantity and labor info
                                            content.drawLine(50, 322, 550, 322); // draw 6th horizontal line
                                            content.drawLine(50, 300, 550, 300); // draw 7th horizontal line
                                            content.drawLine(50, 278, 550, 278); // draw 8th horizontal line
                                            content.drawLine(50, 256, 550, 256); // draw 9th horizontal line
                                            content.drawLine(50, 234, 550, 234); // draw 10th horizontal line
                                            content.drawLine(50, 212, 550, 212); // draw 11th horizontal line
                                            content.drawLine(360, 212, 360, 168); // draw vertical line for labor and total cost
                                            content.drawLine(360, 190, 550, 190); // draw 12th horizontal line
                                            content.drawLine(360, 168, 550, 168); // draw 13th horizontal line
                
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(336, 90);
                                            content.drawString("Signed");
                                            content.endText();

                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 16);
                                            content.moveTextPositionByAmount(350, 50);
                                            content.drawString("Date");
                                            content.endText();

                                            content.drawLine(380, 90, 550, 90); // draw line for signed
                                            content.drawLine(380, 50, 550, 50); // draw line for date

                                            /*    
                                            content.beginText();
                                            content.setFont(PDType1Font.TIMES_ROMAN, 12);
                                            content.moveTextPositionByAmount(350, 5);
                                            content.drawString("Invoice written and created by: Matthew Rodriguez");
                                            content.endText();
                                            */

                                            content.close();
                                            doc.save(fileName); //Saving PDF file with name parameter
                                            doc.close(); // cleaning memory
                                            TwoRageError.ErrorAlert("INFORMATION", "PDF Document Created", "Your file was created in : " + System.getProperty("user.dir") + ". You may view it from there."); // Display Message where file is located
                                            createView.GetCreateForm().ClearAllTextFields();
                                        }
                                        catch(Exception e)
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "PDF File Opened", e.getMessage() + ". Please close the file first before trying to overwrite it."); // Display Message
                                            System.out.println(e.getMessage());
                                        }
                                        
                                    }
                                                    }
                                                    else
                                                    {
                                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 6", "The input entered for Labor Cost 6 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                        createView.GetCreateForm().clearSlot6CostTF();
                                                    }
                                                }
                                                else
                                                {
                                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 5", "The input entered for Labor Cost 5 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                    createView.GetCreateForm().clearSlot5CostTF();
                                                }
                                            }
                                            else
                                            {
                                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 4", "The input entered for Labor Cost 4 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                                createView.GetCreateForm().clearSlot4CostTF();
                                            }
                                        }
                                        else
                                        {
                                            TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 3", "The input entered for Labor Cost 3 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                            createView.GetCreateForm().clearSlot3CostTF();
                                        }
                                    }
                                    else
                                    {
                                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 2", "The input entered for Labor Cost 2 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                        createView.GetCreateForm().clearSlot2CostTF();
                                    }
                                }
                                // If not...
                                else
                                {
                                    TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Cost 1", "The input entered for Labor Cost 1 is not valid. You may either enter a real number or 0. You may include decimals if desired. If 0 is entered, it will not be displayed within the PDF File for this box.");
                                     createView.GetCreateForm().clearSlot1CostTF();
                                }
                            }
                            // If not...
                            else
                            {
                                TwoRageError.ErrorAlert("ERROR", "Invalid Input For Labor Only", "You must enter a number for the Labor Only Slot. It cannot be left blank. You may include decimals if desired. Re-Enter the number again.");
                                createView.GetCreateForm().clearLaborTF();
                            }
                        }
                        // If not...
                        else
                        {
                             TwoRageError.ErrorAlert("ERROR", "Invalid Input For Odometer", "You must enter a valid integer number for the Odometer. It cannot be left blank. Re-Enter the number again.");
                              createView.GetCreateForm().clearOdometerTF();
                        }
                    }
                    //If not...
                    else
                    {
                        TwoRageError.ErrorAlert("ERROR", "Invalid Input For Order Number", "You must enter a valid integer number for the Order Number. It cannot be left blank. Re-Enter the number again.");
                         createView.GetCreateForm().clearOrderNumberTF();
                    }
                }
            }
        });
        
        //Add new Labor Slot Button, update counter, display appropriate GUI
        GetCreateView().GetCreateForm().getAction2().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                // Check the current slot count
                if(laborSlotCount == 6)
                {
                    //System will not allow more than six fields, throw error
                    TwoRageError.ErrorAlert("ERROR", "Cannot Add Service Slot", "You cannot have more than six slots within this form."); // Display Message that user cannot go beyond more than 6 slot
                }
                else
                {
                    //Increment Counter
                    laborSlotCount++;
                    //Some code to modify GUI stuff here...
                    if(laborSlotCount == 6)
                    {
                        createView.GetCreateForm().CreateFormSlotCount6();
                    }
                    else if (laborSlotCount == 5)
                    {
                        createView.GetCreateForm().CreateFormSlotCount5();
                    }
                    else if (laborSlotCount == 4)
                    {
                        createView.GetCreateForm().CreateFormSlotCount4();
                    }
                    else if (laborSlotCount == 3)
                    {
                        createView.GetCreateForm().CreateFormSlotCount3();
                    }
                    else
                    {
                        createView.GetCreateForm().CreateFormSlotCount2();
                    }
                }
              
            }          
        });
        
        //Remove previous Labor Slot Button, update counter, clear Slot Removed TextFields, display appropriate GUI
        GetCreateView().GetCreateForm().getAction3().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
              if(laborSlotCount == 1)
                {
                    TwoRageError.ErrorAlert("ERROR", "Cannot Remove Service Slot", "You need at least one service slot within this form."); // Display Message that user cannot go beyond less than 1 slot
                }
              else
              {
                  laborSlotCount--;
                  if(laborSlotCount == 1)
                  {
                      createView.GetCreateForm().CreateFormSlotCount1();
                      createView.GetCreateForm().clearSlot2TF();
                      createView.GetCreateForm().clearSlot2CostTF();
                  }
                  else if(laborSlotCount == 2)
                  {
                      createView.GetCreateForm().CreateFormSlotCount2();
                      createView.GetCreateForm().clearSlot3TF();
                      createView.GetCreateForm().clearSlot3CostTF();
                  }
                  else if(laborSlotCount == 3)
                  {
                       createView.GetCreateForm().CreateFormSlotCount3();
                       createView.GetCreateForm().clearSlot4TF();
                       createView.GetCreateForm().clearSlot4CostTF();
                  }
                  else if(laborSlotCount == 4)
                  {
                       createView.GetCreateForm().CreateFormSlotCount4();
                       createView.GetCreateForm().clearSlot5TF();
                       createView.GetCreateForm().clearSlot5CostTF();
                  }
                  else
                  {
                      createView.GetCreateForm().CreateFormSlotCount5();
                      createView.GetCreateForm().clearSlot6TF();
                      createView.GetCreateForm().clearSlot6CostTF();
                  }
              }
            }          
        });
        
        GetCreateView().GetCreateForm().getAction4().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
               createView.GetCreateForm().ClearAllTextFields();
               mainStage.setScene(mainMenuScene);
            }          
        });
    }

    /**
     * @return the createView
     */
    public CreateView GetCreateView()
    {
        return createView;
    }

    /**
     * @param createView the createView to set
     */
    public void SetCreateView(CreateView createView)
    {
        this.createView = createView;
    } 
}