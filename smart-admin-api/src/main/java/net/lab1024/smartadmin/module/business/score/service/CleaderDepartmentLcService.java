package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.CleaderDepartmentLcDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentLcQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.CleaderDepartmentLcEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentLcExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 基层单位对机关部门评议打分表（路产） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:50:51
 * @since JDK1.8
 */
@Service
public class CleaderDepartmentLcService {

    @Autowired
    private CleaderDepartmentLcDao cleaderDepartmentLcDao;

    /**
     * 根据id查询
     */
    public CleaderDepartmentLcEntity getById(Long id){
        return  cleaderDepartmentLcDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    public ResponseDTO<PageResultDTO<CleaderDepartmentLcVO>> queryByPage(CleaderDepartmentLcQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<CleaderDepartmentLcVO> voList = cleaderDepartmentLcDao.queryByPage(page, queryDTO);
        PageResultDTO<CleaderDepartmentLcVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    public ResponseDTO<String> add(CleaderDepartmentLcAddDTO addDTO) {
        CleaderDepartmentLcEntity entity = SmartBeanUtil.copy(addDTO, CleaderDepartmentLcEntity.class);
        cleaderDepartmentLcDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(CleaderDepartmentLcUpdateDTO updateDTO) {
        CleaderDepartmentLcEntity entity = SmartBeanUtil.copy(updateDTO, CleaderDepartmentLcEntity.class);
        cleaderDepartmentLcDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        cleaderDepartmentLcDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    public List<CleaderDepartmentLcExcelVO> queryAllExportData(CleaderDepartmentLcQueryDTO queryDTO) {
        return cleaderDepartmentLcDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 12:50:51
     */
    public List<CleaderDepartmentLcExcelVO> queryBatchExportData(List<Long> idList) {
        return cleaderDepartmentLcDao.queryBatchExportData(idList);
    }
}
