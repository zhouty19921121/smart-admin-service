package net.lab1024.smartadmin.module.business.group.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.group.dao.AuthGroupEmployeeDao;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeAddDTO;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeUpdateDTO;
import net.lab1024.smartadmin.module.business.group.domain.dto.AuthGroupEmployeeQueryDTO;
import net.lab1024.smartadmin.module.business.group.domain.entity.AuthGroupEmployeeEntity;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeVO;
import net.lab1024.smartadmin.module.business.group.domain.vo.AuthGroupEmployeeExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 考核组表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:01:40
 * @since JDK1.8
 */
@Service
public class AuthGroupEmployeeService {

    @Autowired
    private AuthGroupEmployeeDao authGroupEmployeeDao;

    /**
     * 根据id查询
     */
    public AuthGroupEmployeeEntity getById(Long id){
        return  authGroupEmployeeDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    public ResponseDTO<PageResultDTO<AuthGroupEmployeeVO>> queryByPage(AuthGroupEmployeeQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AuthGroupEmployeeVO> voList = authGroupEmployeeDao.queryByPage(page, queryDTO);
        PageResultDTO<AuthGroupEmployeeVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    public ResponseDTO<String> add(AuthGroupEmployeeAddDTO addDTO) {
        AuthGroupEmployeeEntity entity = SmartBeanUtil.copy(addDTO, AuthGroupEmployeeEntity.class);
        authGroupEmployeeDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AuthGroupEmployeeUpdateDTO updateDTO) {
        AuthGroupEmployeeEntity entity = SmartBeanUtil.copy(updateDTO, AuthGroupEmployeeEntity.class);
        authGroupEmployeeDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        authGroupEmployeeDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    public List<AuthGroupEmployeeExcelVO> queryAllExportData(AuthGroupEmployeeQueryDTO queryDTO) {
        return authGroupEmployeeDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-14 22:01:40
     */
    public List<AuthGroupEmployeeExcelVO> queryBatchExportData(List<Long> idList) {
        return authGroupEmployeeDao.queryBatchExportData(idList);
    }
}
