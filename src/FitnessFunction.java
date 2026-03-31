

//import Duvar;
//import KitaplariYerlestir;

public class FitnessFunction {
	public static int fitness=0 ;
	//KitaplariYerlestir kitaplariYerlestir1=new KitaplariYerlestir();
	
	
	public int FitnessFunction1(int[] x,Duvar duvar){
		KitaplariYerlestir kitaplariYerlestir1=new KitaplariYerlestir();
		
		int[] a = kitaplariYerlestir1.Diz(x,duvar);
		//fitness=a[0];
		//fitness=a[1];
//		fitness=a[1]/(algoritma.duvarEni*algoritma.duvarBoyu);
		fitness=(a[0]*(algoritma.duvarEni*algoritma.duvarBoyu)/a[1]);
		System.out.println("yerleştirilen kitap sayısı: "+a[0]);
		return fitness;
	}

}
