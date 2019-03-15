import lejos.hardware.*;
import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.port.SensorPort;
import lejos.robotics.LightDetector;
import lejos.robotics.LightDetectorAdaptor;
import lejos.robotics.SampleProvider;

import java.util.*;

public class ColorSensor {
public void forward() //forward function to move robot
{
Motor.C.forward();
Motor.B.forward();
}
public void stop() //stop function
{
Motor.C.stop();
Motor.B.stop();
}
 
public void spin(int x) throws InterruptedException
{
Motor.B.forward(); 
Thread.sleep(x * 1900);
}

public void run() throws InterruptedException {
LightDetector light = (LightDetector) new LightDetectorAdaptor((SampleProvider) SensorPort.S4);      //create light sensor object
 
ArrayList<String> array = new ArrayList<String>();    //dynamic array of type string
int b;
do{
LCD.drawString("Press any up Key", 0, 0); 
b=Button.waitForAnyPress();
 
 
if(b!=Button.ID_ESCAPE)    // while the escape button is not pressed, do the following
{
LCD.clear();
if((light.getLightValue()>=30 && light.getLightValue()<=35))   //if light sensor senses black,perform an action and add "black" to array
{
LCD.drawString("Black", 0, 0);
Thread.sleep(2000);
LCD.clear();
LCD.drawString("I am black and ", 0, 0);
LCD.drawString("proud!!!", 0, 2);
Thread.sleep(3000);
array.add("Black");
}
else if((light.getLightValue()> 35 && light.getLightValue()<=40)) //if light sensor senses blue,perform an action and add "blue" to array

{
LCD.drawString("Blue", 0, 0);
spin(2);
array.add("Blue");
}
else if((light.getLightValue()>40 && light.getLightValue()<=50))  //if light sensor senses green,perform an action and add "green" to array

{
LCD.drawString("Green", 0, 0);
Thread.sleep(3000);
LCD.clear();
LCD.drawString("G0!!", 0, 0);
forward();
Thread.sleep(5000);
array.add("Green");
}
else if(light.getLightValue()>50)   //if light sensor senses red,perform an action and add "red" to array

{
LCD.drawString("Red", 0, 0);
Sound.playTone(50, 4000);;
Thread.sleep(5000);
array.add("Red");
}
}
stop();
LCD.clear();
}while(b!=Button.ID_ESCAPE);
 
System.out.println(array);
Button.waitForAnyPress();
}

}