public class CarsShop {
    private String carName;
    private int dateOfPublication;
    private int maxSpeed;
    private String type;
    private char rudderPosition;

    public CarsShop(String carName, int dateOfPublication, String type, char rudderPosition) {
        this.carName = carName;
        this.dateOfPublication = dateOfPublication;
        this.type = type;
        this.rudderPosition = rudderPosition;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(int dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getRudderPosition() {
        return rudderPosition;
    }

    public void setRudderPosition(char rudderPosition) {
        this.rudderPosition = rudderPosition;
    }
}
