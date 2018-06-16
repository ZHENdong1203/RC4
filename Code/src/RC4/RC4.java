package RC4;
public class RC4 {
		public static int[] myRC4(int[] aInput,int[] aKey) 
	    { 
	        int[] S = new int[256]; 
	        int[] K = new int[256];       
	        for (int i=0;i<256;i++) 
	            S[i]=i; 
	        for (int i= 0;i<256;i++) 
	        { 
	        	      
	        	K[i]=aKey[i % aKey.length]; 
	        }  
	        int  j=0;        
	        for (int i=0;i<256;i++) 
	        { 
	            j=(j+S[i]+K[i]) % 256; 
	            int temp = S[i]; 
	            S[i]=S[j]; 
	            S[j]=temp; 
	        } 
	        int i=0; 
	        j=0; 
	        int[] iInputChar = aInput;
	        int[] iOutputChar = new int[iInputChar.length]; 
	        for(int x = 0;x<iInputChar.length;x++) 
	        { 
	            i = (i+1) % 256; 
	            j = (j+S[i]) % 256; 
	            
	            int temp = S[i]; 
	            S[i]=S[j]; 
	            S[j]=temp; 
	            
	            int t = (S[i]+S[j] ) % 256; 
	            int iY = S[t]; 
	            
	            iOutputChar[x] =(byte) (iInputChar[x] ^ iY);
	        } 
	        
	        return iOutputChar;                
	    }
	public static String BytesToString(int[] bytes) {	
			String result ="";
			for(int i=0;i<bytes.length;i++)
			{
				int temp = bytes[i] & 0xff;
				String tempHex = Integer.toHexString(temp);				
				if(tempHex.length()<2)
					result += "0"+tempHex;
				
				else result += tempHex;
			}		
			return result;		
		}
}
