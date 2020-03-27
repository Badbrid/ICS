package test.spring.data.mongodemo.controller.api;

import lombok.Data;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:35
 */
@Data
public class AdminRequest {
    private Integer page;
    private Integer size;
}
