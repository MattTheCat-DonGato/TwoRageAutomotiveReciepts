package main;

import create.CreateController;
import email.EmailController;
import mainmenu.MainMenuController;

/**
 *
 * @author Matthew Rodriguez
 */
public class MainController
{
    //Controllers
    MainMenuController mainMenuController;
    CreateController createController;
    EmailController emailController;
    
    public MainController(MainMenuController mainMenuController, CreateController createController, EmailController emailController)
    {
        //Set Controllers
        this.mainMenuController = mainMenuController;
        this.createController = createController;
        this.emailController = emailController;
        //attach handlers
        AttachHandlers();
    }
    
    public void AttachHandlers()
    {
        mainMenuController.attachHandlers();
        createController.attachHandlers();
        emailController.attachHandlers();
    }
}
