package com.lixian.tools.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.lixian.tools.R;
import com.lixian.tools.UI.MyDialog;


/**
 * Created by lixian on 2016/7/25.
 */
public class BaseActivity extends AppCompatActivity {
    public Context ct;
    public String Tag = "BaseActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ct = this;


    }


    public void finish(View v) {
        finish();
    }
    public void mToast(String s) {
        try {
            if(s!=null &&s.length()>0){
                Toast.makeText(BaseActivity.this, s, Toast.LENGTH_SHORT).show();
            }else{
                Log.e(Tag,"mToast s is null or length 0");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e(Tag,e.getMessage());
        }
    }


    // 等待对话框
    public MyDialog MyWaitDialog;
    public void showMyWaitDialog(final Context ct) {
        if (ct == null) {
            return;
        }
        if (MyWaitDialog != null && MyWaitDialog.isShowing()) {
            return;
        }
        View view = View.inflate(ct, R.layout.ui_wait_dialog, null);
        if (MyWaitDialog == null) {
            MyWaitDialog = new MyDialog(ct, 0, 0, view, R.style.dialog);
        }
        MyWaitDialog.setCancelable(false);
        MyWaitDialog.show();
    }
    //关闭等待对话框
    public void CancelWaitDialog() {
        if (MyWaitDialog != null && MyWaitDialog.isShowing()) {
            MyWaitDialog.dismiss();
        }
    }






}



