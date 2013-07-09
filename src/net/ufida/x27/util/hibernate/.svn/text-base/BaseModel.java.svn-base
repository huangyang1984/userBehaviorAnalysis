package net.ufida.x27.util.hibernate;


public abstract class BaseModel extends BaseObject implements Modelable {
    
	private int page = 1;
    
    public int hashCode() {
        String idStr = getIdStr();
        return idStr == null ? super.hashCode() : idStr.hashCode();
    }

    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        /*因为字节码增强的关系，getClass()不能用作判断的依据*/
        if (getClass().getPackage() != other.getClass().getPackage()) {
            return false;
        }
        if (hashCode() == other.hashCode()) {
            return true;
        }
        return false;
    }

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

}
