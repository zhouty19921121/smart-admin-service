package net.lab1024.smartadmin.module.business.score.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.lab1024.smartadmin.common.domain.PageResultDTO;
import net.lab1024.smartadmin.common.domain.ResponseDTO;
import net.lab1024.smartadmin.module.business.score.dao.PersonCompanyDao;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyAddDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyUpdateDTO;
import net.lab1024.smartadmin.module.business.score.domain.dto.PersonCompanyQueryDTO;
import net.lab1024.smartadmin.module.business.score.domain.entity.PersonCompanyEntity;
import net.lab1024.smartadmin.module.business.score.domain.vo.PersonCompanyVO;
import net.lab1024.smartadmin.module.business.score.domain.vo.PersonCompanyExcelVO;
import net.lab1024.smartadmin.util.SmartPageUtil;
import net.lab1024.smartadmin.util.SmartBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * [ 基层员工评价表 ]
 *
 * @author 周天颖
 * @version 1.0
 * @company 三格数维
 * @copyright (c)  三格数维Inc. All rights reserved.
 * @date 2021-08-15 13:03:21
 * @since JDK1.8
 */
@Service
public class PersonCompanyService {

    @Autowired
    private PersonCompanyDao personCompanyDao;

    /**
     * 根据id查询
     */
    public PersonCompanyEntity getById(Long id){
        return  personCompanyDao.selectById(id);
    }

    /**
     * 分页查询
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    public ResponseDTO<PageResultDTO<PersonCompanyVO>> queryByPage(PersonCompanyQueryDTO queryDTO) {
        Page page = SmartPageUtil.convert2QueryPage(queryDTO);
        IPage<PersonCompanyVO> voList = personCompanyDao.queryByPage(page, queryDTO);
        PageResultDTO<PersonCompanyVO> pageResultDTO = SmartPageUtil.convert2PageResult(voList);
        return ResponseDTO.succData(pageResultDTO);
    }

    /**
     * 添加
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    public ResponseDTO<String> add(PersonCompanyAddDTO addDTO) {
        PersonCompanyEntity entity = SmartBeanUtil.copy(addDTO, PersonCompanyEntity.class);
        personCompanyDao.insert(entity);
        return ResponseDTO.succ();
    }

    /**
     * 编辑
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> update(PersonCompanyUpdateDTO updateDTO) {
        PersonCompanyEntity entity = SmartBeanUtil.copy(updateDTO, PersonCompanyEntity.class);
        personCompanyDao.updateById(entity);
        return ResponseDTO.succ();
    }

    /**
     * 删除
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    @Transactional(rollbackFor = Exception.class)
    public ResponseDTO<String> deleteByIds(List<Long> idList) {
        personCompanyDao.deleteByIdList(idList);
        return ResponseDTO.succ();
    }

    /**
     * 查询全部导出对象
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    public List<PersonCompanyExcelVO> queryAllExportData(PersonCompanyQueryDTO queryDTO) {
        return personCompanyDao.queryAllExportData( queryDTO);
    }

    /**
     * 批量查询导出对象
     * @author 周天颖
     * @date 2021-08-15 13:03:21
     */
    public List<PersonCompanyExcelVO> queryBatchExportData(List<Long> idList) {
        return personCompanyDao.queryBatchExportData(idList);
    }
}
