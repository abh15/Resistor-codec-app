

package com.example.resistorcolorcodec;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import java.util.*;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.resistorcolorcodec.ShakeDetector.OnShakeListener;

public class rcc extends Activity {

	long counter,c,tol;
	int a,b,qux=1;
	Button black,brown,red,orange,yellow,green,blue,violet,grey,white,gold,silver,calc,r;
	Button b1,b2,m,t;
	TextView disp,d2,d3;	 
	boolean torch_engaged;
		private SensorManager mSensorManager;
	    private Sensor mAccelerometer;
	    private ShakeDetector mShakeDetector;
	    private Camera camera;
	     
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rcc);
        counter=0;
        a=0;
        b=0;
        c=0;
        
  tol=0;  
  disp=(TextView) findViewById(R.id.textView1);
  d2=(TextView) findViewById(R.id.textView2);
  d3=(TextView) findViewById(R.id.textView3);
  
   b1=(Button) findViewById(R.id.button14);
   b2=(Button) findViewById(R.id.button15);
   m=(Button) findViewById(R.id.button16);
   t=(Button) findViewById(R.id.button17);
   r=(Button) findViewById(R.id.button18);
   black=(Button) findViewById(R.id.button1);
   brown=(Button) findViewById(R.id.button2);
   red=(Button) findViewById(R.id.button3);
   orange=(Button) findViewById(R.id.button4); 
   yellow=(Button) findViewById(R.id.button5);
   green=(Button) findViewById(R.id.button6);
   blue=(Button) findViewById(R.id.button7);
   violet=(Button) findViewById(R.id.button8);
   grey=(Button) findViewById(R.id.button9);
   white=(Button) findViewById(R.id.button10);
   gold=(Button) findViewById(R.id.button11);
   silver=(Button) findViewById(R.id.button12);
   calc=(Button) findViewById(R.id.button13);
   
   
   
   black.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		cfunc(R.drawable.black,0,1);
		
	}
});
   
   
   brown.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			cfunc(R.drawable.brown,1,10);
			
			
		}
	});
   
   red.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.red,2,100);
			
				}
	});
   
   orange.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.orange,3,1000);
					
		}
	});
   
   yellow.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.yellow,4,10000);
			
			
		}
	});
   
   green.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			cfunc(R.drawable.green,5,100000);
			
			
		}
	});
  
   blue.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.blue,6,1000000);
			
				
		}
	});
  
   violet.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.violet,7,10000000);
			
				}
	});
   
   grey.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.grey,8,100000000);
			
		}
	});
   
   white.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			cfunc(R.drawable.white,9,1000000000);
			
		}
	});
   
   gold.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
		//	
			if(counter==2)
			{
			c=0;
			counter++;
			m.setBackgroundResource(R.drawable.gold);
			}
			else if(counter==3)
			{
			//
			 tol=5;	
			 t.setBackgroundResource(R.drawable.gold);	
			}
			}
	});
  
   silver.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			tol=10;
			t.setBackgroundResource(R.drawable.silver);
		}
	});
   
   calc.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			long x;
		if(1000000>c&&c>=1000)
		{	
			c=(c/1000);
			x=(((a*10)+b))*c;
			disp.setText(""+x);
		    d2.setText("KΩ±"+tol);
		    d3.setText("%");
		    counter=0;
			
		}
		else if(c>=1000000)
		{
				c=(c/1000000);
				x=(((a*10)+b))*c;
				disp.setText(""+x);
			    d2.setText("MΩ±"+tol);
			    d3.setText("%");
			    counter=0;
				
		}
		else if(c==0)
		{
			disp.setText(""+a+"."+b);
		    d2.setText("Ω±"+tol);
		    d3.setText("%");
		    counter=0;
		    
		}
		else
		{


			x=(((a*10)+b))*c;
			disp.setText(""+x);
		    d2.setText("Ω±"+tol);
		    d3.setText("% ");
		    counter=0;
			}
		    
		}
		});
  

// ShakeDetector initialization
   mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
   mAccelerometer = mSensorManager
           .getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
   mShakeDetector = new ShakeDetector();
   mShakeDetector.setOnShakeListener(new OnShakeListener() {

       @Override
       public void onShake(int count) {
           /*
            * The following method setup whatever you want done once the
            * device has been shook.
            */
    	   reset();
       }
   });
   
 
   
  r.setOnClickListener(new View.OnClickListener() {
	
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
		reset();
	
	}
});
  
	
	
 }
//func definition
	
	public void cfunc(int s,int z,int mul)
	{
		if(counter==0)
		{
		a=z;
		counter++;
		b1.setBackgroundResource(s);
		}
		else if(counter==1)
		{
			b=z;
			counter++;
			b2.setBackgroundResource(s);
		}
		else
		{
			c=mul;
			counter++;
			m.setBackgroundResource(s);
		}
	}
	
	//reset defn
	public void reset()
	{
		a=b=0;
		c=tol=counter=0;
		b1.setBackgroundResource(R.drawable.blank);
		b2.setBackgroundResource(R.drawable.blank);
		m.setBackgroundResource(R.drawable.blank);
		t.setBackgroundResource(R.drawable.blank);
		disp.setText("");
		d2.setText("");
		d3.setText(" ");	
	
	}
	
	
	
	
	@Override
	    public void onResume() {
	        super.onResume();
	        // Add the following line to register the Session Manager Listener onResume
	        mSensorManager.registerListener(mShakeDetector, mAccelerometer,    SensorManager.SENSOR_DELAY_UI);
	    }
	 
	    @Override
	    public void onPause() {
	        // Add the following line to unregister the Sensor Manager onPause
	        mSensorManager.unregisterListener(mShakeDetector);
	        super.onPause();
	      
	    } 
	
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

public boolean onOptionsItemSelected(MenuItem item) {
	
	

if(	item.getItemId()==R.id.as)
{

	Intent k=new Intent(rcc.this,about.class);
		
		startActivity(k);
}



else if(item.getItemId()==R.id.t1)
{
	
	if((qux%2)!=0)
	{
		camera=Camera.open();
		Parameters p=camera.getParameters();
		p.setFlashMode(Parameters.FLASH_MODE_TORCH);
		camera.setParameters(p);
		camera.startPreview();
		item.setTitle("LED OFF" );
		
	
	}
	
	else
	{
		camera.stopPreview();
		camera.release();
		item.setTitle("LED ON" );
	}
	qux++;	

}

return true ;

}
}
