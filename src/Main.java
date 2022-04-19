public class Main {

    public static void TOne(){
        double[][] t1 = new double [][]
                {
                        {1,2,3},
                        {1,15,12},
                        {5,7,9}
                };
        double[][] t2= new double [][]
                {
                        {1,2,38},
                        {1,15,12},
                        {45,7,9}
                };
        double[][] t3 = new double [][]
                {
                        {11,2,3},
                        {1,15,129},
                        {102,7,9}
                };
        double[][] t4 = new double [][]
                {
                        {1,2,3},
                        {1,15,12},
                        {5,22,9}
                };
        var m1= new Matrix(t1);
        var m2= new Matrix(t2);
        var m3= new Matrix(t3);
        var m4= new Matrix(t4);

        try {
            ViewResult(m1.getColumnWithMaxEvenNumber());
            System.out.println(m1);
            ViewResult(m2.getColumnWithMaxEvenNumber());
            System.out.println(m2);
            ViewResult(m3.getColumnWithMaxEvenNumber());
            System.out.println(m3);
            ViewResult(m4.getColumnWithMaxEvenNumber());
            System.out.println(m4);
        }
        catch (MatrixException e){

        }
    }
    public static void ViewResult(double[] arr){
        System.out.println("------------------");
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println("------------------");
    }
    public static void Ex1(){
        System.out.println("Exception #1 -----------------");
        try {
            var mv = new Matrix(-1, 5);
        }
        catch (IllegalArgumentException e)
        {
            System.out.println("IllegalArgumentException: " +e.getMessage());
        }
    }
    public static void Ex2(){
        System.out.println("Exception #2 -----------------");
        try {
            var mv = new Matrix(4, 5).get(-1,9);
        }
        catch (MatrixException e)
        {
            System.out.println("MatrixException: " +e.getMessage());
        }
    }
    public static void Ex3(){
        System.out.println("Exception #3 -----------------");
        try {
            var o = new double[][] {
                    {1,3,5},
                    {5,7,9},
                    {11,13,15}
            };
            var mv = new Matrix(o).getColumnWithMaxEvenNumber();
        }
        catch (MatrixException e)
        {
            System.out.println("MatrixException: " +e.getMessage());
        }
    }
    public static void Ex4(){
        System.out.println("Exception #4 -----------------");
        try {
            var mv = new Matrix(2,3);
            mv.seed();
        }
        catch (NumberFormatException e)
        {
            System.out.println("NumberFormatException: " +e.getMessage());
        }
    }
    public static void main(String[] args){
        TOne();
        Ex1();
        Ex2();
        Ex3();
        Ex4();
    }
}
