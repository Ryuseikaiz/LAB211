package Model;

public class Trash {
    private int[] trashNumber;
    private int stationNumber;

    public Trash(int stationNumber, int[] trashNumber) {
        this.stationNumber = stationNumber;
        this.trashNumber = trashNumber;
    }

    public int[] getTrashNumber() {
        return trashNumber;
    }

    public void setTrashNumber(int[] trashNumber) {
        this.trashNumber = trashNumber;
    }

    public int getStationNumber() {
        return stationNumber;
    }

    public void setStationNumber(int stationNumber) {
        this.stationNumber = stationNumber;
    }
}