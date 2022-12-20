package com.shop.excel;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.Product;

public class ExcelHelper {

	//	method to check if the file is of excel type or not
	public static boolean checkExcelformat(MultipartFile file)
	{
		String contentType = file.getContentType();

		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
		{
			return true;
		} 
		else 
		{
			return false;
		}
	}

	//	method to convert excel to list of products 
	public static List<Product> convertExcelToListOfProduct(InputStream in)
	{
		List<Product> list = new ArrayList<>();
		try {

			XSSFWorkbook workbook= new XSSFWorkbook(in);
			XSSFSheet productSheet = workbook.getSheet("Product");

			int rowNumber = 0;
			Iterator<Row> iterator = productSheet.iterator();
			while(iterator.hasNext())
			{
				Row row = iterator.next();
				if(rowNumber==0)
				{
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells = row.iterator();

				int cid = 0;
				Product p = new Product();
				
				while(cells.hasNext())
				{
					Cell cell = cells.next();
					
					switch (cid) {
					case 0:
						p.setPid((long) cell.getNumericCellValue());
						break;
					case 1:
						p.setProductName(cell.getStringCellValue());
						break;
//					case 2:
//						p.setCategory(cell.getStringCellValue());
//						break;
					case 2:
						p.setProductDesc(cell.getStringCellValue());
						break;
					case 3:
						p.setProductPrice(cell.getNumericCellValue());
						break;
					case 4:
						p.setProductCount(cell.getNumericCellValue());
						break;
					case 5:
						p.setImage(cell.getStringCellValue());
						break;
					default:
						break;
					}
					cid++;
				}
				list.add(p);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
