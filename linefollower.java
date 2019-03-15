

import lejos.hardware.BrickFinder;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.lcd.GraphicsLCD;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import lejos.robotics.Color;

public class LineFollwer  {
static UnregulatedMotor motor1 = new UnregulatedMotor(MotorPort.A);
static UnregulatedMotor motor2 = new UnregulatedMotor(MotorPort.B);
static void Move(){
motor1.setPower(30);
         motor2.setPower(15);
}
static void stop() {
motor1.setPower(0);
         motor2.setPower(0);
}
public static void main(String[] args) 
{ 
ColorSensor colorSensor = new ColorSensor(SensorPort.S3);
colorSensor.setRedMode();
colorSensor.setColorIdMode();
colorSensor.setFloodLight(Color.BLUE);
colorSensor.setFloodLight(false);
Sound.beep();
GraphicsLCD g = BrickFinder.getDefault().getGraphicsLCD();
final int SW = g.getWidth();
final int Height = g.getHeight();
g.drawString("Press A Button", SW/2,  Height/2, GraphicsLCD.BASELINE|GraphicsLCD.HCENTER);
Button.waitForAnyPress();
Delay.msDelay(1000);
g.clear();
//variables
String nameOfColor; //color  of the surface to be followed
int color;// color number value
color = colorSensor.getColorID();//gets the color being found through the color sensor
String colorFollow;
colorFollow = ColorSensor.colorName(color);
nameOfColor = colorFollow;

do {
color = colorSensor.getColorID();
colorFollow=ColorSensor.colorName(color);
if(nameOfColor.equals(colorFollow)) {
Move();
}else {
motor1.setPower(10);
motor1.forward();
motor2.forward();
//motor1.setPower(15);
           // motor2.setPower(30);
            if(nameOfColor.equals(colorFollow)) {
            //stop();
            //Delay.msDelay(1000);
Move();
}
}
 
}while(!Button.ESCAPE.isDown());
colorSensor.close();
}
}


