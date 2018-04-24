//package Service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import Service.Interfaces.ApartmentService;
//import Service.Interfaces.RankService;
//import Service.Interfaces.UserService;
//import domain.Comment;
//import domain.Pair;
//
//@Service
//public class rankServiceImpl implements RankService{
//
//	@Autowired
//	private ApartmentService apartmentService;
//	
//	@Autowired
//	private UserService userService;
//	
//	@Override
//	public void rank(Pair<Integer, Double> pair, int rank) {
//		int numOfRanks = pair.getFirst() + 1;
//        double oldAvg = pair.getSecond(); 
//    	double newAvg = (numOfRanks * oldAvg + rank) / numOfRanks;
//    	pair.setFirst(numOfRanks);
//    	pair.setSecond(newAvg);
//	}
//}
