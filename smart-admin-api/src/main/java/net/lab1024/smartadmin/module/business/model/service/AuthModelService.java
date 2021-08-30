package net.lab1024.smartadmin.module.business.model.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.model.dao.AuthModelDao;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelAddDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelUpdateDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.entity.AuthModelEntity;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 考核模板 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:11:15
 * @since JDK1.8
 */
@Service
public class AuthModelService {

    @Autowired
    private AuthModelDao authModelDao;

    /**
     * 根据id查询
     */
    public AuthModelEntity getById(Long id){
        return  authModelDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    public ResponseDTO<PageResultDTO<AuthModelVO>> queryByPage(AuthModelQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AuthModelVO> voList = authModelDao.queryByPage(page, queryDTO);
        PageResultDTO<AuthModelVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    public ResponseDTO<String> add(AuthModelAddDTO addDTO) {
        AuthModelEntity entity = SmartBeanUtil.copy(addDTO, AuthModelEntity.class);
        authModelDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AuthModelUpdateDTO updateDTO) {
        AuthModelEntity entity = SmartBeanUtil.copy(updateDTO, AuthModelEntity.class);
        authModelDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        authModelDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    public List<AuthModelExcelVO> queryAllExportData(AuthModelQueryDTO queryDTO) {
        return authModelDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-14 22:11:15
     */
    public List<AuthModelExcelVO> queryBatchExportData(List<Long> idList) {
        return authModelDao.queryBatchExportData(idList);
    }
}
