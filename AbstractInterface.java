package abstractions;
// Abstract data objects
interface AbstractInterface {
	public boolean addItem( String value, String key );
	public boolean subItem( String key );
	public boolean filter( String value );
	public String getItem( String key );
	public String[] getArray();
}
