package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.LeaderCompanyDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.LeaderCompanyEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderCompanyExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class LeaderCompanyService {

    @Autowired
    private LeaderCompanyDao leaderCompanyDao;

    /**
     * 根据id查询
     */
    public LeaderCompanyEntity getById(Long id){
        return  leaderCompanyDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    public ResponseDTO<PageResultDTO<LeaderCompanyVO>> queryByPage(LeaderCompanyQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<LeaderCompanyVO> voList = leaderCompanyDao.queryByPage(page, queryDTO);
        PageResultDTO<LeaderCompanyVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    public ResponseDTO<String> add(LeaderCompanyAddDTO addDTO) {
        LeaderCompanyEntity entity = SmartBeanUtil.copy(addDTO, LeaderCompanyEntity.class);
        leaderCompanyDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(LeaderCompanyUpdateDTO updateDTO) {
        LeaderCompanyEntity entity = SmartBeanUtil.copy(updateDTO, LeaderCompanyEntity.class);
        leaderCompanyDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        leaderCompanyDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    public List<LeaderCompanyExcelVO> queryAllExportData(LeaderCompanyQueryDTO queryDTO) {
        return leaderCompanyDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 12:57:48
     */
    public List<LeaderCompanyExcelVO> queryBatchExportData(List<Long> idList) {
        return leaderCompanyDao.queryBatchExportData(idList);
    }
}
