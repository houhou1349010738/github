package com.example.sus.caijiannan20170509.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sus.caijiannan20170509.R;
import com.example.sus.caijiannan20170509.Xiangqing;
import com.example.sus.caijiannan20170509.bean.InpoBean;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 16:33
 */

public class LayoutMess extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;

    public LayoutMess(Context context, List<InpoBean.ResultBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    private List<InpoBean.ResultBean.DataBean> list = new ArrayList<>();
    @Override//给 RecyclerView创建一个子布局
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Myholder holder = new Myholder(LayoutInflater.from(context).inflate(R.layout.recview, parent, false));

        return holder;//返回创建的子布局
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        Myholder o= (Myholder) holder;
        x.image().bind(o.im,list.get(position).getThumbnail_pic_s());
        o.tv.setText(list.get(position).getTitle());
        o.tv2.setText(list.get(position).getAuthor_name());
        ViewGroup.LayoutParams layoutParams = o.itemView.getLayoutParams();
        layoutParams.height=100;
        o.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(context,Xiangqing.class);
                        it.putExtra("name",list.get(position).getTitle());
                        it.putExtra("image",list.get(position).getThumbnail_pic_s02());
                        it.putExtra("title",list.get(position).getAuthor_name());
                        context.startActivity(it);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list!=null?list.size():0;
    }
    public static class Myholder  extends RecyclerView.ViewHolder{
       ImageView im;
       TextView tv;
        TextView tv2;

        public Myholder(View itemView) {
            super(itemView);
            //获取子布局的资源id
            im = (ImageView) itemView.findViewById(R.id.rec_iv);
            tv = (TextView) itemView.findViewById(R.id.rec_tv);
            tv2 = (TextView) itemView.findViewById(R.id.rec_tv2);
        }

    }
}
