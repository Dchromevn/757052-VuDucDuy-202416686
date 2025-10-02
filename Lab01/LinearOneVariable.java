import javax.swing.JOptionPane;
public class LinearOneVariable {
    public static void main(String[] args) {
        String stra =JOptionPane.showInputDialog(null,"Enter coeficient a:","input a",JOptionPane.INFORMATION_MESSAGE);
        String strb =JOptionPane.showInputDialog(null,"Enter coeficient b:","input b",JOptionPane.INFORMATION_MESSAGE);
        double a = Double.parseDouble(stra);
        double b = Double.parseDouble(strb);
        if (a==0){
            if (b==0){
                JOptionPane.showMessageDialog(null,"The equation has ifinity solutions");
            } else {
                JOptionPane.showMessageDialog(null,"The equation has no solution");
            }
        }else{
            double x = -b/a;
            JOptionPane.showMessageDialog(null, "The solution is: " + x,"Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
