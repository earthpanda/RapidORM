package com.wangjie.rapidorm.core.dao;

import com.wangjie.rapidorm.core.delegate.database.RapidORMSQLiteDatabaseDelegate;
import com.wangjie.rapidorm.util.func.RapidOrmFunc1;

import java.util.Collection;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/25/15.
 */
public interface BaseDao<T> {

    void insert(T model) throws Exception;

    void update(T model) throws Exception;

    void delete(T model) throws Exception;

    void deleteAll() throws Exception;

    List<T> queryAll() throws Exception;

    List<T> rawQuery(String sql, String[] selectionArgs) throws Exception;

    void rawExecute(String sql, Object[] bindArgs) throws Exception;

    /**
     * ********************* execute in tx *************************
     */
    void insertInTx(T... models) throws Exception;

    void insertInTx(Iterable<T> models) throws Exception;

    void updateInTx(T... models) throws Exception;

    void updateInTx(Iterable<T> models) throws Exception;

    void deleteInTx(T... models) throws Exception;

    void deleteInTx(Iterable<T> models) throws Exception;

    void executeInTx(RapidORMSQLiteDatabaseDelegate db, RapidOrmFunc1 func1) throws Exception;

    void executeInTx(RapidOrmFunc1 func1) throws Exception;

    void executeInTxSync(RapidOrmFunc1 func1) throws Exception;

    /**
     * v2.2.x insertOrUpdate
     */
    boolean isExist(T model) throws Exception;

    void insertOrUpdate(T model) throws Exception;

    void insertOrUpdate(T... models) throws Exception;

    void insertOrUpdate(Collection<T> models) throws Exception;

    void insertOrUpdateInTx(T... models) throws Exception;

    void insertOrUpdateInTx(Collection<T> models) throws Exception;

}
