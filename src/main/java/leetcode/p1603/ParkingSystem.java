package leetcode.p1603;

public class ParkingSystem {
    private int[] resources;
    public ParkingSystem(int big, int medium, int small) {
        resources = new int[3];
        resources[0] = big;
        resources[1] = medium;
        resources[2] = small;
    }

    public boolean addCar(int carType) {
        int zeroBasedCarType = carType-1;
        if (resources[zeroBasedCarType] == 0) {
            return false;
        }
        resources[zeroBasedCarType]--;
        return true;
    }
}
