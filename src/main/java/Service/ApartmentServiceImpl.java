package Service;

import DL.ApartmentRepository;
import DL.UserRepository;
import domain.Apartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    @Autowired
    private ApartmentRepository apartmentRepository;

    @Transactional
    @Override
    public List<Apartment> getAll() {
        Iterable<Apartment> l= apartmentRepository.findAll();
        List<Apartment> ans= new ArrayList<Apartment>();
        for (Apartment i : l){
            ans.add(i);

        }
        return ans;
    }
}
