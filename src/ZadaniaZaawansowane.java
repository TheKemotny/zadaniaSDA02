import java.util.Random;
import java.util.Scanner;

public class ZadaniaZaawansowane {
    public static int[][] losujTabliceDwuWymiarowa(int dolnyZakres, int gornyZakres, int szerokosc, int wysokosc){
        Random random = new Random();
        int[][] resultTab = new int[wysokosc][szerokosc];
        for(int i = 0; i < resultTab.length; i ++){
            for(int j = 0; j < resultTab[i].length; j++){
                resultTab[i][j] = random.nextInt(gornyZakres - dolnyZakres+1)+dolnyZakres;
            }
        }
        return resultTab;
    }

    public static int[] losujTablice(int dolnyZakres, int gornyZakres, int chcianyRozmiarTablicy){
        int[] resultTab = new int[chcianyRozmiarTablicy];
        Random random = new Random();
        for(int i = 0; i < resultTab.length; i++){
            resultTab[i] = random.nextInt(1 + gornyZakres - dolnyZakres) + dolnyZakres;
        }
        return resultTab;
    }

    public static void wypiszTablice(int[] tablicaDoWypisania){
        for (int elementTablicy : tablicaDoWypisania) {
            System.out.print(elementTablicy + "\t");
        }
        System.out.println();
    }

    public static void wypiszTabliceDwyWymierowa(int[][] tablicaDoWypisania){
        for (int i = 0; i < tablicaDoWypisania.length; i++) {
            for (int j = 0; j < tablicaDoWypisania[i].length; j++) {
                System.out.print(tablicaDoWypisania[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void wypiszTabliceDwyWymierowa(char[][] tablicaDoWypisania){
        for (int i = 0; i < tablicaDoWypisania.length; i++) {
            for (int j = 0; j < tablicaDoWypisania[i].length; j++) {
                System.out.print(tablicaDoWypisania[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static int uzytkownikuPodajLiczbe(String wiadomoscDlaUzytkownika){
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        boolean isCorrect;
        do{
            System.out.println(wiadomoscDlaUzytkownika);
            try {
                result = scanner.nextInt();
                isCorrect = true;
            }catch (Exception e){
                scanner.nextLine();
                System.out.println("Nie podaleś liczby, spróbuj jeszcze raz: ");
                isCorrect = false;
            }
        }while (!isCorrect);
        return result;
    }

    public static void piewszeZadanie(int[] tab){
        int iloscLiczbParzystych = 0;
        for(int i = 0; i < tab.length; i++){
            if(tab[i]%2==0) iloscLiczbParzystych++;
        }
        int i = 0;
        int j = i + 1;
        while(i != iloscLiczbParzystych){
            if(tab[i]%2==0){
                i++;
                j = i + 1;
            } else if (j < tab.length) {
                int temp = tab[i];
                tab[i] = tab[j];
                tab[j] = temp;
                j++;
            }
        }
    }

    public static int[] drugieZadanie(int[][] tab){
        int[] resultTab = new int[tab.length];
        int maxWiersza = 0;
        for(int i = 0; i < tab.length; i++){
            for(int j = 0; j < tab[i].length;j++){
                if(tab[i][j] > maxWiersza) maxWiersza = tab[i][j];
            }
            resultTab[i] = maxWiersza;
            maxWiersza = 0;
        }
        return resultTab;
    }

    public static void trzecieZadanie(int[][] tab){
        int[] maxWWierszach = drugieZadanie(tab);
        int maxLiczbaWTablicy = 0;
        for(int i = 0; i < maxWWierszach.length;i++){
            if(maxLiczbaWTablicy < maxWWierszach[i]) maxLiczbaWTablicy = maxWWierszach[i];
        }
        wypiszTabliceDwyWymierowa(tab);
        int[] resultTab = new int[maxLiczbaWTablicy+1];
        for(int i = 0; i < tab.length; i ++){
            for(int j = 0; j < tab[i].length; j++){
                resultTab[tab[i][j]]++;
            }
        }
        for (int i = 0; i < resultTab.length; i++) {
            System.out.println("Ilość " + i + " w tablicy to " + resultTab[i]);
        }
    }

    public static void czwarteZadanie(){
        char[][] tab = new char[5][5];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                tab[i][j] = 'X';
            }
        }
        wypiszTabliceDwyWymierowa(tab);
        int x, y;
        boolean isOutBounds;
        for(int i = 0; i < 3; i++){
            do {
                isOutBounds = false;
                x = uzytkownikuPodajLiczbe("PODAJ KOLUMNE: ");
                if(x >= 0 && x < 5){
                    y = uzytkownikuPodajLiczbe("PODAJ WIERSZ: ");
                    if(y >= 0 && y < 5){
                        tab[y][x] = 'O';
                    }else{
                        isOutBounds = true;
                        System.out.println("COS NIE TAK. WPROWADZ PONOWNIE.");
                    }
                }else {
                    isOutBounds = true;
                    System.out.println("COS NIE TAK. WPROWADZ PONOWNIE.");
                }
            }while(isOutBounds);
            wypiszTabliceDwyWymierowa(tab);
        }
    }

    public static void drugieZadaniePomocniczne(){
        int[][] tablicaDoDrugiegoZadania = losujTabliceDwuWymiarowa(0,25,6,6);
        int[] tablicaWynikowaDlaDrugiegoZadania = drugieZadanie(tablicaDoDrugiegoZadania);
        wypiszTabliceDwyWymierowa(tablicaDoDrugiegoZadania);
        for (int i = 0; i < tablicaWynikowaDlaDrugiegoZadania.length; i++) {
            System.out.println("MAKSYMALNA LICZBA W "+ i + " WIERSZU TO " + tablicaWynikowaDlaDrugiegoZadania[i]);
        }
    }

    public static void main(String[] args) {
        int[] exampleToPierwszego = {5,4,8,7,9,1,2,3};
        int[] randomowaTablica = losujTablice(0,5, 20);
        wypiszTablice(randomowaTablica);
        piewszeZadanie(randomowaTablica);
        wypiszTablice(randomowaTablica);
        drugieZadaniePomocniczne();
        int[][] tablicaDoTrzeciegoZadania = losujTabliceDwuWymiarowa(0,20,6,6);
        int[][] exampleDoTrzeciego = {{2,3,4},{5,2,3},{6,7,8}};
        trzecieZadanie(exampleDoTrzeciego);
        czwarteZadanie();

    }
}
