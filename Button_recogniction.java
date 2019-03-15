/*
 
 Emmanuel Idehen
 04/03/2018
 
 Program:
 •    Up Button
 o    The robot should move forward for 5 seconds
 o    Also, the robot’s display should show a counter from 1 to 5 for each second going forward.
 •    Down Button
 o    The robot should move backwards and beeps for 5 seconds
 o    Also, the robot’s display should show a counter from 1 to 5 for each second going backward.
 •    Left Button
 o    The robot should turn left 90 degrees
 o    Also, the robot should say “Left” before it starts turning
 •    Right Button
 o    The robot should turn right 90 degrees
 o    Also, the robot should say “Right” before it starts turning

 *******************************
 Algorithm:
 
 •    Up Button
 o    move forward for 5 seconds
 o    show a counter from 1 to 5 for each second going forward.
 •    Down Button
 o    move backwards and beeps for 5 seconds
 o    show a counter from 1 to 5 for each second going backward.
 •    Left Button
 o    turn left 90 degrees
 o    say “Left” before it starts turning
 •    Right Button
 o    turn right 90 degrees
 o    say “Right” before it starts turning

 */
package com.domain;
import lejos.nxt.Button;
import lejos.nxt.*;
package ev3.exercises.driveRegulated;
import lejos.hardware.Button;
import lejos.hardware.Sound;
import lejos.hardware.motor.*;
import lejos.hardware.port.*;
import lejos.utility.Delay;
import ev3.projects.library.*;

public class buttons
{

	public static void main(String[] args)
    {
		int x=0;
        //loop while true
		while(true)	
		{   //while button is pressed, call function
			Button.waitForAnyPress();
            //move forward while up pressed
			if(Button.UP.isDown())
			{
                 System.out.println("Right");
                 tts.say("Right");
                 rightMotor.setPower(rightPower);
                
				 motorA.forward(5000);
                 motorB.forward(5000);
                // show counter for moving
				
			}
			//decrement when left button is pressed
			if(Button.LEFT.isDown())
			{
				// say left turn
                 System.out.println("Left");
                 tts.say("Left");
                 leftMotor.setPower(leftPower);
                
				 motorB.rotateTo(-90, true);
                 motorB.rotateTo()
			}
		
			if(Button.RIGHT.isDown())
			{
                // move forward and
                motorA.rotateTo(90, true);
                argss = 4;
                
                int count = 0;
                
                for(int i = 0; i < argss; i++)
                {
                    System.out.println(argss[i]);
                    count++;
                   
                }
			}
           
			if(Button.ESCAPE.isDown())
			{
                //move back ward
                motorA.backward();
                argss = 4;
                
                int count = 0;
                
                for(int i = 0; i < argss; i++)
                {
                    System.out.println(argss[i]);
                    count++;
                    
                }
				
            }
        }

    }
	
}

 
