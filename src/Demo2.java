class Box {
    int number;
}

public class Demo2 {
    public static void change(Box b) {
        b.number = 999;
    }

    public static void main(String[] args) {
        Box myBox = new Box();   // 建立 Box 物件
        myBox.number = 123;

        change(myBox);           // 傳 Box 的參考（看起來像傳址）
        System.out.println(myBox.number);  // ➜ 999
        /*「傳址」的字面解釋似乎是傳遞記憶體位址，
        但實際上是將記憶體位址參考的值傳遞給方法，
        此參考指向的是物件記憶體位置，
        因此並不是直接將記憶體位址傳遞。

        當傳入的參數若是物件參考變數或陣列，
        就可以修改指向物件的變數值，
        也可使用指向物件的其他方法與變數，
        但因為是共用同個物件實體，
        要留意資料連動產生的變化。*/
    }
}
