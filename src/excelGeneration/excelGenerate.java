package excelGeneration;

import java.io.FileInputStream;

import java.io.FileOutputStream;	
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import controller.*;
import model.add_criminal;
public class excelGenerate {
	
	
	
	public void createExcel(List<add_criminal> lists) throws IOException {
		String[] col = {"Name","DOB","Address","Crime","ID","Punishment","Weight"};
		
		int rowNumber = 1;
		
		//create blank workbook
		Workbook wb = new HSSFWorkbook(); 
		
		//create sheet
		org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Criminal"); 
		
		//creating Row
		Row row_header = sheet.createRow(0);
		
		for(int i=0;i<col.length; i++) {
			Cell cell = row_header.createCell(i);
			cell.setCellValue(col[i]);
			
		}		
		
		for(add_criminal ac : lists) {
			Row row = sheet.createRow(rowNumber++);
		    row.createCell(0).setCellValue(ac.getCriminal_name());
		    row.createCell(1).setCellValue(ac.getCriminal_dob());
		    row.createCell(2).setCellValue(ac.getCriminal_addr());
		    row.createCell(3).setCellValue(ac.getCriminal_crime());
		    row.createCell(4).setCellValue(ac.getCriminal_id());
		    row.createCell(5).setCellValue(ac.getCriminal_punishment());
		    row.createCell(6).setCellValue(ac.getCriminal_weight());
		}
		
		//FileOutputStream out = new FileOutputStream(new File("E:\\Criminal_Record.xlsx"));
		OutputStream fileOut = new FileOutputStream("criminalrecord.xls");
		
		wb.write(fileOut);
		fileOut.close();
		System.out.println("Successfully Criminal Record has been Created.");
	}
	
	
	public void delete(List<add_criminal> lists) throws IOException, InterruptedException {
		
		
		//create blank workbook
		Workbook wb = new HSSFWorkbook(); 
		
        //create sheet
		org.apache.poi.ss.usermodel.Sheet sheet = wb.createSheet("Criminal"); 
		
		//Read the spreadsheet that needs to be updated
		 FileInputStream fsIP= new FileInputStream("criminalrecord.xls"); 
		 
		 HSSFWorkbook wb1 = new HSSFWorkbook(fsIP); //Access the workbook
		 
		//Access the worksheet, so that we can update / modify it.
		 HSSFSheet worksheet = wb1.getSheetAt(0); 
		 
		// Access the second cell in second row to update the value
		 Row row = wb1.getSheetAt(0).getRow(1);   
         try {
	         row.removeCell(row.getCell(0));
	         row.removeCell(row.getCell(1));                          	       
	         row.removeCell(row.getCell(2));	          
	         row.removeCell(row.getCell(3));	          
	         row.removeCell(row.getCell(4));
	         row.removeCell(row.getCell(5));
	         row.removeCell(row.getCell(6));
         }
         catch(IllegalArgumentException i) {
        	 System.out.println("Criminal ID not matched !");
         }
		
		
		System.out.println("Successfully Criminal Record has been deleted.");
		fsIP.close(); //Close the InputStream
        
        FileOutputStream output_file =new FileOutputStream("criminalrecord.xls");  //Open FileOutputStream to write updates
           
        wb1.write(output_file); //write changes
           
        output_file.close();  //close the stream
       
	}


	
	public void updateExcel(List<add_criminal> nlist) throws IOException {
		

        FileInputStream fsIP= new FileInputStream("criminalrecord.xls"); 
          
        HSSFWorkbook wb = new HSSFWorkbook(fsIP); 
          
        HSSFSheet worksheet = wb.getSheetAt(0); 
          
        for(add_criminal ac : nlist) {
			
			
        	Row row = wb.getSheetAt(0).getRow(1);
		    row.createCell(0).setCellValue(ac.getCriminal_name());
		    row.createCell(1).setCellValue(ac.getCriminal_dob());
		    row.createCell(2).setCellValue(ac.getCriminal_addr());
		    row.createCell(3).setCellValue(ac.getCriminal_crime());
		    row.createCell(4).setCellValue(ac.getCriminal_id());
		    row.createCell(5).setCellValue(ac.getCriminal_punishment());
		    row.createCell(6).setCellValue(ac.getCriminal_weight());
		}
                 
        fsIP.close(); 
         
        FileOutputStream output_file =new FileOutputStream("criminalrecord.xls");  
          
        wb.write(output_file); 
        output_file.close();     
		
	}
	

}
