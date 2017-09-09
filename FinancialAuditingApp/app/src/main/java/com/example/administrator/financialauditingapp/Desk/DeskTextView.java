package com.example.administrator.financialauditingapp.Desk;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.financialauditingapp.R;

/**
 * Created by Administrator on 5/18/2017.
 */

class DeskTextView extends LinearLayout {
    public TextView topTextView;
    public TextView bottomTextView;
    String textTop;
    String textBottom;
    int textTopColor;
    int textBottomColor;
    int textTopSize;
    int textBottomSize;

    final int TEXT_TOP_SIZE_IN_DP =15;
    final int TEXT_BOTTOM_SIZE_IN_DP =7;
    Paint paint;
    float dp;


    public DeskTextView(Context context) {
        this(context, null);
    }

    public DeskTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public DeskTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


    private void init(AttributeSet attrs) {
        inflate(getContext(), R.layout.layout_desktextview,this);

        setOrientation(VERTICAL);


        topTextView = (TextView) findViewById(R.id.topDeskGallery);
        bottomTextView = (TextView) findViewById(R.id.bottomDeskGallery);

        paint = new Paint();

        dp = getResources().getDisplayMetrics().density;

        paint.setAntiAlias(true);
        paint.setStrokeWidth(dp);

        if (attrs!= null){
            TypedArray array = getResources().obtainAttributes(attrs,R.styleable.DeskTextView);
            textTop = array.getString(R.styleable.DeskTextView_textTop);
            textBottom = array.getString(R.styleable.DeskTextView_textBottom);

            textTopColor = array.getColor(R.styleable.DeskTextView_textTopColor,Color.WHITE);
            textBottomColor = array.getColor(R.styleable.DeskTextView_textBottomColor,Color.WHITE);

            textTopSize = (int) array.getDimension(R.styleable.DeskTextView_textTopSize,dp*TEXT_TOP_SIZE_IN_DP);
            textBottomSize = (int) array.getDimension(R.styleable.DeskTextView_textBottomSize,dp*TEXT_BOTTOM_SIZE_IN_DP);

            setTextView(topTextView,textTop,textTopColor,textTopSize);
            setTextView(bottomTextView,textBottom,textBottomColor,textBottomSize);

            topTextView.setGravity(Gravity.CENTER);
            bottomTextView.setGravity(Gravity.CENTER);
        }
    }

    private void setTextView(TextView textView,String text, int color, int textSize){

        textView.setText(text);
        textView.setTextSize(textSize);
        textView.setTextColor(color);
    }

    public void setWidth(int pixels){
        ViewGroup.LayoutParams params = getLayoutParams();
        if(params == null){
            params = generateDefaultLayoutParams();
            params.height = ViewGroup.LayoutParams.MATCH_PARENT;
        }
        params.width = pixels;
        setLayoutParams(params);
    }

}
