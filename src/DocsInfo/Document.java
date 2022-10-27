package DocsInfo;

import java.util.ArrayList;

public class Document {

	private ArrayList<String> doc = new ArrayList<>();

	public ArrayList<String> getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc.add(doc);
	}

	@Override
	public String toString() {
		return doc.toString();
	}
}