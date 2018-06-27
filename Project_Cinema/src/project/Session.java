package project;

import java.time.LocalDateTime;
import java.util.Date;

public class Session {
    private Film film;
    private Hall hall;
    private LocalDateTime date;

    public Session(){

    }
    public Session(Film film, Hall hall , LocalDateTime date) {
        this.film = film;
        this.hall = hall;
        this.date = date;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Session{" +
                "film='" + film + '\'' +
                ", hall='" + hall + '\'' +
                ", date=" + date +
                "}\n";
    }
}
