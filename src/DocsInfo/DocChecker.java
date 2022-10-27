package DocsInfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class DocChecker {

	public static void check(File file, Map<String, Document> docBase) {
		Path path = Paths.get(file.toURI());
		if (!file.getName().endsWith(".txt")) {
			return;
		}
		try {
			BufferedReader reader = Files.newBufferedReader(path);
			String fileStr = reader.lines().collect(Collectors.joining(System.lineSeparator()));
			docBase.put(file.getName().replaceAll(".txt", ""), record(fileStr));
		} catch (IOException e) {
			System.out.println("file not found");
		}
	}

	private static Document record(String line) {
		Pattern docPttrn = Pattern.compile("([0-9]{4}-[\\w]{3}-){2}([0-9][\\w]){2}");
		Pattern numbPttrn = Pattern.compile("\\+\\([0-9]{2}\\)[0-9]{7}");
		Matcher docMtchr = docPttrn.matcher(line);
		Matcher numbMtchr = numbPttrn.matcher(line);
		Document doc = new Document();
		while (docMtchr.find()) {
			doc.setDoc(docMtchr.group());
		}
		while (numbMtchr.find()) {
			doc.setDoc(numbMtchr.group());
		}
		return doc;
	}
}
