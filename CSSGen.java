import java.util.ArrayList;
// Basic class for CSS styles
public class CSSGen {
	protected String[] attrs;
	protected String[] values;
	public String name;
	protected String type;
	public boolean verbose = FALSE;
	public CSSGen( String name, String type ) {
		this.name = name;
		this.type = type;
	}
	// This main function reads input CSS from the command line. The first argument should be the name,
	// the second should be the type, and the third argument should be the print verbose option. The 
	// following arguments should be "Attribute 1", "Value 1", "Attribute 2", "Value 2", and so on.
	public static void main( String[] args ) {
		this.name = args[0];
		this.type = this.type( args[1] );
		this.verbose = args[2] ? TRUE : FALSE;
		ArrayList<String> attrs = new ArrayList<String>();
		ArrayList<String> values = new ArrayList<String>();
		for( int i=3; i<args.length; i+=2 ) {
			attrs.add( args[i] );
			if( i<args.length-1 ) {
				values.add( args[i+1] );
			} else {
				values.add( "1" );
			}
		}
		String[] aArray = attrs.toArray();
		String[] vArray = values.toArray();
		this.attrs = aArray;
		this.values = vArray;
		System.out.println( this.print() );
	}
	public void type( String type ) {
		switch( type ) {
			case "class":
				this.type = '.';
				break;
			case "id":
				this.type = '#';
				break;
			default:
				this.type = '';
		}
	}
	public void set( String attr, value ) {
		String[] newAttr = new String[this.attrs.length+1];
		String[] newVals = new String[this.attrs.length+1];
		for( int i=0; i<this.attrs.length; i++ ) {
			if( this.newAttr[i] == name ) {
				this.newAttr[i] = value;
				return NULL;
			}
			newAttr[i] = this.attrs[i];
			newVals[i] = this.values[i];
		}
		newAttr[this.attrs.length] = attr;
		newVals[this.attrs.length] = String.valueOf( value );
		this.attrs = newAttr;
		this.values = newVals;
	}
	public void clear( String attr ) {
		String[] newAttr = new String[this.attrs.length-1];
		String[] newVals = new String[this.attrs.length-1];
		for( int i=0; i<this.attrs.length; i++ ) {
			if( this.attrs[i] != attr ) {
				newAttr[i] = this.attrs[i];
				newVals[i] = this.values[i];
			}
		}
		this.attrs = newAttr;
		this.values = newVals;
	}
	public String print( boolean verbose ) {
		String eol = this.verbose ? "\n" : "";
		String ind = this.verbose ? "\t" : "";
		String spa = this.verbose ? " " : "";
		String output = this.type + this.name + spa + "{" + eol;
		foreach( this.attr as name => value ) {
			output += ind + name + spa + ":" + spa + value + ";" + eol;
		}
		output += "}" + eol;
		return output;
	} 
}
