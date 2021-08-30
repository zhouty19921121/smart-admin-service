package net.lab1024.smartadmin.module.business.sumscore.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.sumscore.dao.YearLeaderDao;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderAddDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderUpdateDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.dto.YearLeaderQueryDTO;
import net.lab1024.smartadmin.module.business.sumscore.domain.entity.YearLeaderEntity;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderVO;
import net.lab1024.smartadmin.module.business.sumscore.domain.vo.YearLeaderExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 年度综合考评成绩汇总 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 14:57:40
 * @since JDK1.8
 */
@Service
public class YearLeaderService {

    @Autowired
    private YearLeaderDao yearLeaderDao;

    /**
     * 根据id查询
     */
    public YearLeaderEntity getById(Long id){
        return  yearLeaderDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    public ResponseDTO<PageResultDTO<YearLeaderVO>> queryByPage(YearLeaderQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<YearLeaderVO> voList = yearLeaderDao.queryByPage(page, queryDTO);
        PageResultDTO<YearLeaderVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    public ResponseDTO<String> add(YearLeaderAddDTO addDTO) {
        YearLeaderEntity entity = SmartBeanUtil.copy(addDTO, YearLeaderEntity.class);
        yearLeaderDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(YearLeaderUpdateDTO updateDTO) {
        YearLeaderEntity entity = SmartBeanUtil.copy(updateDTO, YearLeaderEntity.class);
        yearLeaderDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        yearLeaderDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    public List<YearLeaderExcelVO> queryAllExportData(YearLeaderQueryDTO queryDTO) {
        return yearLeaderDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 14:57:40
     */
    public List<YearLeaderExcelVO> queryBatchExportData(List<Long> idList) {
        return yearLeaderDao.queryBatchExportData(idList);
    }
}
