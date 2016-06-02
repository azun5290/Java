package week7;
import java.util.*;
public class CTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList <Customer> CList= new ArrayList<Customer>();
		Customer c = new Customer ("Frocio", -105.0,420.0 );
		CList.add(c);
		CList.add((new Customer ("Troia", -1500.0,20000.0 )));
		CList.add((new Customer ("Crosta", -3500.0,65000.0 )));
		for (Customer cus: CList){
			System.out.println(cus);
		}

		TransInfo(CList);
		findRichest(CList);

		System.out.println("9999999999999999999");
		System.out.println(findAtLeast(CList,300.0));

		//System.out.println("LUUUUUUUUUU   "+findTrans(CList));

		// Make new customers from input

		/*		Customer cu = null;
		int index = CList.size(); 
		System.out.println(index);
		Scanner scn = new Scanner (System.in);
		System.out.println("Enter more customers");

		while (scn.hasNext()){
			//index++;
			cu = new Customer();
			cu.setName(scn.next());
			CList.add(index,c);
			CList.get(index).setName(c.getName().trim());

			//CList.get(index).setchequeAccountBalance(Integer.parseInt(scn.next()));
			//CList.get(index).setCreditCardBalance(Integer.parseInt(scn.next()));
		}*/
		//System.out.println(index);
	}

	public static ArrayList<Customer> TransInfo (ArrayList<Customer> list){ 
		double sum =0;
		//int Total=0;
		double ave = 0;
		for (Customer c1 : list){
			sum = ((week7.Customer) c1).getCreditCardBalance()+((week7.Customer) c1).getChequeAccountBalance();
			System.out.println(((week7.Customer) c1).getName() +" has Total " + sum);
		}
		ave = sum/list.size();
		System.out.println("Average is: "+ ave);
		return list;
	}

	public static ArrayList<Customer> findRichest (ArrayList<Customer> list){ 
		double max = list.get(0).getWealth();
		String richestPerson = list.get(0).getName();
		for (Customer c2 : list){
			if (c2.getWealth() > max){
				richestPerson = c2.getName();
				max = c2.getWealth();
			}
		}
		System.out.println("Richest person "+ richestPerson);
		return list;
	}

	/*	public int count (double atLeast){
		int matches = 0;
		for (Customer c : CList)
	}*/

	public static Customer findAtLeast (ArrayList<Customer> list, double atLeast){ 

		for (Customer c : list){
			if (c.getWealth() >= atLeast){

				//System.out.println(f.getName());
				//System.out.println(f.getWealth());
				return c;
			}
		}
		return null;
	}
}