package mainmenu;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
/**
 *
 * @author Matthew Rodriguez
 */

public class MainMenuForm extends GridPane
{
    //Labels
    private Label titleLabel = new Label("TWORAGE AUTOMOTIVE RECIEPTS");
    private Label extraLabel = new Label("Powered by Java and PDFBOX");
    private Label extra2Label = new Label("Invoice Program by Matthew Isaiah Rodriguez 2018");
    
    //Button
    private Button action1 = new Button("Create Invoice");
    private Button action2 = new Button("Send Invoice");
    private Button action3 = new Button("Exit Program");
    
    //Setup
    
    //GUI Form
    public MainMenuForm()
    {
        
        //set title Font
        //titleLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 24));
        //extraLabel.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
        //extra2Label.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.REGULAR, 18));
        
        //vbox variables
        VBox vbox1 = new VBox(30);
        //VBox vbox2 = new VBox();
        
        //set sizes of buttons
        action1.setPrefSize(400, 50);
        action2.setPrefSize(400, 50);
        action3.setPrefSize(400, 50);
        
        //set gap between Things
        this.setVgap(50);
        //add everything
        this.getChildren().clear();
        vbox1.getChildren().addAll(action1,action2,action3);
       // vbox2.getChildren().addAll(extraLabel,extra2Label);
       // this.addRow(0,titleLabel);
        this.addRow(0,vbox1);
       // this.addRow(2,vbox2);
        this.setAlignment(Pos.CENTER);
    }

    /**
     * @return the titleLabel
     */
    public Label GetTitleLabel()
    {
        return titleLabel;
    }

    /**
     * @param titleLabel the titleLabel to set
     */
    public void SetTitleLabel(Label titleLabel)
    {
        this.titleLabel = titleLabel;
    }

    /**
     * @return the action1
     */
    public Button GetAction1()
    {
        return action1;
    }

    /**
     * @param action1 the action1 to set
     */
    public void SetAction1(Button action1)
    {
        this.action1 = action1;
    }

    /**
     * @return the action3
     */
    public Button GetAction3()
    {
        return action3;
    }

    /**
     * @param action3 the action3 to set
     */
    public void SetAction3(Button action3)
    {
        this.action3 = action3;
    }

    /**
     * @return the action2
     */
    public Button GetAction2()
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
}
