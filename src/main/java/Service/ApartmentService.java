package Service;

import domain.Apartment;
import java.util.List;

import Exceptions.NotAuthorizedUser;
import Exceptions.OnlyLandLoardCanDeleteHisAprtment;

public interface ApartmentService {
    List<Apartment> getAll();
//    Apartment addNew(Apartment apt);
	void rank(String address, double rank);
	Apartment getByAddress(String address);
	List<Apartment> getByPrice(int price);
	List<Apartment> getByElevator(boolean elevator);
	List<Apartment> getByFloor(int floor);
	List<Apartment> getByConstructionYear(int constructionYear);
	List<Apartment> getBySize(double size);
	List<Apartment> getByParking(boolean parking);
	List<Apartment> getByWareHouse(Boolean wareHouse);
	List<Apartment> getByNumToilet(int numToilet);
	List<Apartment> getByNumRooms(int numRooms);
	List<Apartment> getByLandLordID(int token);
	Apartment edit(Integer price, Integer floor, Boolean elevator, Integer constructionYear, Boolean wareHouse,
			String description, Double size, String address, Boolean parking, Integer numToilet, Integer numRooms,
			String landLordID, String image);
//	Apartment addNew(Integer price, Integer floor, Boolean elevator, Integer constructionYear, Boolean wareHouse,
//			String description, Double size, String address, Boolean parking, Integer numToilet, Integer numRooms,
//			String landLordID, String image);
	int getViewsForApartment(String address);
	void addViewToApartment(String address);
	Apartment addNewWithUserPermissions(Integer price, Integer floor, Boolean elevator, Integer constructionYear,
			Boolean wareHouse, String description, Double size, String address, Boolean parking, Integer numToilet,
			Integer numRooms, String landLordID, String image) throws NotAuthorizedUser;
	void delete(String address, String landLoardId) throws OnlyLandLoardCanDeleteHisAprtment, NotAuthorizedUser;

}