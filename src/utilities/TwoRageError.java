package utilities;
import javafx.scene.control.Alert;

/**
 *
 * @author mattr
 */
public class TwoRageError
{
    public static void ErrorAlert(String title, String header, String content)
    {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();     
    }
}
