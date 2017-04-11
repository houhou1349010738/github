package application.cartoon.com.day411;

import android.graphics.Point;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import application.cartoon.com.day411.views.RoundView;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    double nLenStart;

    private RoundView roundView;
    private float xstart;
    private float ystart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        roundView = new RoundView(this);
        LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        roundView.setLayoutParams(params);
        LinearLayout ll= (LinearLayout) findViewById(R.id.ll);
        roundView.invalidate();
        ll.addView(roundView);

    }
    @Override
   public boolean onTouchEvent(MotionEvent event) {

                int nCnt = event.getPointerCount();

                int n = event.getAction();
        if (event.getAction()==MotionEvent.ACTION_DOWN && 1== nCnt){
            xstart = event.getX();
            ystart = event.getY();
            Toast.makeText(this, "x值"+ xstart, LENGTH_SHORT).show();


        }else if(event.getAction()==MotionEvent.ACTION_MOVE && 1== nCnt){
            float xEnd = event.getX();
           float yEnd = event.getY();

            roundView.setRoixt(xEnd-xstart,yEnd-ystart);
            xstart=xEnd;
            ystart=yEnd;
        }
                if( (event.getAction()&MotionEvent.ACTION_MASK) == MotionEvent.ACTION_POINTER_DOWN && 2 == nCnt)//<span style="color:#ff0000;">2表示两个手指</span>
                    {

                        for(int i=0; i< nCnt; i++)
                            {
                                float x = event.getX(i);
                                float y = event.getY(i);

                                Point pt = new Point((int)x, (int)y);

                            }

                        int xlen = Math.abs((int)event.getX(0) - (int)event.getX(1));
                        int ylen = Math.abs((int)event.getY(0) - (int)event.getY(1));

                        nLenStart = Math.sqrt((double) xlen * xlen + (double) ylen * ylen);


                    }else if( (event.getAction()&MotionEvent.ACTION_MASK) == MotionEvent.ACTION_MOVE  && 2 == nCnt)
                    {

                        for(int i=0; i< nCnt; i++)
                            {
                                float x = event.getX(i);
                                float y = event.getY(i);

                                Point pt = new Point((int)x, (int)y);

                            }

                        int xlen = Math.abs((int)event.getX(0) - (int)event.getX(1));
                        int ylen = Math.abs((int)event.getY(0) - (int)event.getY(1));

                        double nLenEnd = Math.sqrt((double)xlen*xlen + (double)ylen * ylen);
roundView.setRadius((float) (nLenEnd-nLenStart)/2.0f);
//                        if(nLenEnd > nLenStart)//通过两个手指开始距离和结束距离，来判断放大缩小
//                            {
//                                Toast.makeText(getApplicationContext(), "放大", Toast.LENGTH_SHORT).show();
//                            }
//                        else
//                       {
//                                Toast.makeText(getApplicationContext(), "缩小", Toast.LENGTH_SHORT).show();
//                            }
                        nLenStart=nLenEnd;
                   }



                return super.onTouchEvent(event);
            }

}
