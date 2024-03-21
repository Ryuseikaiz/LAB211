package View;

import Common.Validation;
import Model.Trash;

public class TrashView {
    Validation valid = new Validation();
    private int time = 0;
    private int totalWaste = 0;
    private int numOfTrucks = 0;
    static final int truckCapacity = 10_000;
    static final int costPerTruck = 57_000;
    static final int costPerHour = 120_000;
    public TrashView(){
    }
    
    public Trash createTrash() {
        int stationNumber = valid.checkInputInt("Please enter the number of trash collecting station: ", 0);
        int[] trashNumber = valid.checkInputArray("Please enter the number of trash at station: ", stationNumber);
        return new Trash(stationNumber, trashNumber);
    }

    public double CollectingTrash(Trash tc) {
        int[] TrashNumber;
        TrashNumber = tc.getTrashNumber();
        for (int j : TrashNumber) {
            if (totalWaste + j <= truckCapacity) {
                totalWaste += j;
                time += 8;
            } else {
                totalWaste = j;
                time += 38;
                numOfTrucks++;
            }
        }
        if (totalWaste > 0) numOfTrucks ++;
        time += 30;
        System.out.println("Time: " + time);
        System.out.println("Trucks: " + numOfTrucks);
        return numOfTrucks * costPerTruck + (double) (time * costPerHour) / 60;
    }
}