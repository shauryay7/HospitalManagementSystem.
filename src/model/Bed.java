package model;

public class Bed {
    private String bedId;
    private boolean isOccupied;

    public Bed(String bedId) {
        this.bedId = bedId;
        this.isOccupied = false; // By default, a bed is not occupied
    }

    public String getBedId() {
        return bedId;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void occupy() {
        isOccupied = true;
    }

    public void vacate() {
        isOccupied = false;
    }
}