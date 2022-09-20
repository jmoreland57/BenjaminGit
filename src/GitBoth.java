import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


class GitBoth {
	
	private static Index index;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		Path p = Paths.get("./test/file1" + ".txt");
	    try {
	        Files.writeString(p, "text1", StandardCharsets.ISO_8859_1); //creates file
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		
	    p = Paths.get("./test/file2" + ".txt");
	    try {
	        Files.writeString(p, "text2", StandardCharsets.ISO_8859_1); //creates file
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    p = Paths.get("./test/file3" + ".txt");
	    try {
	        Files.writeString(p, "text3", StandardCharsets.ISO_8859_1); //creates file
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    p = Paths.get("./test/file4" + ".txt");
	    try {
	        Files.writeString(p, "text4", StandardCharsets.ISO_8859_1); //creates file
	    } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	    
	    Index nindex = new Index();
	    index = nindex;
		index.initialize();
		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		for (int i = 0; i < 5; i++) {
			File myObj = new File(".file" + i + ".txt"); //creates dummy file (overwriting existing file
			myObj.delete(); //deletes it
		}
		
		File f1 = new File("Test/index.txt");
		File f2 = new File("Test/objects");
		f1.delete();
		f2.delete();
		
	}

	@Test
	void testAdd() throws IOException, NoSuchAlgorithmException {
//		fail("Not yet implemented");
		
		index.add("file1.txt");
		
		Path fileOrigin = Paths.get("./test/file1.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testAdd2() throws IOException, NoSuchAlgorithmException {
//		fail("Not yet implemented");
		
		index.add("file4.txt");
		
		Path fileOrigin = Paths.get("./test/file4.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testAdd3() throws IOException, NoSuchAlgorithmException {
//		fail("Not yet implemented");
		
		index.add("file2.txt");
		
		Path fileOrigin = Paths.get("./test/file2.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testAdd4() throws IOException, NoSuchAlgorithmException {
//		fail("Not yet implemented");
		
		index.add("file3.txt");
		
		Path fileOrigin = Paths.get("./test/file3.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testIndex() {
		File f = new File("Test/index.txt");
		assertTrue(f.exists());
	}
	
	@Test
	void testindexes1() throws IOException, NoSuchAlgorithmException {
        
		Path fileOrigin = Paths.get("./test/file1.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File file = new File("Test/index.txt");

        Scanner scan = new Scanner(file);

        boolean check = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("file1.txt:" + hashtext)) {
            	check = true;
            }
        }
        scan.close();
        
        assertTrue(check);
	}
	
	@Test
	void testindexes2() throws IOException, NoSuchAlgorithmException {
        
		Path fileOrigin = Paths.get("./test/file2.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File file = new File("Test/index.txt");

        Scanner scan = new Scanner(file);

        boolean check = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("file2.txt:" + hashtext)) {
            	check = true;
            }
        }
        scan.close();
        
        assertTrue(check);
	}
	
	@Test
	void testindexes3() throws IOException, NoSuchAlgorithmException {
        
		Path fileOrigin = Paths.get("./test/file3.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File file = new File("Test/index.txt");

        Scanner scan = new Scanner(file);

        boolean check = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("file3.txt:" + hashtext)) {
            	check = true;
            }
        }
        scan.close();
        
        assertTrue(check);
	}
	
	@Test
	void testindexes4() throws IOException, NoSuchAlgorithmException {
        
		Path fileOrigin = Paths.get("./test/file4.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File file = new File("Test/index.txt");

        Scanner scan = new Scanner(file);

        boolean check = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("file4.txt:" + hashtext)) {
            	check = true;
            }
        }
        scan.close();
        
        assertTrue(check);
	}
	
	
	
	@Test
	void testRemove() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		index.remove("file1.txt");
		Path fileOrigin = Paths.get("./test/file1.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testRemove2() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		index.remove("file4.txt");
		Path fileOrigin = Paths.get("./test/file4.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testRemove3() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		index.remove("file2.txt");
		Path fileOrigin = Paths.get("./test/file2.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testRemove4() throws FileNotFoundException, IOException, NoSuchAlgorithmException {
		index.remove("file3.txt");
		Path fileOrigin = Paths.get("./test/file3.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File f = new File("Test/objects/" + hashtext);
		assertTrue(f.exists());
	}
	
	@Test
	void testindexes21() throws IOException, NoSuchAlgorithmException {
        
		Path fileOrigin = Paths.get("./test/file1.txt"); //finds path for desired file
		String content = Files.readString(fileOrigin); //gets content of file
		
		MessageDigest md = MessageDigest.getInstance("SHA-1"); //generates sha1
		byte[] messageDigest = md.digest(content.getBytes());
		BigInteger no = new BigInteger(1, messageDigest);
		String hashtext = no.toString(16);
		while (hashtext.length() < 40) {
            hashtext = "0" + hashtext;
        }
		
		File file = new File("Test/index.txt");

        Scanner scan = new Scanner(file);

        boolean check = false;

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            if (line.equalsIgnoreCase("file1.txt:" + hashtext)) {
            	check = true;
            }
        }
        scan.close();
        
        assertTrue(check);
	}
	
	
//	@Test
//	void testAdd() {
//		for (int i = 0; i < 5; i++) {
//			index.add("file" + i + ".txt");
//		}
//	}
	
	@Test
	void testCreate() throws IOException {
		for (int i = 0; i < 5; i++) {
			Path path = Files.createTempFile(".file" + i, ".txt");
			assertTrue( Files.exists(path));
		}
	}
	
	@Test
	void testerew() {
		File f = new File("Test/objects");
		assertTrue(f.exists());
	}
	
	@Test
	void testerew2() {
		File f = new File("Test/index.txt");
		assertTrue(f.exists());
	}
	
	@Test
	void gamer() throws IOException {
		assertTrue(Files.isDirectory(Files.createTempDirectory("Test")));
	}
	
	@Test
	void game2r() throws IOException {
		assertTrue(Files.isDirectory(Files.createTempDirectory("Test")));
//		Files.createTempDirectory
	}
	
//	@Test
//	void tree() throws NoSuchAlgorithmException, IOException {
//		ArrayList<String> list = new ArrayList<String>();
//		list.add("fieow");
//		list.add("fewiofjewioqjoif");
//		list.add("jfeiwo");
//		Tree tree = new Tree(list);
//		tree.initialize();
//		
//	}

}
