package com.cpf.service.impl.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cpf.beans.transaction.SpecialBean;
import com.cpf.beans.transaction.TraBidrecord;
import com.cpf.beans.transaction.TraProduct;
import com.cpf.beans.transaction.TraProductFiles;
import com.cpf.beans.transaction.TraTrading;
import com.cpf.mapper.transaction.TraBidrecordMapper;
import com.cpf.mapper.transaction.TraProductFilesMapper;
import com.cpf.mapper.transaction.TraProductMapper;
import com.cpf.mapper.transaction.TraTradingMapper;
import com.cpf.service.transaction.ProductionService;

@Service("productionService")
public class ProductionServiceImpl implements ProductionService {

	@Autowired
	private TraProductMapper productMapper;

	@Autowired
	private TraTradingMapper tradingMapper;
	
	@Autowired
	private TraBidrecordMapper bidRecordMapper;
	@Autowired
	private TraProductFilesMapper productFileMapper;
	
	@Override
	public List<TraProduct> selectBartersBySearch(String productName,String cateid, String ismyself,String era, String sort,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return productMapper.selectBartersBySearch(productName,cateid,ismyself,era,sort, beginIndex, endIndex);
	}

	@Override
	public int selectBartersBySearchCount(String productName,String cateid, String ismyself,String era) {
		// TODO Auto-generated method stub
		return productMapper.selectBartersBySearchCount(productName,cateid,ismyself,era);
	}

	@Override
	public List<SpecialBean> selectSpecialBySearch(String productName,
			String cateid, String ismyself, String era, String sort,
			int beginIndex, int endIndex) {
		// TODO Auto-generated method stub
		return productMapper.selectSpecialBySearch(productName, cateid, ismyself, era, sort, beginIndex, endIndex);
	}

	@Override
	public int selectSpecialBySearchCount(String productName, String cateid,
			String ismyself, String era) {
		// TODO Auto-generated method stub
		return productMapper.selectSpecialBySearchCount(productName, cateid, ismyself, era);
	}

	@Override
	public List<SpecialBean> selectHotSpecialid(int beginIndex,int size) {
		// TODO Auto-generated method stub
		return productMapper.selectHotSpecialid(beginIndex,size);
	}

	@Override
	public List<TraProduct> selectHotBarters(int beginIndex,int size) {
		// TODO Auto-generated method stub
		return productMapper.selectHotBarters(beginIndex,size);
	}

	@Override
	public List<TraTrading> findProductionById(String productId) {
		// TODO Auto-generated method stub
		return tradingMapper.findProductionById(productId);
	}

	@Override
	public List<TraBidrecord> selectBidRecordByProductId(String productId,int beginIndex,int size) {
		// TODO Auto-generated method stub
		return bidRecordMapper.selectBidRecordByProductId(productId,beginIndex,size);
	}

	@Override
	public int selectBidRecordByProductIdCount(String productId) {
		// TODO Auto-generated method stub
		return bidRecordMapper.selectBidRecordByProductIdCount(productId);
	}

	@Override
	public List<TraTrading> findProductionByZcId(String zcId, int beginIndex,
			int size) {
		// TODO Auto-generated method stub
		return tradingMapper.findProductionByZcId(zcId, beginIndex, size);
	}

	@Override
	public int findProductionByZcIdCount(String zcId) {
		// TODO Auto-generated method stub
		return tradingMapper.findProductionByZcIdCount(zcId);
	}

	@Override
	public List<TraProductFiles> selectPicByProductionId(String productId) {
		// TODO Auto-generated method stub
		return productFileMapper.selectPicByProductionId(productId);
	}

	@Override
	public List<TraTrading> selectBartersByUserInfoId(String userInfoId,
			int beginIndex, int size) {
		// TODO Auto-generated method stub
		return tradingMapper.selectBartersByUserInfoId(userInfoId, beginIndex, size);
	}

	@Override
	public int selectBartersByUserInfoIdCount(String userInfoId) {
		// TODO Auto-generated method stub
		return tradingMapper.selectBartersByUserInfoIdCount(userInfoId);
	} 
	
	
}
