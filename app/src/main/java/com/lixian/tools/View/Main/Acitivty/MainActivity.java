package com.lixian.tools.View.Main.Acitivty;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.lixian.tools.Base.BaseActivity;
import com.lixian.tools.Model.DebugBean;
import com.lixian.tools.R;
import com.lixian.tools.Utils.AccessibilityUtil;
import com.lixian.tools.View.Main.Adapter.DeBugAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.lixian.tools.Utils.AllUtils.Counts;

public class MainActivity extends BaseActivity {
    RecyclerView mDeBugView;
    DeBugAdapter mDeBugAdapter;

    RecyclerView mPhoneView;
    DeBugAdapter mPhoneAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitDebug();
        InitPhone();




    }


    public boolean ToAccessSetting = false;
    private void InitDebug() {
        mDeBugView = lx(R.id.mDeBugView);
        mDeBugView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, Counts);
        mDeBugView.setLayoutManager(gridLayoutManager);
        mDeBugView.setItemAnimator(new DefaultItemAnimator());
        mDeBugAdapter = new DeBugAdapter(ct);
        mDeBugAdapter.setOnItemClickLitener(new DeBugAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
                if(AccessibilityUtil.isAccessibilitySettingsOn(MainActivity.this)){
                    mToast("开启了辅助功能");
                }else{
                    mToast("关闭了辅助功能");
                }
            }
        });
        mDeBugView.setAdapter(mDeBugAdapter);
        getDebugInfo();
    }
    List<DebugBean> mDebugBeans;
    private void getDebugInfo() {
        mDebugBeans = new ArrayList<>();
        mDebugBeans.add(new DebugBean(R.mipmap.debug_layout_bounds,"布局边界"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_overdraw,"过度绘制"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_surface_update,"布局跟新"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_strict_mode,"严格模式"));

        mDebugBeans.add(new DebugBean(R.mipmap.debug_pointer_location,"指针位置"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_gpu_rending,"强制GPU渲染"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_gpu_view_update,"GPU视图更新"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_track_gpu_frame,"GPU渲染"));

        mDebugBeans.add(new DebugBean(R.mipmap.icon,"开发者选项"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_settings,"系统设置"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_locale_settings,"语言设置"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_dont_keep_activities,"不保留应用"));


        mDebugBeans.add(new DebugBean(R.mipmap.debug_stay_awake,"不锁定屏幕"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_usb_debugging,"USB调试"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_running_services,"运行在服务"));
        mDebugBeans.add(new DebugBean(R.mipmap.debug_tuner,"系统界面调整"));

        mDeBugAdapter.setmDate(mDebugBeans);
        mDeBugAdapter.notifyDataSetChanged();
    }




    private void InitPhone() {
        mPhoneView = lx(R.id.mPhoneView);
        mPhoneView.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, Counts);
        mPhoneView.setLayoutManager(gridLayoutManager);
        mPhoneView.setItemAnimator(new DefaultItemAnimator());
        mPhoneAdapter = new DeBugAdapter(ct);
        mPhoneAdapter.setOnItemClickLitener(new DeBugAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View v, int postion) {

            }
        });
        mPhoneView.setAdapter(mPhoneAdapter);
        getPhoneInfo();
    }
    List<DebugBean> mPhoneBeans;
    private void getPhoneInfo() {
        mPhoneBeans = new ArrayList<>();
        mPhoneBeans.add(new DebugBean(R.mipmap.info_ui_screen,"屏幕"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_system,"系统"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_hardware,"硬件"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_cpu,"CPU"));

        mPhoneBeans.add(new DebugBean(R.mipmap.info_id,"本机ID"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_vm,"虚拟机"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_network,"网络相关"));
        mPhoneBeans.add(new DebugBean(R.mipmap.info_my_apps,"本机应用"));


        mPhoneAdapter.setmDate(mPhoneBeans);
        mPhoneAdapter.notifyDataSetChanged();

    }


}
