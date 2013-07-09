package net.ufida.x27.core.util;

import java.util.Collection;
import java.util.Iterator;

import net.gbicc.basebox.webfx.TreeNode;
import net.ufida.x27.core.model.Organization;

/**
 * 
 * @author Steven.yang
 *
 */
public class TreeNodeUtils {
    
    public static TreeNode organization2TreeMode(Collection orgFirstLevelCollect) {
        TreeNode root = new TreeNode();
        root.setText("组织机构");
        root.setAction("JavaScript: x27.org.getChild('');");
        root.setOpen(Boolean.TRUE);
        for (Iterator iter = orgFirstLevelCollect.iterator(); iter.hasNext();) {
            Organization element = (Organization) iter.next();
            root.addChildNode(organization2TreeMode(element));
        }
        return root;
    }
    
    private static TreeNode organization2TreeMode(Organization org) {
        TreeNode node = new TreeNode();
        node.setOpen(Boolean.TRUE);
        node.setText(org.getOrgName());
        if (org.getChildOrgs() == null || org.getChildOrgs().size() == 0) {
            node.setAction("JavaScript: x27.org.getOrg('" + org.getIdStr() + "');");
        } else {
            node.setAction("javascript: x27.org.getOrg('" + org.getIdStr() + "');");
            for (Iterator iter = org.getChildOrgs().iterator(); iter.hasNext();) {
                Organization element = (Organization) iter.next();
                node.addChildNode(organization2TreeMode(element));
            }
        }
        return node;
    }
    public static TreeNode organization2TreeModeForSave(Collection orgFirstLevelCollect) {
        TreeNode root = new TreeNode();
        root.setText("组织机构");
        root.setAction("JavaScript: x27.org.select('');");
        root.setOpen(Boolean.TRUE);
        for (Iterator iter = orgFirstLevelCollect.iterator(); iter.hasNext();) {
            Organization element = (Organization) iter.next();
            root.addChildNode(organization2TreeModeForSave(element));
        }
        return root;
    }
    
    private static TreeNode organization2TreeModeForSave(Organization org ) {
        TreeNode node = new TreeNode();
        node.setOpen(Boolean.TRUE);
        node.setText(org.getOrgName());
        if (org.getChildOrgs() == null || org.getChildOrgs().size() == 0) {
            node.setAction("JavaScript: x27.org.select('"+org.getOrgName()+"');");
        } else {
            node.setAction("JavaScript: x27.org.select('"+org.getOrgName()+"');");
            for (Iterator iter = org.getChildOrgs().iterator(); iter.hasNext();) {
                Organization element = (Organization) iter.next();
                node.addChildNode(organization2TreeModeForSave(element));
            }
        }
        return node;
    }
    
}
