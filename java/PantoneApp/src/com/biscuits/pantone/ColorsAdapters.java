package com.biscuits.pantone;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ColorsAdapters extends ArrayAdapter<Pantone> {
	Context context;
	int layoutResourceId;
	List<Pantone> colors;

	public ColorsAdapters (Context context, int layoutResourceId, List<Pantone> colors) {
		super(context, layoutResourceId, colors);
		this.context = context;
		this.layoutResourceId = layoutResourceId;
		this.colors = colors;
	}

	@Override
	public View getView(int position, View row, ViewGroup parent) {
		ColorHolder holder;
		if(row == null)
        {
            LayoutInflater inflater = ((Activity) context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            
            holder = new ColorHolder();
            holder.txtTitle = (TextView)row.findViewById(R.id.color_name);
            
            row.setTag(holder);
        }
        else
        {
            holder = (ColorHolder) row.getTag();
        }
		Pantone c = colors.get(position);
		Log.d("ADAPTER", c.toString());
		holder.txtTitle.setText(c.getName());
		row.setBackgroundColor(Color.parseColor(c.getHexColor()));
		
		return row;
	}
	static class ColorHolder{
		TextView txtTitle;
	}
}
