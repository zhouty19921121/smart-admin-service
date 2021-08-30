package net.lab1024.smartadmin.module.business.score.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.CleaderDepartmentSfEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 基层单位对机关部门评议打分表（收费） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:53:32
 * @since JDK1.8
 */
@Mapper
@Component
public interface CleaderDepartmentSfDao extends BaseMapper<CleaderDepartmentSfEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return CleaderDepartmentSfVO
    */
    IPage<CleaderDepartmentSfVO> queryByPage(Page page, @Param("queryDTO") CleaderDepartmentSfQueryDTO queryDTO);

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
    List<CleaderDepartmentSfExcelVO> queryAllExportData(@Param("queryDTO")CleaderDepartmentSfQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<CleaderDepartmentSfExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
