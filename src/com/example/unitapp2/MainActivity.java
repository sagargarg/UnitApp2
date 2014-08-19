package com.example.unitapp2;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;


public class MainActivity extends Activity {

	public static boolean isMph = true;
	public static Button mphShow;
	public static Button fpsShow;
	public static Button kmphShow;
	public static Button mpsShow;
	public static EditText text;
	public static int speed;
	public static int mph = 17;
	public static TextView spd;
	public static TextView unit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mphShow = (Button) findViewById(R.id.mph);
        fpsShow = (Button) findViewById(R.id.ftpsec);
        kmphShow = (Button) findViewById(R.id.kmph);
        mpsShow = (Button) findViewById(R.id.mpsec);
        unit = (TextView) findViewById(R.id.unit);
        text = (EditText) findViewById(R.id.inputnumber);
        speed = Integer.parseInt(text.getText().toString());
        
        text.setOnEditorActionListener(new OnEditorActionListener() {

			@Override
			public boolean onEditorAction(TextView arg0, int arg1, KeyEvent arg2) {
				int num = Integer.parseInt(text.getText().toString());
				String cs = (String) unit.getText();
				if (cs == "mph") {
					mph = num;
				}
				else if (cs == "ft/sec") {
					mph = (int) Math.round(Integer.parseInt(cs) * 0.681818);
				}
				else if (cs == "km/h") {
					mph = (int) Math.round(Integer.parseInt(cs) * 0.621371);
				}
				else {
					mph = Integer.parseInt(cs) * 3600;
				}
				return true;
			}
        });
        
        View.OnClickListener mphListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				unit.setText("mph");
				speed = mph;
				spd.setText(Integer.toString(speed));
				isMph = true;
			}
    	};
    	mphShow.setOnClickListener(mphListener);
        
    	View.OnClickListener fpsListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Here we have to start the game.
				unit.setText("ft/sec");
				speed = (int) Math.round(mph * 1.4666);
				spd.setText(Integer.toString(speed));
				isMph = false;
				
			}
    	};
    	fpsShow.setOnClickListener(fpsListener);
      
    	View.OnClickListener kmphListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Here we have to start the game.
				unit.setText("km/h");
				speed = (int) Math.round(mph * 5);
				spd.setText(Integer.toString(speed));
				isMph = false;
			}
    	};
    	kmphShow.setOnClickListener(kmphListener);
    	
    	View.OnClickListener mpsListener = new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// Here we have to start the game.
				unit.setText("m/sec");
				speed = (int) Math.round(mph / 3600.00);
				spd.setText(Integer.toString(speed));
				isMph = false;
			}
    	};
    	mpsShow.setOnClickListener(mpsListener);
    	
    	
    	
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
