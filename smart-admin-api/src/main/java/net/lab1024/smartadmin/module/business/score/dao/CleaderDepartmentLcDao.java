package net.lab1024.smartadmin.module.business.score.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.CleaderDepartmentLcEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 基层单位对机关部门评议打分表（路产） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:50:51
 * @since JDK1.8
 */
@Mapper
@Component
public interface CleaderDepartmentLcDao extends BaseMapper<CleaderDepartmentLcEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return CleaderDepartmentLcVO
    */
    IPage<CleaderDepartmentLcVO> queryByPage(Page page, @Param("queryDTO") CleaderDepartmentLcQueryDTO queryDTO);

    /**
     * 根据id删除
     * @param id
     * @return
    */
    void deleteById(@Param("id")Long id);

    /**
     * 根据id批量删除
     * @param idList
     * @return
    */
    void deleteByIdList(@Param("idList") List<Long> idList);

        /**
     * 查询所有导出数据
     * @param queryDTO
     * @return
     */
    List<CleaderDepartmentLcExcelVO> queryAllExportData(@Param("queryDTO")CleaderDepartmentLcQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<CleaderDepartmentLcExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
