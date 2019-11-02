package mainmenu;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Matthew Rodriguez
 */
public class MainMenuView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/backgroundTitle.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, bSize));
    //forms
    private MainMenuForm mainMenuForm = new MainMenuForm();
    
    //constructor
    public MainMenuView()
    {
        this.setBackground(background);
        this.setCenter(mainMenuForm);
    }

    /**
     * @return the mainMenuForm
     */
    public MainMenuForm GetMainMenuForm()
    {
        return mainMenuForm;
    }

    /**
     * @param mainMenuForm the mainMenuForm to set
     */
    public void SetMainMenuForm(MainMenuForm mainMenuForm)
    {
        this.mainMenuForm = mainMenuForm;
    }
            
    public void SetMainMenuForm()
    {
        this.getChildren().clear();
        this.setCenter(mainMenuForm);
    }
}
