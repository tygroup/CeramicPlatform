package com.cpf.service.impl.system;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cpf.beans.transaction.TraProduct;
import com.cpf.beans.transaction.TraProductFiles;
import com.cpf.mapper.transaction.TraProductFilesMapper;
import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.service.system.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements  ProductService{
	@Autowired
	private TraProductMapper productMapper;
	@Autowired
	private TraProductFilesMapper filesmapper;
	@Override
	public TraProduct insert(TraProduct pro) {
		
		productMapper.save(pro);
		 
		 if(pro.getQtpics()!=null && !pro.getQtpics().equals("")){
			 getPics(pro.getQtpics(),pro.getProductid());
			 
		 }
		 return pro;
	}

	@Override
	public TraProduct update(TraProduct pro) {
		  productMapper.update(pro);
		
		  //先删除对应的文件，然后insert
		  filesmapper.deleteFilesByProductid(pro.getProductid());
		  
		  if(pro.getPics()!=null && pro.getPics().size()!=0){
			  getPics(pro.getQtpics(),pro.getProductid());
			 }
		  return pro;
	}
	//写入文件
	private void getPics(String pics,String productid){
		if(pics!=null && !pics.equals("")){
			String[] strlist = pics.split(",");
			for(String str:strlist){
				TraProductFiles files = new TraProductFiles();
				files.setFiles(str);
				files.setProductid(productid);
				filesmapper.save(files);
			}
		}
		
	}
	
	
	 
	@Override
	public int findByUseridCount(Map<String, Object> params) {
		return productMapper.findByUseridCount(params);
	}

	@Override
	public boolean delete(String productid) {
		 productMapper.delete(TraProduct.class, productid);
		 return true;
	}

	@Override
	public TraProduct getByPrimarykey(String productid) {
		TraProduct pro = productMapper.findById(productid);
			pro.setPics(filesmapper.selectPicByProductionId(productid));
		return pro;
	}

	@Override
	public List<TraProduct> selectProductsByUserId(Map<String, Object> params) {
		return productMapper.selectProductsByUserId(params);
	}

	@Override
	public List<TraProduct> selectProductsByUserIdforSJ(
			Map<String, Object> params) {
		return productMapper.selectProductsByUserIdforSJ(params);
	}

	@Override
	public int selectProductsByUseridCountforSJ(Map<String, Object> params) {
		return productMapper.selectProductsByUseridCountforSJ(params);
	}

}
