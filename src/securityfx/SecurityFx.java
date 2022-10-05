package securityfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * 2020-2-21
 * @author Osama_ku
 */
public class SecurityFx extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("fxmlFile.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        // application name 
        stage.setTitle("Security App");
        
        // Application icon
        Image img = new Image("/img/PadLock-icon.png");
        stage.getIcons().add(img);
  
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
