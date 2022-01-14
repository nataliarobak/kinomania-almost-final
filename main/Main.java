package main;
import kinomania.City;
import kinomania.Movie;

public class Main {
    public static void main(String[] args) {

        City Gorlice = new City();
        Gorlice.cityName = "Gorlice";
        Gorlice.initData(10);
        //Gorlice.writeRep(4);
        Gorlice.runSimulation(10);
        Gorlice.writeStatisticsCity(10);

    }
}
