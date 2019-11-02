package create;

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
public class CreateView extends BorderPane
{
    //background
    private Image backgroundImg = new Image("images/backgroundCreateInvoice.png");
    private BackgroundSize bSize = new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false);
    private Background background = new Background(new BackgroundImage(backgroundImg, BackgroundRepeat.SPACE, BackgroundRepeat.SPACE, BackgroundPosition.CENTER, bSize));
    
    //forms
    private CreateForm createForm = new CreateForm();
    
    //constructor
    public CreateView()
    {
        this.setBackground(background);
        this.setCenter(createForm);
    }

    /**
     * @return the createForm
     */
    public CreateForm GetCreateForm()
    {
        return createForm;
    }

    /**
     * @param createForm the createForm to set
     */
    public void SetCreateForm(CreateForm createForm)
    {
        this.createForm = createForm;
    }
    
    public void SetCreateForm()
    {
        this.getChildren().clear();
        this.setCenter(createForm);
    }
}
