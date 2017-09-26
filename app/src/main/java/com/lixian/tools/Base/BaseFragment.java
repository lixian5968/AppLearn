package com.lixian.tools.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * Created by lixian on 2016/2/15.
 */
public abstract class BaseFragment extends Fragment {

    public String Tag = "BaseFragment";
    protected View view;
    public Context ct;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ct = getActivity();
        //防止 多个数据 调用同一个界面
        if (view == null) {
            view = getResourcesView(inflater, container);
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        afterOncreate(savedInstanceState);
    }

    public abstract View getResourcesView(LayoutInflater inflater, ViewGroup container);

    public abstract void afterOncreate(Bundle savedInstanceState);


    public void mToast(String s) {
        if (ct instanceof BaseActivity) {
            ((BaseActivity) ct).mToast(s);
        } else {
            Log.e(Tag, "ct is not instanceof BaseActivity --mToast");
        }
    }
    public void showMyWaitDialog(final Context ct) {
        if (ct instanceof BaseActivity) {
            ((BaseActivity) ct).showMyWaitDialog(ct);
        } else {
            Log.e(Tag, "ct is not instanceof BaseActivity --showMyWaitDialog ");
        }
    }
    public void CancelWaitDialog() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).CancelWaitDialog();
        } else {
            Log.e(Tag, "ct is not instanceof BaseActivity --CancelWaitDialog ");
        }
    }


}
