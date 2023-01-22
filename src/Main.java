import java.util.Random;
import java.util.Scanner;

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
                    modulo9result += (tab[i] + " ");
                }
                modulo3result += (tab[i] + " ");
            }
        }
        wypiszTablice(tab);
        System.out.println(modulo3result);
        System.out.println(modulo9result);
    }

    public static void trzecieZadanie(){

    }

    //Napisać program, gdzie mamy tablicę 7 Stringów “Ala” , “ma”, “kota”, “a”, “on”,
    //“ma”,”ja”. Użytkownik może podać 2 inty, które przyjmują wartość od 0 do 6, a na tej
    //podstawie wyciągane są z tablicy Stringi spod tych indeksów, a następnie należy je
    //połączyć i wypisać.
    public static void czwarteZadanie(String stringDoRozbicia){
        String[] tabZdania = stringDoRozbicia.split(" ");
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int indeksyOdUzytkownika;
        for(int i = 0; i < 2; i++){
            System.out.println("Podaj indeks z jakiego chcesz pobrac Stringi: ");
            try{
                indeksyOdUzytkownika = scanner.nextInt();
            }catch (Exception e){
                indeksyOdUzytkownika = -1;
                scanner.nextLine();
            }
            switch (indeksyOdUzytkownika){
                default -> {
                    //poza zakresem
                }
                case 0,1,2,3,4,5,6 ->{
                    result = result.concat(tabZdania[indeksyOdUzytkownika]);
                }
            }
        }
        System.out.println(result);
    }

    //Napisać program, który pobiera od użytkownika liczbę całkowitą, a następnie: oblicza
    //sumę cyfr tej liczby. (Podpowiedź - zamiana inta na Stringa Integer. toString(int) )
    public static void piateZadanie(){
        Scanner scanner = new Scanner(System.in);
        int liczbaUzytkownika;
        System.out.println("Podaj liczbe, abym zsumowal cyfry: ");
        try{
            liczbaUzytkownika = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
            System.out.println("Nie podales liczby");
            return;
        }
        int suma = 0;
        int liczbaUzytkownikaAleBezwgledna = Math.abs(liczbaUzytkownika);
        while(liczbaUzytkownikaAleBezwgledna != 0){
            suma += (liczbaUzytkownikaAleBezwgledna%10);
            liczbaUzytkownikaAleBezwgledna /= 10;
        }
        System.out.println("Liczba " + liczbaUzytkownika + ", a suma cyfr tej liczby to " + suma );
    }

    public static void piateZadanieAleZPodpowiedzi(){
        Scanner scanner = new Scanner(System.in);
        int liczbaUzytkownika;
        System.out.println("Podaj liczbe, abym zsumowal cyfry: ");
        try{
            liczbaUzytkownika = scanner.nextInt();
        }catch (Exception e){
            scanner.nextLine();
            System.out.println("Nie podales liczby");
            return;
        }
        String liczbaDoStringa = Integer.toString(liczbaUzytkownika);
        int suma = 0;
        if(liczbaUzytkownika < 0){
            liczbaDoStringa = liczbaDoStringa.substring(1);
        }
        for(int i = 0; i < liczbaDoStringa.length(); i++){
            suma += Character.getNumericValue(liczbaDoStringa.charAt(i));
        }
        System.out.println("Liczba " + liczbaUzytkownika + ", a suma cyfr tej liczby to " + suma );
    }

    public static void main(String[] args) {
        pierwszeZadanie();
        drugieZadanie();
        trzecieZadanie();
        czwarteZadanie("Ala ma kota a on ma ja");
        piateZadanie();
        piateZadanieAleZPodpowiedzi();
    }
}