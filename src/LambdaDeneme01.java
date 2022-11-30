import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LambdaDeneme01 {


    public static void main(String[] args) {


        List<Integer> sayi1 = new ArrayList<>(Arrays.asList(1, 5, 8, 9, 12, 45, -52, 65));

        printElStructured(sayi1);
        System.out.println("\n************");
        printElFunctional(sayi1);
        System.out.println("\n************");
        printElFunctional1(sayi1);
        System.out.println("\n************");
        printElFunctional2(sayi1);
        System.out.println("\n************");
        printCiftElStructured(sayi1);
        System.out.println("\n************");
        printCiftElFunctional1(sayi1);
        System.out.println("\n************");
        printCiftOtcKckFunctional(sayi1);
        System.out.println("\n************");
        printCiftOtzBykFuctional(sayi1);
        System.out.println("\n************");

    }

    public static void printElStructured(List<Integer> sayi1) {
        for (Integer w : sayi1) {
            System.out.print(w + " ");
        }
    }

    public static void printElFunctional(List<Integer> sayi1) {
        sayi1.
                stream().
                forEach(System.out::print);
    }

    public static void printElFunctional1(List<Integer> sayi1) {
        sayi1.
                stream().
                forEach((t) -> System.out.println(t + " "));
    }
    public static void yazdir1(int a){
        System.out.print(a +" ");
    }
    public static void printElFunctional2(List<Integer> sayi1){
        sayi1.
                stream().
                forEach(LambdaDeneme01::yazdir1);
    }
    public static void printCiftElFunctional (List<Integer> sayi1) {
        sayi1.
                stream().
                filter(t->t % 2 ==0).
                forEach(LambdaDeneme01::yazdir1);
    }

    public static boolean ciftBul (int a){
        return (a & 2) ==0;
    }
    public static void printCiftElFunctional1 (List<Integer> sayi1) {
        sayi1.
                stream().
                filter(LambdaDeneme01::ciftBul).
                forEach(LambdaDeneme01::yazdir1);
    }

    public static void printCiftElStructured(List<Integer> sayi1){
        for (Integer w : sayi1){
            if (w%2==0){
                System.out.print(w+ "  ");
            }
        }
    }
    public static void printCiftOtcKckFunctional(List<Integer> sayi1){
        sayi1.
                stream().
                filter(t->t%2==0).
                filter(t->t<34).
                forEach(LambdaDeneme01::yazdir1);
    }

public static void printCiftOtzBykFuctional(List<Integer> sayi ){
        sayi.
                stream().
                filter(t->t %2==0 || t>34).
                forEach(LambdaDeneme01::yazdir1);
}































}