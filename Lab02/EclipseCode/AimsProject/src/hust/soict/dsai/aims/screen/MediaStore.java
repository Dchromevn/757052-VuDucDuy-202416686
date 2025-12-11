package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;
    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        btnAddToCart.addActionListener(e -> {
            try {
                cart.addMedia(media);
                JOptionPane.showMessageDialog(this, media.getTitle() + " has been added to the cart.");
            } catch (LimitExceededException ex) {
                // SỬA LỖI: Hiển thị thông báo thay vì ném RuntimeException
                JOptionPane.showMessageDialog(this, ex.getMessage(),
                        "Add to Cart Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        container.add(btnAddToCart);

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            btnPlay.addActionListener(e -> {
                try {
                    ((Playable) media).play();
                    JOptionPane.showMessageDialog(this, "Playing: " + media.getTitle(),
                            "Playback Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(),
                            "Playback Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            container.add(btnPlay);
        }
        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}