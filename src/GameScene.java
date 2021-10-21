import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class GameScene extends Scene {
    // on cree une scene qui s'appelle GameScene et on y introduit une camera

    camera Camera = new camera(200,200);

    public GameScene(camera Camera , Pane pane, Integer X, Integer Y, boolean b ) {
        super(pane,X,Y,b);
        this.Camera=Camera;
    }


}
