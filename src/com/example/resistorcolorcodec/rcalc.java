package com.example.resistorcolorcodec;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.resistorcolorcodec.ShakeDetector.OnShakeListener;


public class rcalc extends Activity {

TextView tv;    
EditText e1;
Spinner s,s2;
CheckBox cb;	
Button ohm,kohm,mohm,c1,c2,c3,t,calc;
long flag;
double x,y,temp,cb1,cb2,cb3,foo;
int flag1;
String o;
boolean torch_engaged;
int qux=1;
double a[]={ 1.0,1.1,1.2,1.3,1.5,1.6,1.8,2.0,2.2,2.4,2.7,3.0,3.3,3.6,3.9,4.3,4.7,5.1,5.6,6.2,6.8,7.5,8.2,9.1,
			10,11,12,13,15,16,18,20,22,24,27,30,33,36,39,43,47,51,56,62,68,75,82,91,
			100,110,120,130,150,160,180,200,220,240,270,300,330,360,390,430,470,510,560,620,680,750,820,910};	
	    

//sensor declarator	
		private SensorManager mSensorManager;
	    private Sensor mAccelerometer;
	    private ShakeDetector mShakeDetector;
	      private Camera camera;
	     
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rcalc);
        tv=(TextView) findViewById(R.id.textView2);
        s = (Spinner) findViewById(R.id.spinner1);
        s2=(Spinner) findViewById(R.id.spinner2);
        cb=(CheckBox) findViewById(R.id.checkBox1);   
        e1=(EditText) findViewById(R.id.editText1);
        c1=(Button) findViewById(R.id.button4);
        c2=(Button) findViewById(R.id.button5);
        c3=(Button) findViewById(R.id.button6);
        calc=(Button) findViewById(R.id.button7);
        t=(Button) findViewById(R.id.button8);
    
        //code for spinner1
    
    List list = new ArrayList();
    list.add("±5%");
    list.add("±10%");
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list);
	dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	s.setAdapter(dataAdapter);
	
	//code for spinner2
	 	List list1 = new ArrayList();
	    list1.add("Ω");
	    list1.add("KΩ");
	    list1.add("MΩ");
	    ArrayAdapter<String> dataAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,list1);
		dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		s2.setAdapter(dataAdapter1);
	
	
	
    
 // ShakeDetector initialisation
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
     	 String v="";
     	 e1.setText(v);
     	c1.setBackgroundResource(R.drawable.blank); 
   	 c2.setBackgroundResource(R.drawable.blank);
   	 c3.setBackgroundResource(R.drawable.blank);
   	 t.setBackgroundResource(R.drawable.blank);
        }
    });
    //end sensors
    
    
    //chkbx code
    
    cb.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
		if(((CheckBox)v).isChecked())
		{
		flag1=1;	
		}
		else
		{
			flag1=0;
		}
		
		}
		});
	
    //end chkbx code
    
    
    
    
    calc.setOnClickListener(new View.OnClickListener() {
		
    	
		@Override
		public void onClick(View arg0) {
			
			// TODO Auto-generated method stub
			   tv.setText("");
			String z=String.valueOf(s.getSelectedItem());
			
			if(z=="±5%")
			    {
			    t.setBackgroundResource(R.drawable.gold);
			    }
			    else if (z=="±10%")    
			    {
			    t.setBackgroundResource(R.drawable.silver);
			    }
				 
String z2=String.valueOf(s2.getSelectedItem());
			

			if(z2=="Ω")
			{
				flag=1;
				o="Ω";
			}
			else if(z2=="KΩ")
			{
				o="KΩ";
				flag=1000;
			}
			else if (z2=="MΩ")
			{
				o="MΩ";
				flag=1000000;
			}
			
		
			//take i/p 
			 try   {
			        x = Double.parseDouble(e1.getText().toString());
			       }
			       catch(Exception e)
			       {
			    	   
			       }
				foo=x;
					 
			 //i/p op finished
	//special case
	if(x>910&&x<=1000)
	 {
	 c1.setBackgroundResource(R.drawable.brown); 
	 c2.setBackgroundResource(R.drawable.black);
	 c3.setBackgroundResource(R.drawable.red);
	 }
	 else if(x>1000)
	 {
		 nonstd();
	 }
			 //
	
	
				if(x>91)
			{
				 cb3=flag*10;
				 y=x/10;
				 cb2= y%10;
				 temp= y-cb2;			
				 cb1=temp/10;
		  
		   if(     cb1==0&&cb2==1||
			       cb1==0&&cb2==2||
  			       cb1==0&&cb2==3||
				   cb1==1&&cb2==0||
				   cb1==1&&cb2==1||
				   cb1==1&&cb2==2||
				   cb1==1&&cb2==3||
				   cb1==1&&cb2==5||
				   cb1==1&&cb2==6||
				   cb1==1&&cb2==8||
				   cb1==2&&cb2==0||
				   cb1==2&&cb2==2||
				   cb1==2&&cb2==4||
				   cb1==2&&cb2==7||
				   cb1==3&&cb2==0||
				   cb1==3&&cb2==3||
				   cb1==3&&cb2==6||
				   cb1==3&&cb2==9||
				   cb1==4&&cb2==3||
				   cb1==4&&cb2==7||
				   cb1==5&&cb2==1||
				   cb1==5&&cb2==6||
				   cb1==6&&cb2==2||
				   cb1==6&&cb2==8||
				   cb1==7&&cb2==5||
				   cb1==8&&cb2==2||
				   cb1==9&&cb2==1
				   )
		   
		   {
		   
		   func(cb1,c1);
		 
		   func(cb2,c2);
			 
		   
		   }
		   else 
		   {
			if(flag1==0)
			{
				nonstd();
			}
			else if(flag1==1)
				
			{

				 for(int ik=0;ik<=a.length;ik++)
				 {
					 if(a[ik]>x)
					 {
						 x=a[ik];
						break; 
					 }
				 }
			
				 cb3=flag*10;
				 y=x/10;
				 cb2= y%10;
				 temp= y-cb2;			
				 cb1=temp/10;
				 tv.setText("Closest std value:"+x+o);
			   
				   func(cb1,c1);
				   func(cb2,c2);
				
			}
		   
		   }
		   }
		

			 
			 
			 
	
		else if (x<=91)
		{
	
			cb3=flag;
			
			if (x!=Math.round(x))
	   {
	  x=x*10;	
	  cb3=flag/10;
	   }
	
			cb2= x%10;
			temp= x-cb2;			
			cb1=temp/10;

  if (    cb1==0&&cb2==1||
		  cb1==0&&cb2==2||
		  cb1==0&&cb2==3||
		  cb1==1&&cb2==0||
		   cb1==1&&cb2==1||
		   cb1==1&&cb2==2||
		   cb1==1&&cb2==3||
		   cb1==1&&cb2==5||
		   cb1==1&&cb2==6||
		   cb1==1&&cb2==8||
		   cb1==2&&cb2==0||
		   cb1==2&&cb2==2||
		   cb1==2&&cb2==4||
		   cb1==2&&cb2==7||
		   cb1==3&&cb2==0||
		   cb1==3&&cb2==3||
		   cb1==3&&cb2==6||
		   cb1==3&&cb2==9||
		   cb1==4&&cb2==3||
		   cb1==4&&cb2==7||
		   cb1==5&&cb2==1||
		   cb1==5&&cb2==6||
		   cb1==6&&cb2==2||
		   cb1==6&&cb2==8||
		   cb1==7&&cb2==5||
		   cb1==8&&cb2==2||
		   cb1==9&&cb2==1
		   )
  
  
  
  
  {
	  if(x==1||x==2||x==3)
	  {
	  beegbug1(x);
	  }
	  else
	  {
	  func(cb1,c1);
	  func(cb2,c2);
	  }	  

  }
  else
  {
	  if(flag1==0)
		{
		  nonstd();
		}
		else if(flag1==1)
			
		{
			 
			double oof = 0;	
			for(int ik=0;ik<=a.length;ik++)
			 {
				 if(a[ik]>foo)
				 {
					 oof=a[ik];
					break; 
				 }
			 }
			  tv.setText("Closest std value:"+oof+o);
			  
		 cb3=flag;
		
     	 if (oof!=Math.round(oof))
		   {
     		oof=oof*10;	
     		cb3=flag/10;
		   }
     	 	cb2= oof%10;
     	 	temp= oof-cb2;			
     	 	cb1=temp/10;
				  
     	 	if(oof==1||oof==2||oof==3)
     		  {
     		  beegbug1(oof);
     		  }
     	 	else
     	 	{
     	 	func(cb1,c1);
     	 	func(cb2,c2);
     	 	}
		}
			  
		}
  }
  
 
		

		
		//code for multiplier
		
		
		if(cb3<1)
		  {
			   c3.setBackgroundResource(R.drawable.gold);
		  }  
		else if(cb3==1)
		  {
			   c3.setBackgroundResource(R.drawable.black);
		  }
		  else if(cb3==10)
		  {
			   c3.setBackgroundResource(R.drawable.brown);
		  }
		  else if(cb3==100)
		  {
			   c3.setBackgroundResource(R.drawable.red);
		  }
		  else if(cb3==1000)
		  {
			   c3.setBackgroundResource(R.drawable.orange);
		  }
		  else if(cb3==10000)
		  {
			   c3.setBackgroundResource(R.drawable.yellow);
		  }
		  else if(cb3==100000)
		  {
			   c3.setBackgroundResource(R.drawable.green);
		  }
		  else if(cb3==1000000)
		  {
			   c3.setBackgroundResource(R.drawable.blue);
		  }
		  else if(cb3==10000000)
		  {
			   c3.setBackgroundResource(R.drawable.violet);
		  }
		  else if(cb3==100000000)
		  {
			   c3.setBackgroundResource(R.drawable.grey);
		  }
		  else if(cb3==1000000000)
		  {
			   c3.setBackgroundResource(R.drawable.white);
		  }
		
		  else if(cb3==221)
		  {
			   c3.setBackgroundResource(R.drawable.blank);
			   c2.setBackgroundResource(R.drawable.blank);
			   c1.setBackgroundResource(R.drawable.blank);
				  
		  }
		
		}
	});


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
	    
	    
	    //nonstd defn
	public void nonstd()
	{
		Context context = getApplicationContext();
   		CharSequence text="Enter standard value ";
   		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, text, duration);
		toast.show();
		cb3=221;
		t.setBackgroundResource(R.drawable.blank);
	}
	//func defn
	public void func(double z,Button b)
	{
		 if(z==0)
		   {
			   b.setBackgroundResource(R.drawable.black);
		   }
		   else if(z==1)
		   {
			   b.setBackgroundResource(R.drawable.brown);
		   }
		   else if(z==2)
		   {
			   b.setBackgroundResource(R.drawable.red);
		   }
		   else if(z==3)
		   {
			   b.setBackgroundResource(R.drawable.orange);
		   }
		   else if(z==4)
		   {
			   b.setBackgroundResource(R.drawable.yellow);
		   }
		   else if(z==5)
		   {
			   b.setBackgroundResource(R.drawable.green);
		   }
		   else if(z==6)
		   {
			   b.setBackgroundResource(R.drawable.blue);
		   }
		   else if(z==7)
		   {
			   b.setBackgroundResource(R.drawable.violet);
		   }
		   else if(z==8)
		   {
			   b.setBackgroundResource(R.drawable.grey);
		   }
		   else if(z==9)
		   {
			   b.setBackgroundResource(R.drawable.white);
		   }
		   	
	}
	
	
	public void beegbug1(double z)
	{
		if(z==1)
		{
			c1.setBackgroundResource(R.drawable.brown); 
		   	 c2.setBackgroundResource(R.drawable.black);
		   	cb3=flag/10;
		   	 
		}
		else if(z==2)
		{

			c1.setBackgroundResource(R.drawable.red); 
		   	 c2.setBackgroundResource(R.drawable.black);
		   	cb3=flag/10;
		}
		else if(z==3)
		{

			c1.setBackgroundResource(R.drawable.orange); 
		   	 c2.setBackgroundResource(R.drawable.black);
		   	cb3=flag/10;
		}
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

	Intent k=new Intent(rcalc.this,about.class);
		
		startActivity(k);
}



else if(item.getItemId()==R.id.t1)
{
	torch_engaged=true;
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
