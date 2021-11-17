public class Main {
    public static void getFibanachi(int count) {
        int last = 0;
        int fibanachi = 1;
        int a;
        if (count == 0){
            System.out.println("");
        return;
        }
        else if (count == 1){
            System.out.println(last);
        return;
        }
        if(count<0){
            System.out.println("error");
            return;
        }
        System.out.println("0\n1");

        for(int i = 2;i<count;i++) {
        a = fibanachi;
        System.out.println(fibanachi = fibanachi + last);
        last = a;
    }
}

    public static void main(String[] args) {
        //Количество выводимых чисел
        int count = 2;
        getFibanachi(count);
    }
}
