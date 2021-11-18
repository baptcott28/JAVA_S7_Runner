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
    private Integer JumpOrder=0;
    private double boostOrder=0;
    private Integer lifeNumber=5;


    public AnimatedThing(String fileName,double posInFenetreX, double posInFenetreY, Integer state){
        this.state=state;
        this.JumpOrder=JumpOrder;
        this.boostOrder=boostOrder;
        Image heroimage = new Image(fileName);
        ImageView imghero= new ImageView(heroimage);
        imghero.setViewport(new Rectangle2D(20,0,60,100));
        imghero.setX(posInFenetreX);
        imghero.setY(posInFenetreY);
        this.imageView=imghero;
        this.image=heroimage;
        this.lifeNumber=lifeNumber;

    }

    public void update(){

        //jump
        if((JumpOrder==1)&&(this.getImageView().getY()>30)){
            imageView.setViewport(new Rectangle2D(20,160,60,105));
            this.getImageView().setY(this.getImageView().getY()-35);
        }

        // remise de JumpOrder a 0
        if ((JumpOrder==1)&&(this.getImageView().getY() <= 30)) {
            JumpOrder=0;
        }

        //gravity
        if((JumpOrder==0)&&(this.getImageView().getY()<250)){
            imageView.setViewport(new Rectangle2D(95,160,70,105));
            this.getImageView().setY(this.getImageView().getY()+17);
        }

        //update run
        if ((this.getImageView().getY()>=250)&&(state == 0)) {
            state=state+1;
        }

        if((this.getImageView().getY()>=250)&&(state==1)){
            imageView.setViewport(new Rectangle2D(20,0,60,100));
        }

        if((this.getImageView().getY()>=250)&&(state==2)){
            imageView.setViewport(new Rectangle2D(95,0,70,100));
        }

        if((this.getImageView().getY()>=250)&&(state==3)){
            imageView.setViewport(new Rectangle2D(170,10,85,90));
        }

        if((this.getImageView().getY()>=250)&&(state==4)){
            imageView.setViewport(new Rectangle2D(270,10,65,90));
        }

        if((this.getImageView().getY()>=250)&&(state==5)){
            imageView.setViewport(new Rectangle2D(345,0,70,100));
        }

        if((this.getImageView().getY()>=250)&&(state==6)){
            imageView.setViewport(new Rectangle2D(425,15,80,85));
        }
        state=(state+1)%7;
    }

    public ImageView getImageView(){
        return imageView;
    }

    public void jump(){
        this.JumpOrder=1;
        System.out.println("JumpOrder="+JumpOrder);
    }

    public void boost(){
        this.boostOrder=1;
        System.out.println("boostorder="+boostOrder);
    }

    public void stopBoost(){
        boostOrder=0;
        System.out.println("boostorder="+boostOrder);
    }

    public Image getImage(){
        return image;
    }

    public double getboostorder(){
        return boostOrder;
    }

    public Integer getLifeNumber(){
        return lifeNumber;
    }

    public void UpdateLifeNumber(){
        this.lifeNumber--;
    }
}
