package net.lab1024.smartadmin.module.support.codegenerator;

import net.lab1024.smartadmin.BaseTest;
import net.lab1024.smartadmin.module.support.codegenerator.constant.SqlOperateTypeEnum;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorDTO;
import net.lab1024.smartadmin.module.support.codegenerator.domain.CodeGeneratorQueryColumnDTO;
import net.lab1024.smartadmin.module.support.codegenerator.service.CodeGeneratorService;
import com.google.common.collect.Lists;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * IdGeneratorService Tester.
 *
 * @author zhuoda
 * @version 1.0
 */
public class CodeGeneratorServiceTest extends BaseTest {

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
        //搜索字段 type， 使用==搜索
        CodeGeneratorQueryColumnDTO type = CodeGeneratorQueryColumnDTO.builder()
                .columnName("type")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        //搜索字段 type， 使用==搜索
        CodeGeneratorQueryColumnDTO year = CodeGeneratorQueryColumnDTO.builder()
                .columnName("year")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO quarter = CodeGeneratorQueryColumnDTO.builder()
                .columnName("quarter")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO month = CodeGeneratorQueryColumnDTO.builder()
                .columnName("month")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO status = CodeGeneratorQueryColumnDTO.builder()
                .columnName("status")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();
        CodeGeneratorQueryColumnDTO approval = CodeGeneratorQueryColumnDTO.builder()
                .columnName("approval")
                .sqlOperate(SqlOperateTypeEnum.EQUALS).build();



        List<CodeGeneratorQueryColumnDTO> queryColumnList = Lists.newArrayList(id, name, type,year,quarter,month,status,approval);

        CodeGeneratorDTO codeGenerator = CodeGeneratorDTO.builder()
                .author("周天颖")//class 注释作者
                .company("三格数维")//class注释公司名字
                .tableName("t_auth_taskinfo")//表名
                .tablePrefix("t_auth")//表名前缀
                .basePackage("net.lab1024.smartadmin")//包名
                .modulePackage("business.taskinfo")//业务子包名
                .queryColumnList(queryColumnList)//加入搜搜字段
                .build();//构建

        //当需要代码生成的时候，请将注释去掉
       codeGeneratorService.codeGenerator(codeGenerator);
    }

}
