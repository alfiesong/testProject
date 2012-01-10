// Ningyu Song
package com.shelby.CSVFormatCorrect;
import java.io.*;

public class CSVFormatCorrect {

	public void writeToFile(String originalFile,String outputFile) {
		try{ 
			FileReader fr = new FileReader(originalFile); 
			BufferedReader fileRead = new BufferedReader(fr);    	    
					
			String line = fileRead.readLine(); 
    	       	    
    	    FileWriter fw = new FileWriter(outputFile);
    	    BufferedWriter  fileOut = new BufferedWriter(fw);  
    	    fileOut.write(line);
    	    fileOut.write("\n");
    	    
    	    System.out.println("Processing...Please wait...");

    	    CSVReader reader = new CSVReader(new FileReader(originalFile), ',' , '"',1);
    		CSVWriter writer = new CSVWriter(new FileWriter(outputFile));
    		String [] nextLine;
    		
    		for (int j=0;(nextLine = reader.readNext()) != null;j++) {
    			
    			for(int i=0;i<nextLine.length;i++) {
    				nextLine[i] = nextLine[i].replace("\n", " ");		
    			}
    			fileOut.write( writer.writeNext(nextLine) );
    						
    		}
    		writer.close();
    		fileRead.close();
     		fr.close(); 
    	    fileOut.close();
    		fw.close(); 	
    		System.out.println(originalFile+" has been successfully modified. New file: " + outputFile);
		}
		catch (Exception e){
			  System.err.println("Error: " + e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {

					
		if(args.length != 2)
			System.err.println("This program requires two parameters: Target CSV file name and Output CSV file name");
		else {
			String originalFile = args[0];
			String outputFile = args[1];
			CSVFormatCorrect csvFormatCorrect = new CSVFormatCorrect();	
			csvFormatCorrect.writeToFile(originalFile,outputFile);
		}				
		
	}

}


