package email;
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

public class EmailView extends BorderPane
{
    private Image backgroundImg = new Image("images/backgroundEmail.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, bSize));
    
    private EmailForm emailForm = new EmailForm();

    public EmailView()
    {
        this.setBackground(background);
        this.setCenter(emailForm);
    }

    /**
     * @return the emailForm
     */
    public EmailForm GetEmailForm()
    {
        return emailForm;
    }

    /**
     * @param emailForm the emailForm to set
     */
    public void SetEmailForm(EmailForm emailForm)
    {
        this.emailForm = emailForm;
    }
    
    //functions
    public void SetEmailForm()
    {
        this.getChildren().clear();
        this.setCenter(emailForm);
    }
}