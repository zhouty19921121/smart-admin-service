package net.lab1024.smartadmin.module.business.group.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeQueryDTO;
import net.lab1024.smartadmin.module.business.group.domain.entity.AuthGroupEmployeeEntity;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeVO;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 考核组表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:01:40
 * @since JDK1.8
 */
@Mapper
@Component
public interface AuthGroupEmployeeDao extends BaseMapper<AuthGroupEmployeeEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return AuthGroupEmployeeVO
    */
    IPage<AuthGroupEmployeeVO> queryByPage(Page page, @Param("queryDTO") AuthGroupEmployeeQueryDTO queryDTO);

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
    List<AuthGroupEmployeeExcelVO> queryAllExportData(@Param("queryDTO")AuthGroupEmployeeQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<AuthGroupEmployeeExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
