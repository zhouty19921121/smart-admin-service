package net.lab1024.smartadmin.module.business.model.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.model.dao.AuthModelStanderDao;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderAddDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderUpdateDTO;
import net.lab1024.smartadmin.module.business.model.domain.dto.AuthModelStanderQueryDTO;
import net.lab1024.smartadmin.module.business.model.domain.entity.AuthModelStanderEntity;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderVO;
import net.lab1024.smartadmin.module.business.model.domain.vo.AuthModelStanderExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 部门考核标准 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 22:10:14
 * @since JDK1.8
 */
@Service
public class AuthModelStanderService {

    @Autowired
    private AuthModelStanderDao authModelStanderDao;

    /**
     * 根据id查询
     */
    public AuthModelStanderEntity getById(Long id){
        return  authModelStanderDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    public ResponseDTO<PageResultDTO<AuthModelStanderVO>> queryByPage(AuthModelStanderQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<AuthModelStanderVO> voList = authModelStanderDao.queryByPage(page, queryDTO);
        PageResultDTO<AuthModelStanderVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    public ResponseDTO<String> add(AuthModelStanderAddDTO addDTO) {
        AuthModelStanderEntity entity = SmartBeanUtil.copy(addDTO, AuthModelStanderEntity.class);
        authModelStanderDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(AuthModelStanderUpdateDTO updateDTO) {
        AuthModelStanderEntity entity = SmartBeanUtil.copy(updateDTO, AuthModelStanderEntity.class);
        authModelStanderDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        authModelStanderDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    public List<AuthModelStanderExcelVO> queryAllExportData(AuthModelStanderQueryDTO queryDTO) {
        return authModelStanderDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-14 22:10:14
     */
    public List<AuthModelStanderExcelVO> queryBatchExportData(List<Long> idList) {
        return authModelStanderDao.queryBatchExportData(idList);
    }
}
