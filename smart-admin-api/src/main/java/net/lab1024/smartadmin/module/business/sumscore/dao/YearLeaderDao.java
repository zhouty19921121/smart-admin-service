package net.lab1024.smartadmin.module.business.sumscore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.YearLeaderEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:57:40
 * @since JDK1.8
 */
@Mapper
@Component
public interface YearLeaderDao extends BaseMapper<YearLeaderEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return YearLeaderVO
    */
    IPage<YearLeaderVO> queryByPage(Page page, @Param("queryDTO") YearLeaderQueryDTO queryDTO);

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
    List<YearLeaderExcelVO> queryAllExportData(@Param("queryDTO")YearLeaderQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<YearLeaderExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
