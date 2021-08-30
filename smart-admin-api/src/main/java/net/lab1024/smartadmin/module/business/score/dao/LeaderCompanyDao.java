package net.lab1024.smartadmin.module.business.score.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.LeaderCompanyEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 基层员工评价对所属各单位测评表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:57:48
 * @since JDK1.8
 */
@Mapper
@Component
public interface LeaderCompanyDao extends BaseMapper<LeaderCompanyEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return LeaderCompanyVO
    */
    IPage<LeaderCompanyVO> queryByPage(Page page, @Param("queryDTO") LeaderCompanyQueryDTO queryDTO);

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
    List<LeaderCompanyExcelVO> queryAllExportData(@Param("queryDTO")LeaderCompanyQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<LeaderCompanyExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
