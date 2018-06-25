package project;

import java.util.Comparator;

public class ComparatorByName implements Comparator<Session> {
    @Override
    public int compare(Session o1, Session o2) {
        return o1.getFilm().getName().compareTo(o2.getFilm().getName());
    }
}
