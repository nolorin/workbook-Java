package abstractions;
// Abstract data objects
abstract class AbstractSubClass1 {
	private String[] varNames = {};
	private String[] varValues = {};

	public void set( String name, String value ) {
		String[] names = new String[this.names.length+1];
		String[] values = new String[names.length];
		for( int i=0; i<names.length; i++ ) {
			names[i] = this.names[i];
			values[i] = this.values[i];
		}
		names[names.length-1] = name;
		values[names.lenght-1] = value;
		this.varNames = names;
		this.varValues = values;		
	}
	public void clear( String name ) {
		String[] names = new String[this.names.length-1];
		String[] values = new String[names.length];
		for( int i=0; i<names.length; i++ ) {
			names[i] = this.names[i];
			values[i] = this.values[i];
		}
		this.varNames = names;
		this.varValues = values;
	}
	public String get( String name ) {
		for( int i=0; i<this.varNames.length; i++ ) {
			if( this.varNames[i] == name ) {
				return this.varValues[i];
			}
		}
		return '';
	}
}
