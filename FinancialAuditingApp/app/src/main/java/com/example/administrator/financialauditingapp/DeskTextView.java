package com.example.administrator.financialauditingapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

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
        inflate(getContext(),R.layout.layout_desktextview,this);

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

            textTopColor = array.getColor(R.styleable.DeskTextView_textTopColor,0);
            textBottomColor = array.getColor(R.styleable.DeskTextView_textBottomColor,0);

            textTopSize = (int) array.getDimension(R.styleable.DeskTextView_textTopSize,-1);
            textBottomSize = (int) array.getDimension(R.styleable.DeskTextView_textBottomSize,-1);
        }

        setTextView(textTop,textBottom,textTopColor,textBottomColor,textTopSize,textBottomSize);
    }

    public void setTextView(String topText, String bottomText, int topTextColor, int bottomTextColor, int topTextSize, int bottomTextSize){
        topTextView.setText(topText);
        topTextView.setTextColor(topTextColor);
        if (topTextSize>0)
            topTextView.setTextSize(topTextSize);

        bottomTextView.setText(bottomText);
        bottomTextView.setTextColor(bottomTextColor);
        if (bottomTextSize>0)
            bottomTextView.setTextSize(bottomTextSize);
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
