import java.util.*;
import java.util.stream.Collectors;

public class LambdaDeneme04 {

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

        System.out.println(notOrtByk75Unv(unv));
        System.out.println("+++++++++++++++++");
        System.out.println(MatDersiVarMi(unv));
        System.out.println("++++++++++++++++++");
        System.out.println(ogrSayisiByktenKckeSirala(unv));
        System.out.println("++++++++++++++++++++");
        System.out.println(matBlmSayisi(unv));
        System.out.println("+++++++++++++++++++++");
        System.out.println(ogrSayisiByk550EnYkskNotOrtBul(unv));
        System.out.println("++++++++++++++++++++++");
        System.out.println(ogrSayisiBKck1050EnKckNotOrtBul(unv));
    }
    // Soru 1: Üniversitelerin not ort 74 ten büyük olduğunu kontrol eden List yapalım

    public static boolean notOrtByk75Unv(List<Universite> unv) {

        return unv.
                stream().
                allMatch(t -> t.getNotOrt() > 74);
    }
    //sor 2::Üniversitelerin herhangi birinde matematik dersi varmı yokmu
    // kontrol eden program creat ediniz.

    public static boolean MatDersiVarMi(List<Universite> unv) {
        return unv.
                stream().
                anyMatch(t -> t.getBolum().toLowerCase().contains("mat"));
    }
// soru 3:: unileri öğr sayılarına göre byk ten kck e sırala

    public static List<Universite> ogrSayisiByktenKckeSirala(List<Universite> unv) {

        return unv.
                stream().
                sorted(Comparator.comparing(Universite::getOgrSayisi).reversed()).
                collect(Collectors.toList());

    }

    public static int matBlmSayisi(List<Universite> unv) {
        return (int) unv.
                stream().
                filter(t -> t.getBolum().contains("mat")).
                count();

    }
//soru::ogr sayısı 550 den buyk olanlardan en buyuk not ort olanı bul


    public static OptionalInt ogrSayisiByk550EnYkskNotOrtBul(List<Universite> unv) {

        return unv.
                stream().
                filter(t -> t.getOgrSayisi() > 550).
                mapToInt(t -> t.getNotOrt()).max();
    }

    //Soru :: ogr sayıları 1050 den az olanların en kck not ort bul
    public static OptionalInt ogrSayisiBKck1050EnKckNotOrtBul(List<Universite> unv) {

        return unv.
                stream().
                filter(t -> t.getOgrSayisi() < 1050).
                mapToInt(t -> t.getNotOrt()).min();


    }
}