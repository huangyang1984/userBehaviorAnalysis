package net.ufida.x27.dict.service;

import java.util.Collection;

public interface Dict2LevelProvider {
    /**提供2级联动的所需数据，数据字典列表
     * 标签会转换成的两级联动三维大数组
     * [[["1001","类别1"],[["2010","scama"],["2020","中文项目"]]],
     *  [["1002","类别2"],[["3010","权证"],["3020","smg"]]]
     * ]
     * @return List<Dictionary>
     */
    Collection provideDictCollect();
}
