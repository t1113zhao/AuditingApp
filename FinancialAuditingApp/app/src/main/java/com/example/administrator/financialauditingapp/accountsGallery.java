package com.example.administrator.financialauditingapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static android.R.id.list;

/**
 * Created by Administrator on 5/18/2017.
 */

public class accountsGallery extends RecyclerView {

    public static class DeskInfo {
        public String topText;
        public String bottomText;

        public DeskInfoListener listener;

        public DeskInfo (String setTop, String setBottom, DeskInfoListener setListener){
            this.topText = setTop;
            this.bottomText = setBottom;
            this.listener = setListener;
        }

        public DeskInfo (String setTop, String setBottom){
            this.topText = setTop;
            this.bottomText = setBottom;
        }

        public DeskInfo(){

        }

        @Override
        public boolean equals(Object o) {
            if (o == null || !(o instanceof DeskInfo)) return  false;
            DeskInfo obj = (DeskInfo) o;

            if (TextUtils.isEmpty(bottomText) && TextUtils.isEmpty(obj.bottomText)) return true;
            if (TextUtils.isEmpty(bottomText)|| TextUtils.isEmpty(obj.bottomText)) return false;
            return bottomText.equals(obj.bottomText);
        }
    }

    public interface DeskInfoListener{
        void onClick(DeskInfo info);
    }

    public class DeskInfoOnClickListener implements  View.OnClickListener{

        DeskInfo info;
        @Override
        public void onClick(View v) {
            if (info != null && info.listener != null){
                info.listener.onClick(info);
            }
        }
    }

    public accountsGallery(Context context) {
        super(context);
        init();
    }

    public accountsGallery(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public accountsGallery(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    ColorDrawable divider;

    public void setData (List< DeskInfo> list ){

    }

    public class galleryAdapter extends RecyclerView.Adapter<galleryAdapter.ViewHolder> {

        List<DeskInfo> infolist= new ArrayList<DeskInfo>();


        public galleryAdapter(ArrayList<DeskInfo> deskInfos) {
            super();
            this.infolist = deskInfos;
        }

        @Override
        public galleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder holder = new ViewHolder(new DeskTextView(getContext()));
            return  holder;
        }

        @Override
        public void onBindViewHolder(galleryAdapter.ViewHolder holder, int position) {
            //TODO
        }

        @Override
        public int getItemCount() {
            return infolist.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            public DeskTextView desk;
            public ViewHolder(View itemView) {
                super(itemView);
                desk = (DeskTextView) itemView;
            }
        }
    }

    public void init(){
        setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        manager.setOrientation(HORIZONTAL);

        setLayoutManager(manager);
        addItemDecoration(new itemDecor());
        setAdapter(new galleryAdapter(new ArrayList<DeskInfo>()));
    }

    //TODO THIS WILL NOT DISPLAYB ON THE SCREEN/ I DONT HAVE INFORMATION FOR IT TO FILL IN
    class itemDecor  extends  RecyclerView.ItemDecoration{
        int devicePixels =0;

        public itemDecor(){
            super();
            devicePixels = getResources().getDimensionPixelSize(R.dimen.activity_horizontal_margin) /16;
        }

        @Override
        public void onDraw(Canvas c, RecyclerView parent, State state) {
            super.onDraw(c, parent, state);
            drawVertical (c,parent);
        }

        public void drawVertical(Canvas c, RecyclerView parent){
            final int childAmount = parent.getChildCount();

            for(int i =0; i<childAmount; i++){
                final View child = parent.getChildAt(i);

                final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();

                int top = child.getTop() - params.topMargin;
                int bottom =child.getBottom() + params.bottomMargin;
                int left = child.getRight() + params.rightMargin;
                int right = left+devicePixels/2;

                if (child instanceof DeskTextView){
                    DeskTextView dtv = (DeskTextView) child;
                    Layout layout = dtv.topTextView.getLayout();
                    top += layout.getLineDescent(0);
                }

                divider.setBounds(left,top,right,bottom);
                divider.draw(c);

            }
        }
    }
}
