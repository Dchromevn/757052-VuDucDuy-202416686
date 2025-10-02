import javax.swing.JOptionPane;
public class SolveEquation {
    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Choose type of equation", null, 0);
        String[] options = {"Linear equation one variable (ax + b = 0)", "Quadratic equation (ax^2 + bx + c = 0)", "Linear equation two variables (ax + by + c = 0)(cx + dy + e = 0)"};
        int choice = JOptionPane.showOptionDialog(null, "Select the type of equation to solve:", "Equation Type", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        switch (choice) {
            case 0:
                solveLinearEquation();
                break;
            case 1:
                solveQuadraticEquation();
                break;
            case 2:
                solveLinearEquationTwoVariables();
                break;
            default:
                JOptionPane.showMessageDialog(null, "No option selected. Exiting.");
                break;
        }
    }
    public static void solveLinearEquation(){
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
    public static void solveQuadraticEquation(){
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
    public static void solveLinearEquationTwoVariables(){
        String stra1 =JOptionPane.showInputDialog(null,"Enter coeficient a1:", "input a1",JOptionPane.INFORMATION_MESSAGE);
        String strb1 =JOptionPane.showInputDialog(null,"Enter coeficient b1z","input b1",JOptionPane.INFORMATION_MESSAGE);
        String strc1 =JOptionPane.showInputDialog(null,"Enter coeficient c1:","input c1",JOptionPane.INFORMATION_MESSAGE);
        String stra2 =JOptionPane.showInputDialog(null,"Enter coeficient a2:","input a2",JOptionPane.INFORMATION_MESSAGE);
        String strb2 =JOptionPane.showInputDialog(null,"Enter coeficient b2:","input b2",JOptionPane.INFORMATION_MESSAGE);
        String strc2 =JOptionPane.showInputDialog(null,"Enter coeficient c2:","input c2",JOptionPane.INFORMATION_MESSAGE);
        double a1 = Double.parseDouble(stra1);
        double b1 = Double.parseDouble(strb1);
        double c1 = Double.parseDouble(strc1);
        double a2 = Double.parseDouble(stra2);
        double b2 = Double.parseDouble(strb2);
        double c2 = Double.parseDouble(strc2);
        double D =a1*b2 - a2*b1;
        double Dx = c1*b2 - c2*b1;
        double Dy =a1*c2 -a2*c1;
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
