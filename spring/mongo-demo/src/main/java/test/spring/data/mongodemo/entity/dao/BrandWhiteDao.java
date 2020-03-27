package test.spring.data.mongodemo.entity.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;
import test.spring.data.mongodemo.base.mongo.BaseDao;
import test.spring.data.mongodemo.entity.mongo.BrandWhite;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 17:11
 */
@Component
public class BrandWhiteDao extends BaseDao<BrandWhite> {


}
