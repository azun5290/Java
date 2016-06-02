package util;

public class Sequence {
	private String id;
	private String sequence;

			
	public Sequence(String id, String seq) {
		this.id = id;
		sequence = seq.toUpperCase();
	}
	public String toString() {
		return ">" + id + "\n" + sequence;
	}
	public double getGCContent() {
		int numGCs = 0;
		for (int i = 0; i < sequence.length(); ++i) {
			char base = sequence.charAt(i);
//			numGCs += (base == 'C' || base == 'G') ? 1 : 0;
			if (base == 'C' ||base == 'G') {
				numGCs++;
			}
		}
		return (double) numGCs / sequence.length();
	}
	public String getID() {
		return id;
	}

}