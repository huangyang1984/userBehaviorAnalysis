package net.ufida.x27.util.web;

import java.util.LinkedList;
import java.util.List;

import net.ufida.x27.util.hibernate.BaseObject;

/**
 * 
 * @author Steven.yang
 *
 */
public class TreeNode extends BaseObject {
    
    private String id;
    
    private String text;
    
    private Boolean leaf;
    
    private List children = new LinkedList();

    public TreeNode(String id, String text, Boolean leaf) {
        this.id = id;
        this.text = text;
        this.leaf = leaf;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public List getChildren() {
        return children;
    }

    public void setChildren(List childs) {
        this.children = childs;
    }
    
    public void addChild(TreeNode child) {
        children.add(child);
    }
    
}
