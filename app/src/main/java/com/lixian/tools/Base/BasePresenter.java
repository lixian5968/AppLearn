package com.lixian.tools.Base;

import android.content.Context;
import android.util.Log;


/**
 * Created by lixian on 2016/8/17.
 */
public class BasePresenter {
    public Context ct;
    public String Tag = "BasePresenter";

    public BasePresenter(Context ct) {
        this.ct = ct;
    }

    public void mToast(String s) {
        if (ct instanceof BaseActivity) {
            ((BaseActivity) ct).mToast(s);
        } else {
            Log.e(Tag, "ct is not instanceof BaseActivity --mToast");
        }
    }
    public void showMyWaitDialog(Context ct) {
        if (ct instanceof BaseActivity) {
            ((BaseActivity) ct).showMyWaitDialog(ct);
        }else {
            Log.e(Tag, "ct is not instanceof BaseActivity --showMyWaitDialog");
        }
    }
    public void CancelWaitDialog() {
        if (ct instanceof BaseActivity) {
            ((BaseActivity) ct).CancelWaitDialog();
        }else {
            Log.e(Tag, "ct is not instanceof BaseActivity --CancelWaitDialog");
        }
    }


}
