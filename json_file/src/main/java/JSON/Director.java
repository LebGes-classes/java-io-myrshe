package JSON;

public class Director {
    private String name;
    private Film film;
    public String getName() {
        return name;
    }
    public Film getFilm() {
        return film;
    }
    public Director(String name, Film film) {
        this.name = name;
        this.film = film;
    }
    @Override
    public String toString() {
        return "Имя - " + name + " ,фильм - " + film;
    }
}
