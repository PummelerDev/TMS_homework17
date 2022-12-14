package DocsInfo;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {

		Map<String, Document> docBase = new HashMap();
		File fileDir = new File("D:\\java-workspace\\TMS_homework17\\testForCatalogInfo");
		DocsInfo.checkAll(fileDir, docBase, 11);

		for (Entry<String, Document> item : docBase.entrySet()) {
			System.out.println(item.getKey() + " " + item.getValue());
		}
	}
}
