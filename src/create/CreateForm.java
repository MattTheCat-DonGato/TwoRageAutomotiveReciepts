package create;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

/**
 *
 * @author Matthew Rodriguez
 */
public class CreateForm extends GridPane
{
    //Labels
    private Label cNameLabel = new Label("Customer Name");
    private Label cPhoneLabel = new Label("Customer Phone Number");
    private Label cAddressLabel = new Label("Customer Address");
    private Label cCityLabel = new Label("City");
    private Label cStateLabel = new Label("State");
    private Label cZipLabel = new Label("Zip Code");
    private Label cDate_TimeLabel = new Label("Date Vehicle was Recieved");
    private Label cOrderNumberLabel = new Label("Order Number");
    private Label cVehicleYearLabel = new Label("Vehicle Year");
    private Label cVehicleMakeLabel = new Label("Vehicle Make");
    private Label cVehicleModelLabel = new Label("Vehicle Model");
    private Label cSerialVINLabel = new Label("VIN Number");
    private Label cLicenseNumberLabel = new Label("License Plate Number");
    private Label cOdometerLabel = new Label("Odometer Value of Vehicle");
    private Label cSlot_1Label = new Label("Enter Service 1 Applied to Vehicle");
    private Label cSlot_1LaborCost = new Label ("Enter Service 1 Cost (Enter 0 if none)");
    private Label cSlot_2Label = new Label("Enter Service 2 Applied to Vehicle");
    private Label cSlot_2LaborCost = new Label ("Enter Service 2 Cost (Enter 0 if none)");
    private Label cSlot_3Label = new Label("Enter Service 3 Applied to Vehicle");
    private Label cSlot_3LaborCost = new Label ("Enter Service 3 Cost (Enter 0 if none)");
    private Label cSlot_4Label = new Label("Enter Service 4 Applied to Vehicle");
    private Label cSlot_4LaborCost = new Label ("Enter Service 4 Cost (Enter 0 if none)");
    private Label cSlot_5Label = new Label("Enter Service 5 Applied to Vehicle");
    private Label cSlot_5LaborCost = new Label ("Enter Service 5 Cost (Enter 0 if none)");
    private Label cSlot_6Label = new Label("Enter Service 6 Applied to Vehicle");
    private Label cSlot_6LaborCost = new Label ("Enter Service 6 Cost (Enter 0 if none)");
    private Label cLaborLabel = new Label("Input Labor Only Cost");
    private Label FileNameLabel = new Label("Input Name of PDF File");
    
    //TextFields
    private TextField cNameTF = new TextField();
    private TextField cPhoneTF = new TextField();
    private TextField cAddressTF = new TextField();
    private TextField cCityTF = new TextField();
    private TextField cStateTF = new TextField();
    private TextField cZipTF = new TextField();
    private TextField cDate_TimeTF = new TextField();
    private TextField cOrderNumberTF = new TextField();
    private TextField cVehicleYearTF = new TextField();
    private TextField cVehicleMakeTF = new TextField();
    private TextField cVehicleModelTF = new TextField();
    private TextField cSerialVINTF = new TextField();
    private TextField cLicenseNumberTF = new TextField();
    private TextField cOdometerTF = new TextField();
    private TextField cSlot_1TF = new TextField();
    private TextField cSlot_1LaborCostTF = new TextField();
    private TextField cSlot_2TF= new TextField();
    private TextField cSlot_2LaborCostTF = new TextField();
    private TextField cSlot_3TF = new TextField();
    private TextField cSlot_3LaborCostTF = new TextField();
    private TextField cSlot_4TF = new TextField();
    private TextField cSlot_4LaborCostTF = new TextField();
    private TextField cSlot_5TF = new TextField();
    private TextField cSlot_5LaborCostTF = new TextField();
    private TextField cSlot_6TF = new TextField();
    private TextField cSlot_6LaborCostTF = new TextField();
    private TextField cLaborTF = new TextField();
    private TextField FileNameTF = new TextField();
    
    //Buttons
    private Button action1 = new Button("Save Invoice");
    private Button action2 = new Button ("Add Service Slot");
    private Button action3 = new Button ("Remove Service Slot");
    private Button action4 = new Button("Return to Main Menu");
    
    //TextArea
    TextArea invoiceInfo = new TextArea();
    
    /*
        Starting GUI Form
    */
    public CreateForm()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
    /*
        Set this form when laborSlotCount = 1
    */
    public void CreateFormSlotCount1()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }

    /*
        Set this form when laborSlotCount = 2
    */
    public void CreateFormSlotCount2()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cSlot_2Label,cSlot_2TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,cSlot_2LaborCost,cSlot_2LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
    /*
        Set this form when laborSlotCount = 3
    */
    public void CreateFormSlotCount3()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cSlot_2Label,cSlot_2TF,cSlot_3Label,cSlot_3TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,cSlot_2LaborCost,cSlot_2LaborCostTF,cSlot_3LaborCost,cSlot_3LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
    /*
        Set this form when laborSlotCount = 4
    */
    public void CreateFormSlotCount4()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cSlot_2Label,cSlot_2TF,cSlot_3Label,cSlot_3TF,cSlot_4Label,cSlot_4TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,cSlot_2LaborCost,cSlot_2LaborCostTF,cSlot_3LaborCost,cSlot_3LaborCostTF,cSlot_4LaborCost,cSlot_4LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
    /*
        Set this form when laborSlotCount = 5
    */
    public void CreateFormSlotCount5()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cSlot_2Label,cSlot_2TF,cSlot_3Label,cSlot_3TF,cSlot_4Label,cSlot_4TF,cSlot_5Label,cSlot_5TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,cSlot_2LaborCost,cSlot_2LaborCostTF,cSlot_3LaborCost,cSlot_3LaborCostTF,cSlot_4LaborCost,cSlot_4LaborCostTF,cSlot_5LaborCost,cSlot_5LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
     /*
        Set this form when laborSlotCount = 6
    */
    public void CreateFormSlotCount6()
    {
        VBox labelAndTextBox1 = new VBox(5);
        VBox labelAndTextBox2 = new VBox(5);
        VBox labelAndTextBox3 = new VBox(5);
        VBox labelAndTextBox4 = new VBox(5);
        labelAndTextBox1.getChildren().addAll(cNameLabel,cNameTF,cPhoneLabel,cPhoneTF,cAddressLabel,cAddressTF,cCityLabel,cCityTF,cStateLabel,cStateTF,cZipLabel,cZipTF,cDate_TimeLabel,cDate_TimeTF);
        labelAndTextBox2.getChildren().addAll(cOrderNumberLabel,cOrderNumberTF,cVehicleYearLabel,cVehicleYearTF,cVehicleMakeLabel,cVehicleMakeTF,cVehicleModelLabel,cVehicleModelTF,cSerialVINLabel,cSerialVINTF,cLicenseNumberLabel,cLicenseNumberTF,cOdometerLabel,cOdometerTF);
        labelAndTextBox3.getChildren().addAll(cSlot_1Label,cSlot_1TF,cSlot_2Label,cSlot_2TF,cSlot_3Label,cSlot_3TF,cSlot_4Label,cSlot_4TF,cSlot_5Label,cSlot_5TF,cSlot_6Label,cSlot_6TF,cLaborLabel,cLaborTF);
        labelAndTextBox4.getChildren().addAll(cSlot_1LaborCost,cSlot_1LaborCostTF,cSlot_2LaborCost,cSlot_2LaborCostTF,cSlot_3LaborCost,cSlot_3LaborCostTF,cSlot_4LaborCost,cSlot_4LaborCostTF,cSlot_5LaborCost,cSlot_5LaborCostTF,cSlot_6LaborCost,cSlot_6LaborCostTF,FileNameLabel,FileNameTF);
        VBox buttonBox = new VBox(20);
        buttonBox.getChildren().addAll(action1,action2,action3,action4);
        //add everything
        this.getChildren().clear();
        this.setVgap(15);
        this.setHgap(30);
        this.addRow(0,labelAndTextBox1,labelAndTextBox2,labelAndTextBox3,labelAndTextBox4,buttonBox);
        this.setAlignment(Pos.CENTER);
    }
    
    //Properties    

    /**
     * @return the cNameLabel
     */
    public Label getcNameLabel()
    {
        return cNameLabel;
    }

    /**
     * @param cNameLabel the cNameLabel to set
     */
    public void setcNameLabel(Label cNameLabel)
    {
        this.cNameLabel = cNameLabel;
    }

    /**
     * @return the cPhoneLabel
     */
    public Label getcPhoneLabel()
    {
        return cPhoneLabel;
    }

    /**
     * @param cPhoneLabel the cPhoneLabel to set
     */
    public void setcPhoneLabel(Label cPhoneLabel)
    {
        this.cPhoneLabel = cPhoneLabel;
    }

    /**
     * @return the cAddressLabel
     */
    public Label getcAddressLabel()
    {
        return cAddressLabel;
    }

    /**
     * @param cAddressLabel the cAddressLabel to set
     */
    public void setcAddressLabel(Label cAddressLabel)
    {
        this.cAddressLabel = cAddressLabel;
    }

    /**
     * @return the cCityLabel
     */
    public Label getcCityLabel()
    {
        return cCityLabel;
    }

    /**
     * @param cCityLabel the cCityLabel to set
     */
    public void setcCityLabel(Label cCityLabel)
    {
        this.cCityLabel = cCityLabel;
    }

    /**
     * @return the cStateLabel
     */
    public Label getcStateLabel()
    {
        return cStateLabel;
    }

    /**
     * @param cStateLabel the cStateLabel to set
     */
    public void setcStateLabel(Label cStateLabel)
    {
        this.cStateLabel = cStateLabel;
    }

    /**
     * @return the cZipLabel
     */
    public Label getcZipLabel()
    {
        return cZipLabel;
    }

    /**
     * @param cZipLabel the cZipLabel to set
     */
    public void setcZipLabel(Label cZipLabel)
    {
        this.cZipLabel = cZipLabel;
    }

    /**
     * @return the cDate_TimeLabel
     */
    public Label getcDate_TimeLabel()
    {
        return cDate_TimeLabel;
    }

    /**
     * @param cDate_TimeLabel the cDate_TimeLabel to set
     */
    public void setcDate_TimeLabel(Label cDate_TimeLabel)
    {
        this.cDate_TimeLabel = cDate_TimeLabel;
    }

    /**
     * @return the cOrderNumberLabel
     */
    public Label getcOrderNumberLabel()
    {
        return cOrderNumberLabel;
    }

    /**
     * @param cOrderNumberLabel the cOrderNumberLabel to set
     */
    public void setcOrderNumberLabel(Label cOrderNumberLabel)
    {
        this.cOrderNumberLabel = cOrderNumberLabel;
    }

    /**
     * @return the cVehicleYearLabel
     */
    public Label getcVehicleYearLabel()
    {
        return cVehicleYearLabel;
    }

    /**
     * @param cVehicleYearLabel the cVehicleYearLabel to set
     */
    public void setcVehicleYearLabel(Label cVehicleYearLabel)
    {
        this.cVehicleYearLabel = cVehicleYearLabel;
    }

    /**
     * @return the cVehicleMakeLabel
     */
    public Label getcVehicleMakeLabel()
    {
        return cVehicleMakeLabel;
    }

    /**
     * @param cVehicleMakeLabel the cVehicleMakeLabel to set
     */
    public void setcVehicleMakeLabel(Label cVehicleMakeLabel)
    {
        this.cVehicleMakeLabel = cVehicleMakeLabel;
    }

    /**
     * @return the cVehicleModelLabel
     */
    public Label getcVehicleModelLabel()
    {
        return cVehicleModelLabel;
    }

    /**
     * @param cVehicleModelLabel the cVehicleModelLabel to set
     */
    public void setcVehicleModelLabel(Label cVehicleModelLabel)
    {
        this.cVehicleModelLabel = cVehicleModelLabel;
    }

    /**
     * @return the cSerialVINLabel
     */
    public Label getcSerialVINLabel()
    {
        return cSerialVINLabel;
    }

    /**
     * @param cSerialVINLabel the cSerialVINLabel to set
     */
    public void setcSerialVINLabel(Label cSerialVINLabel)
    {
        this.cSerialVINLabel = cSerialVINLabel;
    }

    /**
     * @return the cLicenseNumberLabel
     */
    public Label getcLicenseNumberLabel()
    {
        return cLicenseNumberLabel;
    }

    /**
     * @param cLicenseNumberLabel the cLicenseNumberLabel to set
     */
    public void setcLicenseNumberLabel(Label cLicenseNumberLabel)
    {
        this.cLicenseNumberLabel = cLicenseNumberLabel;
    }

    /**
     * @return the cOdometerLabel
     */
    public Label getcOdometerLabel()
    {
        return cOdometerLabel;
    }

    /**
     * @param cOdometerLabel the cOdometerLabel to set
     */
    public void setcOdometerLabel(Label cOdometerLabel)
    {
        this.cOdometerLabel = cOdometerLabel;
    }

    /**
     * @return the cSlot_1Label
     */
    public Label getcSlot_1Label()
    {
        return cSlot_1Label;
    }

    /**
     * @param cSlot_1Label the cSlot_1Label to set
     */
    public void setcSlot_1Label(Label cSlot_1Label)
    {
        this.cSlot_1Label = cSlot_1Label;
    }

    /**
     * @return the cSlot_2Label
     */
    public Label getcSlot_2Label()
    {
        return cSlot_2Label;
    }

    /**
     * @param cSlot_2Label the cSlot_2Label to set
     */
    public void setcSlot_2Label(Label cSlot_2Label)
    {
        this.cSlot_2Label = cSlot_2Label;
    }

    /**
     * @return the cSlot_3Label
     */
    public Label getcSlot_3Label()
    {
        return cSlot_3Label;
    }

    /**
     * @param cSlot_3Label the cSlot_3Label to set
     */
    public void setcSlot_3Label(Label cSlot_3Label)
    {
        this.cSlot_3Label = cSlot_3Label;
    }

    /**
     * @return the cSlot_4Label
     */
    public Label getcSlot_4Label()
    {
        return cSlot_4Label;
    }

    /**
     * @param cSlot_4Label the cSlot_4Label to set
     */
    public void setcSlot_4Label(Label cSlot_4Label)
    {
        this.cSlot_4Label = cSlot_4Label;
    }

    /**
     * @return the cSlot_5Label
     */
    public Label getcSlot_5Label()
    {
        return cSlot_5Label;
    }

    /**
     * @param cSlot_5Label the cSlot_5Label to set
     */
    public void setcSlot_5Label(Label cSlot_5Label)
    {
        this.cSlot_5Label = cSlot_5Label;
    }

    /**
     * @return the cSlot_6Label
     */
    public Label getcSlot_6Label()
    {
        return cSlot_6Label;
    }

    /**
     * @param cSlot_6Label the cSlot_6Label to set
     */
    public void setcSlot_6Label(Label cSlot_6Label)
    {
        this.cSlot_6Label = cSlot_6Label;
    }

    /**
     * @return the cLaborLabel
     */
    public Label getcLaborLabel()
    {
        return cLaborLabel;
    }

    /**
     * @param cLaborLabel the cLaborLabel to set
     */
    public void setcLaborLabel(Label cLaborLabel)
    {
        this.cLaborLabel = cLaborLabel;
    }

    /**
     * @return the FileNameLabel
     */
    public Label getFileNameLabel()
    {
        return FileNameLabel;
    }

    /**
     * @param FileNameLabel the FileNameLabel to set
     */
    public void setFileNameLabel(Label FileNameLabel)
    {
        this.FileNameLabel = FileNameLabel;
    }

    /**
     * @return the cNameTF
     */
    public TextField getcNameTF()
    {
        return cNameTF;
    }

    /**
     * @param cNameTF the cNameTF to set
     */
    public void setcNameTF(TextField cNameTF)
    {
        this.cNameTF = cNameTF;
    }

    /**
     * @return the cPhoneTF
     */
    public TextField getcPhoneTF()
    {
        return cPhoneTF;
    }

    /**
     * @param cPhoneTF the cPhoneTF to set
     */
    public void setcPhoneTF(TextField cPhoneTF)
    {
        this.cPhoneTF = cPhoneTF;
    }

    /**
     * @return the cAddressTF
     */
    public TextField getcAddressTF()
    {
        return cAddressTF;
    }

    /**
     * @param cAddressTF the cAddressTF to set
     */
    public void setcAddressTF(TextField cAddressTF)
    {
        this.cAddressTF = cAddressTF;
    }

    /**
     * @return the cCityTF
     */
    public TextField getcCityTF()
    {
        return cCityTF;
    }

    /**
     * @param cCityTF the cCityTF to set
     */
    public void setcCityTF(TextField cCityTF)
    {
        this.cCityTF = cCityTF;
    }

    /**
     * @return the cStateTF
     */
    public TextField getcStateTF()
    {
        return cStateTF;
    }

    /**
     * @param cStateTF the cStateTF to set
     */
    public void setcStateTF(TextField cStateTF)
    {
        this.cStateTF = cStateTF;
    }

    /**
     * @return the cZipTF
     */
    public TextField getcZipTF()
    {
        return cZipTF;
    }

    /**
     * @param cZipTF the cZipTF to set
     */
    public void setcZipTF(TextField cZipTF)
    {
        this.cZipTF = cZipTF;
    }

    /**
     * @return the cDate_TimeTF
     */
    public TextField getcDate_TimeTF()
    {
        return cDate_TimeTF;
    }

    /**
     * @param cDate_TimeTF the cDate_TimeTF to set
     */
    public void setcDate_TimeTF(TextField cDate_TimeTF)
    {
        this.cDate_TimeTF = cDate_TimeTF;
    }

    /**
     * @return the cOrderNumberTF
     */
    public TextField getcOrderNumberTF()
    {
        return cOrderNumberTF;
    }

    /**
     * @param cOrderNumberTF the cOrderNumberTF to set
     */
    public void setcOrderNumberTF(TextField cOrderNumberTF)
    {
        this.cOrderNumberTF = cOrderNumberTF;
    }

    /**
     * @return the cVehicleYearTF
     */
    public TextField getcVehicleYearTF()
    {
        return cVehicleYearTF;
    }

    /**
     * @param cVehicleYearTF the cVehicleYearTF to set
     */
    public void setcVehicleYearTF(TextField cVehicleYearTF)
    {
        this.cVehicleYearTF = cVehicleYearTF;
    }

    /**
     * @return the cVehicleMakeTF
     */
    public TextField getcVehicleMakeTF()
    {
        return cVehicleMakeTF;
    }

    /**
     * @param cVehicleMakeTF the cVehicleMakeTF to set
     */
    public void setcVehicleMakeTF(TextField cVehicleMakeTF)
    {
        this.cVehicleMakeTF = cVehicleMakeTF;
    }

    /**
     * @return the cVehicleModelTF
     */
    public TextField getcVehicleModelTF()
    {
        return cVehicleModelTF;
    }

    /**
     * @param cVehicleModelTF the cVehicleModelTF to set
     */
    public void setcVehicleModelTF(TextField cVehicleModelTF)
    {
        this.cVehicleModelTF = cVehicleModelTF;
    }

    /**
     * @return the cSerialVINTF
     */
    public TextField getcSerialVINTF()
    {
        return cSerialVINTF;
    }

    /**
     * @param cSerialVINTF the cSerialVINTF to set
     */
    public void setcSerialVINTF(TextField cSerialVINTF)
    {
        this.cSerialVINTF = cSerialVINTF;
    }

    /**
     * @return the cLicenseNumberTF
     */
    public TextField getcLicenseNumberTF()
    {
        return cLicenseNumberTF;
    }

    /**
     * @param cLicenseNumberTF the cLicenseNumberTF to set
     */
    public void setcLicenseNumberTF(TextField cLicenseNumberTF)
    {
        this.cLicenseNumberTF = cLicenseNumberTF;
    }

    /**
     * @return the cOdometerTF
     */
    public TextField getcOdometerTF()
    {
        return cOdometerTF;
    }

    /**
     * @param cOdometerTF the cOdometerTF to set
     */
    public void setcOdometerTF(TextField cOdometerTF)
    {
        this.cOdometerTF = cOdometerTF;
    }

    /**
     * @return the cSlot_1TF
     */
    public TextField getcSlot_1TF()
    {
        return cSlot_1TF;
    }

    /**
     * @param cSlot_1TF the cSlot_1TF to set
     */
    public void setcSlot_1TF(TextField cSlot_1TF)
    {
        this.cSlot_1TF = cSlot_1TF;
    }

    /**
     * @return the cSlot_2TF
     */
    public TextField getcSlot_2TF()
    {
        return cSlot_2TF;
    }

    /**
     * @param cSlot_2TF the cSlot_2TF to set
     */
    public void setcSlot_2TF(TextField cSlot_2TF)
    {
        this.cSlot_2TF = cSlot_2TF;
    }

    /**
     * @return the cSlot_3TF
     */
    public TextField getcSlot_3TF()
    {
        return cSlot_3TF;
    }

    /**
     * @param cSlot_3TF the cSlot_3TF to set
     */
    public void setcSlot_3TF(TextField cSlot_3TF)
    {
        this.cSlot_3TF = cSlot_3TF;
    }

    /**
     * @return the cSlot_4TF
     */
    public TextField getcSlot_4TF()
    {
        return cSlot_4TF;
    }

    /**
     * @param cSlot_4TF the cSlot_4TF to set
     */
    public void setcSlot_4TF(TextField cSlot_4TF)
    {
        this.cSlot_4TF = cSlot_4TF;
    }

    /**
     * @return the cSlot_5TF
     */
    public TextField getcSlot_5TF()
    {
        return cSlot_5TF;
    }

    /**
     * @param cSlot_5TF the cSlot_5TF to set
     */
    public void setcSlot_5TF(TextField cSlot_5TF)
    {
        this.cSlot_5TF = cSlot_5TF;
    }

    /**
     * @return the cSlot_6TF
     */
    public TextField getcSlot_6TF()
    {
        return cSlot_6TF;
    }

    /**
     * @param cSlot_6TF the cSlot_6TF to set
     */
    public void setcSlot_6TF(TextField cSlot_6TF)
    {
        this.cSlot_6TF = cSlot_6TF;
    }

    /**
     * @return the cLaborTF
     */
    public TextField getcLaborTF()
    {
        return cLaborTF;
    }

    /**
     * @param cLaborTF the cLaborTF to set
     */
    public void setcLaborTF(TextField cLaborTF)
    {
        this.cLaborTF = cLaborTF;
    }

    /**
     * @return the FileNameTF
     */
    public TextField getFileNameTF()
    {
        return FileNameTF;
    }

    /**
     * @param FileNameTF the FileNameTF to set
     */
    public void setFileNameTF(TextField FileNameTF)
    {
        this.FileNameTF = FileNameTF;
    }

    /**
     * @return the action1
     */
    public Button getAction1()
    {
        return action1;
    }

    /**
     * @param action1 the action1 to set
     */
    public void setAction1(Button action1)
    {
        this.action1 = action1;
    }

    /**
     * @return the action2
     */
    public Button getAction2()
    {
        return action2;
    }

    /**
     * @param action2 the action2 to set
     */
    public void setAction2(Button action2)
    {
        this.action2 = action2;
    }
 
    /**
     * @return the action3
     */
    public Button getAction3()
    {
        return action3;
    }

    /**
     * @param action3 the action3 to set
     */
    public void setAction3(Button action3)
    {
        this.action3 = action3;
    }

    /**
     * @return the action4
     */
    public Button getAction4()
    {
        return action4;
    }

    /**
     * @param action4 the action4 to set
     */
    public void setAction4(Button action4)
    {
        this.action4 = action4;
    }
    
    /**
     * @return the cSlot_1LaborCost
     */
    public Label getcSlot_1LaborCost()
    {
        return cSlot_1LaborCost;
    }

    /**
     * @param cSlot_1LaborCost the cSlot_1LaborCost to set
     */
    public void setcSlot_1LaborCost(Label cSlot_1LaborCost)
    {
        this.cSlot_1LaborCost = cSlot_1LaborCost;
    }

    /**
     * @return the cSlot_1LaborCostTF
     */
    public TextField getcSlot_1LaborCostTF()
    {
        return cSlot_1LaborCostTF;
    }

    /**
     * @param cSlot_1LaborCostTF the cSlot_1LaborCostTF to set
     */
    public void setcSlot_1LaborCostTF(TextField cSlot_1LaborCostTF)
    {
        this.cSlot_1LaborCostTF = cSlot_1LaborCostTF;
    }

    /**
     * @return the cSlot_2LaborCostTF
     */
    public TextField getcSlot_2LaborCostTF()
    {
        return cSlot_2LaborCostTF;
    }

    /**
     * @param cSlot_2LaborCostTF the cSlot_2LaborCostTF to set
     */
    public void setcSlot_2LaborCostTF(TextField cSlot_2LaborCostTF)
    {
        this.cSlot_2LaborCostTF = cSlot_2LaborCostTF;
    }

    /**
     * @return the cSlot_3LaborCostTF
     */
    public TextField getcSlot_3LaborCostTF()
    {
        return cSlot_3LaborCostTF;
    }

    /**
     * @param cSlot_3LaborCostTF the cSlot_3LaborCostTF to set
     */
    public void setcSlot_3LaborCostTF(TextField cSlot_3LaborCostTF)
    {
        this.cSlot_3LaborCostTF = cSlot_3LaborCostTF;
    }

    /**
     * @return the cSlot_4LaborCostTF
     */
    public TextField getcSlot_4LaborCostTF()
    {
        return cSlot_4LaborCostTF;
    }

    /**
     * @param cSlot_4LaborCostTF the cSlot_4LaborCostTF to set
     */
    public void setcSlot_4LaborCostTF(TextField cSlot_4LaborCostTF)
    {
        this.cSlot_4LaborCostTF = cSlot_4LaborCostTF;
    }

    /**
     * @return the cSlot_5LaborCostTF
     */
    public TextField getcSlot_5LaborCostTF()
    {
        return cSlot_5LaborCostTF;
    }

    /**
     * @param cSlot_5LaborCostTF the cSlot_5LaborCostTF to set
     */
    public void setcSlot_5LaborCostTF(TextField cSlot_5LaborCostTF)
    {
        this.cSlot_5LaborCostTF = cSlot_5LaborCostTF;
    }

    /**
     * @return the cSlot_6LaborCostTF
     */
    public TextField getcSlot_6LaborCostTF()
    {
        return cSlot_6LaborCostTF;
    }

    /**
     * @param cSlot_6LaborCostTF the cSlot_6LaborCostTF to set
     */
    public void setcSlot_6LaborCostTF(TextField cSlot_6LaborCostTF)
    {
        this.cSlot_6LaborCostTF = cSlot_6LaborCostTF;
    }

    /**
     * @return the cSlot_2LaborCost
     */
    public Label getcSlot_2LaborCost()
    {
        return cSlot_2LaborCost;
    }

    /**
     * @param cSlot_2LaborCost the cSlot_2LaborCost to set
     */
    public void setcSlot_2LaborCost(Label cSlot_2LaborCost)
    {
        this.cSlot_2LaborCost = cSlot_2LaborCost;
    }

    /**
     * @return the cSlot_3LaborCost
     */
    public Label getcSlot_3LaborCost()
    {
        return cSlot_3LaborCost;
    }

    /**
     * @param cSlot_3LaborCost the cSlot_3LaborCost to set
     */
    public void setcSlot_3LaborCost(Label cSlot_3LaborCost)
    {
        this.cSlot_3LaborCost = cSlot_3LaborCost;
    }

    /**
     * @return the cSlot_4LaborCost
     */
    public Label getcSlot_4LaborCost()
    {
        return cSlot_4LaborCost;
    }

    /**
     * @param cSlot_4LaborCost the cSlot_4LaborCost to set
     */
    public void setcSlot_4LaborCost(Label cSlot_4LaborCost)
    {
        this.cSlot_4LaborCost = cSlot_4LaborCost;
    }

    /**
     * @return the cSlot_5LaborCost
     */
    public Label getcSlot_5LaborCost()
    {
        return cSlot_5LaborCost;
    }

    /**
     * @param cSlot_5LaborCost the cSlot_5LaborCost to set
     */
    public void setcSlot_5LaborCost(Label cSlot_5LaborCost)
    {
        this.cSlot_5LaborCost = cSlot_5LaborCost;
    }

    /**
     * @return the cSlot_6LaborCost
     */
    public Label getcSlot_6LaborCost()
    {
        return cSlot_6LaborCost;
    }

    /**
     * @param cSlot_6LaborCost the cSlot_6LaborCost to set
     */
    public void setcSlot_6LaborCost(Label cSlot_6LaborCost)
    {
        this.cSlot_6LaborCost = cSlot_6LaborCost;
    }
    
    /*
        Called when using all six Labor Slots. Clears all the text fields within the form.
    */
    public void ClearAllTextFields()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cSlot_2TF.clear();
        cSlot_2LaborCostTF.clear();
        cSlot_3TF.clear();
        cSlot_3LaborCostTF.clear();
        cSlot_4TF.clear();
        cSlot_4LaborCostTF.clear();
        cSlot_5TF.clear();
        cSlot_5LaborCostTF.clear();
        cSlot_6TF.clear();
        cSlot_6LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    /*
        Called when using Five Labor Slots. Clears all the text fields within the form. 
    */
    public void ClearTextFields5Slots()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cSlot_2TF.clear();
        cSlot_2LaborCostTF.clear();
        cSlot_3TF.clear();
        cSlot_3LaborCostTF.clear();
        cSlot_4TF.clear();
        cSlot_4LaborCostTF.clear();
        cSlot_5TF.clear();
        cSlot_5LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    /*
        Called when using Four Labor Slots. Clears all the text fields within the form. 
    */
    public void ClearTextFields4Slots()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cSlot_2TF.clear();
        cSlot_2LaborCostTF.clear();
        cSlot_3TF.clear();
        cSlot_3LaborCostTF.clear();
        cSlot_4TF.clear();
        cSlot_4LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    /*
        Called when using Three Labor Slots. Clears all the text fields within the form. 
    */
    public void ClearTextFields3Slots()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cSlot_2TF.clear();
        cSlot_2LaborCostTF.clear();
        cSlot_3TF.clear();
        cSlot_3LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    /*
        Called when using Two Labor Slots. Clears all the text fields within the form. 
    */
    public void ClearTextFields2Slots()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cSlot_2TF.clear();
        cSlot_2LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    /*
        Called when using One Labor Slot. Clears all the text fields within the form. 
    */
    public void ClearTextFields1Slot()
    {
        cNameTF.clear();
        cPhoneTF.clear();
        cAddressTF.clear();
        cCityTF.clear();
        cStateTF.clear();
        cZipTF.clear();
        cDate_TimeTF.clear();
        cOrderNumberTF.clear();
        cVehicleYearTF.clear();
        cVehicleMakeTF.clear();
        cVehicleModelTF.clear();
        cSerialVINTF.clear();
        cLicenseNumberTF.clear();
        cOdometerTF.clear();
        cSlot_1TF.clear();
        cSlot_1LaborCostTF.clear();
        cLaborTF.clear();
        FileNameTF.clear();
    }
    
    public void clearOrderNumberTF()
    {
        cOrderNumberTF.clear();
    }
    
    public void clearOdometerTF()
    {
        cOdometerTF.clear();
    }
    public void clearLaborTF()
    {
        cLaborTF.clear();
    }
    public void clearSlot1CostTF()
    {
        cSlot_1LaborCostTF.clear();
    }
    public void clearSlot2CostTF()
    {
        cSlot_2LaborCostTF.clear();
    }
    public void clearSlot3CostTF()
    {
        cSlot_3LaborCostTF.clear();
    }
    public void clearSlot4CostTF()
    {
        cSlot_4LaborCostTF.clear();
    }
    public void clearSlot5CostTF()
    {
        cSlot_5LaborCostTF.clear();
    }
    public void clearSlot6CostTF()
    {
        cSlot_6LaborCostTF.clear();
    }
    public void clearSlot1TF()
    {
        cSlot_1TF.clear();
    }
    public void clearSlot2TF()
    {
        cSlot_2TF.clear();
    }
    public void clearSlot3TF()
    {
        cSlot_3TF.clear();
    }
    public void clearSlot4TF()
    {
        cSlot_4TF.clear();
    }
    public void clearSlot5TF()
    {
        cSlot_5TF.clear();
    }
    public void clearSlot6TF()
    {
        cSlot_6TF.clear();
    }
}