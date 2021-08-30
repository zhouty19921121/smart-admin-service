package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.CleaderDepartmentSfDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.CleaderDepartmentSfQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.CleaderDepartmentSfEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.CleaderDepartmentSfExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 基层单位对机关部门评议打分表（收费） ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 12:53:32
 * @since JDK1.8
 */
@Service
public class CleaderDepartmentSfService {

    @Autowired
    private CleaderDepartmentSfDao cleaderDepartmentSfDao;

    /**
     * 根据id查询
     */
    public CleaderDepartmentSfEntity getById(Long id){
        return  cleaderDepartmentSfDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    public ResponseDTO<PageResultDTO<CleaderDepartmentSfVO>> queryByPage(CleaderDepartmentSfQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<CleaderDepartmentSfVO> voList = cleaderDepartmentSfDao.queryByPage(page, queryDTO);
        PageResultDTO<CleaderDepartmentSfVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    public ResponseDTO<String> add(CleaderDepartmentSfAddDTO addDTO) {
        CleaderDepartmentSfEntity entity = SmartBeanUtil.copy(addDTO, CleaderDepartmentSfEntity.class);
        cleaderDepartmentSfDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(CleaderDepartmentSfUpdateDTO updateDTO) {
        CleaderDepartmentSfEntity entity = SmartBeanUtil.copy(updateDTO, CleaderDepartmentSfEntity.class);
        cleaderDepartmentSfDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        cleaderDepartmentSfDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    public List<CleaderDepartmentSfExcelVO> queryAllExportData(CleaderDepartmentSfQueryDTO queryDTO) {
        return cleaderDepartmentSfDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 12:53:32
     */
    public List<CleaderDepartmentSfExcelVO> queryBatchExportData(List<Long> idList) {
        return cleaderDepartmentSfDao.queryBatchExportData(idList);
    }
}
