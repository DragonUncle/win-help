package top.dragon;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class Code {
    /**
     * 要生成的表名
     */
    private static final String[] tables = {
            "sweet_goods_shop",
            "sweet_goods_shop_picture",
    };

    /**
     * 数据库类型
     */
    private static final DbType dbType = DbType.MYSQL;

    /**
     * 启动入口
     * @param args 参数
     */
    public static void main(String[] args) {
        AutoGenerator gen = new AutoGenerator();
        /**
         * 数据库配置
         */
        //数据库配置四要素
        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://192.168.1.10:3306/win-help?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "ws101122..";
        gen.setDataSource(new DataSourceConfig()
                .setDbType(dbType)
                .setDriverName(driverName)
                .setUrl(url)
                .setUsername(username)
                .setPassword(password)
        );

        /**
         * 全局配置
         */
        //基本包
        String outputDir = "D:\\JavaProjects\\win-help\\merchant\\src\\main\\java";
        //作者
        String author = "DragonUncle";
        gen.setGlobalConfig(new GlobalConfig()
                .setActiveRecord(false)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)//XML columList
                .setIdType(IdType.NONE)//设置主键类型
                .setAuthor(author)
                .setOutputDir(outputDir)
                .setOpen(false)//生成后打开文件夹
                .setFileOverride(true)//是否覆盖文件
                .setServiceName("%sService")
                .setSwagger2(true)
        );
        /**
         * 策略配置
         */
        //table前缀
        String prefix = "";
        gen.setStrategy(new StrategyConfig()
                        .setTablePrefix(prefix)// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tables) // 需要生成的表
//                        .setRestControllerStyle(true)
                        //.setExclude(new String[]{"test"}) // 排除生成的表
                        // 自定义实体父类
                        // .setSuperEntityClass("com.baomidou.demo.TestEntity")
                        // 自定义实体，公共字段
                        //.setSuperEntityColumns(new String[]{"test_id"})
                        //.setTableFillList(tableFillList)
                        // 自定义 mapper 父类 默认BaseMapper
                        //.setSuperMapperClass("com.baomidou.mybatisplus.mapper.BaseMapper")
                        // 自定义 service 父类 默认IService
                        // .setSuperServiceClass("com.baomidou.demo.TestService")
                        // 自定义 service 实现类父类 默认ServiceImpl
                        // .setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl")
                        // 自定义 controller 父类
                        //.setSuperControllerClass("com.kichun."+packageName+".controller.AbstractController")
                        // 【实体】是否生成字段常量（默认 false）
                        // public static final String ID = "test_id";
                        // .setEntityColumnConstant(true)
                        // 【实体】是否为构建者模型（默认 false）
                        // public User setName(String name) {this.name = name; return this;}
                        .setEntityBuilderModel(true)
                        // 【实体】是否为lombok模型（默认 false）<a href="https://projectlombok.org/">document</a>
                        .setEntityLombokModel(true)
                        // Boolean类型字段是否移除is前缀处理
                        .setEntityBooleanColumnRemoveIsPrefix(true)
                        .setRestControllerStyle(true)
                         .setControllerMappingHyphenStyle(true)
        );

        /**
         * 包配置
         */
        //生成的代码放在这个包里
        String packageName = "top.dragon";
        gen.setPackageInfo(new PackageConfig()
                .setParent(packageName)
                .setController("controller")// 这里是控制器包名，默认 web
                .setEntity("entity") // 设置Entity包名，默认entity
                .setMapper("mapper") // 设置Mapper包名，默认mapper
                .setService("service") // 设置Service包名，默认service
                .setServiceImpl("service.impl") // 设置Service Impl包名，默认service.impl
                .setXml("xml") // 设置Mapper XML包名，默认mapper.xml
        );
        // 执行生成
        gen.execute();
    }
}
