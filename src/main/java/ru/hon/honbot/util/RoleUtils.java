package ru.hon.honbot.util;

import ru.hon.honbot.enums.RoleGPM;
import ru.hon.honbot.enums.RoleKD;
import ru.hon.honbot.enums.RoleWIN;

/**
 * Created by Madolimov Evgeny.
 * Comment:
 */

public class RoleUtils {

    public static String getKD(double kd) {
        if (kd >= 0.5 && kd < 1.0) {
            return RoleKD.KD_0_5.value;
        } else if (kd >= 1.0 && kd < 1.5) {
            return RoleKD.KD_1_0.value;
        } else if (kd >= 1.5 && kd < 2.0) {
            return RoleKD.KD_1_5.value;
        } else if (kd >= 2.0 && kd < 2.5) {
            return RoleKD.KD_2_0.value;
        } else if (kd >= 2.5 && kd < 3.0) {
            return RoleKD.KD_2_5.value;
        } else if (kd >= 3.0 && kd < 3.5) {
            return RoleKD.KD_3_0.value;
        } else if (kd >= 3.5 && kd < 4.0) {
            return RoleKD.KD_3_5.value;
        } else if (kd >= 4.0 && kd < 4.5) {
            return RoleKD.KD_4_0.value;
        } else if (kd >= 4.5 && kd < 5.0) {
            return RoleKD.KD_4_5.value;
        } else if (kd >= 5.0) {
            return RoleKD.KD_5_0.value;
        } else {
            return "";
        }
    }

    public static String getWIN(long wins) {
        if (wins >= 10L & wins < 20L) {
            return RoleWIN.WIN10.value;
        } else if (wins >= 20L & wins < 30L) {
            return RoleWIN.WIN20.value;
        } else if (wins >= 30L & wins < 40L) {
            return RoleWIN.WIN30.value;
        } else if (wins >= 40L & wins < 50L) {
            return RoleWIN.WIN40.value;
        } else if (wins >= 50L & wins < 60L) {
            return RoleWIN.WIN50.value;
        } else if (wins >= 60L & wins < 70L) {
            return RoleWIN.WIN60.value;
        } else if (wins >= 70L & wins < 80L) {
            return RoleWIN.WIN70.value;
        } else if (wins >= 80L & wins < 90L) {
            return RoleWIN.WIN80.value;
        } else if (wins >= 90L & wins < 100L) {
            return RoleWIN.WIN90.value;
        } else if (wins == 100L) {
            return RoleWIN.WIN100.value;
        } else {
            return "";
        }
    }

    public static String getGPM(long gpm) {
        if (gpm >= 100L & gpm < 150L) {
            return RoleGPM.GPM100.value;
        } else if (gpm >= 150L & gpm < 200L) {
            return RoleGPM.GPM150.value;
        } else if (gpm >= 200L & gpm < 250L) {
            return RoleGPM.GPM200.value;
        } else if (gpm >= 250L & gpm < 300L) {
            return RoleGPM.GPM250.value;
        } else if (gpm >= 300L & gpm < 350L) {
            return RoleGPM.GPM300.value;
        } else if (gpm >= 350L & gpm < 400L) {
            return RoleGPM.GPM350.value;
        } else if (gpm >= 400L & gpm < 450L) {
            return RoleGPM.GPM400.value;
        } else if (gpm >= 450L & gpm < 500L) {
            return RoleGPM.GPM450.value;
        } else if (gpm >= 500L) {
            return RoleGPM.GPM500.value;
        } else {
            return "";
        }
    }
}
