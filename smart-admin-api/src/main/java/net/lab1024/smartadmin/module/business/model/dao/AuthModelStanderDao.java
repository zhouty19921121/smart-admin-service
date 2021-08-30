package net.lab1024.smartadmin.module.business.model.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.entity.AuthModelStanderEntity;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:10:14
 * @since JDK1.8
 */
@Mapper
@Component
public interface AuthModelStanderDao extends BaseMapper<AuthModelStanderEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return AuthModelStanderVO
    */
    IPage<AuthModelStanderVO> queryByPage(Page page, @Param("queryDTO") AuthModelStanderQueryDTO queryDTO);

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
    List<AuthModelStanderExcelVO> queryAllExportData(@Param("queryDTO")AuthModelStanderQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<AuthModelStanderExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
