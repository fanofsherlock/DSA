package Arrays;

import java.util.ArrayList;

public class MAXSPROD {
	
	public int maxSpecialProduct(ArrayList<Integer> A) {
	    
        int[] left = new int[A.size()];
        int[] right = new int[A.size()];
        int m= 1000000007;
        
        int curMax=Integer.MIN_VALUE;
        int curMaxIndex=-1;
        
        
        for(int i=0;i<A.size();i++){
            if(A.get(i)>=curMax){
                curMax=A.get(i);
                curMaxIndex=i;
                left[i]=-1;
                continue;
            }
            left[i]=curMaxIndex;
        }
        
        curMax=Integer.MIN_VALUE;
        curMaxIndex=-1;
        
        for(int i=A.size()-1;i>=0;i--){
            if(A.get(i)>=curMax){
                curMax=A.get(i);
                curMaxIndex=i;
                right[i]=-1;
                continue;
            }   
            right[i]=curMaxIndex;
        }
        
        int maxProduct=Integer.MIN_VALUE;
        int curProduct=maxProduct;
        
        for(int i=0;i<A.size();i++){
            if(left[i]==-1||right[i]==-1){
                curProduct=0;
            }
            
            else{
            
            int lv=left[i];
            int rv=right[i];
            for(int j=i-1;j>=left[i];j--) {
                  if(A.get(j)>A.get(i)) {
                      lv=j;
                      break;
                  }
            }    
            
            for(int j= i+1;j<=right[i];j++) {
                  if(A.get(j)>A.get(i)) {
                      rv=j;
                      break;
                  }
            }    
            
            curProduct=((lv%m)*(rv%m))%m;
            
            }
            
           if(curProduct>maxProduct){
               maxProduct=curProduct;
           }
        }
        
        return maxProduct%m;
        
        
    }

}
