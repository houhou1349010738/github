package com.example.sus.caijiannan20170509.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sus.caijiannan20170509.R;
import com.example.sus.caijiannan20170509.bean.Product;

import org.xutils.x;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * 项目名称：Caijiannan20170509
 * 项目创建人：caijiannan
 * 项目创建时间:2017/5/9 10:31
 */

public class MasonryAdapter extends RecyclerView.Adapter<MasonryAdapter.MasonryView>{
    private List<Product> products = new ArrayList<>();
    private Context context;
    private OnRecyclerItemClickListener mOnItemClickListener;//单击事件
    private onRecyclerItemLongClickListener mOnItemLongClickListener;//长按事件
    private List<Integer> integerlit = new ArrayList<>();
    public MasonryAdapter(List<Product> list,Context context) {
        products=list;
        this.context=context;
        for(int i=0;i<products.size();i++){
            Random rand = new Random();
            int i1 = rand.nextInt(200)+100;
            integerlit.add(i1);
        }
    }
    @Override
    public MasonryView onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.frag2, viewGroup, false);
        return new MasonryView(view);
    }

    @Override
    public void onBindViewHolder(final MasonryView masonryView, final int position) {
        ViewGroup.LayoutParams layoutParams = masonryView.itemView.getLayoutParams();
        layoutParams.height=integerlit.get(position);
        masonryView.itemView.setLayoutParams(layoutParams);
        ViewGroup.LayoutParams layoutParams1 = masonryView.imageView.getLayoutParams();
       layoutParams1.height=integerlit.get(position);
        masonryView.imageView.setLayoutParams(layoutParams1);
        x.image().bind(masonryView.imageView,products.get(position).getImg());
        masonryView.textView.setText(products.get(position).getTitle());
        //设置单击事件
        if(mOnItemClickListener !=null){

            masonryView.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    mOnItemClickListener.onItemClick(v,masonryView.getLayoutPosition());
                }
            });
        }
        //长按事件
        if(mOnItemLongClickListener != null){
            masonryView.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    //回调出去
                    mOnItemLongClickListener.onItemLongClick(v,masonryView.getLayoutPosition());
                    return true;//不返回true,松手还会去执行单击事件
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class MasonryView extends  RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;

        public MasonryView(View itemView){
            super(itemView);

            imageView= (ImageView) itemView.findViewById(R.id.masonry_item_img );
            textView= (TextView) itemView.findViewById(R.id.masonry_item_title);
        }


    }

    /**
     * 处理item的点击事件,因为recycler没有提供单击事件,所以只能自己写了
     */
    public interface OnRecyclerItemClickListener {
        public void onItemClick(View view, int position);
    }

    /**
     * 长按事件
     */
    public interface  onRecyclerItemLongClickListener{
        public void onItemLongClick(View view, int position);
    }

    /**
     * 暴露给外面的设置单击事件
     */
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

    /**
     * 暴露给外面的长按事件
     */
    public void setOnItemLongClickListener(onRecyclerItemLongClickListener onItemLongClickListener){
        mOnItemLongClickListener = onItemLongClickListener;
    }

    /**
     * 向指定位置添加元素
     */
    public void addItem(int position, Product value) {
        if(position > products.size()) {
            position = products.size();
        }
        if(position < 0) {
            position = 0;
        }
        /**
         * 使用notifyItemInserted/notifyItemRemoved会有动画效果
         * 而使用notifyDataSetChanged()则没有
         */
        products.add(position,value);//在集合中添加这条数据
        integerlit.add(position,new Random().nextInt(200) + 100);//添加一个随机高度,会在onBindViewHolder方法中得到设置

        notifyItemInserted(position);//通知插入了数据
    }

    /**
     * 移除指定位置元素
     */
    public Product removeItem(int position) {
//        if(position > products.size()-1) {
//            return null;
//        }
        integerlit.remove(position);//删除添加的高度
        Product value = products.remove(position);//所以还需要手动在集合中删除一次
        notifyItemRemoved(position);//通知删除了数据,但是没有删除list集合中的数据
        return value;
    }

}
