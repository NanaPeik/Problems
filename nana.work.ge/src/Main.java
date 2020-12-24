import java.util.*;

public class Main {

    static Boolean isPalindrome(String text) {
        int beginingIndex = 0, lastInddex = text.length() - 1;
        while (beginingIndex < lastInddex) {
            if (text.charAt(beginingIndex) != text.charAt(lastInddex))
                return false;
            beginingIndex++;
            lastInddex--;
        }
        return true;
    }
    static int minSplit(int amount) {
        int minimalAmount = 0, a;
        int coins[]={50,20,10,5,1};
        for (int coin:coins) {
            a=amount/coin;
            amount%=coin;
            minimalAmount+=a;
        }
        return minimalAmount;
    }
    static int notContains(int[] array){
        Arrays.sort(array);
        int minimal = 1;
        if(array[0] > minimal){
            return minimal;
        }else if(array[0] > 0){
            minimal++;
        }
        for(int i=1;i<array.length;i++){
            int b = array[i];
            if(minimal < b){
                return minimal;
            }else if(b > 0 && array[i-1] != b){
                    minimal++;
            }
        }
        return minimal;
    }

    static Boolean isProperly(String sequence){
        int counter=0;
        for(int i=0;i<sequence.length();i++){
            if(sequence.charAt(i)=='(' && counter>=0){
                counter++;
            }else if(sequence.charAt(i)==')'){
                if(counter<=0)
                    return false;
                counter--;
            }
        }
        if(counter==0)
            return true;
        else return false;
    }

    static int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }
    static int countVariants(int stearsCount){
        stearsCount++;
        return fib(stearsCount);
    }

    public static void main(String[] args) {
//        String str = "geeks";
//
//        if (isPalindrome(str))
//            System.out.print("Yes");
//        else
//            System.out.print("No");
//        int a[]={1,9,9,9,9,9,9,1};
//        System.out.println(notContains(a));
//        Random rand = new Random();
//        for(int i=0;i<100;i++){
//            int rand_int1 = rand.nextInt(1000);
//            if(minSplit(rand_int1)==minSplit1(rand_int1))
//                System.out.println("Yes   "+rand_int1);
//            else System.out.println("No");
//        }

//        System.out.println(minSplit(rand_int1));
//        System.out.println(minSplit1(rand_int1));
        //System.out.println(countVariants(7));

        MyDS ds = new MyDS();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
    }

}



class MyDS {
    ArrayList<Integer> arr;
    HashMap<Integer, Integer> hash;
    public MyDS() {
        arr = new ArrayList<Integer>();
        hash = new HashMap<Integer, Integer>();
    }
    void add(int x) {
        if (hash.get(x) != null)
            return;

        int s = arr.size();
        arr.add(x);

        hash.put(x, s);
    }
    void remove(int x) {
        Integer index = hash.get(x);
        if (index == null)
            return;
        hash.remove(x);

        int size = arr.size();
        Integer last = arr.get(size-1);
        Collections.swap(arr, index,  size-1);

        arr.remove(size-1);
        hash.put(last, index);
    }
    Integer search(int x)
    {
        return hash.get(x);
    }
}
