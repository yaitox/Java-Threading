
public class MyFile 
{
	public MyFile(boolean local, String origin, String pdfName)
	{
		_isLocal = local;
		_origin = origin;
		_pdfName = pdfName;
	}
	
	final public boolean IsLocal() { return _isLocal; }
	
	public String GetOrigin() { return _origin; }
	public String GetPDFName() { return _pdfName; }
	
	private String _origin;
	private String _pdfName;
	private boolean _isLocal;
}
