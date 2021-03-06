package us.youfailed.util;

import android.util.Log;

public class CommPacket {
		private static final String TAG = "commpacket";
		public float speed;
    	public float steer;
    	public boolean lights;
    	public boolean misc1;
    	public boolean misc2;
    	
    	private static final String sep = ":"; 
    	
    	private String toChar(boolean bit)  {
    		return bit ? "1" : "0";
    	}

    	private String toChar(float normVal) {
    		//if(normVal <= 0.01f ) return "0:0";
    		
    		//convert normVal to -9<= x <= 9
    		float val = ((normVal - 0.5f) * 2f) * 9f;
    		float absVal = Math.abs(val);
    		absVal = Math.round(absVal);
    		String bit = toChar(val > 0f);
    		if(absVal>9f)  {
    			Log.wtf(TAG, "absval should be 0-9, was:" + absVal);
    			absVal = 9f;
    		}
    		String chr = Integer.toString((int)absVal);
    		return bit + ":" + chr;
    	}
    	
    	public String packetString() {
    		StringBuilder sb = new StringBuilder("s" + sep);
    		sb.append(toChar(speed)).append(sep);
    		sb.append(toChar(steer)).append(sep);
    		sb.append(toChar(lights)).append(sep);
    		sb.append(toChar(misc1)).append(sep);
    		sb.append(toChar(misc2));
    		return sb.toString();
    	}

    	
}
