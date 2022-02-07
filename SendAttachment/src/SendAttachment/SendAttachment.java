package SendAttachment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.*;

class SendAttachment {
	public final static String fullPathName = "D:\\jsoup-resumebuilder\\";
	static Properties props = new Properties();

	public static void main(String[] args) {
		final String samplepath = fullPathName + "menumaster";
		FileInputStream fstream = null;
		try {
			try {
				
				fstream = new FileInputStream(new File(samplepath));
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			String strLine;
			int count = 0;
			File newTextFile = new File("D:\\jsoup-resumebuilder\\a.txt");
			FileWriter fw = new FileWriter(newTextFile);
			while ((strLine = br.readLine()) != null) {
				if (strLine.length() > 0) {
					count++;
					String abc = "const alterSql" + count + " = '" + strLine + "';";
					System.out.println(abc);
					fw.write(abc + "\n");
					String str2 = "await queryRunner.query(alterSql" + count + ");" + "\n";
					fw.write(str2);
				}
			}
			fw.close();
			System.out.println("end the program :)");
			fstream.close();
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
	}
}