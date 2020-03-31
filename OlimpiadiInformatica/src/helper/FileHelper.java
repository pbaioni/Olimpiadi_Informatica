package helper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

	public static File getFileByName(String folderPath, String name) {
		// looking for input file
		File dir = new File(folderPath);
		File[] inputFiles = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.contains(name);
			}
		});

		return inputFiles[0];
	}

	public static File getFileByExtension(String folderPath, String extension) {
		// looking for input file
		File dir = new File(folderPath);
		File[] inputFiles = dir.listFiles(new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.endsWith(extension);
			}
		});

		return inputFiles[0];
	}

	public static List<String> getAllFileLines(String filePath) {

		List<String> lines = new ArrayList<String>();
		try {
			BufferedReader br = Files.newBufferedReader(Paths.get(filePath));
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return lines;
	}

	public static String getFirstFileLine(String filePath) {

		List<String> lines = getAllFileLines(filePath);

		return lines.get(0);

	}

	public static void WriteLines(String outputFilePath, List<String> lines) {

		boolean init = true;
		FileWriter fw;

		try {

			fw = new FileWriter(outputFilePath);
			for (String line : lines) {
				if (init) {
					fw.write(line);
					init = false;
				} else {
					fw.write("\n" + line);
				}
			}
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
