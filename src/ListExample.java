import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;


public class ListExample {
    public static void main(String[] args) {

        List<String> fruits = new ArrayList<>();
        String []string=new String[]{};
        String str ;
        String[] abc;
        str="This is a book";
        abc = new String[3];
        abc[0]="This is a book";
        abc[2]="I hava three book";

        fruits.add("蘋果");
        fruits.add("香蕉");
        fruits.add("香蕉");


        System.out.println("第一個水果是：" + fruits.get(0));


        for (String fruit : fruits) {
            System.out.println("水果：" + fruit);
        }

        for (int i=0;i<abc.length;i++){
            try{
                System.out.println(abc[i].toString());
            }
            catch(NullPointerException n){

            }
        }
        String[] abc2=new String[fruits.size()];
        int size = fruits.size();
        for(String s : fruits){
            abc2[size-1]=s;
            size=size-1;
        }
        for (int c=0;c<abc2.length;c++){
            System.out.println(abc2[c]);
        }
        Set<String> set2 = new HashSet<String>();
        for (int h=0;h<abc.length;h++){
            if (abc[h]!=null) {
                set2.add(abc[h]);
            }
            else{

            }

        }
        for (int f=0;f<abc2.length;f++){
            set2.add(abc2[f]);
        }
        System.out.println("==========");
        for (String set3 : set2) {

            System.out.println(set3);
        }

    }
}

