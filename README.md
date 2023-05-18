# 使用技术

- 开发语言 
  - Java  jdk1.8
- 使用框架
  - SpringBoot 
  - Spring
  - Mybatis
  - WebMagic  
  - Thymeleaf
- 数据库
  - Mysql 5.7

# SpringBoot 

Spring Boot 是由 Pivotal 团队提供的基于 Spring 的全新框架，旨在简化 Spring 应用的初始搭建和开发过程。该框架使用了特定的方式来进行配置，从而使开发人员不再需要定义样板化的配置。

Spring 官网给的定义是：Spring Boot 是所有基于 Spring 开发项目的起点。Spring Boot 集成了绝大部分目前流行的开发框架，就像 Maven 集成了所有的 JAR 包一样，Spring Boot 集成了几乎所有的框架，使得开发者能快速搭建 Spring 项目。

Spring Boot 的核心设计思想是“约定优于配置”。基于这一设计原则，Spring Boot 极大地简化了项目和框架的配置。比如在使用 Spring 开发 Web 项目时，我们需要配置 web.xml、Spring 和 MyBatis 等，还需要将它们集成在一起。而使用 Spring Boot 一切将变得极其简单，它采用了大量的默认配置来简化这些文件的配置过程，只需引入对应的 Starters（启动器）。

Spring Boot 可以构建一切。设计它就是为了使用最少的配置，以最快的速度来启动和运行 Spring 项目。

# Spring

Spring框架是一个[开放源代码](https://baike.baidu.com/item/开放源代码/114160?fromModule=lemma_inlink)的[J2EE](https://baike.baidu.com/item/J2EE/110838?fromModule=lemma_inlink)应用程序框架，由[Rod Johnson](https://baike.baidu.com/item/Rod Johnson/1423612?fromModule=lemma_inlink)发起，是针对bean的生命周期进行管理的轻量级容器（lightweight container）。 Spring解决了开发者在J2EE开发中遇到的许多常见的问题，提供了功能强大IOC、[AOP](https://baike.baidu.com/item/AOP/1332219?fromModule=lemma_inlink)及Web MVC等功能。Spring可以单独应用于构筑应用程序，也可以和Struts、Webwork、Tapestry等众多Web框架组合使用，并且可以与 Swing等[桌面应用程序](https://baike.baidu.com/item/桌面应用程序/2331979?fromModule=lemma_inlink)AP组合。因此， Spring不仅仅能应用于J2EE应用程序之中，也可以应用于桌面应用程序以及小应用程序之中。Spring框架主要由七部分组成，分别是 Spring Core、 Spring AOP、 Spring ORM、 Spring DAO、Spring Context、 Spring Web和 Spring Web MVC

# Mybatis

MyBatis 是一款优秀的[持久层](https://baike.baidu.com/item/持久层/3584971?fromModule=lemma_inlink)框架，它支持定制化 [SQL](https://baike.baidu.com/item/SQL/86007?fromModule=lemma_inlink)、[存储过程](https://baike.baidu.com/item/存储过程/1240317?fromModule=lemma_inlink)以及高级映射。MyBatis 避免了几乎所有的 JDBC 代码和手动设置参数以及获取[结果集](https://baike.baidu.com/item/结果集/11040011?fromModule=lemma_inlink)。MyBatis 可以使用简单的 XML 或注解来配置和映射原生信息，将接口和 Java 的 [POJOs](https://baike.baidu.com/item/POJOs/6656035?fromModule=lemma_inlink)(Plain Ordinary Java Object,普通的 Java对象)映射成数据库中的记录。



# WebMagic  

WebMagic是一个简单灵活的Java爬虫框架。基于WebMagic，你可以快速开发出一个高效、易维护的爬虫。

**特性：**

- 简单的API，可快速上手
- 模块化的结构，可轻松扩展
- 提供多线程和分布式支持

# Thymeleaf

Thymeleaf 是一款用于渲染 XML/XHTML/HTML5 内容的模板引擎。它与 JSP，Velocity，FreeMaker 等模板引擎类似，也可以轻易地与 Spring MVC 等 Web 框架集成。与其它模板引擎相比，Thymeleaf 最大的特点是，即使不启动 Web 应用，也可以直接在浏览器中打开并正确显示模板页面 。





# 开发步骤

## 使用IntelliJ IDEA创建项目

首先在创建项目时选择 Spring Initializr，如下图：

![img](http://www.javaboy.org/images/boot/1-3.png)

然后点击 Next ，填入 Maven 项目的基本信息，如下：

![img](http://www.javaboy.org/images/boot/1-4.png)

再接下来选择需要添加的依赖，如下图：

![img](http://www.javaboy.org/images/boot/1-5.png)

勾选完成后，点击 Next 完成项目的创建。

## 引用pom文件依赖

```yml
<!--     Thymeleaf 页面模板    -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!--   mybatis mysql     -->
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.0.0</version>
</dependency>
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>druid-spring-boot-starter</artifactId>
    <version>1.1.10</version>
</dependency>
<!-- 集成MySQL连接 -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.25</version>
</dependency>

<!-- WebMagic -->
<dependency>
    <groupId>us.codecraft</groupId>
    <artifactId>webmagic-core</artifactId>
    <version>0.7.4</version>
</dependency>

<!-- devtools 热部署依赖 -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <!--      optional 表示依赖是否向下传递 true表示不向下传递  默认值是false向下传递      -->
    <scope>runtime</scope>
    <optional>true</optional>
</dependency>
```

## 开发爬虫

创建爬虫,创建接口类，实现IGearService接口 

```java
/**
 * @author Administrator
 */
@Service
public class GearServiceImpl implements IGearService {

    @Autowired
    private GearMapper gearMapper;


    @Override
    public List<Gear> getGearList() {
        return gearMapper.getAllGears();
    }

    @Override
    public int startWebMagic() {
        Spider.create(new SpiderServiceImpl())
                // 设置起始URL
                .addUrl("https://khkchilun.com")
                .run(); // 启动爬虫
        return 0;

    }

    @Override
    public int addGear(Gear gear) {
        return gearMapper.addGear(gear);
    }

    @Override
    public int clearData() {
        return gearMapper.clearData();
    }


}

```

编写接口实现PageProcessor,编写爬虫规则。其中Page是WebMagic框架中爬取页面的对象。

```java
/**
 * @author Administrator
 */
public class SpiderServiceImpl implements PageProcessor {

    private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

    public static final String URL_LIST = "https://khkchilun.com";
    //因为要固定的几个页面故写死
    public static final ArrayList<String> URLS = Lists.newArrayList("https://khkchilun.com/spurgears.html", "https://khkchilun.com/helicalgears.html", "https://khkchilun.com/gearrack.html", "https://khkchilun.com/wormgears.html", "https://khkchilun.com/bevelgears.html", "https://khkchilun.com/mitergears.html", "https://khkchilun.com/internalgears.html");




    @Override
    public void process(Page page) {
        // 在这里定义你的页面解析逻辑
        // 使用page对象提供的方法来提取数据，如XPath、CSS选择器等
        // 解析页面，提取数据
        if (page.getUrl().toString().equals(URL_LIST)) {
            List<String> all = page.getHtml().xpath("//div[@id='leftprolist']").links().all();

            page.addTargetRequests(URLS);
        } else {

            dispose(page);
        }


    }

    private void dispose(Page page) {
        Selectable xpath = page.getHtml().xpath("//div[@class='bigcolumn']");

        //型号
        List<String> all = xpath.xpath("//div[@class='centertex']").xpath("//h3/text()").all();
        all.remove(0);


        //名称
        List<String> all3 = xpath.xpath("//div[@class='centertex']").xpath("//p/text()").all();

        //备注
        List<String> all1 = xpath.xpath("//div[@class='righttex']").xpath("//p/text()").all();

        //内容
        List<String> all2 = xpath.xpath("//p").all();

        //图片
        List<String> all4 = xpath.$("img", "src").all();
        all4.remove(0);

        HashMap<String, String> map = new HashMap(14);


        List<Gear> list = new ArrayList<Gear>();

        for (int i = 0; i < all.size(); i++) {
            // 创建实体对象
            Gear gear = new Gear();
            gear.setModel(all.get(i));

            gear.setName(all3.get(i));

            for (int j = 0; j < all2.size(); j++) {
               if (all2.get(j).startsWith("<p>模数")){
                   String s = all2.get(j);
                   String substring = s.substring(3);
                   String substring1 = substring.substring(0,substring.length() - 4);
                   String[] brs = substring1.split("<br>");
                   for (String br : brs) {
                       String[] split = br.split(":");
                        if (split.length > 1){
                            map.put(split[0], split[1]);
                        }


                   }


               }

                all2.remove(all2.get(j));
            }

            gear.setRemarks(all1.get(i));

            int typeNum =0;

            for (int i1 = 0; i1 < URLS.size(); i1++) {
                if (URLS.get(i1).equals(page.getUrl().toString())){
                    typeNum =i1;
                }
            }

            gear.setType(typeNum);

            gear.setIndexNumber(i);
            gear.setModulus(map.get("模数 "));
            gear.setMaterials(map.get("材料 "));
            gear.setHeatTreatment(map.get("热处理 "));
            gear.setTotalLength(map.get("全长 "));
            gear.setHeadCount(map.get("头数 "));
            gear.setGearToothMachining(map.get("齿面加工 "));
            gear.setGearPrecision(map.get("齿轮精度 "));

            gear.setImg(all4.get(i));

            list.add(gear);

        }

        IGearService bean = GetBeanUtils.getBean(IGearService.class);

        // 保存到数据库
        for (Gear gear : list) {
           bean.addGear(gear);
        }

    }



    @Override
    public Site getSite() {
        return site;
    }


}
```

## 整合Mybatis

在application.yml中配置数据库的基本信息：

```
# 数据源配置
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/demo?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource
    driverClassName: com.mysql.cj.jdbc.Driver
```

创建Mapper

```java
@Mapper
public interface  GearMapper {


    @Select("select id,type,index_number as indexNumber, name,model, modulus,materials,heat_treatment as  heatTreatment, total_length as totalLength,head_count as headCount, gear_tooth_machining as  gearToothMachining , gear_precision as gearPrecision,  CONCAT('https://khkchilun.com/',img) as img, remarks  from t_gear")
    List<Gear> getAllGears();

    @Insert({"insert into t_gear(type,index_number,name,model,modulus,materials,heat_treatment,total_length,head_count,gear_tooth_machining,gear_precision, img, remarks) values(#{type},#{indexNumber},#{name},#{model},#{modulus},#{materials},#{heatTreatment},#{totalLength},#{headCount},#{gearToothMachining},#{gearPrecision},#{img},#{remarks})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addGear(Gear gear);

    @Delete("delete from t_gear WHERE 1=1 ")
    int clearData();
}

```

这里是通过全注解的方式来写SQL，不写XML文件，@Select、@Insert、@Update以及@Delete四个注解分别对应XML中的select、insert、update以及delete标签，@Results注解类似于XML中的ResultMap映射文件（getUserById方法给查询结果的字段取别名），另外使用@SelectKey注解可以实现主键回填的功能，即当数据插入成功后，插入成功的数据id会赋值到user对象的id属性上。

Mapper创建好之后，还要配置mapper扫描，上面添加`@Mapper`注解，

## 编写前端页面

```html
        <h1 th:text="${title}" class="sysName"></h1>
```

在 `Thymeleaf` 中，通过 `th:each` 指令来遍历一个集合，数据的展示通过 `th:text` 指令来实现，

