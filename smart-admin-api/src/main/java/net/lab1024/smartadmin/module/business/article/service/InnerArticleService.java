package net.lab1024.smartadmin.module.business.article.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.article.dao.InnerArticleDao;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleAddDTO;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleUpdateDTO;
import net.lab1024.smartadmin.module.business.article.domain.dto.InnerArticleQueryDTO;
import net.lab1024.smartadmin.module.business.article.domain.entity.InnerArticleEntity;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleVO;
import net.lab1024.smartadmin.module.business.article.domain.vo.InnerArticleExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 内部采风 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-14 20:49:41
 * @since JDK1.8
 */
@Service
public class InnerArticleService {

    @Autowired
    private InnerArticleDao innerArticleDao;

    /**
     * 根据id查询
     */
    public InnerArticleEntity getById(Long id){
        return  innerArticleDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    public ResponseDTO<PageResultDTO<InnerArticleVO>> queryByPage(InnerArticleQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<InnerArticleVO> voList = innerArticleDao.queryByPage(page, queryDTO);
        PageResultDTO<InnerArticleVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    public ResponseDTO<String> add(InnerArticleAddDTO addDTO) {
        InnerArticleEntity entity = SmartBeanUtil.copy(addDTO, InnerArticleEntity.class);
        innerArticleDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(InnerArticleUpdateDTO updateDTO) {
        InnerArticleEntity entity = SmartBeanUtil.copy(updateDTO, InnerArticleEntity.class);
        innerArticleDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        innerArticleDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    public List<InnerArticleExcelVO> queryAllExportData(InnerArticleQueryDTO queryDTO) {
        return innerArticleDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-14 20:49:41
     */
    public List<InnerArticleExcelVO> queryBatchExportData(List<Long> idList) {
        return innerArticleDao.queryBatchExportData(idList);
    }
}
