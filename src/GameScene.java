import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.geometry.Rectangle2D;


public class GameScene extends Scene {
    // on cree une scene qui s'appelle GameScene et on y introduit une camera

    camera Camera = new camera(200,200);

    public GameScene(Group group, Integer X, Integer Y, boolean b ) {
        super(group,X,Y,b);
        //this.Camera=Camera;
        staticThing bckgrnd1 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert.png",600,630);
        staticThing bckgrnd2 = new staticThing("C:\\Users\\bapti\\Documents\\COURS ENSEA\\2A\\JAVA\\desert",600,630);
        group.getChildren().add(bckgrnd1.getImageView());
        group.getChildren().add(bckgrnd2.getImageView());
    }



}
