/**
 *Name : Tran Van Khoi
 *MSSV : HE130007
 *Email : khoitvhe130007@fpt.edu.vn
 *Lecturer : DuongTB
 */
package main;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import view.MainView;

/**
 *
 * @author khoitvhe130007@fpt.edu.vn
 */
public class Main extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        MainView mainView = new MainView();
        mainView.setResizable(false);
        mainView.setLocationRelativeTo(null);
        mainView.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
