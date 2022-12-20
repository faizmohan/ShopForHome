package com.shop.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.Product;
import com.shop.excel.ExcelHelper;
import com.shop.service.ExcelService;

@RestController
@CrossOrigin("*")
public class ExcelController {
	@Autowired
	private ExcelService excelService;
	
	@PostMapping("/product/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file) throws InterruptedException
	{
		Thread.sleep(4000);
		if(ExcelHelper.checkExcelformat(file))
		{
//			true
			this.excelService.save(file);
			return ResponseEntity.ok(Map.of("message","File is uploaded and saved to db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	}
	@GetMapping("/product/fetch")
	public List<Product> getAllProducts()
	{
		return this.excelService.getAllProducts();
	}
}
