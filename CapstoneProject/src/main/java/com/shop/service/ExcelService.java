 package com.shop.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.shop.entity.Product;
import com.shop.excel.ExcelHelper;
import com.shop.repo.ProductRepository;

@Service
public class ExcelService {
	@Autowired
	private ProductRepository productRespository;
	public void save(MultipartFile file)
	{
		try {
			List<Product> products = ExcelHelper.convertExcelToListOfProduct(file.getInputStream());
			this.productRespository.saveAll(products);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public List<Product> getAllProducts()
	{
		return this.productRespository.findAll();
	}
}
