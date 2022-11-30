import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class LambdaDeneme02 {

    public static void main(String [] args) {
        List<Integer> sayi =new ArrayList<>(Arrays.asList(4,2,11,-5,7,6));
        tekKupBirFazlaPrint(sayi);
        System.out.println("\n-------------------");
        ciftKarePrint(sayi);
        System.out.println("\n********************");
        maxElBul(sayi);
        System.out.println("\n--------------------");
        stuructedMaxElBul(sayi);
        System.out.println("\n********************");
        ciftKareMaxPrint(sayi);
        System.out.println("\n+++++++++++++++++++++");
        ciftKareKokPrint(sayi);
        System.out.println("\n********************");
//        tekKupBirFazlaPrint(sayi);
//        System.out.println("\n________________");
//        tekKupBirFazlaPrint(sayi);
//        System.out.println("\n********************");
//        tekKupBirFazlaPrint(sayi);

    }
    public static void tekKupBirFazlaPrint(List<Integer> sayi){
        sayi.
                stream().
                filter(t->t%2!=0).
                map(t->(t*t*t)+1).
                forEach(Lambda01::yazdir);
    }
    public static void ciftKarePrint(List<Integer> sayi){
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(t-> t*t).
                forEach(Lambda01::yazdir);

    }
    public static void ciftKareKokPrint(List<Integer> sayi) {
        sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(Math::sqrt).
                forEach(t-> System.out.print(t+"  "));

    }
    public static void maxElBul(List<Integer> sayi) {
        Optional<Integer> maxSayi =
                sayi.stream().
                        reduce(Math::max);
        System.out.println(maxSayi);
    }

    public static void stuructedMaxElBul(List<Integer> sayi){
       int max=Integer.MIN_VALUE;
        System.out.println("max="+max);
        for (int i=0; i<sayi.size();i++){
            if (sayi.get(i)>max) max=sayi.get(i);
            System.out.println("en buyuk sayı:" +max);
        }
    }

public static void ciftKareMaxPrint(List<Integer> sayi){
        System.out.println(sayi.
                stream().
                filter(Lambda01::ciftBul).
                map(a->a*a).
                reduce(Integer::max));
}













































}
