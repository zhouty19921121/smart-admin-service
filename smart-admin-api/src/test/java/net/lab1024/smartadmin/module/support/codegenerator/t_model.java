package net.lab1024.smartadmin.module.support.codegenerator;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import net.lab1024.smartadmin.BaseTest;
import net.lab1024.smartadmin.module.support.codegenerator.constant.SqlOperateTypeEnum;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorDTO;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorQueryColumnDTO;
import net.lab1024.smartadmin.module.support.codegenerator.service.CodeGeneratorService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IdGeneratorService Tester.
 *
 * @author zhuoda
 * @version 1.0
 */
@Slf4j
public class t_model extends BaseTest {

   // @Test

    public void testGenerate() throws Exception {
        /**
         * !!! 所有查询条件均包含了createTime和updateTime的 范围查询 !!!
         */
        new t_model_cleader_department_lc().testGenerate();
        log.info("代码生成完毕：", "t_model_cleader_department_lc");
        new t_model_cleader_department_sf().testGenerate();
        log.info("代码生成完毕：", "t_model_cleader_department_sf");
        new t_model_departmen_department().testGenerate();
        log.info("代码生成完毕：", "t_model_departmen_department");
        new t_model_leader_company().testGenerate();

        log.info("代码生成完毕：", "t_model_leader_company");
        new t_model_leader_department().testGenerate();
        log.info("代码生成完毕：", "t_model_leader_department");
        new t_model_person_company().testGenerate();
        log.info("代码生成完毕：", "t_model_person_company");
    }

}
