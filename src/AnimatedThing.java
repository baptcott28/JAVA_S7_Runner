import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.*;

public class AnimatedThing {

    private Integer state;
    private double posInFenetreX;
    private double posInFenetreY;
    private ImageView imageView;
    private Image image;


    public AnimatedThing(String fileName,double posInFenetreX, double posInFenetreY, Integer state){
        this.state=state;
        Image heroimage = new Image(fileName);
        ImageView imghero= new ImageView(heroimage);
        imghero.setViewport(new Rectangle2D(20,0,60,100));
        imghero.setX(posInFenetreX);
        imghero.setY(posInFenetreY);
        this.imageView=imghero;
        this.image=heroimage;

    }

    public void update(){

        state=(state+1)%7;
        if (state == 0) {
            state=state+1;
        }

        if(state==1){
            imageView.setViewport(new Rectangle2D(20,0,60,100));
        }

        if(state==2){
            imageView.setViewport(new Rectangle2D(95,0,70,100));
        }

        if(state==3){
            imageView.setViewport(new Rectangle2D(170,10,85,90));
        }

        if(state==4){
            imageView.setViewport(new Rectangle2D(270,10,65,90));
        }

        if(state==5){
            imageView.setViewport(new Rectangle2D(345,0,70,100));
        }

        if(state==6){
            imageView.setViewport(new Rectangle2D(425,15,80,85));
        }
    }

    public ImageView getImageView(){
        return imageView;
    }

    public Image getImage(){
        return image;
    }

}
