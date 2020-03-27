package test.spring.data.mongodemo.base.mongo;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import test.spring.data.mongodemo.entity.mongo.BrandWhite;
import test.spring.data.mongodemo.entity.mongo.base.BaseMongoEntity;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 17:21
 */
public abstract class BaseDao<T extends BaseMongoEntity> {
    @Autowired
    MongoTemplate mongoTemplate;

    public void insert(T t){
        mongoTemplate.save(t);
    }

    public boolean exist(BrandWhite brandWhite){
        Query query = getQuery(brandWhite);
        return mongoTemplate.exists(query,BrandWhite.class);
    }

    public Query getQuery(BrandWhite brandWhite){
        Query query = new Query();
        if(ObjectUtils.isNotEmpty(brandWhite.getBrand())){
            query.addCriteria(Criteria.where("brand").is(brandWhite.getBrand()));
        }
        if(ObjectUtils.isNotEmpty(brandWhite.getModel())){
            query.addCriteria(Criteria.where("model").is(brandWhite.getModel()));
        }
        if(ObjectUtils.isNotEmpty(brandWhite.getModelVersion())){
            query.addCriteria(Criteria.where("modelVersion").is(brandWhite.getModel()));
        }
        return query;
    }
}
