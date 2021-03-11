/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailForm extends GridPane
{
    // Boxes
    private VBox emailContentBox = new VBox(15);
    private VBox buttonBox = new VBox(25);
    private HBox groupedBoxes = new HBox(20);

    // Buttons
    private Button selectFileButton = new Button("Choose File...");
    private Button sendEmailButton = new Button("Send Email");
    private Button returnButton = new Button("Return to Main Menu");

    // Labels
     private Label emailLabel = new Label("Recipient Email Address");
     private Label fileNameLabel = new Label("No File Selected");
     private Label messageLabel = new Label("Message");
     private Label subjectLabel = new Label("Subject");
     private Label passLabel = new Label("App Password");

    // TextFields
    private TextField emailTF = new TextField();
    private TextField subjectTF = new TextField();
    private TextArea messageTA = new TextArea();
    private TextField passTF = new TextField();
    
    public EmailForm()
    {
        VBox emailContentBox = new VBox(15);
        VBox buttonBox = new VBox(25);
        HBox groupedBoxes = new HBox(20);
        emailContentBox.getChildren().addAll(passLabel,passTF,emailLabel,emailTF,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonBox.getChildren().addAll(selectFileButton,fileNameLabel,sendEmailButton,returnButton);
        buttonBox.setAlignment(Pos.CENTER);
        //add everything
        this.getChildren().clear();
        this.setHgap(15); 
        groupedBoxes.getChildren().addAll(emailContentBox,buttonBox);     
        this.add(groupedBoxes, 0, 0);
        this.setAlignment(Pos.CENTER);
    }
    
    /*
        Called Function to refresh file name
    */
    public void EmailFormWithFileName()
    {
        VBox emailContentBox = new VBox(15);
        VBox buttonBox = new VBox(25);
        HBox groupedBoxes = new HBox(20); 
        emailContentBox.getChildren().addAll(passLabel,passTF,emailLabel,emailTF,subjectLabel,subjectTF,messageLabel,messageTA);
        buttonBox.getChildren().addAll(selectFileButton,fileNameLabel,sendEmailButton,returnButton);
        buttonBox.setAlignment(Pos.CENTER);
        //add everything
        this.getChildren().clear();
        this.setHgap(15); 
        groupedBoxes.getChildren().addAll(emailContentBox,buttonBox);     
        this.add(groupedBoxes, 0, 0);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the buttonBox
     */
    public VBox GetButtonBox()
    {
        return buttonBox;
    }

    /**
     * @param buttonBox the buttonBox to set
     */
    public void SetButtonBox(VBox buttonBox)
    {
        this.buttonBox = buttonBox;
    }

    /**
     * @return the selectFileButton
     */
    public Button GetSelectFileButton()
    {
        return selectFileButton;
    }

    /**
     * @param selectFileButton the selectFileButton to set
     */
    public void SetSelectFileButton(Button selectFileButton)
    {
        this.selectFileButton = selectFileButton;
    }

    /**
     * @return the sendEmailButton
     */
    public Button GetSendEmailButton()
    {
        return sendEmailButton;
    }

    /**
     * @param sendEmailButton the sendEmailButton to set
     */
    public void SetSendEmailButton(Button sendEmailButton)
    {
        this.sendEmailButton = sendEmailButton;
    }

    /**
     * @return the returnButton
     */
    public Button GetReturnButton()
    {
        return returnButton;
    }

    /**
     * @param returnButton the returnButton to set
     */
    public void SetReturnButton(Button returnButton)
    {
        this.returnButton = returnButton;
    }

    /**
     * @return the messageLabel
     */
    public Label GetMessageLabel()
    {
        return messageLabel;
    }

    /**
     * @param messageLabel the messageLabel to set
     */
    public void SetMessageLabel(Label messageLabel)

    {
        this.messageLabel = messageLabel;
    }

    /**
     * @return the subjectLabel
     */
    public Label GetSubjectLabel()
    {
        return subjectLabel;
    }

    /**
     * @param subjectLabel the subjectLabel to set
     */
    public void SetSubjectLabel(Label subjectLabel)
    {
        this.subjectLabel = subjectLabel;
    }

    /**
     * @return the subjectTF
     */
    public TextField GetSubjectTF()
    {
        return subjectTF;
    }

    /**
     * @param subjectTF the subjectTF to set
     */

    public void SetSubjectTF(TextField subjectTF)
    {
        this.subjectTF = subjectTF;
    }

    /**
     * @return the messageTA
     */
    public TextArea GetMessageTA()
    {
        return messageTA;
    }

    /**
     * @param messageTA the messageTA to set
     */

    public void SetMessageTA(TextArea messageTA)
    {
        this.messageTA = messageTA;
    }

    /**
     * @return the emailContentBox
     */
    public VBox GetEmailContentBox()
    {
        return emailContentBox;
    }

    /**
     * @param emailContentBox the emailContentBox to set
     */
    public void SetEmailContentBox(VBox emailContentBox)
    {
        this.emailContentBox = emailContentBox;
    }

    /**
     * @return the groupedBoxes
     */
    public HBox GetGroupedBoxes()
    {
        return groupedBoxes;
    }

    /**
     * @param groupedBoxes the groupedBoxes to set
     */
    public void SetGroupedBoxes(HBox groupedBoxes)
    {
        this.groupedBoxes = groupedBoxes;
    }
    
    public void clearTF()
    {
        emailTF.clear();
        subjectTF.clear();
        messageTA.clear();
    }

    /**
     * @return the emailLabel
     */
    public Label getEmailLabel()
    {
        return emailLabel;
    }

    /**
     * @param emailLabel the emailLabel to set
     */
    public void setEmailLabel(Label emailLabel)
    {
        this.emailLabel = emailLabel;
    }

    /**
     * @return the emailTF
     */
    public TextField GetEmailTF()
    {
        return emailTF;
    }

    /**
     * @param emailTF the emailTF to set
     */
    public void setEmailTF(TextField emailTF)
    {
        this.emailTF = emailTF;
    }

    public Label GetPassLabel() 
    {
        return passLabel;
    }

    public void SetPassLabel(Label passLabel) 
    {
        this.passLabel = passLabel;
    }

    public TextField GetPassTF() 
    {
        return passTF;
    }

    public void SetPassTF(TextField passTF) 
    {
        this.passTF = passTF;
    }

    public Label GetFileNameLabel() {
        return fileNameLabel;
    }

    public void SetFileNameLabel(Label fileNameLabel) {
        this.fileNameLabel = fileNameLabel;
    }
}
