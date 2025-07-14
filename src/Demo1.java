public class Demo1 {
    private int param1;
    private double param2;
    private Double param3;



    public  Demo1(int a , double b , Double c){
        this.param1 = a;
        this.param2 = b;
        this.param3 = c;

    }

    public Demo1(int a , double b){
        this.param1 = a;
        this.param2 = b;

        this.param3 = new Double(1000);

    }

    public int getParam1(){
        return this.param1;

    }
    public double getParam2(){
        return this.param2;

    }
    public Double getParam3(){
        return this.param3;

    }

    public static void main (String[] args){
        System.out.println("in");


        int p1 = 1;
        double p2 =2d;
        Double p3 = new Double(5);


        Demo1 d1 = new Demo1(1, 2d, new Double(3));

        Demo1 d2 = new Demo1(2 , 4d );

        Demo1 d3 = new Demo1(p1 * 3,p2 *3, p3);

        Demo1 d4 = new Demo1(p1*4,p2*4);

        double p2_1 = d1.getParam2();
        double p2_2 = d2.getParam2();
        double p2_3 = d3.getParam2();
        double p2_4 = d4.getParam2();

        System.out.println("p2_1 = " + p2_1);
        System.out.println("p2_2 = " + p2_2);
        System.out.println("p2_3 = " + p2_3);
        System.out.println("p2_4 = " + p2_4);
    }
}

