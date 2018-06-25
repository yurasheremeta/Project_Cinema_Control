package project;

import java.util.Comparator;

public class ComparatorByHall implements Comparator<Session> {
    @Override
    public int compare(Session o1, Session o2) {
        int res = Integer.compare(o1.getHall().getNumber(), o2.getHall().getNumber());
        if(res == 0){
            res = o1.getFilm().getName().compareTo(o2.getFilm().getName());
        }
        return res;
    }
}
