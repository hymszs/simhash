

import java.io.IOException;



public class generatesimhash {

    private int w[]={10,5,5,5,1,1,1,1,1,1};//weight
    private String s[]={"","","","","","","","","",""};//store string from json file
    private String featurehash[]={"","","","","","","","","",""};   //store feature vector
	private String tokens;
    private String SimHashString;
    
    public String getSimHashString()
    {return this.SimHashString;}
    
    public generatesimhash(String tokens) throws IOException{
       
        this.tokens=tokens;
        String[] elements = tokens.split("\\t");
        int length=elements.length;
        
        if(length>3)s[0]=elements[3];
        if(length>8)s[1]=elements[8];
        if(length>10)s[2]=elements[10];
        if(length>11)s[3]=elements[11];
        if(length>1)s[4]=elements[1];
        if(length>2)s[5]=elements[2];
        if(length>6)s[6]=elements[6];
        if(length>7)s[7]=elements[7];
        if(length>12)s[8]=elements[12];
        if(length>13)s[9]=elements[13];
        this.SimHashString = this.simHash();
    }

	private String simHash()  {
         int i;
         //  initialize simhash array
         int[] v = new int[32];
         for(i=0;i<32;i++)   v[i]=0;
         for(i=0;i<s.length;i++)  featurehash[i]=Integer.toBinaryString(s[i].hashCode());//generate feature vector using String.hashCode()
         for(i=0;i<s.length;i++)   
         {
        	 for(int j=0;j<featurehash[i].length();j++)
        	 {   
        		 //add to v[j]
        		 if(featurehash[i].charAt(j)=='0')
                 {
               	  v[j]-=w[i];
                 }
                 else
                 {
               	  v[j]+=w[i];
                 }
        	 }
        	 
        	
        	 
         }
         
         //set v[j] to be either 1 or 0
         for(i=0;i<32;i++)
         {   
        	 
        	 if(v[i]>0) v[i]=1;
        	 else v[i]=0;
        	 
         }
         
         //convert v[j] to a string and return it
         StringBuilder sb = new StringBuilder(v.length);
         for (i=0;i<32;i++) {
           sb.append(v[i]);
         }
        return  sb.toString(); 
         
         
         
 
	}
	
	
}
