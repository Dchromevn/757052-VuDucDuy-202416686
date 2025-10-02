import javax.swing.JOptionPane;
public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification="You have just entered:";
        strNum1 = JOptionPane.showInputDialog(null,"Please enter first number:","Input the first number ",JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null,"Please enter second number:","Input the second number ",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, strNotification + "\nFirst number: " + strNum1 + "\nSecond number: " + strNum2);
    }
}
