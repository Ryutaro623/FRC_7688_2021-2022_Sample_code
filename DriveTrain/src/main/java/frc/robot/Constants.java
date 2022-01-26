// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants { 
    /* speed,-1 to 1;
       sen, 0to 1;
       highest_output,0-1;
    */

    /*Drive Train*/
    public static final int LEFT_FRONT_TOP_MOTOR = 5;
    public static final int LEFT_FRONT_BOTTOM_MOTOR = 10;
    public static final int LEFT_BACK_TOP_MOTOR = 13;
    public static final int LEFT_BACK_BOTTOM_MOTOR = 8;

    public static final int RIGHT_FRONT_TOP_MOTOR = 1;
    public static final int RIGHT_FRONT_BOTTOM_MOTOR = 11;
    public static final int RIGHT_BACK_TOP_MOTOR = 12;
    public static final int RIGHT_BACK_BOTTOM_MOTOR = 4;

    /*Encoder*/
    public static final int[] LEFT_ENCODER= new int[]{0,1};
    public static final int[] RIGHT_ENCODER = new int[]{2,3};

    public static final double WHEELDIAMETERCM = 15.24*Math.PI;
    public static final double DISTENCEPERPULS = WHEELDIAMETERCM/2056;


    public static final double SENSITYVITY(double speed,double sen,double highest_output){
        if(sen > highest_output){
            sen = highest_output;
        }
        double motor_output = Math.pow(speed, 3)*sen+(highest_output-sen)*speed;
        return motor_output;

    }
}
