package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Override
    //事物控制 默认对RuntimeException 进行事物回滚
    @Transactional
    public boolean addArea(Area area) {
        if (area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("区域信息不能为空！");
    }

    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaId() != null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try {
                int effectNum = areaDao.updateArea(area);
                if (effectNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("区域ID不为空！");
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0){
            int effectNum = areaDao.deleteArea(areaId);
            try {

                if (effectNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:" + e.getMessage());
            }
        }
        throw new RuntimeException("区域ID不为空！");
    }
}