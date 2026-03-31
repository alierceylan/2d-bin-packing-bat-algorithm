
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BAT {
	int S[];

	int v;//best ile yeni string arasındaki fark sayısı
	public static ArrayList<Integer> DegSatir=new ArrayList<Integer>();
	public static ArrayList<Integer> DegDeger=new ArrayList<Integer>();
	FitnessFunction FF1=new FitnessFunction();
	double A=0.6;
	double r=0.5;
	double rand;
	
	public int [] BatFonksiyonu(int[] x,Duvar duvar1,int[] best, int [] local_best){
		  DegSatir.clear();
          DegDeger.clear();
         
          rand=Math.random()*0.3+0.7;
          if(rand>r){
        	  S=hammingDist(x,best);
          }
          else{S=x;}
          
          if(rand<A && FF1.FitnessFunction1(x,duvar1)>FF1.FitnessFunction1(best,duvar1) ){
        	  //S=hammingDist(x,best);
        	  r=r*(1-Math.exp(0.98));
        	  A=0.98*A;
        	  S=x;
          }
          
          

		  //S=hammingDist(x,best);
		//  System.out.println("fitnes best : "+FF1.FitnessFunction1(best,duvar1));
		 // System.out.println("fitness x : "+FF1.FitnessFunction1(x,duvar1));
		  return S;
}
	 static int[] hammingDist(int [] x, int [] best) 
	  {  // System.out.println("ilk x:   "+Arrays.toString(x));
	       ArrayList<Integer> degisecekler= new ArrayList<Integer>();
	       ArrayList<Integer> degisecekDegerler= new ArrayList<Integer>();
	       
	       
	       for(int i=0;i<x.length;i++){
	      	
	      	 if(x[i]!=best[i]){
	      		 degisecekler.add(i);   
	      		 degisecekDegerler.add(x[i]);	 
	      	 }
//	      	 
	       }
	      
	       while(DegSatir.size()<degisecekler.size()){
	      	int a = degisecekler.get((int) (Math.random()*degisecekDegerler.size()));
	      	int b = degisecekDegerler.get((int) (Math.random()*degisecekDegerler.size()));
	      if(DegSatir.indexOf(a)<0 && DegDeger.indexOf(b)<0){
	    	  DegSatir.add(a);
	          DegDeger.add(b);
//	          System.out.println(a+"   "+b);
	      	  x[a]=b;}
	  }
//	      
	      
	     //s  System.out.println("son x:   "+Arrays.toString(x));
		
	     return x;
	  
	  }

}