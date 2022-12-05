package by.gsu.pms;

public class Car {
    private int id;
    private String brand;
    private String model;
    private int yearOfManufacture;
    private String color;
    private int price;
    private int serialNumber;

    public Car(String[] string) {
        this.id = Integer.parseInt(string[0]);
        this.brand = string[1];
        this.model = string[2];
        this.yearOfManufacture = Integer.parseInt(string[3]);
        this.color = string[4];
        this.price = Integer.parseInt(string[5]);
        this.serialNumber = Integer.parseInt(string[6]);
    }

    public Car(int id, String brand, String model, int yearOfManufacture, String color, int price, int serialNumber) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
        this.price = price;
        this.serialNumber = serialNumber;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public String getBrand() {return brand;}
    public void setBrand(String brand) {this.brand = brand;}
    public String getModel() {return model;}
    public void setModel(String model) {this.model = model;}
    public int getYearOfManufacture() {return yearOfManufacture;}
    public void setYearOfManufacture(int yearOfManufacture) {this.yearOfManufacture = yearOfManufacture;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price = price;}
    public int getSerialNumber() {return serialNumber;}
    public void setSerialNumber(int serialNumber) {this.serialNumber = serialNumber;}

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfManufacture=" + yearOfManufacture +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", serialNumber=" + serialNumber +
                '}';
    }
}
