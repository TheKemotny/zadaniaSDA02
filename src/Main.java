import java.util.Random;

public class Main {
    public static void pierwszeZadanie(){
        Random random = new Random();
        int[] tab = new int[15];
        for(int i = 0; i < tab.length; i++){
            tab[i] = (random.nextInt(10)+1)*2;
        }

        for(int i = 0; i < tab.length; i++){
            System.out.println("tab[" + i + "]: " + tab[i]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        pierwszeZadanie();
    }
}