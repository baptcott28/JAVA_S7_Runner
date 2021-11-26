import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Main extends Application {

    private MouseButton mouse;
    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("GameScene");
        primaryStage.setResizable(false);

        Group group1 = new Group();
        StaticScene sceneIntro = new StaticScene(group1,800,400,true);
        Group root = new Group();
        GameScene Gamescene = new GameScene(root, 800, 400, true,primaryStage);
        Group group2 = new Group();
        StaticScene sceneFinale = new StaticScene(group2,800,400, true);
        Group group3 = new Group();
        StaticScene sceneCommand = new StaticScene(group3,800,400,true);

        //sceneIntro
        Button button1= new Button("Play");
        button1.setOnAction(e -> primaryStage.setScene(Gamescene));
        Button button4 = new Button("Command");
        button4.setOnAction(e -> primaryStage.setScene(sceneCommand));
        Label labelBienvenue = new Label("BIENVENUE", new Rectangle(300,600,1,1));
        Label signature = new Label("Baptiste Cottu - 2021", new Rectangle(300,600,1,1));

        group1.getChildren().add(sceneIntro.getBackground().getImageView());
        group1.getChildren().add(sceneIntro.getHero().getImageView());
        group1.getChildren().add(sceneIntro.getMechant().getImageView());

        button1.setLayoutX(300);
        button1.setLayoutY(200);
        button4.setLayoutX(450);
        button4.setLayoutY(200);

        labelBienvenue.setLayoutX(320);
        labelBienvenue.setLayoutY(50);
        labelBienvenue.setFont(new Font("Playbill",50));
        labelBienvenue.setTextFill(Color.RED);

        signature.setFont(new Font("Playbill",25));
        signature.setTextFill(Color.BLACK);
        signature.setLayoutX(620);
        signature.setLayoutY(370);

        group1.getChildren().add(button1);
        group1.getChildren().add(button4);
        group1.getChildren().add(labelBienvenue);
        group1.getChildren().add(signature);

        // GameScene
        root.getChildren().add(Gamescene.getBackgroundLeft().getImageView());
        root.getChildren().add(Gamescene.getBackgroundRight().getImageView());
        root.getChildren().add(Gamescene.getHero().getImageView());
        root.getChildren().add(Gamescene.getLife().getImageView());
        root.getChildren().add(Gamescene.getMechant().getImageView());
        root.getChildren().add(Gamescene.getScoretext());
        Gamescene.getTimer().handle(0);
        Gamescene.getTimer().start();

        //SceneCommands
        Button button3= new Button("Back to menu");
        button3.setOnAction(e -> primaryStage.setScene(sceneIntro));

        Label labelCommands = new Label("Commands",new Rectangle(300,600,1,1));
        Label instructions = new Label("ESC : Pause\nUP : Jump\nRIGHT : Boost\nLEFT : Stop Boost", new Rectangle(300,600,1,1));
        group3.getChildren().add(sceneCommand.getBackground().getImageView());
        group3.getChildren().add(sceneCommand.getMechant().getImageView());
        group3.getChildren().add(sceneCommand.getHero().getImageView());

        button3.setLayoutX(600);
        button3.setLayoutY(350);

        labelCommands.setFont(new Font("Playbill",50));
        labelCommands.setTextFill(Color.RED);
        labelCommands.setLayoutX(320);
        labelCommands.setLayoutY(20);

        instructions.setLayoutY(145);
        instructions.setLayoutX(340);
        instructions.setFont(new Font("Playbill",25));
        instructions.setTextFill(Color.RED);

        group3.getChildren().add(button3);
        group3.getChildren().add(labelCommands);
        group3.getChildren().add(instructions);


        primaryStage.setScene(sceneIntro);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
        //write your code here

    }
}
