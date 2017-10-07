package com.lixian.tools.Model;

import com.lixian.tools.Base.BaseBean;

/**
 * Created by lixian on 2017/10/4.
 */

public class DebugBean extends BaseBean {
    public int IconID;
    public String name;
    public int id;

    public DebugBean() {
    }

    public DebugBean(int iconID, String name) {
        IconID = iconID;
        this.name = name;
    }
}
