package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.DepartmenDepartmentDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.DepartmenDepartmentQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.DepartmenDepartmentEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.DepartmenDepartmentVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.DepartmenDepartmentExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 本部部门互评打分表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:56:11
 * @since JDK1.8
 */
@Service
public class DepartmenDepartmentService {

    @Autowired
    private DepartmenDepartmentDao departmenDepartmentDao;

    /**
     * 根据id查询
     */
    public DepartmenDepartmentEntity getById(Long id){
        return  departmenDepartmentDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    public ResponseDTO<PageResultDTO<DepartmenDepartmentVO>> queryByPage(DepartmenDepartmentQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<DepartmenDepartmentVO> voList = departmenDepartmentDao.queryByPage(page, queryDTO);
        PageResultDTO<DepartmenDepartmentVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    public ResponseDTO<String> add(DepartmenDepartmentAddDTO addDTO) {
        DepartmenDepartmentEntity entity = SmartBeanUtil.copy(addDTO, DepartmenDepartmentEntity.class);
        departmenDepartmentDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(DepartmenDepartmentUpdateDTO updateDTO) {
        DepartmenDepartmentEntity entity = SmartBeanUtil.copy(updateDTO, DepartmenDepartmentEntity.class);
        departmenDepartmentDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        departmenDepartmentDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    public List<DepartmenDepartmentExcelVO> queryAllExportData(DepartmenDepartmentQueryDTO queryDTO) {
        return departmenDepartmentDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 12:56:11
     */
    public List<DepartmenDepartmentExcelVO> queryBatchExportData(List<Long> idList) {
        return departmenDepartmentDao.queryBatchExportData(idList);
    }
}
