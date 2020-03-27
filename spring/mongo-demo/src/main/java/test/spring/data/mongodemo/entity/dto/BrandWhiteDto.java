package test.spring.data.mongodemo.entity.dto;

import lombok.Data;
/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:53
 */
@Data
public class BrandWhiteDto extends BaseDto {

    private String brand;
    private String model;
    private String modelVersion;

}
