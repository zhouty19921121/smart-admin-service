package net.lab1024.smartadmin.module.support.codegenerator;

import com.google.common.collect.Lists;
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
public class CodeGeneratorServiceTestiModel extends BaseTest {

    @Autowired
    private CodeGeneratorService codeGeneratorService;

    //@Test
    public void testGenerate() throws Exception {
        /**
         * !!! 所有查询条件均包含了createTime和updateTime的 范围查询 !!!
         */
//搜索字段 kind， 使用 == 搜索
        CodeGeneratorQueryColumnDTO id = CodeGeneratorQueryColumnDTO.builder()
                .columnName("id")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        //搜索字段 name， 使用like搜索
        CodeGeneratorQueryColumnDTO name = CodeGeneratorQueryColumnDTO.builder()
                .columnName("name")
                .sqlOperate(SqlOperateTypeEnum.LIKE).build();


        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(id,name);
        CodeGeneratorDTO codeGenerator = CodeGeneratorDTO.builder()
                .author("周天颖")//class 注释作者
                .company("三格数维")//class注释公司名字
                .tableName("t_auth_model")//表名
                .tablePrefix("t_")//表名前缀
                .basePackage("net.lab1024.smartadmin")//包名
                .modulePackage("business.model")//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建

        //当需要代码生成的时候，请将注释去掉
       codeGeneratorService.codeGenerator(codeGenerator);
    }

}
