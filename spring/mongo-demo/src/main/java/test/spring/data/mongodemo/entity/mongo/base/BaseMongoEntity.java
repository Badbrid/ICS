package test.spring.data.mongodemo.entity.mongo.base;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 9:56
 */
@Data
public class BaseMongoEntity {

    @Id
    private String id;

    @Field("create_time")
    private Long createTime;

    @Field("update_time")
    private Long updateTime;

    @Field("del_flg")
    private Integer delFlg;

    @Transient
    private Integer page;

    @Transient
    private Integer size;

    public BaseMongoEntity(){
        createTime = System.currentTimeMillis();
        updateTime = System.currentTimeMillis();
        delFlg = 0;
    }
}
