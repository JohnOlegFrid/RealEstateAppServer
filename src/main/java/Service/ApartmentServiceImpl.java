package Service;

import DL.ApartmentRepository;
import DL.UserRepository;
import Exceptions.NotAuthorizedUser;
import Exceptions.OnlyLandLoardCanDeleteHisAprtment;
import Exceptions.UserDoesntExistException;
import domain.Apartment;
import domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {
	
    @Autowired
    private ApartmentRepository apartmentRepository;
    @Autowired
	private UserService userService;

    @Transactional
    @Override
    public List<Apartment> getAll() {
        Iterable<Apartment> l= apartmentRepository.findAll();
        List<Apartment> ans= new ArrayList<>();
        for (Apartment i : l){
            ans.add(i);

        }
        return ans;
    }


	@Override
	public void rank(String address, double rank) {
		Apartment apartment = apartmentRepository.findOne(address);
		apartment.setAvergeRank((double)rank);
		apartmentRepository.save(apartment);
	}

	@Override
	public Apartment getByAddress(String address) {
		return apartmentRepository.findOne(address);
	}

	@Override
	public List<Apartment> getByLandLordID( int token) {
		return apartmentRepository.findByLandLordID(token);

	}

	@Override
	public List<Apartment> getByPrice(int price) {
		return apartmentRepository.findByPrice(price);
	}

	@Override
	public List<Apartment> getByElevator(boolean elevator) {
		return apartmentRepository.findByElevator(elevator);
	}

	@Override
	public List<Apartment> getByFloor( int floor) {		
		return apartmentRepository.findByFloor(floor);
	}

	@Override
	public List<Apartment> getByConstructionYear( int constructionYear) {
		return apartmentRepository.findByConstructionYear(constructionYear);
	}

	@Override
	public List<Apartment> getBySize(double size) {
		return apartmentRepository.findBySize( size);
	}

	@Override
	public List<Apartment> getByParking(boolean parking) {
		return apartmentRepository.findByParking( parking);
	}

	@Override
	public List<Apartment> getByWareHouse(Boolean wearHouse) {
		return apartmentRepository.findByWareHouse(wearHouse);
	}

	@Override
	public List<Apartment>  getByNumToilet(int numToilet) {
		return apartmentRepository.findByNumToilet( numToilet);
	}

	@Override
	public List<Apartment> getByNumRooms(int numRooms) {
		return apartmentRepository.findByNumRooms( numRooms);
	}

	@Override
	public Apartment edit(Integer price, Integer floor, Boolean elevator, Integer constructionYear, Boolean wareHouse,
			String description, Double size, String address, Boolean parking, Integer numToilet, Integer numRooms,
			String landLordID, String image) {
		Apartment apt=new Apartment(price,floor,elevator,constructionYear,
        		wareHouse,description,size,address,parking,numToilet,numRooms,landLordID,image);
		if (apartmentRepository.exists(address)) {
            apartmentRepository.delete(apt);
            return apartmentRepository.save(apt);
        }
        else return null;
	}

	@Override
	public void delete(String address, String landLoardId) 
			throws OnlyLandLoardCanDeleteHisAprtment, NotAuthorizedUser {
		if(landLoardId != apartmentRepository.findOne(address).getLandLordID())
			throw new OnlyLandLoardCanDeleteHisAprtment();
		checkIsRoot(landLoardId);
		apartmentRepository.delete(address);
	}
	
	@Override
	public int getViewsForApartment(String address){
		Apartment apatrment = apartmentRepository.findOne(address);
		return apatrment.getViews();
	}


	@Override
	public void addViewToApartment(String address) {
		Apartment apatrment = apartmentRepository.findOne(address);
		apatrment.addViews();
	}


	@Override
	public Apartment addNewWithUserPermissions(Integer price, Integer floor, 
			Boolean elevator, Integer constructionYear,
			Boolean wareHouse, String description, Double size, String address, Boolean parking, Integer numToilet,
			Integer numRooms, String landLordID, String image) throws NotAuthorizedUser {
		
		checkIsRoot(landLordID);

		Apartment apt=new Apartment(price,floor,elevator,constructionYear,wareHouse,description,size,
        		address,parking,numToilet,numRooms,landLordID,image);
		return apartmentRepository.save(apt);
	}


	private void checkIsRoot(String landLordID) throws NotAuthorizedUser {
		User user = userService.getByToken(landLordID);
		if(!user.isRoot())
			throw new NotAuthorizedUser();
	}
}
 