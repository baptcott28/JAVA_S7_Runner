import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class AnimatedThing {

    ImageView image;
    Integer state;
    double posInFenetreX;
    double posInFenetreY;
    private ImageView ImageView;


    public AnimatedThing(String fileName,double posInFenetreX, double posInFenetreY, Integer state){
        this.state=state;

        Image heroimage = new Image(fileName);
        ImageView imghero= new ImageView(heroimage);

        if(state==1){
            imghero.setViewport(new Rectangle2D(20,0,60,100));
        }

        if(state==2){
            imghero.setViewport(new Rectangle2D(95,0,70,100));
        }

        if(state==3){
            imghero.setViewport(new Rectangle2D(170,10,85,90));
        }

        if(state==4){
            imghero.setViewport(new Rectangle2D(270,10,65,90));
        }

        if(state==5){
            imghero.setViewport(new Rectangle2D(345,0,70,100));
        }

        if(state==6){
            imghero.setViewport(new Rectangle2D(425,15,80,85));
        }
        imghero.setX(posInFenetreX);
        imghero.setY(posInFenetreY);
        this.ImageView=imghero;

    }

    public ImageView getImageView(){
        return ImageView;
    }

}
