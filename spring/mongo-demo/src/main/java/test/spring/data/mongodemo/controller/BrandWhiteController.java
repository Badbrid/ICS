package test.spring.data.mongodemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import test.spring.data.mongodemo.base.api.DataResult;
import test.spring.data.mongodemo.controller.api.BrandWhiteRequest;
import test.spring.data.mongodemo.controller.api.BrandWriteResponse;
import test.spring.data.mongodemo.entity.dto.BrandWhiteDto;
import test.spring.data.mongodemo.service.AdminService;

import javax.validation.Valid;

/**
 * @author zhangsht
 * @version 1.0
 * @date 2020/3/26 15:29
 */
@RestController
@RequestMapping("/admin/brandWhite")
public class BrandWhiteController {
    @Autowired
    AdminService adminService;

    @PostMapping("/add")
    public DataResult<BrandWriteResponse> add(@RequestBody @Valid BrandWhiteRequest request){
        BrandWhiteDto brandWhiteDto = getBrandWhite(request);
        BrandWriteResponse brandWriteResponse = new BrandWriteResponse();
        if(adminService.brandWhiteExist(brandWhiteDto)){
            brandWriteResponse.setResultCode(0);
            brandWriteResponse.setResultMsg("添加失败，白名单已经存在");
            return DataResult.newSuccess(brandWriteResponse);
        }
        adminService.insertBrandWhite(brandWhiteDto);
        brandWriteResponse.setResultCode(1);
        brandWriteResponse.setResultMsg("添加成功");
        return DataResult.newSuccess(brandWriteResponse);
    }

    private BrandWhiteDto getBrandWhite(BrandWhiteRequest brandWhiteRequest){
        BrandWhiteDto brandWhiteDto = new BrandWhiteDto();
        brandWhiteDto.setBrand(brandWhiteRequest.getBrand());
        brandWhiteDto.setModel(brandWhiteRequest.getModel());
        brandWhiteDto.setModelVersion(brandWhiteRequest.getModelVersion());
        brandWhiteDto.setPage(brandWhiteRequest.getPage());
        brandWhiteDto.setSize(brandWhiteRequest.getSize());
        return brandWhiteDto;
    }
}
