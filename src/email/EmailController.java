/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package email;

import email.EmailAttachmentSender;
import java.io.File;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import utilities.Email;
import utilities.TwoRageError;

/**
 *
 * @author Matthew Rodriguez
 */
public class EmailController
{
    //Needed to open a window for file choosing
    FileChooser fileChooser = new FileChooser();
    
    //String of attached Files that wil be added to Email Object for submission
    String [] attachFiles = new String[1];
    
    //stage ref
    Stage mainStage;
    
    //scenes
    Scene mainMenuScene;
    
    //views
    private EmailView emailView;
    
    
    public EmailController(Stage mainStage, EmailView emailView, Scene mainMenuScene)
    {
        this.mainStage = mainStage;
        this.emailView = emailView;
        this.mainMenuScene = mainMenuScene;
    }
    
    public void attachHandlers()
    {
        emailView.GetEmailForm().GetSelectFileButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {           
                    File file = fileChooser.showOpenDialog(mainStage);
                        if(file != null)
                        {
                            attachFiles[0] = file.toString();            
                        }
                    TwoRageError.ErrorAlert("INFORMATION", "File Attached", "File " + attachFiles[0] + " has been attached to Email.");
                }
                catch(Exception e)
                {
                    System.out.println("Exception at EmailForm, Function ChooseFile: " + e.getMessage());
                }    
            }
        });
        emailView.GetEmailForm().GetSendEmailButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
                if (emailView.GetEmailForm().GetEmailTF().getText().endsWith("@gmail.com") || emailView.GetEmailForm().GetEmailTF().getText().endsWith("@yahoo.com") || emailView.GetEmailForm().GetEmailTF().getText().endsWith("@hotmail.com") || emailView.GetEmailForm().GetEmailTF().getText().endsWith("@aol.com") || emailView.GetEmailForm().GetEmailTF().getText().endsWith("@outlook.com") || emailView.GetEmailForm().GetEmailTF().getText().endsWith("@msn.com"))
                {
                    if (emailView.GetEmailForm().GetSubjectTF().getText().trim().length() == 0)
                    {
                        TwoRageError.ErrorAlert("ERROR", "Subject Field Empty", "Please enter a subject in the text field.");
                    }
                    else
                    {
                        if (attachFiles[0] == null)
                        {
                            TwoRageError.ErrorAlert("ERROR", "File Not Selected", "Choose a file to attach to the email.");
                        }
                        else
                        {
                            try
                            {
                                Email myEmail = new Email();
                                myEmail.setHost("smtp.gmail.com");
                                String host = myEmail.getHost();
                                myEmail.setPort("465");
                                String port = myEmail.getPort();
                                myEmail.setMailFrom("tworageautomotive96@gmail.com");
                                String mailFrom = myEmail.getMailFrom();
                                myEmail.setPassword("tworage_96");
                                String password = myEmail.getPassword();
                                String toAddress = emailView.GetEmailForm().GetEmailTF().getText();
                                String subject = emailView.GetEmailForm().GetSubjectTF().getText();
                                String message = emailView.GetEmailForm().GetMessageTA().getText();                           
                                EmailAttachmentSender.sendEmailWithAttachments(host, port, mailFrom, password, toAddress, subject, message, attachFiles);
                                TwoRageError.ErrorAlert("INFORMATION", "Email Sent", "Email has been sent to: " + toAddress);
                                if(attachFiles != null)
                                    for (int i = 0; i < attachFiles.length; i++)
                                    {
                                        attachFiles[i] = null;
                                    }
                                emailView.GetEmailForm().clearTF();
                            }
                            catch (Exception e)
                            {
                                TwoRageError.ErrorAlert("ERROR", "Sending Email Failed", "Email couldn't be sent because the email provided does not exist or an internet connection could not be established."
                                        + "Please check your network settings and verify that the email address is correct before retrying."
                                        + "If issues continue to happen please send an email from your personal device to: mattrodriguez64@gmail.com for more help.");
                            }
                        }
                    }
                }
                else
                {
                    TwoRageError.ErrorAlert("INFORMATION", "Invalid Email Address", "Please enter a valid email address suffix.");
                }   
            }
        });
        emailView.GetEmailForm().GetReturnButton().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event)
            {
               emailView.GetEmailForm().clearTF();
               if(attachFiles != null)
                   for (int i = 0; i < attachFiles.length; i++)
                   {
                       attachFiles[i] = null;
                   }  
               mainStage.setScene(mainMenuScene);
            }
        });
    }
}