package main;

import create.CreateController;
import create.CreateView;
import create.CreateModel;
import email.EmailController;
import email.EmailView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import mainmenu.MainMenuController;
import mainmenu.MainMenuView;

/**
 *
 * @author Matthew Rodriguez
 */
public class TwoRageAutomotiveReciepts extends Application
{
    //Stage
    Stage mainStage;
    
    //Views
    MainMenuView mainMenuView = new MainMenuView();
    CreateView createView = new CreateView();
    EmailView emailView = new EmailView();
    
    //Models
    CreateModel invoiceModel = new CreateModel();
    
    //Scenes
    Scene mainMenuScene = new Scene(mainMenuView, 1000, 550);
    Scene createScene = new Scene(createView, 1000, 550);
    Scene emailScene = new Scene(emailView, 1000, 550);
    
    //Controllers
    MainMenuController mmc;
    MainController mc;
    CreateController cc;
    EmailController ec;
    
    @Override
    public void start(Stage primaryStage)
    {
        //set stage instance
        mainStage = primaryStage;
        
        //setup controllers
        mmc = new MainMenuController(mainStage,mainMenuView,createScene,emailScene);
        cc = new CreateController(mainStage,createView,mainMenuScene);
        ec = new EmailController (mainStage,emailView,mainMenuScene);
        mc = new MainController(mmc,cc,ec);
        
        //show initial scene
        mainStage.setTitle("TwoRageAutomotiveReciepts");
        mainStage.setScene(mainMenuScene);
        mainStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }   
}