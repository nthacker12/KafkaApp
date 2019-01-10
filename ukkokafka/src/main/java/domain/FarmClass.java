package domain;

import java.util.concurrent.atomic.AtomicInteger;

public class FarmClass {

    private int id;
    private String name;
    private String address;
    private float longitude;
    private float latitude;

    private static AtomicInteger ID_GENERATOR = new AtomicInteger(1000);

    public FarmClass(){

    }

    public FarmClass(String fN, String fA){
        this.id = ID_GENERATOR.getAndIncrement();
        this.name = fN;
        this.address = fA;
    }

    public int getId(){
        return id;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName(){
        return name;
    }

    public void setAddress(String a){
        this.address = a;
    }

    public String getAddress(){
        return address;
    }

    public void setLongitude(float lo){
        this.longitude = lo;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public String getLongitudeLatitude() {
        return ("Longitude: " + longitude + " Latitude: " + latitude);
    }

    @Override
    public String toString() {
        return String.format("Farm ID: %s \n Farm Name: %s \n Farm Address: %s \n Farm Longitude & Latitude: %.2f & %.2f \n",
                id, name, address, latitude, longitude);
    }
}
