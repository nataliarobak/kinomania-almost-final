package kinomania;

import java.util.Random;

public class Cinema {
    public Hall[] halls;
    public String name;
    public String address;
    private int hallsAmount;
    public int[] stats;
    private Random randomizer = new Random();
    //public static int ileSprzedanychBiletow = 0;

    public Cinema(String name, String address, int hallsAmount, int[] seatsForEachHall, int daysAmount) {
        this.name = name;
        this.address = address;
        this.hallsAmount = hallsAmount;

        halls = new Hall[hallsAmount]; //tu bylo hallsNr-1

        for (int i = 0; i < hallsAmount; i++) {
            halls[i] = new Hall(i+1, seatsForEachHall[i], daysAmount);
        }
    }

    public boolean isMultiplex() {
        if (hallsAmount > 1) {
            return true;
        }
        return false;
    }

    public void addRepertoire(int whichHall, Movie movie, int day) {
        halls[whichHall].addMovie(day, movie);
        //System.out.println("Dodałem film " + movie.title + " dnia " + day + " hala " + whichHall );
        //System.out.println("moviesPlayed " + halls[whichHall].moviesPlayed[day].title);
    }

    public Movie drawMovie(int day) {
        if (!isMultiplex()) {
            //System.out.println("losowanie filmu male" + halls[0].moviesPlayed[day]);
            return halls[0].moviesPlayed[day];
        } else {
            int randHall = randomizer.nextInt(halls.length);
            //System.out.println("losowanie filmu multi" + halls[randHall].moviesPlayed[day]);
            return halls[randHall].moviesPlayed[day];
        }
    }

    public Movie bestMovieToday(int day) {
        int max = 0;
        Movie tempBest = null;
        if (!isMultiplex()) {
            //System.out.println("Little, Am I here?" + halls[0].moviesPlayed[day]);
            return halls[0].moviesPlayed[day];
        }
        else {
            for (int m = 0; m < halls.length; m++) {
                if (halls[m].moviesPlayed[day].grade > max) {
                    //System.out.println("Am I here?" + halls[m].moviesPlayed[day].title);
                    tempBest = halls[m].moviesPlayed[day];
                    max = halls[m].moviesPlayed[day].grade;
                    //System.out.println("Am I here? " + tempBest);

                }
            }
            return tempBest;
        }
    }

    public boolean sellTickets(int howManyTickets, int dayNumber, Movie whatMovie) {
        for (int i = 0; i < hallsAmount; i++) {
            //System.out.println("abc " + i + " hallsNr " + hallsAmount);
            if (halls[i].sellTickets(howManyTickets, whatMovie, dayNumber)) {
                //System.out.println("sold tickets: " + howManyTickets);
                //ileSprzedanychBiletow += howManyTickets;
                return true;
            }
        }
        return false;
    }

    public void writeStats(int daysAmount) {
        System.out.println("\nCinema: " + name);
        for (int day = 0; day < daysAmount; day++) {
            System.out.println("\tStatistics for day number " + day);
            for (int hall = 0; hall < halls.length; hall++) {

                System.out.println("\t\tHall number " + hall + ", movie " + halls[hall].moviesPlayed[day].title + ", " + halls[hall].statistics(day) + " tickets sold.");
            }
        }
    }
}
