import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

public class Tree {

	private ArrayList<String> list;
	
	public Tree (ArrayList<String> nlist) {
		list = nlist;
	}
	
	public void initialize() throws IOException, NoSuchAlgorithmException {
		
		String out = "" + list.get(0);
		
		for (int i = 1; i < list.size(); i++) {
			out = out + "\n" + list.get(i);
		}
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(out.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File f = new File("Test/objects/" + hashtext);
		FileWriter fw = new FileWriter("./Test/objects/"+ hashtext);
		PrintWriter pw = new PrintWriter (fw);
		pw.write(out);
		if(pw != null) {
			pw.flush();
			pw.close();
		}
	}
	
}
