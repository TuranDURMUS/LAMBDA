import java.util.stream.IntStream;

public class Lambda05 {

    public static void main(String[] args) {
        System.out.println(topla(5));
        System.out.println(toplaCincix(5));
        System.out.println(toplaCift(4));
        System.out.println(toplaIlkXCift(4));
        System.out.println(toplaIlkXTek(3));
        ikininIlkXKuvvetPrint(3);
        System.out.println();
        istenenSayiIlkXKuvvetPrint(3,2);
        System.out.println();
        System.out.println(istenenSayiFactorial(5));


    }

        //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar (x dahil)
        // tamsayilari toplayan bir program create ediniz.

    //Structured
    public static int topla(int x) {
        int toplam =0;
        for(int i=0 ; i<=x ; i++ ) {
            toplam = toplam + i ;
        }
        return toplam;
    }

    // Functional
    public static int toplaCincix(int x) {  // List<Integer> x ---> x.stream().
        return IntStream. // int değerlerde bir akış sağlar
                range(1,x+1). // range(a,b) --> a dan b'ye kadar ( b dahil değil) int değerler akısa alındı
                sum();// akışdan gelen değerler toplandı
    }
    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir program create ediniz.
    public static int toplaCift(int x) {
        return IntStream.
                rangeClosed(1,x).
                filter(Lambda01::ciftBul).
                sum();
    }
    //TASK 03 --> Ilk x pozitif cift sayiyi toplayan program  create ediniz.
    public static int toplaCiftIlk(int x) {
        return IntStream.
                rangeClosed(1, x * 2).
                filter(Lambda01::ciftBul).
                sum();
    }
    public static int toplaIlkXCift(int x){
        return IntStream.
                iterate(2,t->t+2).// 2 den sonsuza kadar elemanları 2 artırarak akışa alır --> 2,4,6,8,..
                        limit(x). // x ile sınırlıyorum
                        sum(); // akışdan gelen bütün değerleri topluyorum

    }
    //TASK 04 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int toplaIlkXTek(int x) {
        return IntStream.
                iterate(1,t->t+2). // 1,3,5,7,9,.....
                        limit(x). // ilk x tek tamsayı ile sınırlandırıldı
                        sum();  // akışdan gelen int değerler toplandı
    }
    //TASK 05 --> 2'nin ilk pozitif x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void ikininIlkXKuvvetPrint(int x) { // 2,4,8,16,32
        IntStream.
                iterate( 2, t->t*2 ). // iterasyon için sartımızı yazdık
                limit(x). // x değeri ile sınırladık
                forEach(Lambda01::yazdir); //Lamnbda01 clasındaki yazdır() metodunu çağırarak ekrana yazdık
    }
    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini ekrana yazdiran programi  create ediniz.
    public static void istenenSayiIlkXKuvvetPrint(int istenenSayi,int x) {
        IntStream.
                iterate(istenenSayi, t->t*istenenSayi).
                limit(x).
                forEach(Lambda01::yazdir);

    }
    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan programi  create ediniz.
    // 5 --> 5*4*3*2     3 --> 3*2
    public static int istenenSayiFactorial(int x) {  // 5
        return IntStream. // int akış başladı
                rangeClosed(1,x). // rangeClosed(1,5) --> 1,2,3,4,5
                reduce(1,(t,u)->t*u);
    }


}
