import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * <P>
 * {@code java IntOccurancesInArray}
 * </P>
 **/
public class countOccs {
	public static final void main(String[] igno_red) {
		int[] ai = new int[] { 
				
				5,13,23,24,26,35,41,9,34,
				1,10,12,13,25,31,34,15,38,
				9,10,17,24,34,35,43,8,33,
				18,19,25,31,33,37,43,13,34,
				4,9,16,28,35,37,43,3,20,
				10,20,26,27,29,34,44,2,19,
				4,6,8,20,33,37,44,1,2,
				8,11,14,19,30,36,40,5,16,
				5,7,8,13,14,15,29,27,28,
				1,9,12,22,24,25,30,6,39,
				5,16,19,26,29,32,39,1,4,
				20,22,23,25,33,34,36,13,21,
				5,19,30,31,32,37,40,24,44,
				3,5,10,11,18,30,44,31,42,
				9,10,11,21,35,43,45,40,41,
				28,29,32,34,36,37,41,9,30,
				2,7,13,21,26,36,42,29,40,
				1,3,10,12,26,34,42,4,20,
				21,23,27,35,37,42,44,28,32,
				1,2,13,19,29,33,43,9,31,
				4,9,13,21,24,37,38,28,34,
				13,18,22,24,25,43,45,12,35,
				15,18,19,21,25,34,45,1,30,
				3,6,7,25,29,32,42,2,22,
				1,4,9,11,15,32,37,34,44,
				8,9,14,19,40,41,44,4,18,
				14,18,20,25,33,36,38,6,19,
				3,13,20,21,26,30,33,17,37,
				2,15,30,33,34,38,44,8,20,
				1,11,17,19,23,27,36,40,45,
				2,10,11,13,22,29,33,8,9,
				2,5,9,19,27,36,45,7,41,
				4,7,8,17,20,30,40,28,45,
				5,7,10,14,15,21,32,16,31,
				2,17,18,21,30,33,37,32,43,
				9,26,32,39,40,42,44,4,11,
				2,4,6,14,16,25,27,21,45,
				13,24,27,28,30,33,43,4,25,
				2,17,18,21,29,37,45,11,38,
				2,29,30,34,35,41,45,3,19,
				2,8,10,25,28,33,37,1,41,
				2,3,12,24,33,42,45,6,19,
				10,11,14,22,26,36,42,34,45,
				3,4,16,17,29,32,44,33,34,
				4,11,16,24,28,33,45,41,44,
				4,5,14,15,16,29,42,10,36,
				3,5,22,25,27,36,45,41,44,
				5,19,20,23,26,31,43,21,35,
				3,4,6,18,21,23,31,26,37,
				2,4,19,25,30,31,38,11,22,
				6,32,36,39,40,42,44,28,38,
				2,5,7,10,11,12,36,4,14,
				1,7,9,30,31,35,40,13,39,
				2,14,15,20,28,31,34,29,42,
				23,24,33,36,38,40,44,20,37,
				2,6,11,19,35,39,40,8,22,
				4,7,19,26,35,41,43,23,31,
				6,13,17,19,25,34,37,12,45,
				4,11,20,21,25,42,45,1,23,
				7,13,15,21,25,42,43,22,27,
				1,15,21,29,35,36,45,19,40,
				8,9,13,16,24,25,42,4,33,
				14,28,29,30,37,38,44,9,34,
				2,10,21,25,33,41,43,4,31,
				13,14,18,21,23,25,31,2,38,
				6,9,20,21,22,38,40,2,18,
				6,14,17,19,25,32,34,5,41,
				3,12,17,21,24,38,45,2,19,
				3,6,15,19,20,23,28,2,31,
				10,14,27,30,34,36,40,4,17,
				6,15,16,22,35,39,43,2,40,
				13,15,31,33,34,36,45,2,32,
				15,23,25,28,38,43,44,8,41,
				1,3,9,15,29,40,43,18,39,
				2,3,4,12,17,26,32,8,22,
				1,5,7,31,33,41,43,38,42,
				3,5,29,32,37,41,43,16,36,
				3,9,21,25,33,35,42,16,38,
				1,10,15,30,31,38,43,22,35,
				3,16,17,19,24,25,35,14,33,
				1,3,10,14,22,29,37,13,15,
				7,14,28,30,39,41,42,8,34,
				1,10,11,15,19,20,44,4,28,
				8,12,26,32,36,40,41,2,10,
				1,3,7,23,36,37,41,10,32,
				1,2,16,17,32,34,44,5,35,
				5,8,14,20,21,35,40,22,41,
				2,3,12,19,23,32,40,6,37,
				4,5,7,16,26,31,39,9,32,
				4,6,14,20,23,26,35,19,40,
				3,11,15,25,28,29,41,4,43,
				1,4,7,10,12,25,35,5,33,
				4,5,12,30,35,36,43,16,40,
				5,17,22,27,29,31,35,12,38,
				6,12,18,19,24,25,35,23,31,
				1,10,16,19,21,31,40,17,42,
				15,16,23,29,33,40,45,22,41,
				2,4,19,24,30,33,38,3,20,
				14,16,17,19,22,41,43,7,44,
				24,30,32,34,38,41,42,13,28


		};
		Map<Integer, Integer> mpNumWHits = new TreeMap<Integer, Integer>();
		for (int i = 0; i < ai.length; i++) {
			int iValue = ai[i];
			if (!mpNumWHits.containsKey(iValue)) {
				mpNumWHits.put(iValue, 1);
			} else {
				mpNumWHits.put(iValue, (mpNumWHits.get(iValue) + 1));
			}
		}

		Set<Integer> stInts = mpNumWHits.keySet();
		Iterator<Integer> itrInts = stInts.iterator();

		int[] ai300 = new int[300];

		int i = 0;
		while (itrInts.hasNext()) {
			int iValue = itrInts.next();
			int iHits = mpNumWHits.get(iValue);
			System.out.println(iValue + " found " + iHits + " times");
			ai300[iValue] = iHits;

		}
		
		
		for (int j = 0; j < ai300.length; j++) {
			if (ai300[j] > 0) {
				System.out.println("ai300[" + j + "]=" + ai300[j]);
				// System.out.println("ai100[" + j + "]=" + ai300[j]);

			}
		}
		
/*		System.out.println("AHAAAAH!!!!!");
		
		int itemSorted; // index of the item to be inserted
		for (itemSorted = 1; itemSorted < ai300.length; itemSorted++) {
			int temp = ai300[itemSorted];
			int loc = itemSorted - 1;
			while (loc >= 0 && ai300[loc] > temp) {
				ai300[loc + 1] = ai300[loc]; // bump item from ai300[loc] up to
												// loc+1
				loc--;
			}
			ai300[loc + 1] = temp;
		}

		for (int j = 0; j < ai300.length; j++) {
			if (ai300[j] > 0) {
				System.out.println("ai300[" + j + "]=" + ai300[j]);
				// System.out.println("ai100[" + j + "]=" + ai300[j]);

			}
		}*/
	}
}