package application.cartoon.com.day411.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

import application.cartoon.com.day411.MainActivity;

/**
 * 作    者： shangzemin
 * 类的用途：
 * 日    期： 2017-04-11.
 */

public class RoundView extends View {
    /**
     * 定义画笔
     */
    private Paint mpaint;
    /**
     * 定义圆的半径
     */
    private float radius;
    /**
     * 定义圆圆心位置 x和y
     */
    private float roixtX;
    private float roixtY;

    public RoundView(Context context) {

        super(context);
        mpaint=new Paint();
        mpaint.setColor(Color.BLUE);
        radius=10;
        getScreenMeric();
    }

    public RoundView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(roixtX,roixtY,radius,mpaint);
    }
    public void setRadius(float s){
        radius+=s;
        if (radius<0){
            radius=0;
        }invalidate();
    }
    public void setRoixt(float x,float y){
        roixtX+=x;
        roixtY+=y;
        if (roixtX<0){
            roixtX=0;
        }if (roixtY<0){
            roixtY=0;
        }

        invalidate();
    }
private void getScreenMeric(){
    DisplayMetrics metric = new DisplayMetrics();
    ((MainActivity)getContext()).getWindowManager().getDefaultDisplay().getMetrics(metric);
    // 屏幕宽度（像素）
   float width = metric.widthPixels;
    roixtX=width/2.0f;

    // 屏幕高度（像素）
    float  height = metric.heightPixels;
    roixtY=height/2.0f;
    float density = metric.density;      // 屏幕密度（0.75 / 1.0 / 1.5）
    int densityDpi = metric.densityDpi;

}

}
