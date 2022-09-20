import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class RegularTester {

	public static void main (String[]args) throws IOException, NoSuchAlgorithmException {
		Index index = new Index();
		index.initialize();
		index.add("file1.txt");
	}
	
}
