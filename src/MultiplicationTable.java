import java.io.*;

public class MultiplicationTable {
     int a;
    static double b;
    byte c;
    boolean d;
    float e;
    short f;
    char g;
    long h;

    public long geth(String innerP) {
        long re;

        re = this.h;

        return re;
    }

    public int tranning(int a , int a2){
        int total = a+a2;

        return  total;
    }


    public static void main(String[] args) throws FileNotFoundException {
        MultiplicationTable abce  = new MultiplicationTable();
        int a1 = abce.a +1 ;

        double d2 = MultiplicationTable.b;


        int[][] table = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                table[i][j] = (i + 1) * (j + 1);
            }
        }
        PrintStream printStream = new PrintStream(new FileOutputStream("C:/Users/user/Desktop/Table.txt"));
        for (int group = 0; group < 3; group++) {
            int x1 = group;
            int x2 = group + 3;
            int x3 = group + 6;

            for (int i = 0; i < 9; i++) {
                printStream.printf("%d × %d = %-2d ", x1 + 1, i + 1, table[x1][i]);
                printStream.printf("%d × %d = %-2d ", x2 + 1, i + 1, table[x2][i]);
                printStream.printf("%d × %d = %-2d ", x3 + 1, i + 1, table[x3][i]);
                printStream.println();
            }
            printStream.println();
        }

        printStream.close();
        Double d = new Double("1.2");
        double c = d.doubleValue();


        int a;
        double b;


        float e;
        short f;
        char g;
        long h;

    }
}



