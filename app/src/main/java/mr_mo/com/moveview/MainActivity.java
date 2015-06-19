package mr_mo.com.moveview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 移动view demo
 */
public class MainActivity extends Activity {

    private int currentX;
    private int currentY;
    private int moveY = 0;
    private int moveX = 0;

    private TextView tvMoveView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMoveView = (TextView) findViewById(R.id.tvMoveView);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                currentX = (int) event.getRawX();
                currentY = (int) event.getRawY();
                break;
            }
            case MotionEvent.ACTION_MOVE: {
                int x2 = (int) event.getRawX();
                int y2 = (int) event.getRawY();
                moveY = y2 - currentY;
                moveX = x2 - currentX;

                tvMoveView.offsetTopAndBottom(moveY);
                tvMoveView.offsetLeftAndRight(moveX);

                currentX = x2;
                currentY = y2;
                break;
            }
        }
        return super.onTouchEvent(event);
    }
}
