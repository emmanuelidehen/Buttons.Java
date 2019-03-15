/*
 Emmanuel Idehen
 3/29/2018
 
 Program Discription : Using the buttons on the EV3 brick, write program that "only" outputs the screen the name of the button when pressed!
 
 Agorithm: while button pressed is true
 - if enter, prints enter button
 - if left, prints left button
 - if rigth, prints right button
 - if escape, prints escape button
 
 */





//import required APIS and 
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.*;
import lejos.hardware.BrickFinder;

import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.port.*;
import lejos.utility.Delay;

public class AllSensors {
//function to move robot
static void Move(){
Motor.A.forward();
Motor.B.forward();
}
//function to stop the robot
static void Stop(){
Motor.A.stop();
Motor.B.stop();
}
public static void main(String[] args) 
{ 
//for use of graphics
GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
final int SW = g.getWidth();
final int Height = g.getHeight();
//instantiation of Sensor classes 
TouchSensor touchSensor = new TouchSensor(SensorPort.S1);
ColorSensor colorSensor = new ColorSensor(SensorPort.S3);
colorSensor.setColorIdMode();
colorSensor.setFloodLight(false);
UltraSonicSensor uss = new UltraSonicSensor(SensorPort.S4);
//variables declaration
int color;
Sound.beep();
float  range;
int count =0;
do {
String nameOfColor;
color = colorSensor.getColorID();//gets color integer value
range = uss.getRange();//gets distance
//variables
int Number=3;
String countDown;
nameOfColor=ColorSensor.colorName(color);//gets the name of the color
//checks to see if touch sensor is activated
if(touchSensor.isTouched())
{ count++;
if(count==1) {
for(int i=0; i<3; i++) 
{ g.clear();
//increases
Delay.msDelay(500);
countDown=  Integer.toString(Number);
//outputs countdown
g.drawString(countDown, SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
Number--;//decrements the number
g.clear();
}
g.drawString("Moving Forward", SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Move();//makes the robot move
}
if(count==2){
for(int i=0; i<3; i++) 
{ g.clear();
countDown=  Integer.toString(Number);
//outputs countdown
g.drawString(countDown, SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
Number--;//decrements the number
}
g.clear();
g.drawString("Stopping", SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Stop();//stops the motors/robot
Delay.msDelay(500);
count=0;//resets count
}
}
if(nameOfColor.equals("Yellow")){//checks to see if it is color blue and outputs it
Sound.beepSequence();//makes unique sound
g.drawString(ColorSensor.colorName(color), SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
g.clear();
}
if(nameOfColor.equals("Red")){//checks to see if it is color red and outputs it
Sound.beepSequenceUp();//makes unique sound
g.drawString(ColorSensor.colorName(color), SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
g.clear();
}
if(nameOfColor.equals("Green")){//checks to see if it is color green and outputs it
Sound.buzz();//makes unique sound
g.drawString(ColorSensor.colorName(color), SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
g.clear();
}
if (range < .305)// checks to see if there is an obstacle within 12 inches 
{ Stop();
g.drawString("PATH BLOCKED", SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Delay.msDelay(500);
g.clear();
}
//keeps the robot moving if no object is within 12 inches
if((count==1) && (range >.305)){ 
Move();
} 
g.clear();//clears screen
}while(!Button.ESCAPE.isDown());//ends the program
//closes sensors
touchSensor.close();
uss.close();
}
}