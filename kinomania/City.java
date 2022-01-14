package kinomania;
import java.util.Random;

public class City {
    public String cityName;
    private Inhabitant[] inhabitants;
    public Cinema[] cinemas;
    public Movie[] movies;
    private Random randomizer = new Random();


    public void initData(int howManyDays) {
        /*inhabitants = new Inhabitant[6];
        inhabitants[0] = new Koneser();
        inhabitants[1] = new Koneser();
        inhabitants[2] = new Kinoman();
        inhabitants[3] = new Koneser();
        inhabitants[4] = new Kinoman();
        inhabitants[5] = new OkazjonalnyWidz();*/


        inhabitants = new Inhabitant[21];
        inhabitants[0] = new Kinoman();
        inhabitants[1] = new Koneser();
        inhabitants[2] = new Kinoman();
        inhabitants[3] = new OkazjonalnyWidz();
        inhabitants[4] = new Koneser();
        inhabitants[5] = new Koneser();
        inhabitants[6] = new Kinoman();
        inhabitants[7] = new OkazjonalnyWidz();
        inhabitants[8] = new Other();
        inhabitants[9] = new Koneser();
        inhabitants[10] = new Kinoman();
        inhabitants[11] = new Kinoman();
        inhabitants[12] = new Kinoman();
        inhabitants[13] = new Koneser();
        inhabitants[14] = new Kinoman();
        inhabitants[15] = new OkazjonalnyWidz();
        inhabitants[16] = new Kinoman();
        inhabitants[17] = new Koneser();
        inhabitants[18] = new Kinoman();
        inhabitants[19] = new OkazjonalnyWidz();
        inhabitants[20] = new Koneser();


        int moviesNumber = 12; //if changing this number, remember to change titles and grades, too
        movies = new Movie[moviesNumber];
        String[] moviesTitles = {"Bolt", "Ice Age: 3", "Frozen", "The Godfather 1", "Forrest Gump", "Notting Hill", "Star Trek: The Next Generation", "Diune", "Star Wars I", "Chocolate", "Whatever", "Some Film"};
        int[] grades = {6, 5, 7, 9, 9, 8, 7, 6, 5, 3, 1, 7};
        //int[] grades = {9, 9, 9, 9, 9, 10, 9, 10, 9, 9, 9, 9};
        //int[] grades = {0, 1, 4};

        for (int i = 0; i < moviesNumber; i++) {
            movies[i] = new Movie();
            movies[i].title = moviesTitles[i];
            movies[i].grade = grades[i];
        }

        int cinemasNumber = 4; //if changing this number, remember to change names, addresses, hallsNr, seatsArr, too
        cinemas = new Cinema[cinemasNumber];
        String[] names = {"Multi 1", "Little 1", "Little 2", "Multi 2"};
        //String[] names = {"Little 1", "Multi 1"};
        String[] addresses = {"abc", "def", "ghi", "jkl"};
        int[] hallsNumbers = {4, 1, 1, 3};
        //int[][] seatsArr = {{30}, {20, 15, 30, 10}};
        int[][] seatsArr = {{20, 15, 30, 10}, {30}, {40}, {10, 20, 30}};

        for (int cn = 0; cn < cinemas.length; cn++)  {
            cinemas[cn] = new Cinema(names[cn], addresses[cn], hallsNumbers[cn], seatsArr[cn], howManyDays);
            for (int hl = 0; hl < cinemas[cn].halls.length; hl++) {
                for (int day = 0; day < howManyDays; day++) {
                    int randomMovie = randomizer.nextInt(movies.length);
                    cinemas[cn].addRepertoire(hl, movies[randomMovie], day);
                }
            }
        }

        /*for (int day = 0; day < howManyDays; day++) {
            for (int cn = 0; cn < cinemasNumber; cn++) {
                cinemas[cn] = new Cinema(names[cn], addresses[cn], hallsNumbers[cn], seatsArr[cn], howManyDays);
                for (int hll = 0; hll < cinemas[cn].halls.length; hll++) {
                    int randomMovie = randomizer.nextInt(movies.length);
                    //System.out.println("Day " + day + ": cinema " + cinemas[cn].name + "- hall nr " + hll + "- movie "+ movies[randomMovie].title);
                    cinemas[cn].addRepertoire(hll, movies[randomMovie], day);
                    //System.out.println("Dodalem se film " + movies[randomMovie].title);
                }
            }
        } */
/*
        cinemas[0].addRepertoire(0, movies[0], 0);
        cinemas[0].addRepertoire(1, movies[1], 0);
        cinemas[0].addRepertoire(2, movies[2], 0);
        cinemas[0].addRepertoire(3, movies[3], 0);
        cinemas[1].addRepertoire(0, movies[4], 0);
        cinemas[2].addRepertoire(0, movies[5], 0);
        cinemas[3].addRepertoire(0, movies[6], 0);
        cinemas[3].addRepertoire(1, movies[7], 0);
        cinemas[0].addRepertoire(0, movies[8], 1);
        cinemas[0].addRepertoire(1, movies[9], 1);
        cinemas[0].addRepertoire(2, movies[10], 1);
        cinemas[0].addRepertoire(3, movies[11], 1);
        cinemas[1].addRepertoire(0, movies[11], 1);
        cinemas[2].addRepertoire(0, movies[10], 1);
        cinemas[3].addRepertoire(0, movies[9], 1);
        cinemas[3].addRepertoire(1, movies[8], 1);
        cinemas[0].addRepertoire(0, movies[7], 2);
        cinemas[0].addRepertoire(1, movies[6], 2);
        cinemas[0].addRepertoire(2, movies[5], 2);
        cinemas[0].addRepertoire(3, movies[4], 2);
        cinemas[1].addRepertoire(0, movies[3], 2);
        cinemas[2].addRepertoire(0, movies[2], 2);
        cinemas[3].addRepertoire(0, movies[1], 2);
        cinemas[3].addRepertoire(1, movies[0], 2);
        cinemas[0].addRepertoire(0, movies[4], 3);
        cinemas[0].addRepertoire(1, movies[7], 3);
        cinemas[0].addRepertoire(2, movies[2], 3);
        cinemas[0].addRepertoire(3, movies[1], 3);
        cinemas[1].addRepertoire(0, movies[0], 3);
        cinemas[2].addRepertoire(0, movies[10], 3);
        cinemas[3].addRepertoire(0, movies[8], 3);
        cinemas[3].addRepertoire(1, movies[11], 3);


 */
    }

    public void writeRep(int howManyDays) {
        for (int day = 0; day < howManyDays; day++) {
            for (int cn = 0; cn < cinemas.length; cn++) {
                for (int hll = 0; hll < cinemas[cn].halls.length; hll++) {
                    //int randomMovie = randomizer.nextInt(movies.length);
                    System.out.println("Day " + day + ": cinema " + cinemas[cn].name + "- hall nr " + cinemas[cn].halls[hll].number + "- movie "+ cinemas[cn].halls[hll].moviesPlayed[day].title);
                    //cinemas[cn].addRepertoire(hll, movies[randomMovie], day);
                } } }
    }

    public void runSimulation(int howManyDays) {
        for (int day = 0; day < howManyDays; day++) {
            //System.out.println("run for day: " + day);
            for (int i = 0; i < inhabitants.length; i++) {
                //System.out.println("run inhabitant: " +inhabitants[i] + " day "+ day);
                if (inhabitants[i].getClass() == Koneser.class) {
                    //System.out.println("run for koneser");
                    Movie m = bestMovieInTheCity(day);
                    //System.out.println("elelelelelelel");
                    if (m != null) {
                        boolean success = false;
                        int c = 0;
                        //System.out.println("If");
                        while (c < cinemas.length && !success) { //&&?
                            success = cinemas[c].sellTickets(1, day, m);
                            //System.out.println("Hello " + cinemas[c].name + " success: " + success);
                            if (success) {
                                inhabitants[i].goToCinema(1, cinemas[c], m);
                            }
                            c += 1;
                        }
                    }
                }
                else if (inhabitants[i].getClass() == Kinoman.class) {
                    //System.out.println("run for kinoman");
                    if (day % 3 == ((Kinoman)inhabitants[i]).startDay) {
                        int randomForCinema = randomizer.nextInt(cinemas.length);
                        int randomForGuests = randomizer.nextInt(8) + 1;
                        //int randomForMovies = randomizer.nextInt(movies.length);
                        if (cinemas[randomForCinema].sellTickets(randomForGuests, day, cinemas[randomForCinema].drawMovie(day))) {
                            //System.out.println("wywołanie sell tickets w kinomanie");
                            inhabitants[i].goToCinema(randomForGuests, cinemas[randomForCinema], cinemas[randomForCinema].drawMovie(day));
                        }
                    }
                }
                else if (inhabitants[i].getClass() == OkazjonalnyWidz.class) {
                    //System.out.println("run for okazjonalny");
                    if (((OkazjonalnyWidz)inhabitants[i]).isGoingToCinemaToday()) {
                        //System.out.println("wywołanie sell tickets w okazjonalnym");
                        int randomForCinema2 = randomizer.nextInt(cinemas.length);
                        //int randomForMovie2 = randomizer.nextInt(movies.length);
                        if (cinemas[randomForCinema2].sellTickets(1, day, cinemas[randomForCinema2].drawMovie(day))) {
                            inhabitants[i].goToCinema(1, cinemas[randomForCinema2], cinemas[randomForCinema2].drawMovie(day));
                        }
                    }
                }
                else if (inhabitants[i].getClass() == Other.class) {
                    inhabitants[i].goToCinema(0,null,null);
                }
            }
        }
        //System.out.println("cinema " + Cinema.ileSprzedanychBiletow);
        //System.out.println("inhab " + Inhabitant.ileSprzedanychBiletow);
    }

    public Movie bestMovieInTheCity(int day) {
        int max = 0;
        Movie tempBest = null;
        //System.out.println("movie is null");
        for (int c = 0; c < cinemas.length; c++) {
            //System.out.println("for in bmitc");
            if (cinemas[c].bestMovieToday(day).grade > max) {
                //System.out.println("if");
                tempBest = cinemas[c].bestMovieToday(day);
                max = cinemas[c].bestMovieToday(day).grade;
            }
        }
        return tempBest;
    }

    public void writeStatisticsCity(int daysAmount) {
        for (int inhab = 0; inhab < inhabitants.length; inhab++) {
            inhabitants[inhab].writeStatistics(inhab);
        }
        for (int c = 0; c < cinemas.length; c++) {
            cinemas[c].writeStats(daysAmount);
        }
    }
}
