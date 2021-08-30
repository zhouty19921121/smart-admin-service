package net.lab1024.smartadmin.module.business.sumscore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.QuarterCompanyEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:39:58
 * @since JDK1.8
 */
@Mapper
@Component
public interface QuarterCompanyDao extends BaseMapper<QuarterCompanyEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return QuarterCompanyVO
    */
    IPage<QuarterCompanyVO> queryByPage(Page page, @Param("queryDTO") QuarterCompanyQueryDTO queryDTO);

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
    List<QuarterCompanyExcelVO> queryAllExportData(@Param("queryDTO")QuarterCompanyQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<QuarterCompanyExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
