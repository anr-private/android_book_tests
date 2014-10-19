package com.commonsware.android.lifecycle;

// Requires permission to write log file.
// Put this in AndroidManfest.xml (e.g., just before the <application ... tag.
//  <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import android.os.Environment;

/**
 * Created by art on 10/19/14.
 */
public class L {

    // For use by the using classes: usually like this:
    //	  if (L.D)L.d("...");
    // Usually set true for testing, false for production.
    //public static final boolean /*L*/OG = true;
    public static final boolean /*L*/V = true;
    public static final boolean /*L*/D = true;
    public static final boolean /*L*/I = true;
    public static final boolean /*L*/W = true;
    public static final boolean /*L*/E = true;

    // If True, month is '1'..'12'	else 'Jan'..'Dec'
    //public static boolean _monthIsNumber = true;

    // Set by setLogTag(), usually once at start of execution.
    // @@@ EDIT THIS when you add this class to your project @@@@@@@@@@@@@@@@@@@@@@@@@
    private static String _logtag = "LIFECYCLE";

    // If True, logs to a file in /mnt/sdcard/ (or /sdcard/)
    // // as well as to the android logcat log. Otherwise just to logcat log.
    // THIS STUFF IS USUALLY HARD-CODED - initialize() is never called
    private static boolean _logToFile = false;
    private static String _logFilename = "lifecycle.log";
    private static String _absPath = "";
    private static BufferedWriter _logf = null;

    // USUALLY STUFF IS HARDCODED SO no need to L.initialize()
    // Initialize this module
    // If this is not called, defaults are used.
    // This must be called if you want to enable logging
    // into a file.
/*
public static void initialize(String logtag,
                                String logFilename,
                                boolean month_is_number) {

    if (logtag != null && logtag.length() > 0) {
        _logtag = logtag;
    }
    if (logFilename != null && logFilename.length() > 0) {
        _logToFile = true;
        _logFilename = logFilename;
    }
    _monthIsNumber = month_is_number;
}
  */


    private static void _openLogFile() {

        if (_logf != null) return;

        File file = new File(Environment.getExternalStorageDirectory(),
                _logFilename);

        String absPath = file.getAbsolutePath();
        boolean exists = file.exists();

        try {
            FileWriter fw = new FileWriter(absPath, exists);

            BufferedWriter out = new BufferedWriter(fw);

            _absPath = absPath;
            _logf = out;

            android.util.Log.i(_logtag,
                    "LOGGER: LOGFILE=" + absPath);

        } catch (IOException ex) {
            android.util.Log.e(_logtag,
                    "LOGGER: ERROR OPENING LOGFILE=" + absPath,
                    ex);
        }
    }


    private static void _wlog(String level, String mesg) {

        if ( ! _logToFile) return;

        if (_logf == null) {
            _openLogFile();
        }

        if (_logf == null) {
            return;
        }

        try {
            Date d = new Date();

            // Java Date and Calendar are a mess
            @SuppressWarnings("deprecation")
            int year = d.getYear() + 1900;
            @SuppressWarnings("deprecation")
            int month = d.getMonth(); // 0..11 !!
            @SuppressWarnings("deprecation")
            int day = d.getDate(); // getDate?! gets day-of-month! 1..31

            _logf.write(Integer.toString(year));
            _logf.write("-");

            //if (_monthIsNumber) {
            month += 1; // 0..11 ==> 1..12
            if (month < 10) {
                _logf.write("0");
            }
            _logf.write(Integer.toString(month));

            // } else {
            // switch (month) {
            // case 0: _logf.write("Jan"); break;
            // case 1: _logf.write("Feb"); break;
            // case 2: _logf.write("Mar"); break;
            // case 3: _logf.write("Apr"); break;
            // case 4: _logf.write("May"); break;
            // case 5: _logf.write("Jun"); break;
            // case 6: _logf.write("Jul"); break;
            // case 7: _logf.write("Aug"); break;
            // case 8: _logf.write("Sep"); break;
            // case 9: _logf.write("Oct"); break;
            // case 10: _logf.write("Nov"); break;
            // case 11: _logf.write("Dec"); break;
            // default: _logf.write("???"); break;
            // }
            // }

            _logf.write("-");
            if (day < 10) {
                _logf.write("0");
            }
            _logf.write(Integer.toString(day));
            _logf.write("_");

            @SuppressWarnings("deprecation")
            int hour = d.getHours();   // 0..23
            @SuppressWarnings("deprecation")
            int min	= d.getMinutes(); // 0..59
            @SuppressWarnings("deprecation")
            int sec	= d.getSeconds(); // 0..61	 !!
            if (hour < 10) {
                _logf.write("0");
            }
            _logf.write(Integer.toString(hour));
            if (min < 10) {
                _logf.write("0");
            }
            _logf.write(Integer.toString(min));
            if (sec < 10) {
                _logf.write("0");
            }
            _logf.write(Integer.toString(sec));

            _logf.write(" ");

            _logf.write(level);

            if (mesg != null) {
                _logf.write(" ");
                _logf.write(mesg);
            }
            _logf.write("\n");
            _logf.flush();
        } catch (IOException ex) {
            android.util.Log.e(_logtag,
                    "LOGGER: ERROR WRITING LOGFILE=" + _absPath,
                    ex);
        }
    }


    public static String getLogTag() {
        return _logtag;
    }


    public static void v(String mesg) {
        android.util.Log.v(_logtag, mesg);
        _wlog("V", mesg);
    }

    public static void d(String mesg) {
        android.util.Log.d(_logtag, mesg);
        _wlog("D", mesg);
    }

    public static void i(String mesg) {
        android.util.Log.i(_logtag, mesg);
        _wlog("I", mesg);
    }

    public static void w(String mesg) {
        android.util.Log.w(_logtag, mesg);
        _wlog("W", mesg);
    }

    public static void e(String mesg) {
        android.util.Log.e(_logtag, mesg);
        _wlog("E", mesg);
    }
}

// ### end ###

