import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ListIter {
	public static void main( String[] args ) {
		String[] list1 = { "Tom", "Jane", "Mary", "Farouk", "Elizabeth", "Pat" };
		String[] list2 = { "Worker", "Manager", "Contractor", "Executive" };
		String[] list3 = { "Experienced", "Skilled", "Novice" };
		String[] list4 = { "Boston", "Chicago", "Los Angeles", "San Francisco", "Seattle", "Atlanta", "Austin", "Houston" };
		String[] list5 = { "", "Illinois", "California", "California", "Washington", "Georgia", "Texas", "Texas" };

		int[][] eigenKey = { 
			{ 0, 1, 1, 3 },
			{ 1, 2, 1, 4 },
			{ 2, 0, 2, 6 },
			{ 2, 0, 0, 2 },
			{ 3, 1, 1, 0 },
			{ 4, 2, 1, 5 },
			{ 5, 0, 1, 4 },
			{ 5, 0, 2, 4 } 
		};

		String text = "";

		for( var i=0; i<eigenKey.length; i++ ) {
			text += list1[eigenKey[i][0]] + " is a&?" + list3[eigenKey[i][2]] + " " + list2[eigenKey[i][1]] + " from " + list4[eigenKey[i][3]];
			if( list5[eigenKey[i][3]] != "" ) {
				text += ", " + list5[eigenKey[i][3]];
			}
			text += ".\n";
		}

		char[] textArray = new char[text.length()];
		textArray = text.toCharArray();
		String output = "";

		for( var c = 0; c<textArray.length; c++ ) {
			if( textArray[c] == '&' && textArray[c+1] == '?' ) {
				if( textArray[c+2] == 'a' || textArray[c+2] == 'e' || textArray[c+2] == 'i' || textArray[c+2] == 'o' ) {
					output += "n ";
				} else {
					output += " ";
				}
				c++;
			} else {
				output += textArray[c];
			}
		}

		System.out.println( output );
	}
}
