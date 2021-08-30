package net.lab1024.smartadmin.module.business.rpscore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.constant.JudgeEnum;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.rpscore.dao.AuthRewardsPenaltyDao;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyAddDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyUpdateDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.dto.AuthRewardsPenaltyQueryDTO;
import net.lab1024.smartadmin.module.business.rpscore.domain.entity.AuthRewardsPenaltyEntity;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyVO;
import net.lab1024.smartadmin.module.business.rpscore.domain.vo.AuthRewardsPenaltyExcelVO;
import net.lab1024.smartadmin.module.system.login.domain.RequestTokenBO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
@Service
public class AuthRewardsPenaltyService {

    @Autowired
    private AuthRewardsPenaltyDao authRewardsPenaltyDao;

    /**
     * 根据id查询
     */
    public AuthRewardsPenaltyEntity getById(Long id){
        return  authRewardsPenaltyDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    public ResponseDTO<PageResultDTO<AuthRewardsPenaltyVO>> queryByPage(AuthRewardsPenaltyQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AuthRewardsPenaltyVO> voList = authRewardsPenaltyDao.queryByPage(page, queryDTO);
        PageResultDTO<AuthRewardsPenaltyVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    public ResponseDTO<String> add(AuthRewardsPenaltyAddDTO addDTO, RequestTokenBO requestToken) {
        AuthRewardsPenaltyEntity entity = SmartBeanUtil.copy(addDTO, AuthRewardsPenaltyEntity.class);
        Date today =new Date();
        entity.setYear(today.getYear()+"");
        entity.setMonth(today.getMonth());
        entity.setQuarter(today.getMonth()/3);
        entity.setFillperson(requestToken.getRequestUserId().intValue());
        entity.setFilltime(today);
        entity.setCreateTime(today);
        entity.setIsDelete(JudgeEnum.NO.getValue());
        entity.setApproval(JudgeEnum.NO.getValue());
        entity.setApprovalperson(null);
        entity.setApprovaltime(null);
        authRewardsPenaltyDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AuthRewardsPenaltyUpdateDTO updateDTO) {
        AuthRewardsPenaltyEntity entity = SmartBeanUtil.copy(updateDTO, AuthRewardsPenaltyEntity.class);
        authRewardsPenaltyDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        authRewardsPenaltyDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    public List<AuthRewardsPenaltyExcelVO> queryAllExportData(AuthRewardsPenaltyQueryDTO queryDTO) {
        return authRewardsPenaltyDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-20 11:36:35
     */
    public List<AuthRewardsPenaltyExcelVO> queryBatchExportData(List<Long> idList) {
        return authRewardsPenaltyDao.queryBatchExportData(idList);
    }
}
