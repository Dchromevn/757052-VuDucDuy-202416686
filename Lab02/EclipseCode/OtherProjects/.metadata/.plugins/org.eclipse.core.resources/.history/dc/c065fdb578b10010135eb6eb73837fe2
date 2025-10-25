import javax.swing.JOptionPane;
public class MergeMatrices {
    public static void main(String[] args) {
        String rowStr = JOptionPane.showInputDialog("Enter number of rows:");
        if (rowStr == null) return;
        int rows = Integer.parseInt(rowStr);
        String colStr = JOptionPane.showInputDialog("Enter number of columns:");
        if (colStr == null) return;
        int cols = Integer.parseInt(colStr);
        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];
        int[][] C = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String val = JOptionPane.showInputDialog("Enter A[" + (i+1) + "][" + (j+1) + "]:");
                if (val == null) return;
                A[i][j] = Integer.parseInt(val);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String val = JOptionPane.showInputDialog("Enter B[" + (i+1) + "][" + (j+1) + "]:");
                if (val == null) return;
                B[i][j] = Integer.parseInt(val);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        String result = "Matrix C (A + B):\n";
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result += C[i][j] +"  "+ "\t";
            }
            result += "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }
}