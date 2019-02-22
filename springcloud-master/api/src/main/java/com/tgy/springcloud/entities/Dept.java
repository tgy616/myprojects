package com.tgy.springcloud.entities;

/**
 * @author tanggy
 * @date 2019/2/20
 */

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import java.io.Serializable;

/**
 * Lombok工作中需要注意的点
 *
 * 1、在类需要序列化、反序列化时详细控制字段时（例如：Jackson json序列化）；
 * 2、使用Lombok能够省去手动创建setter和getter方法，但是也降低了源代码文件的可读性和完整性，降低了源代码阅读的舒适度；
 * 3、使用@Slf4j还是@Log4j看项目使用的日志框架；
 * 4、选择适合的地方使用Lombok，例如POJO是一个好地方，因为他很单纯；
 */

@NoArgsConstructor//注解在类上；为类提供一个无参的构造方法
//@AllArgsConstructor//注解在类上；为类提供一个全参的构造方法
@Data//@Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
@Accessors(chain = true)
public class Dept implements Serializable// entity --orm--- db_table
{
    private Long deptno; // 主键
    private String dname; // 部门名称
    private String db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库

    public Dept(String dname) {
        super();
        this.dname = dname;
    }

    public static void main(String[] args) {
        Dept dept=new Dept();

        dept.setDeptno(11L).setDname("test").setDb_source("DB01");

        System.out.println(dept.getDeptno());
    }
}