package kinomania;
import java.util.Random;

abstract class Inhabitant {
    public int ticketsBought;
    //public String name;
    //private City whatCity;
    static protected Random rndm = new Random();
    //public static int ileSprzedanychBiletow = 0;


    public void goToCinema(int howMany, Cinema whatCinema, Movie whatMovie) {
        ticketsBought += howMany;
        //ileSprzedanychBiletow += ticketsBought;
    }

    public void writeStatistics(int i) {
        System.out.println("Inhabitant indexed as " + i + " bought " + ticketsBought + " tickets.");
    }
}
