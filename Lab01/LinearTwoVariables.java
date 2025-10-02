import javax.swing.JOptionPane;

public class LinearTwoVariables {
    public static void main(String[] args) {
        String stra11 =JOptionPane.showInputDialog(null,"Enter coeficient a11:", "input a11",JOptionPane.INFORMATION_MESSAGE);
        String stra12 =JOptionPane.showInputDialog(null,"Enter coeficient a12","input a12",JOptionPane.INFORMATION_MESSAGE);
        String strb1 =JOptionPane.showInputDialog(null,"Enter coeficient b1:","input b1",JOptionPane.INFORMATION_MESSAGE);
        String stra21 =JOptionPane.showInputDialog(null,"Enter coeficient a21:","input a21",JOptionPane.INFORMATION_MESSAGE);
        String stra22 =JOptionPane.showInputDialog(null,"Enter coeficient  a22:","input a22",JOptionPane.INFORMATION_MESSAGE);
        String strb2 =JOptionPane.showInputDialog(null,"Enter coeficient b2:","input b2",JOptionPane.INFORMATION_MESSAGE);
        double a11 = Double.parseDouble(stra11);
        double a12 = Double.parseDouble(stra12);
        double a21 = Double.parseDouble(stra21);
        double a22 = Double.parseDouble(stra22);
        double b2 = Double.parseDouble(strb2);
        double b1 = Double.parseDouble(strb1);
        double D =a11*a22 - a21*a12;
        double Dx = b1*a22 - b2*a12;
        double Dy =a11*b2 - a21*b1;
        if (D==0){
            if (Dx==0 && Dy==0){
                JOptionPane.showMessageDialog(null,"The equation has ifinity solutions");
            } else {
                JOptionPane.showMessageDialog(null,"The equation has no solution"); 
            }
        } else {
            double x = Dx/D;
            double y = Dy/D;
            JOptionPane.showMessageDialog(null, "The solution is: (" + x + ", " + y + ")","Solution", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
}
