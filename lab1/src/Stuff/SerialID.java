package Stuff;

public class SerialID{
	private String serialContent;
	private String serial_id;
	private final static int letter=2;
	private final static int number=4;
	public SerialID(String ser){
		serialContent =ser;
	}
	private boolean isValidated(String data){
		data =data.trim();
		if(data.length()!=(letter+number))
			return false;
		for(int s=0;s<number;s++){
			if(!Character.isDigit(data.charAt(s)))
				return false;
		}
		for(int s=number;s<(letter+number);s++){
			if(!Character.isLetter(data.charAt(s)))
				return false;
		}
		return true;
	}
	public void setSerial_id(String serial){
		if(this.isValidated(serial))
			this.serial_id = serial;
	}
	public String getSerial_id(){
		return serialContent;
	}
}