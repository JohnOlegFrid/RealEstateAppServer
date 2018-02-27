package Service;

import domain.Apartment;

import java.util.List;

public interface ApartmentService {
    List<Apartment> getAll();
    Apartment addNew(Apartment apt);
    Apartment edit(Apartment apt);

}
