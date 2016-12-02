

public class CalculateOut {
	private double fmiter;
	private double lmiter;
	private double rate;
	private double results;
	private double fl;
	
	public CalculateOut(double fmiter,double lmiter,double rate){
		this.fmiter = fmiter;
		this.lmiter = lmiter;
		this.rate = rate;
		
		fl = lmiter - fmiter;
		
		results = fl*rate;
		
	}
	
	public double getResults(){
		return results;
	}
	
	public double getFirstMiter(){
		return fmiter;
	}
	
	public double getLastMiter(){
		return lmiter;
	}
	
	public String toString(){
		return "Tariff "+rate+" Unit/Baht"; //อัตราค่าไฟ หน่วยละ"+rate+" บาท
	}


}
