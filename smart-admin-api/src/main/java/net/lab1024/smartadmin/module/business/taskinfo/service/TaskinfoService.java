package net.lab1024.smartadmin.module.business.taskinfo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.taskinfo.dao.TaskinfoDao;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoAddDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoUpdateDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.dto.TaskinfoQueryDTO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.entity.TaskinfoEntity;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoVO;
import net.lab1024.smartadmin.module.business.taskinfo.domain.vo.TaskinfoExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
@Service
public class TaskinfoService {

    @Autowired
    private TaskinfoDao taskinfoDao;

    /**
     * 根据id查询
     */
    public TaskinfoEntity getById(Long id){
        return  taskinfoDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    public ResponseDTO<PageResultDTO<TaskinfoVO>> queryByPage(TaskinfoQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<TaskinfoVO> voList = taskinfoDao.queryByPage(page, queryDTO);
        PageResultDTO<TaskinfoVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    public ResponseDTO<String> add(TaskinfoAddDTO addDTO) {
        TaskinfoEntity entity = SmartBeanUtil.copy(addDTO, TaskinfoEntity.class);
        taskinfoDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(TaskinfoUpdateDTO updateDTO) {
        TaskinfoEntity entity = SmartBeanUtil.copy(updateDTO, TaskinfoEntity.class);
        taskinfoDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        taskinfoDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    public List<TaskinfoExcelVO> queryAllExportData(TaskinfoQueryDTO queryDTO) {
        return taskinfoDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-14 16:20:27
     */
    public List<TaskinfoExcelVO> queryBatchExportData(List<Long> idList) {
        return taskinfoDao.queryBatchExportData(idList);
    }
}
