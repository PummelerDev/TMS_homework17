package DocsInfo;

import java.io.File;
import java.util.Map;

public class DocsInfo {

	public static void checkAll(File file, Map<String, Document> docBase) {

		for (File item : file.listFiles()) {
			if (item.isDirectory()) {
				checkAll(item, docBase);
			} else {
				DocChecker.check(item, docBase);
			}
		}
	}
}
