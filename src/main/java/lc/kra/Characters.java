package lc.kra;

/**
 * Copyright (c) 2015 Kristian Kraljic
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Characters {
	public static final Characters
		WHITESPACE = new Characters(' ',Pattern.compile("\r\n|\n\r|[ \t\n\r\\f]")),
		NEW_LINE = new Characters('\n',Pattern.compile("\r\n|\n\r|[\n\r]"),Pattern.compile("\n?\r?"));
	private static final String EMPTY = "";
	private static Map<Character,Characters> characters;
	
	public final char character;
	private final String string;
	private Pattern match,start,end,last,left,right,both,condense,split;
	
	private Characters(char character) { this(character,Pattern.compile(Character.toString(character))); }
	public Characters(char character,Pattern pattern) {
		string = String.valueOf(this.character=character);
		split = match = pattern; }
	public Characters(char character,Pattern match,Pattern split) {
		this(character,match); this.split = split; }
	
	public boolean equals(String input) { return match.matcher(input).matches(); }
	public boolean contains(String input) { return match.matcher(input).find(); }
	public boolean startsWith(String input) { return (start!=null?start:(start=Pattern.compile("\\A(?:"+match.pattern()+")"))).matcher(input).find(); }
	public boolean endsWith(String input) { return (end!=null?end:(end=Pattern.compile("(?:"+match.pattern()+")\\z"))).matcher(input).find(); }
	public int indexOf(String input) { Matcher matcher = match.matcher(input); return matcher.find()?matcher.start():-1; }
	public int lastIndexOf(String input) { Matcher matcher = (last!=null?last:(last=Pattern.compile(".*("+match.pattern()+")",Pattern.DOTALL))).matcher(input); return matcher.find()?matcher.start(1):-1; }
	public String replace(String input,String replacement) { return match.matcher(input).replaceAll(replacement); }
	public String trim(String input) { return (both!=null?both:(both=Pattern.compile("\\A(?:"+match.pattern()+")+|(?:"+match.pattern()+")+\\z"))).matcher(input).replaceAll(EMPTY); }
	public String leftTrim(String input) { return (left!=null?left:(left=Pattern.compile("\\A(?:"+match.pattern()+")+"))).matcher(input).replaceAll(EMPTY); }
	public String rightTrim(String input) { return (right!=null?right:(right=Pattern.compile("(?:"+match.pattern()+")+\\z"))).matcher(input).replaceAll(EMPTY); }
	public String condense(String input) { return (condense!=null?condense:(condense=Pattern.compile("(?:"+match.pattern()+")+"))).matcher(input).replaceAll(string); }
	public String[] split(String input) { return split.split(input); }
	
	@Override public String toString() { return string; }
	
	public static Characters valueOf(char character) {
		if(characters==null) characters = new HashMap<Character,Characters>();
		if(!characters.containsKey(character))
			characters.put(character,new Characters(character));
		return characters.get(character);
	}
}