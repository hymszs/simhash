
	import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;  
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;  
import java.util.List;  

	  
	public class getsimhashtable {  
 	

		
	    public void ReadAllFile(String filePath,String outputPath) throws IOException {  
	    	
	    	
	        File f = null;  
	        f = new File(filePath);  
	        File[] files = f.listFiles(); 
	        List<File> list = new ArrayList<File>();  
	        for (File file : files) {  
	            if(file.isDirectory()) {  
	                 
	                ReadAllFile(file.getAbsolutePath(),outputPath);  
	            } else {  
	                list.add(file);  
	            }  
	        }  
	        for(File file : files) {  
	        	if(!file.isDirectory()){
	       	   //initialize reader
	        		BufferedReader bf = new BufferedReader(new FileReader(file));
	        	     System.out.println(file.getName());
	           //initialize writer
	        	     File output = new File(outputPath+File.separator+file.getName()+".txt");    	  
	        	     output.createNewFile();  
	        	     BufferedWriter bw = new BufferedWriter(new FileWriter(output,true)); 
	        	String s;
	        	int countline=0;
	        	 while ((s = bf.readLine()) != null) {	                 
	                 countline++;  
	                 generatesimhash sh=new generatesimhash(s);
	             	 bw.write(sh.getSimHashString()+"\t"); 
	     			 bw.write("\r\n");
	     			 bw.flush(); 
	     			
	             }
				
				
	        	 bf.close();
	        	 bw.close(); 
	        	}
	        }
	         
          
	        
	    }  
	      
	   
	      
	    public static void main(String[] args) throws IOException {  
	        String filePath = args[0];
	        String outputPath=args[1];
	        new getsimhashtable().ReadAllFile(filePath,outputPath);  
	    }  
	}  

