package mainmenu;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author mattr
 */
public class MainMenuController
{
    //stage reference
    Stage mainStage;
    
    //scenes
    Scene createScene;
    Scene emailScene;
    
    //views
    private MainMenuView mainMenuView;
    
    //constructor
    public MainMenuController(Stage mainStage, MainMenuView mainMenuView, Scene createScene, Scene emailScene)
    {
        this.mainStage = mainStage;
        this.mainMenuView = mainMenuView;
        this.createScene = createScene;
        this.emailScene = emailScene;
    }
    
    public void attachHandlers()
    {
        mainMenuView.GetMainMenuForm().GetAction1().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(createScene);
            }           
        });
        
        mainMenuView.GetMainMenuForm().GetAction2().setOnAction(new EventHandler <ActionEvent>() 
        {
            @Override
            public void handle(ActionEvent event)
            {
                mainStage.setScene(emailScene);
            }
        });
        
        mainMenuView.GetMainMenuForm().GetAction3().setOnAction(new EventHandler <ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Platform.exit();
            }           
        });
    }
}
