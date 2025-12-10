package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc; // Ví dụ để thêm dữ liệu test
import hust.soict.dsai.aims.screen.CartScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class AimsApplication extends Application {

    // Đối tượng Cart được Controller yêu cầu trong hàm khởi tạo
    private Cart myCart = new Cart();

    @Override
    public void start(Stage primaryStage) throws Exception {

        // --- CHUẨN BỊ DỮ LIỆU TEST (Tùy chọn) ---
        // Thêm vài mục vào Cart để kiểm tra TableView có hiển thị không
        myCart.addMedia(new DigitalVideoDisc("The Lion King", "Animation", 19.95f, "Roger Allers",87 ));
        myCart.addMedia(new DigitalVideoDisc("Star Wars", "Science Fiction", 24.95f, "George Lucas", 137));

        // --- QUÁ TRÌNH TẢI FXML VÀ KHỞI TẠO CONTROLLER ---

        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/hust/soict/dsai/aims/screen/CartScreen.fxml")
        );

        // BƯỚC KHẮC PHỤC LỖI MÀN HÌNH TRẮNG (Controller Factory)
        fxmlLoader.setControllerFactory(param -> {
            // Kiểm tra xem lớp Controller cần tạo có phải là CartScreenController không
            if (param.equals(CartScreenController.class)) {
                // Nếu đúng, tạo Controller và truyền đối tượng myCart vào
                return new CartScreenController(myCart);
            }
            // Nếu không phải, để FXMLLoader xử lý các Controller khác
            return null;
        });

        // 3. Tải FXML
        Parent root = fxmlLoader.load();

        // 4. Thiết lập và hiển thị Stage
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("AIMS - Cart Screen");
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Lệnh khởi động JavaFX runtime
        launch(args);
    }
}