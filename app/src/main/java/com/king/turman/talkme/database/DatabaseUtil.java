package com.king.turman.talkme.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.king.turman.talkme.viewbeans.TaskBean;

/**
 * Created by diaoqf on 2018/10/24.
 */

public class DatabaseUtil {
    private DatabaseHelper databaseHelper;
    private static class SingletonInner {
        private static DatabaseUtil singletonStaticInner = new DatabaseUtil();
    }

    public static DatabaseUtil getInstance(Context context) {
        if (SingletonInner.singletonStaticInner.databaseHelper == null) {
            SingletonInner.singletonStaticInner.databaseHelper = new DatabaseHelper(context, DatabaseContent.DB_VERSION);
        }
        return SingletonInner.singletonStaticInner;
    }

    public void insertTask(TaskBean bean) {
        SQLiteDatabase database = databaseHelper.getWritableDatabase();
        String receiver ="";
        if (bean.getReceivers() != null) {
            for (String str : bean.getReceivers()) {
                receiver += str + ",";
            }
            receiver = receiver.substring(0,receiver.length()-1);
        }
        String fileList = "";
        if (bean.getFileList() != null) {
            for (String str : bean.getFileList()) {
                fileList += str + ",";
            }
            fileList = fileList.substring(0,fileList.length()-1);
        }
        String alertTime = "";
        if (bean.getAlertTimes() != null) {
            for (String str : bean.getAlertTimes()) {
                alertTime += str + ",";
            }
            alertTime = alertTime.substring(0,alertTime.length()-1);
        }
        database.execSQL(DatabaseContent.SQL_INSERT_TASK,
                new Object[] {
                        bean.getSender(),
                        receiver,
                        bean.getTaskTitle(),
                        bean.getRemark(),
                        fileList,
                        bean.getCreateTime(),
                        bean.getAcceptTime(),
                        alertTime
                });
        database.close();
    }

    public void queryTask(TaskBean bean) {
        if (bean == null) {
            bean = new TaskBean();
        }
        SQLiteDatabase database = databaseHelper.getReadableDatabase();
        Cursor cursor = database.rawQuery(DatabaseContent.SQL_QUERY_TASK,null);
        while (cursor.moveToNext()) {
            bean.setSender(cursor.getString(1));
        }
        cursor.close();
        database.close();
    }

}
