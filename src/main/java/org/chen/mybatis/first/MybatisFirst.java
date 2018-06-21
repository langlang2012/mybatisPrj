package org.chen.mybatis.first;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.chen.mybatis.mapper.UserMapper;
import org.chen.mybatis.po.AppLog;
import org.chen.mybatis.po.AppLogDeviceStat;
import org.chen.mybatis.po.User;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *
 * Title: MybatisFirst
 *
 * @author chenxiaochan
 */
public class MybatisFirst {

    private static SqlSessionFactory sqlSessionFactory;

    public SqlSessionFactory getSqlSessionFactory(){
        if (sqlSessionFactory == null){
            // mybatis配置文件
            String resource = "SqlMapConfig.xml";
            // 得到配置文件流
            InputStream inputStream = null;
            try {
                inputStream = Resources.getResourceAsStream(resource);
            } catch (IOException e) {
                e.printStackTrace();
            }
             // 创建会话工厂，传入mybatis的配置文件信息
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(inputStream);
        }
        return sqlSessionFactory;
    }

    /**
     * 生成统计数据
     */
    @Test
    public void insertStat(){
        // 会话工厂
        sqlSessionFactory = getSqlSessionFactory();
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            //先删除，再添加
            String day = "2018-06-10";
            sqlSession.delete("deviceStat.deleteByDay", day);
            int result = sqlSession.insert("deviceStat.insert", day);
            if (result > 0){
                System.out.println("添加成功！");
            }

            //查询展示
            Map paramMap = new HashMap();
            paramMap.put("startDay", "2018-06-11");
            paramMap.put("endDay", "2018-06-12");
            List<AppLogDeviceStat> appLogDeviceStatList = sqlSession.selectList("deviceStat.selectByDay", paramMap);
            System.out.println("appLogDeviceStatList: "+appLogDeviceStatList.size());
            for (AppLogDeviceStat appLogDeviceStat: appLogDeviceStatList) {
                System.out.println(appLogDeviceStat.getId()+", "+appLogDeviceStat.getDay()+","+appLogDeviceStat.getTotal());
            }
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.commit();
            // 释放资源
            sqlSession.close();
        }
    }

    /**
     * 查询设备明细数据
     */
    @Test
    public void deviceDetail(){
        // 会话工厂
        sqlSessionFactory = getSqlSessionFactory();
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {

            String day = "2018-06-10";

           // <!-- 查询直到某一天为止的全部设备-->
            List<AppLog> appLogList = sqlSession.selectList("deviceDetail.getAllUntilDay", day);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询时间段内的新增设备-->
            Map paramMap = new HashMap();
            paramMap.put("startDay", "2018-06-08");
            paramMap.put("endDay", "2018-06-09");
            appLogList = sqlSession.selectList("deviceDetail.getNewBetweenDay", paramMap);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询时间段内的启动设备个数-->
            appLogList = sqlSession.selectList("deviceDetail.getDevicesBetweenDay", paramMap);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询时间段内的设备启动次数-->
            appLogList = sqlSession.selectList("deviceDetail.getTimesBetweenDay", paramMap);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println("设备启动次数："+appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询每日沉默设备： 30天内未启动过的设备个数-->
            day = "2018-06-10";
            appLogList = sqlSession.selectList("deviceDetail.getSilentsByDay", day);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询每日沉睡设备：一个月内没用过的，但上个月内用过的设备个数-->
            day = "2018-06-10";
            appLogList = sqlSession.selectList("deviceDetail.getSleepsByDay", day);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

            //<!-- 查询每日流失设备：60天内未启动过的设备个数-->
            day = "2018-06-10";
            appLogList = sqlSession.selectList("deviceDetail.getLostByDay", day);
            System.out.println("appLogList: "+appLogList.size());
            for (AppLog appLog: appLogList) {
                System.out.println(appLog.getDevice_id()+", "+appLog.getCreate_time()+","+appLog.getActive_time());
            }

        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.commit();
            // 释放资源
            sqlSession.close();
        }
    }

    // 根据id查询用户信息，得到一条记录结果
    @Test
    public void findUserByIdTest() throws IOException {
        // 会话工厂
        sqlSessionFactory = getSqlSessionFactory();
        // 通过工厂得到SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            // 通过SqlSession操作数据库
            // 第一个参数：映射文件中statement的id，等于=namespace+"."+statement的id
            // 第二个参数：指定和映射文件中所匹配的parameterType类型的参数
            // sqlSession.selectOne结果 是与映射文件中所匹配的resultType类型的对象
            // selectOne查询出一条记录
            //使用XML
            User user = sqlSession.selectOne("test.findUserById", 1);
            System.out.println(user);

            User paramUser = new User();
            paramUser.setUsername("测试员");
            paramUser.setSex("男");
            paramUser.setBirthday(new Date());
            paramUser.setAddress("广东省清远市333333333333");
           // int c = sqlSession.insert("test.insert", paramUser);

            paramUser.setId(7);
            //int u = sqlSession.update("test.updateUser", paramUser);

            paramUser.setId(6);
            int d = sqlSession.delete("test.deleteUser", paramUser);
            //使用注解
            org.chen.mybatis.mapper.UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user1 = mapper.findUserById(1);
            System.out.println(user1);
        }catch (Exception e){
            e.printStackTrace();
            sqlSession.rollback();
        }finally {
            sqlSession.commit();
            // 释放资源
            sqlSession.close();
        }

    }
}