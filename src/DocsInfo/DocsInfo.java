package DocsInfo;

import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

public class DocsInfo {

	private static void check(File file, Map<String, Document> docBase, int quantityToCheck) {
		File[] obj = file.listFiles();
		Stream<File> sorted = Arrays.stream(obj).sorted((o1, o2) -> {
			if (o1.isDirectory() && o2.isFile()) {
				return 1;
			}
			if (o1.isFile() && o2.isDirectory()) {
				return -1;
			}
			if (o1.isFile() && o2.isFile()) {
				return o1.getName().compareTo(o2.getName());
			}
			if (o1.isDirectory() && o2.isDirectory()) {
				return o1.getName().compareTo(o2.getName());
			}
			return 0;
		});
		for (File item : sorted.toList()) {
			if (DocChecker.chekedDocs == quantityToCheck) {
				return;
			}
			if (item.isDirectory()) {
				check(item, docBase, quantityToCheck);
			} else {
				DocChecker.check(item, docBase);
			}
		}
	}

	public static void checkAll(File file, Map<String, Document> docBase, int quantityToCheck) {
		check(file, docBase, quantityToCheck);
		System.out.println("Correct docs is " + DocChecker.correctDocsCounter + "\nIncorrect docs is "
				+ DocChecker.incorrectDocsCounter);
	}
}
