package week11;

public class classB extends classA{


	private int weightB = 7;


	public classB (int n){
		super (n+1);
	}

	public int getNum(){
		return super.getNum()*10;
	}

	public int getWeight(){
		return weightB;
	}

	public int eval(){
		return super.eval()* getWeight();
	}

}
