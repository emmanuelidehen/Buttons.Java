/*


Program:  This programs uses sensors to help operate the robot
when the robot is turned on it should make a sound 
and also display hello after first touch the robot should 
display a 3 sec count down and display moving forward
and then procced to move forward. on second touch the robot
will display stopping and should stop reseting the touch 
sequence. ultrasonic sensor will be used helping the robot notice
objects that are 12 inches away and will display path is blocked
 


***Design (Pseudo/Algorithm)***

Define/Identify the variables that I'm going to be using in the program.
Prompt the user to provide two numbers
Store those numbers in the associated variables
Assign the mathematical variable their values based on the correct operation.
Output each operation with the labels

*******************************

*/
import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.Motor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;


public class sensors {

 
private EV3TouchSensor touch;
 
public static void main(String[] args) {
 
//EV3UltrasonicSensor us1 = new EV3UltrasonicSensor(SensorPort.S1);
 
//Sound Sensor
Sound.beep();
GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
final int SW = g.getWidth();
final int SH = g.getHeight();
g.drawString("Hello!", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(4000);
g.clear();
 
//Touch Sensor
//First touch
 
g.drawString("3", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("2", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("1", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("Moving Forward", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
 
Motor.C.forward();
Motor.B.forward();
Sound.beepSequence();
 
//Second touch
Button.waitForAnyPress();
g.drawString("3", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("2", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("1", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(2000);
g.clear();
 
g.drawString("Stopping", SW/2, SH/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
 
Motor.B.stop();
Motor.C.stop();
  
//Ultrasonic Sensor
 
 
System.out.println("Path blocked!");
 
//Light Sensor
 
 
}

public void getRangeReading()
{
 
}
public EV3TouchSensor getTouch() {
return touch;
}

public void setTouch(EV3TouchSensor touch) {
this.touch = touch;
}
}