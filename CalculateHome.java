

public class CalculateHome {
	private double results;
	private double cal;
	private double fmiter;
	private double lmiter;
	private double ft = -0.33;
	private double rate;
	public CalculateHome(double fmiter ,double lmiter) {
		this.fmiter = fmiter;
		this.lmiter = lmiter;
		double u = lmiter-fmiter;
		if(u<150){
			if(u<=15){
				cal = u*2.3488;
			}
			else if(u>15&&u<=25){
				cal = (15*2.3488)+((u-15)*2.9882);
			}
			else if(u>25&&u<=35){
				cal = (15*2.3488)+(10*2.9882)+((u-25)*3.2405);
			}
			else if(u>35&&u<=100){
				cal = (15*2.3488)+(10*2.9882)+(10*3.2405)+((u-35)*3.6237);
			}
			else if(u>100&&u<=150){
				cal = (15*2.3488)+(10*2.9882)+(10*3.2405)+(65*3.6237)+((u-100)*3.7171);
			}
	
			cal = cal+8.19;
		}
		else if(u>=150){
			if(u==150){
				cal = 150*3.2484;
			}
			else if(u>150&&u<=400){
				cal = (150*3.2484)+((u-150)*4.2218);
			}
			else if(u>400){
				cal = (150*3.2484)+(250*4.2218)+((u-400)*4.4217);
			}
			cal = cal+38.22;
		}
		
		rate = u*ft;
		results = rate+cal;

		double per = (results*7)/100;
		
		results = results+per;
		
		
		
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
		return 
				"1.Use electricity less than 150Units"+ //1.���ѧ�ҹ俿������Թ 150 ˹���
				"- First 15Units(0-15Units) 2.3488Baht/Unit"+ //15 ˹����á (˹��·�� 0-15) 2.3488 �ҷ/˹���
				"- Next 10Units(16-25Units) 2.9882Baht/Unit"+ //10 ˹��µ��� (˹��·�� 16-25) 2.9882 �ҷ/˹���
				"- Next 10Units(26-35Units) 3.2405Baht/Unit"+ //10 ˹��µ��� (˹��·�� 26-35) 3.2405 �ҷ/˹���
				"- Next 65Units(36-100Units) 3.6237Baht/Unit"+ //65 ˹��µ��� (˹��·�� 36-100) 3.6237 �ҷ/˹���
				"- Next 50Units(101-150Units) 3.7171Baht/Unit"+ //50 ˹��µ��� (˹��·�� 101-150) 3.7171 �ҷ/˹���
				"- Next 250Units(151-400Units) 4.2218Baht/Unit"+ //250 ˹��µ��� (˹��·�� 151-400) 4.2218 �ҷ/˹���
				"- More than 400Units(400Units or above) 4.4217Baht/Unit"+ //400 ˹��¢��� (˹��·�� 401 �繵��)4.4217 �ҷ/˹���
				"2.Use electricity more than 150Units"+ //2.���ѧ�ҹ俿���Թ 150 ˹���
				"- First 150Units(0-150Units) 3.2484Baht/Unit"+ //150 ˹����á (˹��·�� 0-150) 3.2484
				"- Next 250Units(151-400Units) 4.2218Baht/Unit"+ //250 ˹��µ��� (˹��·�� 151-400) 4.2218�ҷ/˹���
				"- More than 400Units(401Units or above) 4.4217Baht/Unit"; //400 ˹��¢��� (˹��·�� 401 �繵��) 4.4217 �ҷ/˹���
	}


}
