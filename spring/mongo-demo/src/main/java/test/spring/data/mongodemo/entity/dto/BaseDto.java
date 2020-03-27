package test.spring.data.mongodemo.entity.dto;

import lombok.Data;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 17:31
 */
@Data
public class BaseDto {
    private Integer page = 0;
    private Integer size = 10;

}
