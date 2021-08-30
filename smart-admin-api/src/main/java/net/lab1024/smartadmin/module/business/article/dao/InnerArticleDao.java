package net.lab1024.smartadmin.module.business.article.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleQueryDTO;
import net.lab1024.smartadmin.module.business.article.domain.entity.InnerArticleEntity;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleVO;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 20:49:41
 * @since JDK1.8
 */
@Mapper
@Component
public interface InnerArticleDao extends BaseMapper<InnerArticleEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return InnerArticleVO
    */
    IPage<InnerArticleVO> queryByPage(Page page, @Param("queryDTO") InnerArticleQueryDTO queryDTO);

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
    List<InnerArticleExcelVO> queryAllExportData(@Param("queryDTO")InnerArticleQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<InnerArticleExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
