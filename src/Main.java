import java.util.Random;

public class Main {

    public static void wypiszTablice(int[] tab){
        for(int i = 0; i < tab.length; i++){
            System.out.println("tab[" + i + "]: " + tab[i]);
        }
    }

    //Napisać program, który wstawia do tablicy losowo generowane tylko liczby parzyste.
    public static void pierwszeZadanie(){
        Random random = new Random();
        int[] tab = new int[15];
        for(int i = 0; i < tab.length; i++){
            tab[i] = (random.nextInt(10)+1)*2;
        }
        wypiszTablice(tab);
    }

    //Napisać program, gdzie stworzymy tablicę z liczbami od 1 do 30 (30 elementów).
    //Następnie wypisać w formie ciągu tylko te, które są podzielne przez 3, a w drugim
    //ciągu tylko te podzielne przez 9.
    public static void drugieZadanie(){
        Random random = new Random();
        int[] tab = new int[30];
        String modulo9result = "Liczby podzielne przez 9: ";
        String modulo3result = "Liczby podzielne przez 3: ";
        for (int i = 0; i < tab.length; i++) {
            tab[i] = random.nextInt(29) + 1;
            if(tab[i]%3==0){
                if(tab[i]%9==0){
                    modulo9result += tab[i] + " ";
                }
                modulo3result += tab[i] + " ";
            }
        }
        wypiszTablice(tab);
        System.out.println(modulo3result);
        System.out.println(modulo9result);
    }

    public static void trzecieZadanie(){

    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        pierwszeZadanie();
        drugieZadanie();
    }
}