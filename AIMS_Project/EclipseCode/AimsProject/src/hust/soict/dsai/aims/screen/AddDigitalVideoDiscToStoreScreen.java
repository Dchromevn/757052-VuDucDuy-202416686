package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart);
        setTitle("Add DVD to Store");
    }

    @Override
    protected void addSpecificFields(JPanel center) {
        center.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        center.add(tfDirector);

        center.add(new JLabel("Length:"));
        tfLength = new JTextField();
        center.add(tfLength);
    }

    @Override
    protected void addItemToStore() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        float cost = 0;
        int length = 0;

        try {
            cost = Float.parseFloat(tfCost.getText());
            length = Integer.parseInt(tfLength.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Cost and Length must be valid numbers", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost, director, length);

        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added successfully");

        tfTitle.setText("");
        tfCategory.setText("");
        tfCost.setText("");
        tfDirector.setText("");
        tfLength.setText("");
    }
}