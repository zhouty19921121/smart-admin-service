package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.LeaderDepartmentDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.LeaderDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.LeaderDepartmentEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.LeaderDepartmentExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class LeaderDepartmentService {

    @Autowired
    private LeaderDepartmentDao leaderDepartmentDao;

    /**
     * 根据id查询
     */
    public LeaderDepartmentEntity getById(Long id){
        return  leaderDepartmentDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    public ResponseDTO<PageResultDTO<LeaderDepartmentVO>> queryByPage(LeaderDepartmentQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<LeaderDepartmentVO> voList = leaderDepartmentDao.queryByPage(page, queryDTO);
        PageResultDTO<LeaderDepartmentVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    public ResponseDTO<String> add(LeaderDepartmentAddDTO addDTO) {
        LeaderDepartmentEntity entity = SmartBeanUtil.copy(addDTO, LeaderDepartmentEntity.class);
        leaderDepartmentDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(LeaderDepartmentUpdateDTO updateDTO) {
        LeaderDepartmentEntity entity = SmartBeanUtil.copy(updateDTO, LeaderDepartmentEntity.class);
        leaderDepartmentDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        leaderDepartmentDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    public List<LeaderDepartmentExcelVO> queryAllExportData(LeaderDepartmentQueryDTO queryDTO) {
        return leaderDepartmentDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 12:59:58
     */
    public List<LeaderDepartmentExcelVO> queryBatchExportData(List<Long> idList) {
        return leaderDepartmentDao.queryBatchExportData(idList);
    }
}
