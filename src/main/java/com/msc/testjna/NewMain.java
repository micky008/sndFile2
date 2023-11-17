package com.msc.testjna;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;

/**
 *
 * @author micky
 */
public class NewMain {

    private void go(String[] args) {

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
	System.out.println("debut");
	MPEG123 mpg123 = (MPEG123) Native.loadLibrary("J:\\NetbeansProjects\\testJNA\\libmpg123-0.dll", MPEG123.class);
	mpg123.mpg123_init();
	IntByReference err = new IntByReference();
	LongByReference rate = new LongByReference();
	IntByReference channels = new IntByReference();
	IntByReference enc = new IntByReference();
	Pointer m = mpg123.mpg123_new(null, err);
	mpg123.mpg123_open(m, "C:\\Users\\micky\\Music\\01.mp3");
	mpg123.mpg123_getformat(m, rate, channels, enc);
	System.out.println("rate=" + rate.getValue());
	System.out.println("channels=" + channels.getValue());
	System.out.println("enc=" + enc.getValue());
	mpg123.mpg123_scan(m);
	long nsc2 = mpg123.mpg123_length(m);
	System.out.println("nb de Sample " + nsc2);
	System.out.println("temps (en sec) " + (nsc2 / rate.getValue()));
	
	mpg123.mpg123_delete(m);
	mpg123.mpg123_exit();
	System.out.println("fin");
    }

}
