import javax.swing.JOptionPane;
public class MultiMatrices {
    public static void main(String[] args) {
        String rowAStr = JOptionPane.showInputDialog("Enter number of rows of A:");
        if (rowAStr == null) return;
        int rowsA = Integer.parseInt(rowAStr);
        String colAStr = JOptionPane.showInputDialog("Enter number of columns of A:");
        if (colAStr == null) return;
        int colsA = Integer.parseInt(colAStr);
        String rowBStr = JOptionPane.showInputDialog("Enter number of rows of B:");
        if (rowBStr == null) return;
        int rowsB = Integer.parseInt(rowBStr);
        String colBStr = JOptionPane.showInputDialog("Enter number of columns of B:");
        if (colBStr == null) return;
        int colsB = Integer.parseInt(colBStr);
        if (colsA != rowsB) {
            JOptionPane.showMessageDialog(null, "Cannot multiply: cols of A != rows of B");
            return;
        }
        int[][] A = new int[rowsA][colsA];
        int[][] B = new int[rowsB][colsB];
        int[][] C = new int[rowsA][colsB]; 
        for (int i = 0; i < rowsA; i++)
            for (int j = 0; j < colsA; j++) {
                String val = JOptionPane.showInputDialog("Enter A[" + (i+1) + "][" + (j+1) + "]:");
                if (val == null) return;
                A[i][j] = Integer.parseInt(val);
            }
        for (int i = 0; i < rowsB; i++)
            for (int j = 0; j < colsB; j++) {
                String val = JOptionPane.showInputDialog("Enter B[" + (i+1) + "][" + (j+1) + "]:");
                if (val == null) return;
                B[i][j] = Integer.parseInt(val);
            }
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                C[i][j] = 0;
                for (int k = 0; k < colsA; k++) { 
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        String result = "Matrix C (A x B):\n";
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                result += C[i][j] +"  " +"\t";
            }
            result += "\n";
        }
        JOptionPane.showMessageDialog(null, result);
    }
}
