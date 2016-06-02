package week11;

public class classA {

	private int weight = 5;
	private int num ;

	public classA (int number){
		num = number;
	}

	public int getNum(){
		return num;
	}

	public int getWeight(){
		return weight;
	}

	public int eval(){
		return getNum()* getWeight();
	}

}

