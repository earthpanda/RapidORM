package com.wangjie.rapidorm.core.config;

import com.wangjie.rapidorm.core.generate.statement.DeleteStatement;
import com.wangjie.rapidorm.core.generate.statement.InsertStatement;
import com.wangjie.rapidorm.core.generate.statement.TableCreateStatement;
import com.wangjie.rapidorm.core.generate.statement.UpdateStatement;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: wangjie
 * Email: tiantian.china.2@gmail.com
 * Date: 6/25/15.
 */
public class TableConfig<T> {
    protected String tableName;
    protected Class<T> tableClazz;

    protected List<ColumnConfig> allColumnConfigs;
    protected List<ColumnConfig> pkColumnConfigs;
    protected List<ColumnConfig> noPkColumnConfigs;

    protected List<ColumnConfig> indexColumnConfigsCache;
    protected List<ColumnConfig> uniqueComboColumnConfigsCache;

    protected TableCreateStatement<T> tableCreateStatement;
    private InsertStatement<T> insertStatement;
    private UpdateStatement<T> updateStatement;
    private DeleteStatement<T> deleteStatement;

    public TableConfig(@NonNull Class<T> tableClazz) {
        this.tableClazz = tableClazz;
        parseAllConfigs();
        tableCreateStatement = new TableCreateStatement<>(this);
    }

    protected void parseAllConfigs() {
        // implementation by subclass which auto generated by rapidOrm
    }


    protected ColumnConfig buildColumnConfig(String name, boolean autoincrement, boolean notNull, String defaultValue, boolean index, boolean unique, boolean uniqueCombo, boolean primaryKey) {
        ColumnConfig columnConfig = new ColumnConfig();
        // column name
        columnConfig.setColumnName(name);
        // autoincrement
        columnConfig.setAutoincrement(autoincrement);
        // notNull
        columnConfig.setNotNull(notNull);
        // defaultValue
        columnConfig.setDefaultValue(defaultValue);
        // index
        columnConfig.setIndex(index);
        // unique
        columnConfig.setUnique(unique);
        // uniqueCombo
        columnConfig.setUniqueCombo(uniqueCombo);
        // primaryKey
        columnConfig.setPrimaryKey(primaryKey);
        return columnConfig;
    }


    public List<ColumnConfig> getUniqueComboColumnConfigs() {
        List<ColumnConfig> uniqueComboColumnConfigs = new ArrayList<>();
        for (ColumnConfig columnConfig : allColumnConfigs) {
            if (columnConfig.isUniqueCombo()) {
                uniqueComboColumnConfigs.add(columnConfig);
            }
        }
        return uniqueComboColumnConfigs;
    }

    public List<ColumnConfig> getUniqueComboColumnConfigsFromCache() {
        if (null == uniqueComboColumnConfigsCache) {
            uniqueComboColumnConfigsCache = getUniqueComboColumnConfigs();
        }
        return uniqueComboColumnConfigsCache;
    }

    public List<ColumnConfig> getIndexColumnConfigs() {
        List<ColumnConfig> indexColumnConfigs = new ArrayList<>();
        for (ColumnConfig columnConfig : allColumnConfigs) {
            if (columnConfig.isIndex()) {
                indexColumnConfigs.add(columnConfig);
            }
        }
        return indexColumnConfigs;
    }

    public List<ColumnConfig> getIndexColumnConfigsFromCache() {
        if (null == indexColumnConfigsCache) {
            indexColumnConfigsCache = getIndexColumnConfigs();
        }
        return indexColumnConfigsCache;
    }

    public String getTableName() {
        return tableName;
    }

    public Class getTableClazz() {
        return tableClazz;
    }

    public List<ColumnConfig> getAllColumnConfigs() {
        return allColumnConfigs;
    }

    public List<ColumnConfig> getPkColumnConfigs() {
        return pkColumnConfigs;
    }

    public List<ColumnConfig> getNoPkColumnConfigs() {
        return noPkColumnConfigs;
    }


    public TableCreateStatement<T> getTableCreateStatement() {
        return tableCreateStatement;
    }

    public InsertStatement<T> getInsertStatement() {
        if (null == insertStatement) {
            insertStatement = new InsertStatement<>(this);
        }
        return insertStatement;
    }

    public UpdateStatement<T> getUpdateStatement() {
        if (null == updateStatement) {
            updateStatement = new UpdateStatement<>(this);
        }
        return updateStatement;
    }

    public DeleteStatement<T> getDeleteStatement() {
        if (null == deleteStatement) {
            deleteStatement = new DeleteStatement<>(this);
        }
        return deleteStatement;
    }


}