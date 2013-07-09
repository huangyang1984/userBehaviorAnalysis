package net.ufida.x27.core.manager;

import net.ufida.x27.core.model.SystemCfg;
import net.ufida.x27.util.hibernate.BaseManager;
import net.ufida.x27.util.text.StrUtils;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

/**
 * 
 * @author Steven.yang
 *
 */
public class SystemCfgManager extends BaseManager {
    
    /**reportCode表示业务编号*/
    public static final String NAME_ReportCode = "reportCode";
    
    /**得到最新可用的业务编号，加上悲观锁，同时更新数据库中的业务编号加1，返回的是加1后的编号
     */
    public String findNewReportCode() {
        Criteria criteria = super.getCriteria4Update();
        criteria.add(Restrictions.eq("name", NAME_ReportCode));
        SystemCfg entity = (SystemCfg) criteria.uniqueResult();
        int reportCodeInt = Integer.parseInt(entity.getValue()) + 1;
        //业务编号8位长
        String newReportCode = StrUtils.addZeroBefore(reportCodeInt, 8);
        entity.setValue(newReportCode);
        super.update(entity);
        return newReportCode;
    }
    
    public SystemCfg findByName(String name) {
        DetachedCriteria dc = super.getDetachedCriteria();
        dc.add(Restrictions.eq("name", name));
        return (SystemCfg) super.findUniqueResult(dc);
    }

    
    public SystemCfg findById(String id) {
        return (SystemCfg) super.findById(id);
    }

    public Class getModelClass() {
        return SystemCfg.class;
    }

}
