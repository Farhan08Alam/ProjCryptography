package com.example.gamelocker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class MyAdapter extends BaseAdapter {
    Context context;
    int [] images;

    public MyAdapter(Context c,int[] images){
        context = c;
        this.images = images;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imgView;
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View tempview = layoutInflater.inflate(R.layout.element,null);
        imgView = tempview.findViewById(R.id.cell);
        imgView.setImageResource(images[i]);
        return tempview;
    }
}
