package net.ufida.x27.dict.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import net.ufida.x27.dict.service.DictionaryFactory;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class DictionaryFactoryDB extends DictionaryFactory {
    
    private static final String SQL_SUBFIX = ".sql";

    private static final String DICT_APPLICATION_SQL = "DICTApplication.sql";

    /**
     * 数据源
     */
    private DataSource dataSource;
     
    protected List getData(String dictCode) {
        Assert.notNull(dataSource, "dataSource is null");
        String sql = config.getString(dictCode + SQL_SUBFIX);
        boolean isAppication = false;
        /*首先判断单独业务字典的sql语句有没有，没有的话说明属于系统字典*/
        if (StringUtils.isEmpty(sql)) {
            isAppication = true;
            sql = config.getString(DICT_APPLICATION_SQL);
        }
        Assert.hasLength(sql, "sql is not found");
        List list = new JdbcTemplate(dataSource).queryForList(sql);
        //如果是单独业务数据字典的话，对返回结果增加dictCode和diceName
        if (isAppication == false) {
            for (Iterator iterator = list.iterator(); iterator.hasNext();) {
                Map map = (Map) iterator.next();
                map.put(super.DICT_CODE, dictCode);
                map.put(super.DICT_NAME, config.getString(dictCode));
            }
        }
        return list;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
}
