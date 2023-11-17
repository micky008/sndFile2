package com.msc.testjna;

import com.sun.jna.Library;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.LongByReference;
import com.sun.jna.ptr.ShortByReference;

/**
 *
 * @author micky
 */
public interface MPEG123 extends Library {


    public static final int MPG123_DONE = -12;
    public static final int MPG123_NEW_FORMAT = -11;
    public static final int MPG123_NEED_MORE = -10;
    public static final int MPG123_ERR = -1;
    
    
    public enum Errors {
	
	MPG123_OK, /**
	 * < Success
	 */
	MPG123_BAD_OUTFORMAT, /**
	 * < Unable to set up output format!
	 */
	MPG123_BAD_CHANNEL, /**
	 * < Invalid channel number specified.
	 */
	MPG123_BAD_RATE, /**
	 * < Invalid sample rate specified.
	 */
	MPG123_ERR_16TO8TABLE, /**
	 * < Unable to allocate memory for 16 to 8 converter table!
	 */
	MPG123_BAD_PARAM, /**
	 * < Bad parameter id!
	 */
	MPG123_BAD_BUFFER, /**
	 * < Bad buffer given -- invalid pointer or too small size.
	 */
	MPG123_OUT_OF_MEM, /**
	 * < Out of memory -- some malloc() failed.
	 */
	MPG123_NOT_INITIALIZED, /**
	 * < You didn't initialize the library!
	 */
	MPG123_BAD_DECODER, /**
	 * < Invalid decoder choice.
	 */
	MPG123_BAD_HANDLE, /**
	 * < Invalid mpg123 handle.
	 */
	MPG123_NO_BUFFERS, /**
	 * < Unable to initialize frame buffers (out of memory?).
	 */
	MPG123_BAD_RVA, /**
	 * < Invalid RVA mode.
	 */
	MPG123_NO_GAPLESS, /**
	 * < This build doesn't support gapless decoding.
	 */
	MPG123_NO_SPACE, /**
	 * < Not enough buffer space.
	 */
	MPG123_BAD_TYPES, /**
	 * < Incompatible numeric data types.
	 */
	MPG123_BAD_BAND, /**
	 * < Bad equalizer band.
	 */
	MPG123_ERR_NULL, /**
	 * < Null pointer given where valid storage address needed.
	 */
	MPG123_ERR_READER, /**
	 * < Error reading the stream.
	 */
	MPG123_NO_SEEK_FROM_END,/**
	 * < Cannot seek from end (end is not known).
	 */
	MPG123_BAD_WHENCE, /**
	 * < Invalid 'whence' for seek function.
	 */
	MPG123_NO_TIMEOUT, /**
	 * < Build does not support stream timeouts.
	 */
	MPG123_BAD_FILE, /**
	 * < File access error.
	 */
	MPG123_NO_SEEK, /**
	 * < Seek not supported by stream.
	 */
	MPG123_NO_READER, /**
	 * < No stream opened or no reader callback setup.
	 */
	MPG123_BAD_PARS, /**
	 * < Bad parameter handle.
	 */
	MPG123_BAD_INDEX_PAR, /**
	 * < Bad parameters to mpg123_index() and mpg123_set_index()
	 */
	MPG123_OUT_OF_SYNC, /**
	 * < Lost track in bytestream and did not try to resync.
	 */
	MPG123_RESYNC_FAIL, /**
	 * < Resync failed to find valid MPEG data.
	 */
	MPG123_NO_8BIT, /**
	 * < No 8bit encoding possible.
	 */
	MPG123_BAD_ALIGN, /**
	 * < Stack aligmnent error
	 */
	MPG123_NULL_BUFFER, /**
	 * < NULL input buffer with non-zero size...
	 */
	MPG123_NO_RELSEEK, /**
	 * < Relative seek not possible (screwed up file offset)
	 */
	MPG123_NULL_POINTER, /**
	 * < You gave a null pointer somewhere where you shouldn't have.
	 */
	MPG123_BAD_KEY, /**
	 * < Bad key value given.
	 */
	MPG123_NO_INDEX, /**
	 * < No frame index in this build.
	 */
	MPG123_INDEX_FAIL, /**
	 * < Something with frame index went wrong.
	 */
	MPG123_BAD_DECODER_SETUP, /**
	 * < Something prevents a proper decoder setup
	 */
	MPG123_MISSING_FEATURE /**
	 * < This feature has not been built into libmpg123.
	 */
	, MPG123_BAD_VALUE /**
	 * < A bad value has been given, somewhere.
	 */
	, MPG123_LSEEK_FAILED /**
	 * < Low-level seek failed.
	 */
	, MPG123_BAD_CUSTOM_IO /**
	 * < Custom I/O not prepared.
	 */
	, MPG123_LFS_OVERFLOW /**
	 * < Offset value overflow during translation of large file API calls --
	 * your client program cannot handle that large file.
	 */
	, MPG123_INT_OVERFLOW /**
	 * < Some integer overflow.
	 */
	, MPG123_BAD_FLOAT;
	/**
	 * < Floating-point computations work not as expected.
	 */
    };

    int mpg123_init();

    Pointer mpg123_new(String nullable, IntByReference error);

    String mpg123_plain_strerror(int noerror);

    int mpg123_open(Pointer mp123_handle, String fillePathname);

    int mpg123_getformat(Pointer mp123_handle, LongByReference rate, IntByReference channels, IntByReference encodage);

    int mpg123_outblock(Pointer handle);

    int mpg123_scan(Pointer handle);

    long mpg123_length(Pointer handle);

    int mpg123_read(Pointer handle, ShortByReference minibuf, int buffer_size, LongByReference sampleCount);

    void mpg123_seek(Pointer handle, int offset, int seekSet);

    int mpg123_framebyframe_next(Pointer handle);

    int mpg123_framedata(Pointer handle, IntByReference header, IntByReference bodydata, IntByReference bodybytes);

    int mpg123_spf(Pointer handle);

    void mpg123_free(Pointer p);

    void mpg123_delete(Pointer p);

    void mpg123_exit();
}
