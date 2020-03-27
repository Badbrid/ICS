package test.spring.data.mongodemo.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import test.spring.data.mongodemo.entity.dao.BrandWhiteDao;
import test.spring.data.mongodemo.entity.dto.BrandWhiteDto;
import test.spring.data.mongodemo.entity.mongo.BrandWhite;
import test.spring.data.mongodemo.service.AdminService;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:57
 */
@Service
@Slf4j
public class AdminServiceImpl implements AdminService {
    @Autowired
    BrandWhiteDao brandWhiteDao;

    @Override
    public void insertBrandWhite(BrandWhiteDto brandWhiteDto) {
        brandWhiteDao.insert(createBrandWhite(brandWhiteDto));

    }

    @Override
    public boolean brandWhiteExist(BrandWhiteDto brandWhiteDto) {
        boolean exist = brandWhiteDao.exist(createBrandWhite(brandWhiteDto));
        log.info("看看设备是不是在库里 {}",  exist);
        return exist;
    }

    @Override
    public void delBrandWhite(BrandWhiteDto brandWhiteDto) {

    }

    private BrandWhite createBrandWhite(BrandWhiteDto brandWhiteDto){
        BrandWhite brandWhite = new BrandWhite();
        brandWhite.setBrand(brandWhiteDto.getBrand());
        brandWhite.setModel(brandWhiteDto.getModel());
        brandWhite.setModelVersion(brandWhiteDto.getModelVersion());
        brandWhite.setPage(brandWhiteDto.getPage());
        brandWhite.setSize(brandWhiteDto.getSize());
        return brandWhite;
    }
}
