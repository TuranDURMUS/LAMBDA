import java.util.List;
import java.util.stream.IntStream;

public class LambdaDeneme05 {
    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaFunctional(6));
        System.out.println(toplaCift(15));
        System.out.println(toplaİlkXCift(25));
        istenenSayiIlkXKuvvetPrint(7, 3);
        System.out.println("++++++++++++++++++++");
        System.out.println(istenenSayininFactorial(9));
    }

    // soru::sturucted prg ve functional prg ile 1 den X e
    // kadar olan sayıların topl prg yaz

    public static int topla(int x) {
        int toplam = 0;
        for (int i = 0; i <= x; i++) {
            toplam = toplam + i;

        }
        return toplam;

    }

    // functional olarak
    public static int toplaFunctional(int x) {
        return IntStream.
                range(1, x + 1).
                sum();
    }

    //Soru :: 1 den X e kadar olan cift sayıların topl.

    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1, x).
                filter(Lambda01::ciftBul).
                sum();
    }

    public static int toplaİlkXCift(int x) {
        return IntStream.
                iterate(2, t -> t + 2).
                limit(x).
                sum();
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi, int x) {
        IntStream.
                iterate(istenenSayi, t -> t * istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);
    }
//Soru:: İstenen sayının faktöriyelini lan prg create ediniz.

    public static int istenenSayininFactorial(int x){
        return IntStream.
                rangeClosed(1,x).
                reduce(1,(t,u)->t*u);
    }

}















