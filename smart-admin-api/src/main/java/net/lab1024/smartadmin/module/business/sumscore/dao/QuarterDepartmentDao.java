package net.lab1024.smartadmin.module.business.sumscore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.QuarterDepartmentEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 季度本部各部门考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:41:36
 * @since JDK1.8
 */
@Mapper
@Component
public interface QuarterDepartmentDao extends BaseMapper<QuarterDepartmentEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return QuarterDepartmentVO
    */
    IPage<QuarterDepartmentVO> queryByPage(Page page, @Param("queryDTO") QuarterDepartmentQueryDTO queryDTO);

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
    List<QuarterDepartmentExcelVO> queryAllExportData(@Param("queryDTO")QuarterDepartmentQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<QuarterDepartmentExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
