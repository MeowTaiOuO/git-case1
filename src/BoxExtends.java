public class BoxExtends <T extends Number> {
    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }


    public static void main(String[] args) {
        BoxExtends<Integer> intBox = new BoxExtends<>();
        intBox.setItem(123);
        System.out.println(intBox.getItem());


    }
}
