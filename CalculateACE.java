

public class CalculateACE {
	private double fmiter;
	private double lmiter;
	private double fl;
	private double results;
	public CalculateACE(double fmiter,double lmiter){
		this.fmiter = fmiter;
		this.lmiter = lmiter;
		fl = lmiter - fmiter;
		if(fl<=150){
			results = fl*5;
		}
		else if(fl>150){
			results = fl*6;
		}
		
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
		return "Tariff"+"- 1-150Units 5Baht"+"- 151Units or above 6Baht";
	}


}
