package com.lixian.tools.View.Main.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lixian.tools.Model.DebugBean;
import com.lixian.tools.R;

import java.util.List;

import static com.lixian.tools.Utils.AllUtils.Counts;

/**
 * Created by lixian on 2017/4/17.
 */

public class DeBugAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private static final String TAG = "DeBugAdapter";


    Context ct;
    List<DebugBean> mDebugBeans;
    private int Grid = 0;

    public DeBugAdapter(Context ct) {
        this.ct = ct;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_debug_item, parent, false);
        GridHolder vh = new GridHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof GridHolder) {
            try {
                DebugBean bean = mDebugBeans.get(position);
                if (bean != null) {
                    ((GridHolder) holder).DebugItemImage.setImageDrawable(ct.getResources().getDrawable(bean.IconID));
                    ((GridHolder) holder).DebugItemText.setText(bean.name);
                }
                if(position<Counts){
                    ((GridHolder) holder).TopView.setVisibility(View.GONE);
                }else{
                    ((GridHolder) holder).TopView.setVisibility(View.VISIBLE);
                }

            } catch (Exception e) {
                e.printStackTrace();
                Log.e(TAG,e.getMessage());
            }
        }
    }


    @Override
    public int getItemViewType(int position) {
        return Grid;
    }

    @Override
    public int getItemCount() {
        if (mDebugBeans != null) {
            return mDebugBeans.size();
        } else {
            return 0;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
        }
    }

    public void setmDate(List<DebugBean> mDebugBeans) {
        this.mDebugBeans = mDebugBeans;
        notifyDataSetChanged();
    }


    class GridHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView DebugItemImage;
        TextView DebugItemText;
        View TopView;

        public GridHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            DebugItemImage = itemView.findViewById(R.id.DebugItemImage);
            DebugItemText = itemView.findViewById(R.id.DebugItemText);
            TopView = itemView.findViewById(R.id.TopView);
        }

        @Override
        public void onClick(View v) {
            mOnItemClickLitener.onItemClick(v, this.getPosition());
        }
    }


    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickListener mOnItemClickLitener) {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
}
