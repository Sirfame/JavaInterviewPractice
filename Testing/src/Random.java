public class Random {
	static final String valid = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
	    for( int i = 0; i < length; i++ ) 
	    	sb.append( valid.charAt((int)(Math.random()*valid.length())));
	    return sb.toString();
	} // randomString (length); 
	
	public static int randomNumber(int start, int end) {
		if (start < end) {
			return ((int)(Math.random() * (end - start + 1) + start));
		} else {
			return ((int)(Math.random() * (start - end + 1) + end));
		}
	    // return ((int)(Math.random() * (end - start + 1) + start));
	} // randomNumber (start, end)
}