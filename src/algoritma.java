

import java.util.ArrayList;
import java.util.Arrays;

//////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////
//BATA basitleştirilmiş ayrık yarasa algoritması
//Mayıs 2020 
//kitapların doyutları datasetler başlıkları altında kitap sınıfının içindedir


public class algoritma {
		
	
	private static int counter= 0;
	

	static public int duvarEni=80;//DUVAR ENİ
	static public int duvarBoyu=150;//DUVAR BOYU
	static double rafKalinligi=3;//RAF KALINLIĞI
	static int populasyonSayisi=5;//POPULASYON SAYISI
	static int iterasyon_s=30;//ITERASYON SAYISI
	
	
	
	
    public static void main(String[] args){
    	ArrayList<kitap> Yerlestirilenkitaplar=new ArrayList<kitap> ();
    	 ArrayList<Double> kitapUzunluklari= new ArrayList<Double>();
    	 int pfitnessilk=0;
    	 int bestfitness=0;
    	 int g_bestfitness=0;
    	  int [] local_best;
    	   int local_bestfitness=0;
    	 int[] x;
    	// int[] best;
    	 int[] g_best ;
    	 
    int [][] p=new int[populasyonSayisi][];	
	Duvar yeniDuvar=new Duvar();
	kitap kitaplar=new kitap();
	BAT bat1=new BAT();
	FitnessFunction FF1=new FitnessFunction();
	yeniDuvar.duvarOlustur(duvarEni,duvarBoyu);
	local_best = kitaplar.baslangic_best();
	g_best=local_best;
	
	
//------------populasyon oluşturma-------------	
	for(int i=0;i<populasyonSayisi;i++){
	kitap kitaplar1=new kitap();
			p[i]=kitaplar1.baslangic_x();
	}
//---------------------------------------------
	
	int initialbestfitness=FF1.FitnessFunction1(local_best,yeniDuvar);
	System.out.println("***ilk local best fitness "+ Arrays.toString(local_best) );
	System.out.println("ilk best local fitness: "+initialbestfitness);
	g_bestfitness=initialbestfitness;
	
//	//Arrays.toString(best)
//	for(int i=0;i<best.length;i++)	{System.out.println("initial.best "+best[i]);}
//	for(int i=0;i<populasyonSayisi;i++)
//		{System.out.println("--------"+i);
//		 System.out.println(Arrays.toString(p[i]));}

	
	
	
	
	
	
  for(int t=0;t< iterasyon_s;t++){
	  
 System.out.println("--------------"+t);
//---------------bir populasyonun en iyi bestfitness hesaplıyor-----
 
	for(int j=0;j<populasyonSayisi;j++){
		
		pfitnessilk=FF1.FitnessFunction1(p[j],yeniDuvar);
		System.out.println(j+".: "+pfitnessilk);
		    
		if(local_bestfitness <=pfitnessilk){
			//System.out.println("*******************"+pfitnessilk);
			local_best=p[j];
			local_bestfitness=pfitnessilk;
		}
	}
	 
	// System.out.println("local best fitness "+local_bestfitness);
//-------------------------------------------------------------------
	
//--------------Global en iyi best i güncelliyoruz------------------
	   
	    if(g_bestfitness < local_bestfitness){
			g_bestfitness=local_bestfitness;
			g_best=local_best;
			System.out.println("g_local best fitness "+g_bestfitness);
			System.out.println("***g_local best "+ Arrays.toString(g_best) );
		}
//------------------------------------------------------------------
	    		
//--------populasyon güncellenmesi=diğer iterasyona geçme-----
		for(int i=0;i<populasyonSayisi;i++){
			
			p[i]=bat1.BatFonksiyonu(p[i], yeniDuvar, g_best,local_best);
		
		//System.out.println(i+". ***bat sonrası populasyon "+ Arrays.toString(bat1.BatFonksiyonu(p[i], yeniDuvar, g_best,local_best)) );
			}
//---------------------------------------------------------	
		local_bestfitness=0;
		
   }	 
  		System.out.println("g_local best fitness "+g_bestfitness);
        System.out.println("Kitapların en iyi sıralanışı: "+ Arrays.toString(g_best) );
}
}