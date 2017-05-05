package com.example.sus.timeactivity;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import java.util.Calendar;



/**
 * Created by sus on 2017/5/5.
 */

public class Viewtext extends View {
    private Paint paintbiaopan,//表盘的画笔
            paintbiaoshu,//表盘数字的画笔
            paintbiaoxin,//表芯的画笔
            shizhen,//时钟画笔
            fenzhen,//分钟画笔
            miaozhen,//秒钟画笔
            data;     //创建星期的画笔
    private int width,  height;
//     * View高度，默认256dp
   //View宽度，默认256dp



    /**
     * 日历类，用来获取当前时间
     */
    private Calendar calendar;
    /**
     * 当前时针颜色
     */
    private int shiColor,x,y;
    private int fenColor;
    /**
     * 当前分针颜色
     */
    private int miaoColor;
    /**
     * 当前秒针颜色
     */
    private int shiWidth;
    /**
     * 时针宽度
     */
    private int fenWidth;
    /**
     * 分针宽度
     */
    private int miaoWidth;
    /**
     * 秒针宽度
     */
    //在代码中创建控件时调用
    private int secondWidth;
    private int radius;

    public Viewtext(Context context) {
        this(context,null);
    }
    //在布局文件中创建View时调用
    public Viewtext(Context context, AttributeSet attrs) {
        this(context,attrs,0);
    }

    public Viewtext(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //定义一个自定义初始化的方法设置钟表的颜色，宽高长短
       initView();
    }


    private void initView() {

        calendar = Calendar.getInstance();//获取当前时间的实例

        //时钟默认宽高


        /**
         * TypedValue.applyDimension(int unit, float value, DisplayMetrics metrics)方法来进行单位的互换，
         其中，第一个参数是你想要得到的单位，第二个参数是你想得到的单位的数值，
         比如：我要得到一个25sp，那么我就用TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 25,getResources().getDisplayMetrics())，返回的就是25sp对应的px数值了。
         */


        //初始化默认时钟的宽高
        width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 256, getResources().getDisplayMetrics());
        height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 256, getResources().getDisplayMetrics());


        //给钟表的指针设置颜色
        shiColor= Color.BLACK;
        fenColor =Color.BLACK;
        miaoColor=Color.RED;


        //给钟表的指针设置宽度
        shiWidth=8;
        fenWidth=5;
        miaoWidth=2;

        //初始化各种画笔
        paintbiaopan = new Paint();
        paintbiaoshu = new Paint();
        paintbiaoxin = new Paint();
        shizhen = new Paint();
        fenzhen= new Paint();
        miaozhen = new Paint();
        data = new Paint();

        //给各种画笔去锯齿
        paintbiaoxin.setAntiAlias(true);
        paintbiaoshu.setAntiAlias(true);
        paintbiaopan.setAntiAlias(true);
        shizhen     .setAntiAlias(true);
        fenzhen     .setAntiAlias(true);
        miaozhen    .setAntiAlias(true);
        data.setAntiAlias(true);
        //给各种画笔设置颜色
        paintbiaopan.setColor(Color.GREEN);//设置表盘颜色
        paintbiaoxin.setColor(Color.RED);//设置表芯颜色
        paintbiaoshu.setColor(Color.BLACK);//设置表数的画笔颜色
        shizhen     .setColor(Color.BLACK);//设置时钟的画笔颜色
        fenzhen     .setColor(Color.GREEN);//设置分钟的画笔颜色
        miaozhen    .setColor(Color.RED);//设置秒针的画笔颜色
        data.setColor(Color.RED);
        data.setTextSize(30);

        paintbiaopan.setStyle(Paint.Style.STROKE);
        paintbiaopan.setStrokeWidth(4);//设置描边的宽度
        paintbiaoshu.setTextAlign(Paint.Align.CENTER);
        paintbiaoxin.setStyle(Paint.Style.FILL);//设置表芯的样式
        //文本对齐方式
        paintbiaoshu.setTextAlign(Paint.Align.CENTER);



        //设置时针的宽，颜色，样式
        shizhen.setColor(shiColor);
        shizhen.setStyle(Paint.Style.FILL);
        shizhen.setStrokeWidth(shiWidth);


        //设置分针的宽，颜色，样式
        fenzhen.setColor(fenColor);
        fenzhen.setStyle(Paint.Style.FILL);
        fenzhen.setStrokeWidth(fenWidth);

        //设置秒针的宽，颜色，样式
        miaozhen.setColor(miaoColor);
        miaozhen.setStrokeWidth(miaoWidth);
        miaozhen.setStyle(Paint.Style.FILL);
    }
    //开始重写OnDraw方法库开始画表盘


    @Override
    protected void onDraw(Canvas canvas) {
        calendar = Calendar.getInstance();//获取一个时间的实例
        /**
         * 参数1：圆心X轴坐标
         * 参数2：圆心Y轴坐标
         * 参数3：半径
         * 参数4：画笔
         */
        radius = width / 2 - 10;
        //画表盘
        canvas.drawCircle(width / 2, height / 2, radius,paintbiaopan);
        //画表芯
        canvas.drawCircle(width / 2, height / 2, 15,paintbiaoxin);

//        int i1 = calendar.get(Calendar.DAY_OF_WEEK);
        //设置按钮的文字
        canvas.drawText("周"+zhouji(calendar),width /2-30,width /2- radius +140,data);

        canvas.drawRect(0,120,100,100,paintbiaoxin);
        for (int i = 1; i < 13; i++) {
            //在旋转之前保存画布状态
            canvas.save();
            canvas.rotate(i * 30, width / 2, height / 2);
            //1.2表示起点坐标，3.4表示终点坐标，5.画笔
            canvas.drawLine(width / 2, width / -radius, width / 2, height / 2 - radius + 10,paintbiaopan);
            //画表盘数字1.要绘制的文本，2.文本x轴坐标，3.文本基线，4.文本画笔
            canvas.drawText(i + "", width / 2, height / 2 - radius + 22,paintbiaoshu);
            //恢复画布状态
            canvas.restore();
        }
        //获得当前小时
        int hour = calendar.get(Calendar.HOUR);
        canvas.save();
        //旋转屏幕
        canvas.rotate(hour * 30, width / 2, height / 2);
        //画时针
        canvas.drawLine(width / 2, height / 2 + 20, width / 2, height / 2 - 90,shizhen);
        canvas.restore();

        int minute = calendar.get(Calendar.MINUTE);
        canvas.save();
        canvas.rotate(minute * 6, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 + 30, width / 2, height / 2 - 110,fenzhen);
        canvas.restore();
        int second = calendar.get(Calendar.SECOND);
        canvas.save();
        canvas.rotate(second * 6, width / 2, height / 2);
        canvas.drawLine(width / 2, height / 2 + 40, width / 2, height / 2 - 130,miaozhen);
        canvas.restore();
        //每隔1秒重绘View,重绘会调用onDraw()方法
        postInvalidateDelayed(1000);
    }
    public  String zhouji(Calendar c){

        if(c.get(Calendar.DAY_OF_WEEK)==1){
            return "一";
        }
        if(c.get(Calendar.DAY_OF_WEEK)==2){
            return "二";
        }
        if(c.get(Calendar.DAY_OF_WEEK)==3){
            return "三";
        }
        if(c.get(Calendar.DAY_OF_WEEK)==4){
            return "四";
        }
        if(c.get(Calendar.DAY_OF_WEEK)==5){
            return "五";
        }
        if(c.get(Calendar.DAY_OF_WEEK)==6){
            return "六";
        }
            return "日";
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            x = (int) event.getX();//获取鼠标按下时的X轴的位置
            y = (int) event.getY();//获取鼠标按下时的Y轴的位置
        }
        Log.i("tag",(width /2-30)+"weewe"+(width/2-radius+140));
        if(x>width /2-30&&y<width/2-radius+140){
            //判断点击按钮的范围是否超出啦自定义的View的范围
            getContext().startActivity(new Intent(getContext(),SendActivity.class));

        }
        return super.onTouchEvent(event);
    }
}

