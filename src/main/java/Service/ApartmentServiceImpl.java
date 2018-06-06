package Service;

import DL.ApartmentRepository;
import DL.UserRepository;
import Exceptions.NotAuthorizedUser;
import Exceptions.OnlyLandLoardCanDeleteHisAprtment;
import Exceptions.UserDoesntExistException;
import domain.Apartment;
import domain.ApartmentTransfor;
import domain.User;
//import org.apache.commons.;
//import org.apache.commons
//import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
    public List<? extends Apartment> getAll() {
        Iterable<Apartment> l= apartmentRepository.findAll();
        List<ApartmentTransfor> ans= new ArrayList<>();
        for (Apartment apartment : l)
            ans.add(new ApartmentTransfor(apartment));
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
			String landLordID, byte[] image,boolean isRent) {
		Apartment apt=new Apartment(price,floor,elevator,constructionYear,
        		wareHouse,description,size,address,parking,numToilet,numRooms,landLordID,isRent);
		if (apartmentRepository.exists(address)) {
            apartmentRepository.delete(apt);
            return apartmentRepository.save(apt);
        }
        else return null;
	}

	@Override
	public void delete(String address, String landLoardId) 
			throws OnlyLandLoardCanDeleteHisAprtment, NotAuthorizedUser {
		if(!landLoardId.equals(apartmentRepository.findOne(address).getLandLordID()))
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
	public Apartment addNewWithUserPermissions(ApartmentTransfor apartment) throws NotAuthorizedUser, IOException {
		checkIsRoot(apartment.getLandLordID());
		FileOutputStream stream = null;
		try {
			stream = new FileOutputStream(apartment.getAddress());
		    stream.write(apartment.getImage());
		}catch (Exception e) {} 
		finally {
		    stream.close();
		}
		return apartmentRepository.save(
				new Apartment(
						apartment.price, apartment.floor, apartment.elevator, apartment.constructionYear,
						apartment.wareHouse, apartment.description, apartment.size, apartment.address,
						apartment.parking, apartment.numToilet, apartment.numRooms, 
						apartment.landLordID,apartment.isRent));
	}


	private void checkIsRoot(String landLordID) throws NotAuthorizedUser {
		User user = userService.getByToken(landLordID);
		if(!user.isRoot())
			throw new NotAuthorizedUser();
	}


	@Override
	public boolean delete(String address) {
		try{
			apartmentRepository.delete(address);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
 