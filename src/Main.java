import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello world");
        Group root = new Group();
        Pane pane = new Pane(root);
        //Scene theScene = new Scene(pane,600,400,true);
        camera Camera = new camera(200,200);
        GameScene gameScene = new GameScene(Camera,pane,1000,500,true); // X et Y = format de la scene
        primaryStage.setScene(gameScene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        //write your code here
    }
}
