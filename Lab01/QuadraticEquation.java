import javax.swing.JOptionPane;
public class QuadraticEquation {
    public static void main(String[] args) {
            String stra =JOptionPane.showInputDialog(null,"Enter coeficient a:","input a",JOptionPane.INFORMATION_MESSAGE);
            String strb =JOptionPane.showInputDialog(null,"Enter coeficient b:","input b",JOptionPane.INFORMATION_MESSAGE);
            String strc =JOptionPane.showInputDialog(null,"Enter coeficient c:","input c",JOptionPane.INFORMATION_MESSAGE);
            double a = Double.parseDouble(stra);
            double b = Double.parseDouble(strb);
            double c = Double.parseDouble(strc);
            if (a==0){
                if (b==0){
                    if (c==0){
                        JOptionPane.showMessageDialog(null,"The equation has ifinity solutions");
                    } else {
                        JOptionPane.showMessageDialog(null,"The equation has no solution");
                    }
                }else{
                    double x = -c/b;
                    JOptionPane.showMessageDialog(null, "The solution is: " + x,"Solution", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                double delta = b*b - 4*a*c;
                if (delta<0){
                    JOptionPane.showMessageDialog(null,"The equation has no solution");
                } else if (delta==0){
                    double x = -b/(2*a);
                    JOptionPane.showMessageDialog(null, "The solution is: " + x,"Solution", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    double x1 = (-b + Math.sqrt(delta))/(2*a);
                    double x2 = (-b - Math.sqrt(delta))/(2*a);
                    JOptionPane.showMessageDialog(null, "The solutions are: " + x1 + " and " + x2,"Solutions", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }
    }