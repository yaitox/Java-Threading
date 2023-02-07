
public class MyFile 
{
	public MyFile(String url, String pdfName)
	{
		_url = url;
		_pdfName = pdfName;
	}
	
	public String GetURL() { return _url; }
	public String GetPDFName() { return _pdfName; }
	
	private String _url;
	private String _pdfName;
}
