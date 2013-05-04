package Final;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;

public class HandleData {
	DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("./archives/Final/CIS249Final.dat")));
	SimpleDateFormat timestamp = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");

	public HandleData() throws IOException {
		try {
			output.writeChars(timestamp.toString());
		} catch (IOException ex){
			System.out.println(ex);
		}
	}
	
	public void writeData(String bet) throws IOException{
		try{
			String combinedOutput = (String)(timestamp + "\t" + output);
			System.out.println(combinedOutput);
			output.writeChars(combinedOutput);
		} catch (IOException ex){
			System.out.println(ex);
		}
	}

}
