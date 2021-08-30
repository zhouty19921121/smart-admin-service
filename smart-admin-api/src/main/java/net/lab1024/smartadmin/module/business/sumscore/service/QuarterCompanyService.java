package net.lab1024.smartadmin.module.business.sumscore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.sumscore.dao.QuarterCompanyDao;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.QuarterCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.QuarterCompanyEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.QuarterCompanyExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 季度所属各单位考核结果排名 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:39:58
 * @since JDK1.8
 */
@Service
public class QuarterCompanyService {

    @Autowired
    private QuarterCompanyDao quarterCompanyDao;

    /**
     * 根据id查询
     */
    public QuarterCompanyEntity getById(Long id){
        return  quarterCompanyDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    public ResponseDTO<PageResultDTO<QuarterCompanyVO>> queryByPage(QuarterCompanyQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<QuarterCompanyVO> voList = quarterCompanyDao.queryByPage(page, queryDTO);
        PageResultDTO<QuarterCompanyVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    public ResponseDTO<String> add(QuarterCompanyAddDTO addDTO) {
        QuarterCompanyEntity entity = SmartBeanUtil.copy(addDTO, QuarterCompanyEntity.class);
        quarterCompanyDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(QuarterCompanyUpdateDTO updateDTO) {
        QuarterCompanyEntity entity = SmartBeanUtil.copy(updateDTO, QuarterCompanyEntity.class);
        quarterCompanyDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        quarterCompanyDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    public List<QuarterCompanyExcelVO> queryAllExportData(QuarterCompanyQueryDTO queryDTO) {
        return quarterCompanyDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 14:39:58
     */
    public List<QuarterCompanyExcelVO> queryBatchExportData(List<Long> idList) {
        return quarterCompanyDao.queryBatchExportData(idList);
    }
}
