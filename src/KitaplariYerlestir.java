

import java.util.ArrayList;
import java.util.Arrays;

public class KitaplariYerlestir {
	static int kitapsayisi;
	private static ArrayList<Double> kitapUzunluklari= new ArrayList<Double>();
	private static int counter= 0;
	
	static double maxheight;
	static double rafKalinligi=3;
	kitap kitap1=new kitap();
	
	public int [] Diz(int[] x,Duvar Duvar1){
		ArrayList<kitap> Yerlestirilenkitaplar=new ArrayList<kitap> ();
		counter=0;
		int y[] = {0,0};	
    	double capacity = Duvar1.boyut[0]*Duvar1.boyut[1];
    	double kalanDuvarUzunlugu = Duvar1.boyut[1];
    	double kalanRafGenisligi = Duvar1.boyut[0];
		//int i=0;//kitap numarası
//-----------------------------------------------------
	//	System.out.println("ilk raf genişliği    "+kalanRafGenisligi);	
		for(int i=0;i<x.length;i++){
	//		i=x[m];
		// if(m==(x.length-1)){
		//	m=0;
	//	}
		
//--------------------------------------
		if(kalanRafGenisligi>=kitap1.Kitapboyutu(x[i])[0] && kalanDuvarUzunlugu>=kitap1.Kitapboyutu(x[i])[1] && Yerlestirilenkitaplar.size()<kitap1.KitapSayisi())
		 {
			
			kalanRafGenisligi-=kitap1.Kitapboyutu(x[i])[0];
			//System.out.println("ALİ"+kitap1.Kitapboyutu(x[i])[0]);
			kitapUzunluklari.add(kitap1.Kitapboyutu(x[i])[1]);
			counter++;
			
			Yerlestirilenkitaplar.add(kitap1);	
			//System.out.println("---------------------------------------------");
			
			//System.out.println("1: "+Yerlestirilenkitaplar.size()+"    "+kalanRafGenisligi);
			capacity -= kitap1.KitapAlani(x[i]);
			
			kitap1=new kitap();
		}
	  	if(kalanRafGenisligi<kitap1.Kitapboyutu(x[i])[0] && kalanDuvarUzunlugu>=kitap1.Kitapboyutu(x[i])[1]&& Yerlestirilenkitaplar.size()<kitap1.KitapSayisi()){
			
			for (int j = 0; j < kitapUzunluklari.size(); j++){
	            if (kitapUzunluklari.get(j) >= maxheight) {
	            	maxheight = kitapUzunluklari.get(j);	            	
	            }
	        }
			
			kalanDuvarUzunlugu=kalanDuvarUzunlugu-(maxheight+rafKalinligi);
			capacity-=(rafKalinligi*Duvar1.boyut[0]);
			if(kalanRafGenisligi<kitap1.Kitapboyutu(x[i])[0] && kalanDuvarUzunlugu>=kitap1.Kitapboyutu(x[i])[1]) {
				kalanRafGenisligi=Duvar1.boyut[0];
				kalanRafGenisligi-=kitap1.Kitapboyutu(x[i])[0];
				kitapUzunluklari.clear();
				kitapUzunluklari.add(kitap1.Kitapboyutu(x[i])[1]);
				counter++;
				
				Yerlestirilenkitaplar.add(kitap1);
				
				//System.out.println("2: "+Yerlestirilenkitaplar.size()+"    "+kalanRafGenisligi);
				capacity -= kitap1.KitapAlani(x[i]);
				kitap1=new kitap();
				}
					}
		
		}
//------------------------------------------		
		//System.out.println("Counter:  "+counter);
		y[0]=Yerlestirilenkitaplar.size();  //1 buldu
		y[1]=(int) capacity;		//7940 buldu
		return y;
		
	}

}
