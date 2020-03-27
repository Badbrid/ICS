package test.spring.data.mongodemo.service;

import org.springframework.stereotype.Service;
import test.spring.data.mongodemo.entity.dto.BrandWhiteDto;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:52
 */
public interface AdminService {
    void insertBrandWhite(BrandWhiteDto brandWhiteDto);
    boolean brandWhiteExist(BrandWhiteDto brandWhiteDto);
    void delBrandWhite(BrandWhiteDto brandWhiteDto);
}
