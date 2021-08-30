package net.lab1024.smartadmin.module.business.rpscore.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyQueryDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.entity.AuthRewardsPenaltyEntity;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyVO;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyExcelVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * [ 考核加分扣分记录表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-20 11:36:35
 * @since JDK1.8
 */
@Mapper
@Component
public interface AuthRewardsPenaltyDao extends BaseMapper<AuthRewardsPenaltyEntity> {

    /**
     * 分页查询
     * @param queryDTO
     * @return AuthRewardsPenaltyVO
    */
    IPage<AuthRewardsPenaltyVO> queryByPage(Page page, @Param("queryDTO") AuthRewardsPenaltyQueryDTO queryDTO);

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
    List<AuthRewardsPenaltyExcelVO> queryAllExportData(@Param("queryDTO")AuthRewardsPenaltyQueryDTO queryDTO);

        /**
         * 查询批量导出数据
         * @param idList
         * @return
         */
    List<AuthRewardsPenaltyExcelVO> queryBatchExportData(@Param("idList")List<Long> idList);
}
