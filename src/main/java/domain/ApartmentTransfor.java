package domain;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ApartmentTransfor extends Apartment{

    
//    private String address;
//    private String landLordID;
//    private int price;
//    private int floor;
//    private boolean elevator;
//    private int constructionYear;
//    private boolean wareHouse;
//    private String description;
//    private double size;
//    private double averageRank;
//    private int numOfRankers;
//    private boolean parking;
//    private int numToilet;
//    private int numRooms;
    private String image;
//	private int views;
//	private boolean isRent;
//	private FileOutputStream file;
    public ApartmentTransfor() {}

    public ApartmentTransfor(Apartment apartment) {
		super();
		super.address = apartment.getAddress();
		super.landLordID = apartment.getLandLordID();
		super.price = apartment.getPrice();
		super.floor = apartment.getFloor();
		super.elevator = apartment.getElevator();
		super.constructionYear = apartment.getConstructionYear();
		super.wareHouse = apartment.getWareHouse();
		super.description = apartment.getDescription();
		super.size = apartment.getSize();
		super.averageRank = apartment.getAverageRank();
		super.numOfRankers = apartment.getNumOfRankers();
		super.parking = apartment.getParking();
		super.numToilet = apartment.getNumToilet();
		super.numRooms = apartment.getNumRooms();
		this.views = apartment.getViews();
		super.isRent = apartment.getIsRent();
    	Path path = Paths.get(address);
		byte[] data = null;
    	try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {}
    	image = new String(data);
    	
	}
    
    

	public ApartmentTransfor(Integer price, Integer floor, Boolean elevator, Integer constructionYear,
    		Boolean wareHouse, String description, Double size, String address,
    		Boolean parking, Integer numToilet, Integer numRooms, String landLordID,boolean isRent) {
       super(price,floor,elevator,constructionYear,wareHouse,description,size,address,parking,numToilet,numRooms,landLordID,isRent);
       Path path = Paths.get(address);
		byte[] data = null;
		try {
			data = Files.readAllBytes(path);
		} catch (IOException e) {}
		image = new String(data);
	}
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}