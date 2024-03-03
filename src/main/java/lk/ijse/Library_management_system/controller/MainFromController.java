package lk.ijse.Library_management_system.controller;

import javafx.animation.ScaleTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class MainFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private ImageView imgAdmin;

    @FXML
    private ImageView imgUser;

    @FXML
    private Label lblAbout;
    @FXML
    private Label lblAdmin;

    @FXML
    private Label lblUser;

    @FXML
    void imgAdminOnAction(MouseEvent event) {
        System.out.println("Admin");
    }

    @FXML
    void imgUserOnAction(MouseEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user_sign_in.fxml"));
        Scene scene = new Scene(anchorPane);

        Stage stage = (Stage) root.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Sign_in page");
        stage.centerOnScreen();
    }

    @FXML
    void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView){
            ImageView image = (ImageView) event.getSource();
            switch (image.getId()){
                case "imgAdmin":
                    lblAdmin.setText("Admin");
                    lblAbout.setText("If your Admin,Please click and sing in...");
                    break;
                case "imgUser":
                    lblUser.setText("User");
                    lblAbout.setText("If your are User,Please click and sing in...");
                    break;
            }
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), image);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.CORNFLOWERBLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            image.setEffect(glow);
        }
    }

    @FXML
    void playMouseExiteAnimation(MouseEvent event) {
        if (event.getSource() instanceof ImageView) {
            ImageView image = (ImageView) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), image);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            image.setEffect(null);
            lblAdmin.setText("");
            lblUser.setText("");
            lblAbout.setText("Please select your choice from the following to continue the process..");
        }
    }

}