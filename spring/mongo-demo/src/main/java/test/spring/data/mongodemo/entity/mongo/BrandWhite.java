package test.spring.data.mongodemo.entity.mongo;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import test.spring.data.mongodemo.entity.mongo.base.BaseMongoEntity;


/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/25 20:22
 */
@Document("brand_white")
@Data
public class BrandWhite extends BaseMongoEntity {

    private String brand;

    private String model;

    private String modelVersion;
}
