package com.biscuits.pantone;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
        setListAdapter(new ColorsAdapters(this, R.layout.color_cell, this.getColors()));
   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private List<Pantone> getColors(){
		ArrayList<Pantone> listItems = new ArrayList<Pantone>();
		try {
			String jsonFile = FileUtils.getFileFromAssetsAsString(getApplicationContext(), "items.json");
			JSONArray ja = new JSONArray(jsonFile);
			for (int i = 0; i < ja.length(); i++) {
			    JSONObject jo = (JSONObject) ja.get(i);
			    Pantone p = new Pantone();
			    p.setName(jo.getString("name"));
			    p.setHexColor(jo.getString("hex_code"));
			    listItems.add(p);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		}
//		this.debugList(listItems);
		return listItems;
	} 

	private void debugList(List<Pantone> l){
		Iterator<Pantone> it = l.iterator();
		while(it.hasNext()){
			System.out.println(it.next().toString());
		}
	}
}

