package project;

public class Hall {
    private int number;


    public Hall(){

    }
    public Hall(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return  ""+ number ;
    }
}
