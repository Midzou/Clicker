import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import java.awt.*;
import java.awt.Robot;
import static java.awt.event.InputEvent.BUTTON1_MASK;
import static java.awt.event.KeyEvent.*;


public class Main extends Application {
    Stage window;
    Robot robot;
    Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("clicker");


        StackPane layout = new StackPane();
        robot = new Robot();

        scene = new Scene(layout, 200, 100);
        window.setScene(scene);



        window.show();

        scene.setOnKeyTyped(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent ke) {

                try {
                if (ke.getCharacter().equals( " " )) //запустились через пробел
                {
                    Thread.sleep( 1000 );
                    robot.mouseMove( 680,625 );//сместили мышку
                    robot.keyPress(VK_SPACE);

                    while (true) {

                        robot.mousePress( BUTTON1_MASK );
                        Thread.sleep( 500 );
                        robot.mouseRelease( BUTTON1_MASK );
                        Thread.sleep( 100 );

                        Point location = MouseInfo.getPointerInfo().getLocation();
                        double x = location.getX();
                        double y = location.getY();
                        System.out.println( x );
                        if(x!=680.0)
                           break;
                    }

                }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }


}