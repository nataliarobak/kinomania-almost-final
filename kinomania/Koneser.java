package kinomania;

public class Koneser extends Inhabitant {

    public Movie chooseMovie(Movie[] movies) {
        int maxGrade = 0;
        Movie m = null;
        for (int i = 0; i < movies.length; i++) {
            if (movies[i].grade > maxGrade) {
                maxGrade = movies[i].grade;
                m = movies[i];
            }
        }
        return m;
    }


}
