import java.util.Scanner;

public class Matrix{
    private double[][] _matrix;
    private int _rows;
    public int getRows(){
        return _rows;
    }
    private void setRows(int r) throws IllegalArgumentException{
        if(r<=0)
            throw new IllegalArgumentException("Count of rows cannot be smaller than 1");
        _rows=r;
    }
    private int _columns;

    public int getColumns(){
        return _columns;
    }
    private void setColumns(int c) throws IllegalArgumentException{
        if(c<=0)
            throw new IllegalArgumentException("Count of columns cannot be smaller than 1");
        _columns=c;
    }

    public Matrix(int rows,int columns){
        setColumns(columns);
        setRows(rows);
        _matrix=new double[_rows][_columns];
    }
    public Matrix(double [][] m){
        _matrix=m;
        setColumns(m[0].length);
        setRows(m.length);
    }

    public double get(int r,int c) throws MatrixException{
        if(r>=_rows || c>=_columns || r<0 || c<0)
            throw new MatrixException("Out of range");
        return _matrix[r][c];
    }

    public void seed() throws NumberFormatException{
        var sc = new Scanner(System.in,"cp1251");
        for(int i=0;i<getRows();i++){
            for(int j=0;j<getColumns();j++){
                    _matrix[i][j] = Double.parseDouble(sc.next());
            }
        }
    }

    private int findFirstIndexEvenNumber(double[] array) throws MatrixException{
        for(int i=0;i<array.length;i++){
            if(array[i]%2==0) {
                return i;
            }
        }
        throw new MatrixException("Even number is not found");
    }

    private int indexOfMaxEvenNumberOfArray(double[] array) throws MatrixException{
        int max=findFirstIndexEvenNumber(array);
        for(int i=max+1;i<array.length;i++){
            if(array[max]<array[i] && array[i]%2==0)
                max=i;
        }
        return max;
    }

    private double[] getColumn(int c) throws MatrixException{
        double[] ar = new double[getRows()];
            for (int i = 0; i < getRows(); i++) {
                ar[i] = get(i, c);
            }
        return ar;
    }
    private double[] getColumnWithMaxEvenNumber(int mRows,int mColumns) throws MatrixException{
            for(int i=mColumns+1;i<getColumns();i++){
            try{
                if(get(mRows,mColumns)<get(indexOfMaxEvenNumberOfArray(getColumn(mColumns)),i)) {
                mRows=indexOfMaxEvenNumberOfArray(getColumn(mColumns));
                mColumns=i;
                }
            }
            catch (MatrixException e){
                continue;
            }
        }
        try {
            return getColumn(mColumns);
        }
        catch (MatrixException e) {
            throw new MatrixException("All numbers of matrix are odd");
        }
    }
    public double[] getColumnWithMaxEvenNumber() throws MatrixException{
        int maxRows=-1;
        int maxColumns=-1;
        for(int i=0;i<getColumns();i++){
            try {
                    maxRows = indexOfMaxEvenNumberOfArray(getColumn(i));
                    maxColumns = i;
                    break;
            }
            catch (MatrixException e)
            {
                continue;
            }
        }
        return getColumnWithMaxEvenNumber(maxRows,maxColumns);
    }
    @Override
    public String toString(){
        StringBuilder str= new StringBuilder();
        try {
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getColumns(); j++) {
                    str.append(get(i, j)).append(" ");
                }
                str.append("\n");
            }
        }
        catch (MatrixException e)
        {

        }
        return str.toString();
    }


}
class MatrixException extends Throwable{
    public MatrixException(String msg){
        super(msg);
    }
}
