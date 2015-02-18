package com.example.resistorcolorcodec;


//import com.example.resistorcolorcodec.OnSwipeTouchListener.GestureListener;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	int thud=0;
	MediaPlayer player;
	private Camera camera;
    
	float oldTouchValue;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       
    Button b1,b2,p;
    b1=(Button) findViewById(R.id.button1);
    b2=(Button) findViewById(R.id.button2);
    p=(Button) findViewById(R.id.p);
    
    final Calendar c= Calendar.getInstance();
    int hr1=16;
    int min=02;
    int s1=c.get(Calendar.HOUR_OF_DAY);
	int s2=c.get(Calendar.MINUTE);
	
	
	if(hr1==s1&&min==s2)
{
		player = MediaPlayer.create(MainActivity.this, R.raw.ed);
		player.start();
		 																					//EASTER EGG PERK CODE
}
    
    

    
    
    
    b1.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
		Intent i=new Intent(MainActivity.this,rcalc.class);
		startActivity(i);
		}
	});
    
 b2.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) 
	{
	
	 Intent j=new Intent(MainActivity.this,rcc.class);
	 startActivity(j);
		
	}

});
    
 	
   p.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) 
	{
		thud++;
	
		if(thud>=9)
	{
			thud=0;
			player = MediaPlayer.create(MainActivity.this, R.raw.ed);
			player.start();
		 
	}
	
	}
});
  
    }

	
	

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
     getMenuInflater().inflate(R.menu.activity_main, menu);
     menu.findItem(R.id.t1).setEnabled(false);  	//disable LED ON
     menu.findItem(R.id.t1).setVisible(false);		//hide LED ON
     return true;
    
    }
    
    

public boolean onOptionsItemSelected(MenuItem item) {
  
	

if(	item.getItemId()==R.id.as)
{
	Intent k=new Intent(MainActivity.this,about.class);
	startActivity(k);
}

return true ;

}
}
