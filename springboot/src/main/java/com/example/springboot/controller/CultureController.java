package com.example.springboot.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.resp.Result;
import com.example.springboot.entity.CultureEntity;
import com.example.springboot.entity.EstateEntity;
import com.example.springboot.mapper.CultureMapper;
import com.example.springboot.mapper.EstateMapper;
import com.example.springboot.service.CultureService;
import com.example.springboot.service.EstateService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 文化遗产表 前端控制器
 * </p>
 *
 * @author he
 * @since 2023-12-25
 */
@Tag(name = "文化遗产")
@RestController
@RequestMapping("/cultureEntity")
public class CultureController {
    @Autowired
    private CultureMapper cultureMapper;
    @Autowired
    private CultureService cultureService;
    @Autowired
    private EstateMapper estateMapper;
    @Autowired
    private EstateService estateService;

    @Operation(summary = "遗产分页列表")
    @GetMapping("/list")
    public Result<List<CultureEntity>> pageCulture(@RequestParam Integer current, @RequestParam Integer size) {
        // 创建分页对象
        Page<CultureEntity> page = new Page<>(current, size);
        Page<CultureEntity> entityPage = cultureMapper.selectPage(page, null);
        return Result.success(entityPage);
    }

    @Operation(summary = "获取地图数据")
    @GetMapping("/map")
    public Result<List<CultureEntity>> mapCulture(@RequestParam String city) {
        ArrayList<Object> list = new ArrayList<>();
        long num = estateService.count();
        for (int i = 1; i <= num; i++) {
            QueryWrapper<CultureEntity> wrapper = new QueryWrapper<>();
            wrapper.eq("city", city).eq("category", i);
            QueryWrapper<EstateEntity> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("id", i);
            EstateEntity byId = estateService.getOne(queryWrapper);
            Long count = cultureMapper.selectCount(wrapper);
            HashMap<String, String> map = new HashMap<>();
            map.put("label", byId.getCategory());
            map.put("count", count.toString());
            list.add(map);
        }
        return Result.success(list);
    }


}
