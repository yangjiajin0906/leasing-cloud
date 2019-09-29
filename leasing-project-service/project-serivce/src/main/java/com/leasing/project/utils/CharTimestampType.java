package com.leasing.project.utils;

import org.hibernate.type.TimestampType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * @project:leasing-cloud
 * @date:2019/9/27
 * @author:jiaoshy@yonyou.com
 * @description:
 **/
public class CharTimestampType extends TimestampType {

    public void set(PreparedStatement statement, Object value, int index) throws SQLException {
//        String ts = toString(value);
//        statement.setString(index,ts);
    }

    public Object get(ResultSet resultSet, String name) throws SQLException {
        String s = resultSet.getString(name);
        if (s == null || s.trim().length() == 0) {
            return null;
        }
        return fromStringValue(s);
    }


}
