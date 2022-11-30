import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    /*
   TASK :
   fields --> Universite (String)
              bolum (String)
              ogrcSayisi (int)
              notOrt (int)
              olan POJO clas craete edip main method içinde 5 farklı obj'den List create ediniz.
    */
    public static void main(String[] args) {
        Universite u01 = new Universite("bogazici", "matematik", 571, 93);
        Universite u02 = new Universite("istanbul tk", "matematik", 600, 81);
        Universite u03 = new Universite("istanbul", "hukuk", 1400, 71);
        Universite u04 = new Universite("marmara", "bilg muh", 1080, 77);
        Universite u05 = new Universite("odtu", "gemi mh", 333, 74);
        List<Universite> unv = new ArrayList<>(Arrays.asList(u01, u02, u03, u04, u05));
        System.out.println(notOrt74BykUnv(unv));
        System.out.println();
        System.out.println(matBolumVarMi(unv));
        System.out.println();
        System.out.println(ogrSayisiBykSirala(unv));
        System.out.println(matBolumSayısı(unv));
        System.out.println(ogrSayısı1050AzMinNotOrt(unv));
        System.out.println();
    }

    //task 01--> bütün Ünv. lerin notOrt'larinin 74' den buyuk oldg kontrol eden pr create ediniz.
    public static boolean notOrt74BykUnv(List<Universite> unv) {
        return unv.
                stream(). // akış sağladık   universiteler  u01, u02,u03,u04,u05
                        allMatch(t -> t.getNotOrt() > 74);
    }

    //task 02-->universite'lerde herhangi birinde "matematik" olup olmadigini
    // kontrol eden pr create ediniz.
    public static boolean matBolumVarMi(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        anyMatch(t -> t.getBolum(). // objelerin bölüm isimleri alındı
                        toLowerCase(). // bölüm isimlerindeki karakterler küçük harfe çevrildi
                        contains("mat")); // mat kelimeis var mı kontrol
    }

    //task 03-->universite'leri ogr sayilarina gore b->k siralayiniz.
    public static List<Universite> ogrSayisiBykSirala(List<Universite> unv) {
        return unv.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                // universiteler öğrenci sayısına göre terden sıralandı
                        collect(Collectors.toList()); // Stream yapısı List yapısına dönüştürüldü
    }

//S4::/:: matematik bölümlerini sayısını print et

    public static int matBolumSayısı(List<Universite> unv) {
        return (int) unv.
                stream().
                filter(t -> t.getBolum().
                        contains("mat")).
                count();
    }

    //S5:: ogrenci sayıları 550 den fazla olanların en buyuk not ort bul


    public static OptionalInt ogrSayısı500denBykNotortEnByk(List<Universite> unv) {

        return unv.
                stream().
                filter(t -> t.getOgrSayisi() > 550).
                mapToInt(t -> t.getNotOrt()).
                max();

    }
// ogrenci sayıları 1050 den az olanların not ort en kck olan

    public static OptionalInt ogrSayısı1050AzMinNotOrt(List<Universite> unv) {
      return  unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1050).
                mapToInt(t->t.getNotOrt()).
                min();


    }

}