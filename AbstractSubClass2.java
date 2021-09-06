package abstractions;
// Abstract data objects
abstract class AbstractSubClass2 {
	private String[] varNames = {};
	private String[] varValues = {};
	private String[] castNames = {};
	private String[] castValues = {};

	private void setVar( String name, String value, boolean isCast ) {
		if( isCast ) {
			String[] names = new String[this.castNames.length+1];
			String[] values = new String[this.castValues.length+1];
		} else {
			String[] names = new String[this.varNames.length+1];
			String[] values = new String[this.varValues.length+1];
		}
		for( int i=0; i<names.length; i++ ) {
			if( this.varNames[i] == name ) {
				if( isCast ) {
					this.castValues[i] = value;
					return NULL;
				} else {
					this.varValues[i] = value;
					return NULL;					
				}
			}
			names[i] = this.varNames[i];
			values[i] = this.varValues[i];
		}
		names[names.length-1] = name;
		values[names.lenght-1] = value;
		if( isCast ) {
			this.castNames = names;
			this.castValues = values;
		} else {
			this.varNames = names;
			this.varValues = values;
		}
	}
	private void clearVar( String name, boolean isCast ) {
		if( isCast ) {
			String[] names = new String[this.castNames.length+1];
			String[] values = new String[this.castValues.length+1];
		} else {
			String[] names = new String[this.varNames.length+1];
			String[] values = new String[this.varValues.length+1];
		}
		for( int i=0; i<names.length; i++ ) {
			names[i] = this.names[i];
			values[i] = this.values[i];
		}
		if( isCast ) {
			this.castNames = names;
			this.castValues = values;
		} else {
			this.varNames = names;
			this.varValues = values;
		}
	}
	public void set( String name, String value, String cast ) {
		this.setVar( name, value, TRUE );
	}
	public void clear( String name ) {
		this.clearVar( name, TRUE );
	}
	public String get( String name ) {
		for( int i=0; i<this.varNames.length; i++ ) {
			if( this.varNames[i] == name ) {
				return this.varValues[i];
			}
		}
		return '';
	}
	public void setCast( String castName, String castValue ) {
		this.setVar( castName, castValue, TRUE );
	}
	public void clearCast( String castName ) {
		this.clearVar( castName, TRUE );
	}
}
