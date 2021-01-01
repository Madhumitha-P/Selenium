
public class Simple {
	public String compute(String input){
		String a, b;
		int count = 1;
		String final_val = "";
		String[] inputArray = new String[]{input};
		for(int i=0;i<inputArray.length;i++){
	        a = inputArray[i];
	        b = inputArray[i+1];
	        if(a == b)
	            count = count + 1;
	        if(a != b)
	        	final_val +=  a + String.valueOf(count);
	            count = 1;
	     final_val = final_val + a + String.valueOf(count);
	     }
		return final_val;
	}
	
	public void main(String args[]){
		String final_val = compute("aabbbjcccaaad");
		System.out.println(final_val);
	}
}

