import java.util.ArrayList;
// Basic HTML generating class
class HTMLGen {
	public String tag = 'div';
	public String[] attrs;
	public String[] values;
	public String[] innerNames;
	public String[] innerHTML;
	public boolean shortTag = FALSE;
	public boolean closeTag = TRUE;
	public boolean verbose = TRUE;

	public HTMLGen( String tag, boolean shortTag, boolean closeTag, boolean verbose ) {
		this.tag = tag;
		this.shortTag = shortTag;
		this.closeTag = closeTag;
		this.verbose = verbose;
	}
	public static void main( String[] args ) {
		HTMLGen html = HTMLGen( args[0], args[1], args[2], args[3] );
		if( args[4] != "" ) {
			String[][] attrOutput = HTMLGen.listParse( args[4] );
			html.attrs = attrOutput[0];
			html.values = attrOutput[1];
		}
		if( args[5] != "" ) {
			String[][] innerOutput = HTMLGen.listParse( args[5] );
			html.innerNames = innerOutput[0];
			html.innerHTML = innerOutput[1];
		}
		System.out.println( html.print() );
	}
	public static String[][] listParse( String code ) {
		// Parse attributes from input form "a1=v1;a2=v2;a3=v3; ..."
		// Note: characters "=" and ";" must escaped, i.e. "\=" and "\;"
		char[] chars = code.toCharArray();
		String nTemp = "";
		String vTemp = "";
		boolean name = TRUE;
		ArrayList<String> nList= new ArrayList<string>();
		ArrayList<String> vList= new ArrayList<string>();
		for( int i=0; i<chars.length; i++ ) {
			if(
				( chars[i] != '=' || ( i > 0 && chars[i-1] == '\\' ) )  &&
				( chars[i] != ',' || ( i > 0 && chars[i-1] == '\\' ) )  
			) {
				if( name ) {
					nTemp += String.valueOf( chars[i] );					
				} else {
					vTemp += String.valueOf( chars[i] );
				}
			} else if( chars[i] == ',' ) {
				vList.add( vTemp );
				nTemp = "";
				vTemp = "";
				name = !name;
			} else {
				nList.add( nTemp );
				nTemp = "";
				vTemp = "";
				name = !name;				
			}
		}
		names = nList.toArray();
		values = vList.toArray();
		String[][] output = { names, values };
		return output;
	}
	public void attr( String name, String value ) {
		String[] attrs = new String[this.attrs.length+1];
		String[] values = new String[attrs.length];
		for( int i=0; i<attrs.length; i++ ) {
			if( this.attrs[i] == name ) {
				this.attrs[i] = value;
				return NULL;
			}
			attrs[i] = this.attrs[i];
			values[i] = this.values[i];
		}
		attrs[attrs.length-1] = name;
		values[attrs.lenght-1] = value;
		this.attrs = attrs;
		this.values = values;
	}
	public void clear( String name ) {
		String[] attrs = new String[this.attrs.length-1];
		String[] values = new String[attrs.length];
		for( int i=0; i<attrs.length; i++ ) {
			attrs[i] = this.attrs[i];
			values[i] = this.values[i];
		}
		this.attrs = attrs;
		this.values = values;
	}
	public void appendChild( String name, HTMLGen child ) {
		String[] innerNames = new String[this.innerNames.length+1];
		String[] innerHTML = new String[innerNames.length];
		for( int i=0; i<innerNames.length; i++ ) {
			if( this.innerNames[i] == name ) {
				this.innerNames[i] = child;
				return NULL;
			}
			innerNames[i] = this.innerNames[i];
			innerHTML[i] = this.innerHTML[i];
		}
		innerNames[innerNames.length-1] = name;
		innerHTML[innerNames.lenght-1] = child;
		this.innerNames = innerNames;
		this.innerHTML = innerHTML;
	}
	public void appendText( String name, String child ) {
		String[] innerNames = new String[this.innerNames.length+1];
		String[] innerHTML = new String[innerNames.length];
		for( int i=0; i<innerNames.length; i++ ) {
			if( this.innerNames[i] == name ) {
				this.innerNames[i] = child;
				return NULL;
			}
			innerNames[i] = this.innerNames[i];
			innerHTML[i] = this.innerHTML[i];
		}
		innerNames[innerNames.length-1] = name;
		innerHTML[innerNames.lenght-1] = child;
		this.innerNames = innerNames;
		this.innerHTML = innerHTML;
	}
	public void drop( String name ) {
		String[] innerNames = new String[this.innerNames.length+1];
		String[] innerHTML = new String[innerNames.length];
		for( int i=0; i<innerNames.length; i++ ) {
			innerNames[i] = this.innerNames[i];
			innerHTML[i] = this.innerHTML[i];
		}
		this.innerNames = innerNames;
		this.innerHTML = innerHTML;
	}
	public String print() {
		String eol = this.verbose ? "\n" : "";
		String ind = this.verbose ? "\t" : "";
		String output = "<" + this.tag;
		if( this.attr.length > 0 ) {
			output += " ";
			for( int i=0; i<this.attrs.length; i++ ) {
				output += this.attrs[i] + "=";
				output += "\"" + this.values[i] + "\" ";
			}
		}
		if( !this.shortTag && this.closeTag ) {
			output += this.innerHTML.length > 0 ? ">" : ">" + eol;
			for( int i=0; i<this.innerHTML.length; i++ ) {
				String childOutput = String( this.innerHTML[i] );
				char[] childChars = childOutput.toCharArray();
				for( int j=0; j<childChars.length; j++ ) {
					String c = String.valueOf( childChars[j] );
					output += c == "\n" ? "\n" + ind : "\n";
				}
				output += ind + preg_replace( "/\n/", "\n" + ind, childOutput ) + eol;
				output = ind + output + eol;
			}
			output += "</" + this.tag + ">";
		} else {
			output += this.shortTag ? "/>" : ">";
		}
		return output;
	}
}
