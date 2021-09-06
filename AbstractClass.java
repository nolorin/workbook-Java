package abstractions;
// Abstract data objects
abstract class AbstractClass {
	protected String name;
	protected String owner;
	protected String source;
	protected String key;

	public AbstractClass( String name, String owner, String source, String key ) {
		this.name = name;
		this.owner = owner;
		this.source = source;
		this.key = key;
	}
	public void getProperty( String var ) {
		if( var == 'name' ) {
			return this.name;
		} else if( var == 'owner' ) {
			return this.owner;
		} else if( var == 'source' ) {
			return this.source;
		} else if( var == 'key' ) {
			return this.key;
		}
	}
	public void name( String name ) {
		this.name = name;
	}
}
