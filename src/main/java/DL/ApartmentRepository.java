package DL;

import domain.Apartment;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ApartmentRepository extends CrudRepository<Apartment, String> {
	List<Apartment> findByWareHouse(Boolean wearHouse);
	List<Apartment> findByLandLordID(int token);
	List<Apartment> findByPrice(int price);
	List<Apartment> findByElevator(boolean elevator);
	List<Apartment> findByFloor(int floor);
	List<Apartment> findByConstructionYear(int constructionYear);
	List<Apartment> findBySize(double size);
	List<Apartment> findByParking(boolean parking);
	List<Apartment> findByWareHouse(boolean wearHouse);
	List<Apartment> findByNumToilet(int numToilet);
	List<Apartment> findByNumRooms(int numRooms);
}
