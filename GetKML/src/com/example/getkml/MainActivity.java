package com.example.getkml;
//GETKMLAPP
import java.util.Locale;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;


public class MainActivity extends Activity {
// Extra Message for the .putExtra
	public final static String EXTRA_MESSAGE = "com.example.getkml.MESSAGE";
	String strFinalURL = "";
	String strServer1URL = "http://kml-samples.googlecode.com/svn/trunk/kml/Region/polygon-simple.kml"; // Enter in first server site (include full address http://www.site.com/file.kml)
	String strServer2URL = "http://kml-samples.googlecode.com/svn/trunk/kml/Region/polygon-simple.kml"; // Enter in second server site (include full address http://www.site.com/file.kml)
	
	//String strURL = "";
	
	//Called when radiobuttons are selected
	public void onRadioButtonClicked(View view){
		EditText editText = (EditText) findViewById(R.id.editText1);
		//Is radio button checked?
		boolean checked = ((RadioButton) view).isChecked();
		
		// Check which radio button was clicked
		switch(view.getId()){
			case R.id.radio0:
				if (checked)
					// use strURL
					strFinalURL = strServer2URL;					
				break;
			case R.id.radio1:
				if (checked)
					// use Server1
					strFinalURL = strServer1URL;
				break;
			case R.id.radio2:
				if (checked)
					//use Server2
					strFinalURL = editText.getText().toString();;
				break;
					
		}
	}
	//Called when the user clicks the Send Button
	public void displayKML(View view){
		// Do something in response to button
		//Intent intent = new Intent(this, GetKML.class);
		//EditText editText = (EditText) findViewById(R.id.editText1);
		//String strURL = editText.getText().toString();
		//String strServer1URL = "http://kml-samples.googlecode.com/svn/trunk/kml/Region/polygon-simple.kml"; // Enter in first server site (include full address http://www.site.com/file.kml)
		//String strServer2URL = "http://kml-samples.googlecode.com/svn/trunk/kml/Region/polygon-simple.kml"; // Enter in second server site (include full address http://www.site.com/file.kml)
		//String strFinalURL = "";
		//String kmlWebAddress = "http://kml-samples.googlecode.com/svn/trunk/kml/Region/polygon-simple.kml";
		String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s",strFinalURL);
		Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
		startActivity(intent);
		
		
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
