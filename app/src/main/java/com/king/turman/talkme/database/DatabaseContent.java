package com.king.turman.talkme.database;

/**
 * Created by diaoqf on 2018/10/24.
 */

public class DatabaseContent {
    /**
     * db version
     */
    public static final int DB_VERSION = 1;
    /**
     * 数据库名称
     */
    protected static final String DB_NAME = "com.king.turman.talkme.database.DB";
    /**
     * sql语句定义
     */
    //创建task表
    protected static final String SQL_CREATE_TABLE_TASK = "create table task(" +
            "tid integer primary key autoincrement, " +
            "receivers varchar (520), " +
            "task_title varchar(32), " +
            "remark varchar(640), " +
            "file_list varchar(240), " +
            "create_time varchar(24), " +
            "acceptTime varchar(24), " +
            "deadLine varchar(24), " +
            "alertTimes varchar(120))";

    //插入任务数据
    protected static final String SQL_INSERT_TASK = "insert into task(receivers,task_title,remark,file_list,create_time,acceptTime,deadLine,alertTimes) values (?,?,?,?,?,?,?,?)";
    //查询task数据
    protected static final String SQL_QUERY_TASK = "select * from task";
}
