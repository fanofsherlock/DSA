package Arrays;

import java.util.ArrayList;
import java.util.Collections;

public class HotelBooking {
    
    
	 
    public boolean hotel(ArrayList<Integer> a, ArrayList<Integer> d, int K) {
        
        if(a == null || a.size() == 0||
           d == null || d.size() == 0 ||
           d.size() != a.size() || K < 1)
          {  return false;}
          
          
          
        Collections.sort(a);
        Collections.sort(d);
        
        
       int i=0,j=0;
       int rr=0;
       
       while(i<a.size()&&j<d.size()){
           
           if(a.get(i)<d.get(j)){
               rr++;
               if(rr>K){
                   return false;
               }
               i++;
           }
           else if(a.get(i)>d.get(j)){
               rr--;
               j++;
           } else{
               i++;
               j++;
           }
       }
       
       while(i<a.size()){
           rr++;
           if(rr>K){
               return false;
           }
           i++;
       }
       
       return true;
        
    }
}

