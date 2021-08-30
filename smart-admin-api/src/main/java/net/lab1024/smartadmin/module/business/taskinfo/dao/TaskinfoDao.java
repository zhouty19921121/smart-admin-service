package net.lab1024.smartadmin.module.business.taskinfo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoQueryDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.entity.TaskinfoEntity;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoVO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 工作绩效 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 16:20:27
 * @since JDK1.8
 */
@Mapper
@Component
public interface TaskinfoDao extends BaseMapper<TaskinfoEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return TaskinfoVO
    */
    IPage<TaskinfoVO> queryByPage(Page page, @Param("queryDTO") TaskinfoQueryDTO queryDTO);

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
    List<TaskinfoExcelVO> queryAllExportData(@Param("queryDTO")TaskinfoQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<TaskinfoExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
