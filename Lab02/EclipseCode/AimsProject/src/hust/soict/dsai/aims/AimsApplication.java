package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.CartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AimsApplication extends Application {

    private Cart cart = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {
        cart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f,  "Roger Allers",87));
        cart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f,  "George Lucas",137));
        cart.addMedia(new DigitalVideoDisc("Aladin", "Animation", 18.99f));
        FXMLLoader fxmlLoader = new FXMLLoader(
                CartScreenController.class.getResource("cart.fxml")
        );

        fxmlLoader.setControllerFactory(param -> {
            if (param.equals(CartScreenController.class)) {
                return new CartScreenController(cart);
            }
            return null;
        });

        Parent root = fxmlLoader.load();

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("AIMS - Cart Screen");
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}