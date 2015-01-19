public class House {

    private String homeOwner;
    private int numBedrooms;
    private double numBathrooms;
    private boolean hasGarage;
    private static int numHouses;
    public static final String DEFAULTHOMEOWNER = "HOMEOWNER";

    public static void main(String[] args) {
        House myHouse = new House("testOwner", 2, 2.5, true);
        System.out.println(myHouse.toString());
        House myHouse2 = new House("", 3, 3.5, true);
        System.out.println(myHouse2.toString());
        House myHouse3 = new House();
        System.out.println(myHouse3.toString());
    }

    public House() {
        this(DEFAULTHOMEOWNER, 0, 0, false);
    }

    public House(String homeOwner, int numBedrooms,
        double numBathrooms, boolean hasGarage) {
        if (!homeOwner.equals("") && homeOwner != null) {
            this.homeOwner = homeOwner;
        } else {
            this.homeOwner = DEFAULTHOMEOWNER;
        }
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.hasGarage = hasGarage;
        numHouses++;
    }

    public String getOwner() {
        return homeOwner;
    }

    public void setOwner(String owner) {
        if (owner != "" || owner != null) {
            homeOwner = owner;
        } else {
            homeOwner = DEFAULTHOMEOWNER;
        }
    }

    public void buildBedroom() {
        numBedrooms++;
    }

    public String toString() {
        return "House owned by " + homeOwner + ", " + numBedrooms
            + " bed/" + numBathrooms + " bath, garage: " + hasGarage
            + ", total houses: " + numHouses;
    }

}