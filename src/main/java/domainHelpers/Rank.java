//package domainHelpers;
//
//import domain.Pair;
//
//public class Rank {
//	
//	public static void rank(Pair<Integer, Double> pair, double rank) {
//		int numOfRanks = pair.getFirst() + 1;
//        double oldAvg = pair.getSecond(); 
//    	double newAvg = (numOfRanks * oldAvg + rank) / numOfRanks;
//    	pair.setFirst(numOfRanks);
//    	pair.setSecond(newAvg);
//	}
//
//	public static void rank(double averageRank, int numOfRankers, Double rank) {
//    	double newAvg = (numOfRankers * averageRank + rank) / numOfRankers;
//		
//	}
//
//}
