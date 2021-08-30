package net.lab1024.smartadmin.module.business.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.entity.AuthModelEntity;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:11:15
 * @since JDK1.8
 */
@Mapper
@Component
public interface AuthModelDao extends BaseMapper<AuthModelEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return AuthModelVO
    */
    IPage<AuthModelVO> queryByPage(Page page, @Param("queryDTO") AuthModelQueryDTO queryDTO);

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
    List<AuthModelExcelVO> queryAllExportData(@Param("queryDTO")AuthModelQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<AuthModelExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
