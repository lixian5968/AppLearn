package com.lixian.tools.View.Main.Acitivty;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.lixian.tools.Base.BaseActivity;
import com.lixian.tools.R;

public class MainActivity extends BaseActivity {
    ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.mImageView);


    }

    public void ShowDalog(View v){
        showMyWaitDialog(ct);
        mImageView.setImageDrawable(ct.getResources().getDrawable(R.drawable.ic_launcher_round));
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        CancelWaitDialog();
                    }
                });
            }
        },3000);
    }
}
