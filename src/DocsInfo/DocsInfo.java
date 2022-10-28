package DocsInfo;

import java.io.File;
import java.util.Map;

public class DocsInfo {

	private static void check(File file, Map<String, Document> docBase, int quantityToCheck) {
		for (File item : file.listFiles()) {
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
