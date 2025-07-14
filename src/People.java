public class People {
    public int ages;
    public String gender;

    public People(int a,String b){
        this.ages = a;
        this.gender = b;
    }

    public int getAges(){
        return ages;
    }

    public static void main(String[] args){
        int p1 = 1;
        String p2 = "HI";

        People abc = new People(1,"男性");
        People bcd = new People(10,"female");

        System.out.println(bcd);

    }
}
