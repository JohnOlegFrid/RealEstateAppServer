package Service;

import domain.Apartment;
import domain.ApartmentTransfor;

import java.io.IOException;
import java.util.List;

import Exceptions.NotAuthorizedUser;
import Exceptions.OnlyLandLoardCanDeleteHisAprtment;

public interface ApartmentService {
    List<? extends Apartment> getAll();
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
			String landLordID, byte[] image,boolean isRent);
	int getViewsForApartment(String address);
	void addViewToApartment(String address);
	void delete(String address, String landLoardId) throws OnlyLandLoardCanDeleteHisAprtment, NotAuthorizedUser;
	boolean delete(String address);
//	Apartment addNewWithUserPermissions(Apartment apartment) throws NotAuthorizedUser, IOException;
	Apartment addNewWithUserPermissions(ApartmentTransfor apartmente) throws NotAuthorizedUser, IOException;
}