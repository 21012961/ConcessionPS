package sg.edu.rp.c346.id21012961.concessionps;

public class Concession_Details {

    private float hybrid;
    private float train;
    private float bus;
    private int id;
    private String cardholder;

    public Concession_Details(String cardholder, int id, float hybrid, float bus, float train) {
        this.hybrid = hybrid;
        this.train = train;
        this.bus = bus;
        this.id = id;
        this.cardholder = cardholder;
    }

    public float getHybrid() {
        return hybrid;
    }

    public void setHybrid(float hybrid) {
        this.hybrid = hybrid;
    }

    public float getTrain() {
        return train;
    }

    public void setTrain(float train) {
        this.train = train;
    }

    public float getBus() {
        return bus;
    }

    public void setBus(float bus) {
        this.bus = bus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardholders() {
        return cardholder;
    }

    public void setCardholders(String cardholders) {
        this.cardholder = cardholder;
    }

    @Override
    public String toString() {
        return "Records:\n"
                + "Cardholders: " + cardholder + "\n"
                + "ID: " + id + "\n"
                + "Hybrid Price: " + hybrid + "\n"
                + "Bus Price: " + bus + "\n"
                + "Train Price: " + train + "\n";
    }
}
