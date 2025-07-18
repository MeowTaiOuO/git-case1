public class Demo {
    public static void change(int x) {
        x = 100;
    }

    public static void main(String[] args) {
        int a = 10;
        change(a);               // 傳值：傳的是 10 的拷貝
        System.out.println(a);   // ➜ 印出 10（a 沒有變）

        /*傳值 (Pass By Value)
        「傳值」是將變數的值複製一份給方法用，方法獲得的是複製品，
        而非原始資料。當傳入的參數是八大基本資料型別時，像是int，
        方法裡面對參數的改變，並不會影響到原本方法外變數的值。*/
    }
    int x =0;
}
