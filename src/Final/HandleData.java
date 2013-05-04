package Final;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HandleData {
	DataOutputStream output = new DataOutputStream(new FileOutputStream(new File("./archives/Final/CIS249Final.dat"), true));
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
	

	public HandleData() throws IOException {
		try {
			output.writeChars(simpleDateFormat.format(new Date()));
		} catch (IOException ex){
			System.out.println(ex);
		}
	}
	
	public HandleData(String bet) throws IOException{
		try{
			String combinedOutput = simpleDateFormat.format(new Date()) + "\t" + bet + "\n";
			System.out.println(combinedOutput);
			output.writeChars(combinedOutput);
			output.close();
		} catch (IOException ex){
			System.out.println(ex);
		}
	}

}
