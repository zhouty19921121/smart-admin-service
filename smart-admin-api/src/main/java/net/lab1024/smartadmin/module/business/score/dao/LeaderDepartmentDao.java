package net.lab1024.smartadmin.module.business.score.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.LeaderDepartmentEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 公司领导对机关部门民主评议 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:59:58
 * @since JDK1.8
 */
@Mapper
@Component
public interface LeaderDepartmentDao extends BaseMapper<LeaderDepartmentEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return LeaderDepartmentVO
    */
    IPage<LeaderDepartmentVO> queryByPage(Page page, @Param("queryDTO") LeaderDepartmentQueryDTO queryDTO);

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
    List<LeaderDepartmentExcelVO> queryAllExportData(@Param("queryDTO")LeaderDepartmentQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<LeaderDepartmentExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
