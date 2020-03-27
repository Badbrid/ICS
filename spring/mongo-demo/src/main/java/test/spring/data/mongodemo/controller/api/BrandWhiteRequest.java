package test.spring.data.mongodemo.controller.api;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:34
 */
@Data
public class BrandWhiteRequest extends AdminRequest{

    @NotEmpty(message = "品牌不能为空")
    private String brand;
    @NotEmpty(message = "机型不能为空")
    private String model;
    @NotEmpty(message = "机型版本能为空")
    private String modelVersion;
}
