package com.leasing.calculate.utils;

//import gbu.bs.foundation.oid.OIDGenerator;
//import gbu.itf.foundation.GridFSAdapter;
//import gbu.itf.foundation.RunnableWithReturn;
//import gbu.ui.foundation.util.ClientENV;
//import gbu.vo.foundation.BusinessException;
//import gbu.vo.foundation.base.BusinessLockVO;
//import gbu.vo.sm.ExceptionConstant;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

//import com.ibatis.sqlmap.client.SqlMapClient;

/**
 * @author huangweiguang
 *
 */
public abstract class GeneralOperatUtils {
//    /**
//     * getHibernateTemplate
//     * 取hibernate模版
//     * @param dataSource DataSource
//     * @return HibernateTemplate
//     */
//    public static HibernateTemplate getHibernateTemplate(DataSource dataSource) {
//        SessionFactory sessionFactory = DataSourceUtils.getSessionFactory(dataSource);
//        return new HibernateTemplate(sessionFactory);
//    }
//
//    /**
//     * getHibernateTemplate
//     * 取hibernate模板
//     *
//     * @return HibernateTemplate
//     */
//    public static HibernateTemplate getHibernateTemplate() {
//        return new HibernateTemplate(SessionContext.getSessionContext().getSessionFactory());
//    }
//    /**
//     * getGridFSAdapter
//     * 取GridFSAdapter模板
//     *
//     * @return GridFSAdapter
//     */
//    public static GridFSAdapter getGridFSAdapter() {
//        return (GridFSAdapter)ServerBeanFactoryUtils.getApplicationContext().getBean("gridFSAdapter");
//    }
//
//    /**
//     * getJdbcTemplate
//     * 取jdbc模板
//     *
//     * @param dataSource DataSource
//     * @return JdbcTemplate
//     */
//    public static JdbcTemplate getJdbcTemplate(DataSource dataSource) {
//        return new JdbcTemplate(dataSource);
//    }
//
//    /**
//     * getJdbcTemplate
//     * 取jdbc模板
//     *
//     * @return JdbcTemplate
//     */
//    public static JdbcTemplate getJdbcTemplate() {
//        return new JdbcTemplate(SessionContext.getSessionContext().getDataSource());
//    }
//
//    /**
//     * 取得ibates的sqlMapClient
//     * 不要调用有关事务操作的方法
//     * @return
//     */
//    public static SqlMapClient getSqlMapClient() {
//        return (SqlMapClient) ServerBeanFactoryUtils.getApplicationContext().getBean("sqlMapClient");
//    }

    /**
     * getOID
     * 取值对象的pk
     *
     * @return String
     */
    public static String getOID() {
        //return OIDGenerator.getOID();
        return UUIDUtil.getUUID();
    }

//    /**
//     * 在给定的数据源上使用独立事物
//     * @param callback ：回调函数类
//     * @param dataSourceName： 将要处理的数据源名称
//     * @return ：返回独立事物处理完成后返回的对象
//     */
//    public static Object independenceTrasaction(String dataSourceName, TransactionCallback callback ) {
//        ServletContext servletContext = SessionContext.getSessionContext().getServletContext();
//        SessionContext.getSessionContext().setServletContext(servletContext);
//        String olddsName = SessionContext.getSessionContext().getDataSourceName();
//        try {
//            SessionContext.getSessionContext().initDataSourceByName(dataSourceName);
//            PlatformTransactionManager platformTransactionManager = DataSourceUtils.getTransactionManager();
//            TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
//            transactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRES_NEW);
//            return transactionTemplate.execute(callback);
//        } finally {
//            SessionContext.getSessionContext().initDataSourceByName(olddsName);
//        }
//    }
//    /**
//     * 在当前系统对应的数据源上使用独立事物
//     * @param callback ：回调函数类
//     * @return ：返回独立事物处理完成后返回的对象
//     */
//    public static Object independenceTrasaction(TransactionCallback callback) {
//        String dataSourceName = SessionContext.getSessionContext().getDataSourceName();
//        ServletContext servletContext = SessionContext.getSessionContext().getServletContext();
//        SessionContext.getSessionContext().setServletContext(servletContext);
//        SessionContext.getSessionContext().initDataSourceByName(dataSourceName);
//        PlatformTransactionManager platformTransactionManager = DataSourceUtils.getTransactionManager();
//        TransactionTemplate transactionTemplate = new TransactionTemplate(platformTransactionManager);
//        transactionTemplate.setPropagationBehavior(TransactionTemplate.PROPAGATION_REQUIRES_NEW);
//        return transactionTemplate.execute(callback);
//    }
//
//
//    /**
//     * getClientENV
//     * 取客户端上下文
//     *
//     * @return ClientENV
//     */
//    public static ClientENV getClientENV() {
//        return SessionContext.getSessionContext().getClientenv();
//    }
//
//    private static boolean lock(String lockpk, String pk_user){
//        return lock(lockpk, pk_user, null);
//    }
//
//    private static boolean lock(final String lockpk, final String pk_user, final String lock_message){
//        try {
//            if (lockpk == null || lockpk.trim().length() == 0) {
//                throw new NullPointerException("lockpk不能为空");
//            }
//            List count = getJdbcTemplate().queryForList("select pk_lock from eprk_lock where pk_lock='" + lockpk + "'");
//            if (count.size() > 0) {
//                return false;
//            }
//            Date date = new Date();
//            String ts = getCurTs();
//            getJdbcTemplate().update("insert into eprk_lock(pk_lock,pk_user,ts, lock_message) values(?,?,?,?)",
//                    new Object[] {lockpk, pk_user, ts, lock_message});
//            BusinessLockVO vo = new BusinessLockVO();
//            vo.setPk_lock(lockpk);
//            vo.setPk_user(pk_user);
//            vo.setTs(date);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
////        _logger.info("lock(" + lockpk +")");
//        return true;
//    }
//
//    /**
//     * 加业务锁(悲观锁)
//     * @param lockpk
//     * @param pk_user
//     * @return
//     */
//    public static boolean acquireLock(final String lockpk, final String pk_user) {
//        return acquireLock(lockpk, pk_user, false, null);
//    }
//
//    /**
//     * 加业务锁(悲观锁)
//     * @param lockpk
//     * @param pk_user
//     * @return
//     */
//    public static boolean acquireLock(final String lockpk, final String pk_user, final String lock_message) {
//        return acquireLock(lockpk, pk_user, false, lock_message);
//    }
//
//    /**
//     * acquireLock
//     * 加业务锁(悲观锁)
//     *
//     * @param lockpk String
//     * @param pk_user String
//     * @return boolean
//     */
//    public static boolean acquireLock(final String lockpk, final String pk_user, boolean isSameTrasn, final String lock_message) {
//        boolean bLock = false;
//        if (isSameTrasn) { //与调用的事务相同
//            bLock = lock(lockpk, pk_user, lock_message);
//        } else {
//            //独立事务
//            bLock = (Boolean)independenceTrasaction(new TransactionCallback() {
//                public Object doInTransaction(TransactionStatus status) {
//                    return lock(lockpk, pk_user, lock_message);
//                }
//            });
//        }
//        if (!bLock) {
//            List list = getJdbcTemplate().queryForList("select lock_message from eprk_lock where pk_lock='" + lockpk + "'");
//            String errorMessage = null;
//            if (list.size() > 0) {
//                Map m = (Map) list.get(0);
//                errorMessage = (String) m.get("lock_message");
//            } else {
//                errorMessage = ExceptionConstant.getExceptionMess("SYS_0000_E141");
//            }
//            if (errorMessage == null) {
//                errorMessage = "提示消息未维护，请联系相关开发人员！";
//            }
//            throw new BusinessException(errorMessage);
//        } else {
//            return bLock;
//        }
//    }
//
//    /**
//     * freeLock 释放业务锁(悲观锁)
//     *
//     * @param lockpk
//     *            String
//     */
//    public static void freeLock(final String lockpk) {
//        freeLock(lockpk, false);
//    }
//
//    /**
//     *
//     * @param lockpk 锁值
//     * @param isSameTrasn true: 同一事务 false:独立事务
//     */
//    public static void freeLock(final String lockpk, boolean isSameTrasn) {
//        final String sql = "delete from eprk_lock where pk_lock= ?";
//        final Object param[] = new Object[]{lockpk};
//        if (isSameTrasn) {
//            getJdbcTemplate().update(sql, param);
//        } else {
//            independenceTrasaction(new TransactionCallback() {
//                public Object doInTransaction(TransactionStatus status) {
//                    getJdbcTemplate().update(sql, param);
//                    return null;
//                }
//            });
//        }
//    }
//
//    /**
//     * lockProcess
//     * 业务锁(悲观锁)
//     *
//     * @param lockpk String
//     * @param pk_user String
//     * @param runnable Runnable
//     */
//    public static void lockProcess(String lockpk, String pk_user, Runnable runnable) {
//
//        boolean lock = false;
//        try {
//            lock = acquireLock(lockpk, pk_user);
//            runnable.run();
//        } finally {
//            if (lock) {
//                freeLock(lockpk);
//            }
//        }
//    }
//
//    /**
//     * lockProcess
//     * 业务锁(悲观锁)
//     *
//     * @param lockpk String
//     * @param pk_user String
//     * @param runnable RunnableWithReturn
//     * @return Object
//     */
//    public static Object lockProcess(String lockpk, String pk_user, RunnableWithReturn runnable) {
//
//        boolean lock = false;
//        try {
//            lock = acquireLock(lockpk, pk_user);
//            if (!lock) {
//                throw new BusinessException(ExceptionConstant.getExceptionMess("SYS_0000_E142"));
//            }
//            return runnable.run();
//        } finally {
//            if (lock) {
//                freeLock(lockpk);
//            }
//        }
//    }
//    public static Object lockProcess(String lockpk, String pk_user, String lock_message, RunnableWithReturn runnable)
//    {
//        boolean lock = false;
//        try {
//            Object localObject2;
//            lock = acquireLock(lockpk, pk_user, lock_message);
//            if (!(lock))
//                throw new BusinessException(ExceptionConstant.getExceptionMess("SYS_0000_E142"), new Object[0]);
//
//            return runnable.run();
//        } finally {
//            if (lock)
//                freeLock(lockpk);
//        }
//    }

    /**
     * getDateTime
     * 取系统时间(当前服务器时间)
     *
     * @return String
     */
    public static String getCurDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
    /**
     * getDate
     * 取系统日期(当前服务器时间)
     *
     * @return String
     */
    public static String getCurDate() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    }
    /**
     * getTs
     * 生成时间戳
     *
     * @return String
     */
    public static String getCurTs() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());
    }
}
