package com.lihangogo.lhweather.activity;

import com.example.lhweather.R;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class NoNetActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.errorshow);
		
		Toast.makeText(getApplicationContext(), "网络异常，请退出重试~",
			     Toast.LENGTH_SHORT).show();
	}
}
