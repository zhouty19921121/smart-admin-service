package net.lab1024.smartadmin.module.business.sumscore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.sumscore.dao.QuarterDepartmentDao;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.QuarterDepartmentEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterDepartmentExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 季度本部各部门考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:41:36
 * @since JDK1.8
 */
@Service
public class QuarterDepartmentService {

    @Autowired
    private QuarterDepartmentDao quarterDepartmentDao;

    /**
     * 根据id查询
     */
    public QuarterDepartmentEntity getById(Long id){
        return  quarterDepartmentDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    public ResponseDTO<PageResultDTO<QuarterDepartmentVO>> queryByPage(QuarterDepartmentQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<QuarterDepartmentVO> voList = quarterDepartmentDao.queryByPage(page, queryDTO);
        PageResultDTO<QuarterDepartmentVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    public ResponseDTO<String> add(QuarterDepartmentAddDTO addDTO) {
        QuarterDepartmentEntity entity = SmartBeanUtil.copy(addDTO, QuarterDepartmentEntity.class);
        quarterDepartmentDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(QuarterDepartmentUpdateDTO updateDTO) {
        QuarterDepartmentEntity entity = SmartBeanUtil.copy(updateDTO, QuarterDepartmentEntity.class);
        quarterDepartmentDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        quarterDepartmentDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    public List<QuarterDepartmentExcelVO> queryAllExportData(QuarterDepartmentQueryDTO queryDTO) {
        return quarterDepartmentDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 14:41:36
     */
    public List<QuarterDepartmentExcelVO> queryBatchExportData(List<Long> idList) {
        return quarterDepartmentDao.queryBatchExportData(idList);
    }
}
