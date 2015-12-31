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

import static org.junit.Assert.*;
import static lc.kra.Characters.*;

import org.junit.Test;

public class CharactersTest {
	@Test public void testWhitespace() {
		assertEquals(WHITESPACE.character,' ');
		
		// equals
		assertTrue(WHITESPACE.equals(" "));
		assertTrue(WHITESPACE.equals("\t"));
		assertFalse(WHITESPACE.equals("X"));
		
		// contains
		assertTrue(WHITESPACE.contains("Foo Bar"));
		assertTrue(WHITESPACE.contains("Foo\tBar"));
		assertFalse(WHITESPACE.contains("FooXBar"));
		
		// starts with
		assertTrue(WHITESPACE.startsWith(" Foo Bar"));
		assertTrue(WHITESPACE.startsWith("\tFoo Bar"));
		assertFalse(WHITESPACE.startsWith("Foo Bar "));
		
		// ends with
		assertTrue(WHITESPACE.endsWith("Foo Bar "));
		assertTrue(WHITESPACE.endsWith("Foo Bar \t"));
		assertFalse(WHITESPACE.endsWith(" Foo Bar"));
		
		// index of
		assertEquals(WHITESPACE.indexOf("Foo Bar"),3);
		assertEquals(WHITESPACE.indexOf("Foo\tBar Baz"),3);
		assertEquals(WHITESPACE.indexOf(" FooBar"),0);
		assertEquals(WHITESPACE.indexOf("FooBar"),-1);
		
		// last index of
		assertEquals(WHITESPACE.lastIndexOf("Foo Bar"),3);
		assertEquals(WHITESPACE.lastIndexOf("Foo\tBar Baz"),7);
		assertEquals(WHITESPACE.lastIndexOf(" FooBar"),0);
		assertEquals(WHITESPACE.lastIndexOf("FooBar"),-1);
		
		// replace
		assertEquals(WHITESPACE.replace("Foo Bar","X"),"FooXBar");
		assertEquals(WHITESPACE.replace("Foo\tBar Baz",""),"FooBarBaz");
		
		// trim
		assertEquals(WHITESPACE.trim(" Foo Bar "),"Foo Bar");
		assertEquals(WHITESPACE.trim("\tFoo\tBar Baz"),"Foo\tBar Baz");		
	}
	
	@Test public void testNewLine() {
		assertEquals(NEW_LINE.character,'\n');
		
		// equals
		assertTrue(NEW_LINE.equals("\n"));
		assertTrue(NEW_LINE.equals("\r"));
		assertFalse(NEW_LINE.equals("X"));
		
		// contains
		assertTrue(NEW_LINE.contains("Foo\nBar"));
		assertTrue(NEW_LINE.contains("Foo\n\rBar"));
		assertFalse(NEW_LINE.contains("FooXBar"));
		
		// starts with
		assertTrue(NEW_LINE.startsWith("\n\rFoo Bar"));
		assertTrue(NEW_LINE.startsWith("\r\nFoo Bar"));
		assertFalse(NEW_LINE.startsWith("Foo\nBar\r"));
		
		// ends with
		assertTrue(NEW_LINE.endsWith("Foo Bar\r"));
		assertTrue(NEW_LINE.endsWith("Foo Bar\n\r"));
		assertFalse(NEW_LINE.endsWith("\n\nFoo Bar"));
		
		// index of
		assertEquals(NEW_LINE.indexOf("Foo\nBar"),3);
		assertEquals(NEW_LINE.indexOf("Foo\n\rBar\nBaz"),3);
		assertEquals(NEW_LINE.indexOf("\n\rFooBar"),0);
		assertEquals(NEW_LINE.indexOf("FooBar"),-1);
		
		// last index of
		assertEquals(NEW_LINE.lastIndexOf("Foo\n\rBar"),4);
		assertEquals(NEW_LINE.lastIndexOf("Foo\nBar\nBaz"),7);
		assertEquals(NEW_LINE.lastIndexOf("\n\rFooBar"),1);
		assertEquals(NEW_LINE.lastIndexOf("FooBar"),-1);
		
		// replace
		assertEquals(NEW_LINE.replace("Foo\nBar","X"),"FooXBar");
		assertEquals(NEW_LINE.replace("Foo\n\rBar\nBaz",""),"FooBarBaz");
		
		// trim
		assertEquals(NEW_LINE.trim("\rFoo Bar\n\r"),"Foo Bar");
		assertEquals(NEW_LINE.trim("\nFoo\nBar Baz"),"Foo\nBar Baz");
	}
	
	@Test public void testAnyCharacter() {
		char character = 'X';
		Characters characters = Characters.valueOf(character);		
		assertEquals(characters.character,character);
		assertTrue(characters==Characters.valueOf(character));
		
		// equals
		assertTrue(characters.equals("X"));
		assertFalse(characters.equals("x"));
		
		// contains
		assertTrue(characters.contains("FooXBar"));
		assertFalse(characters.contains("FooxBar"));
		
		// starts with
		assertTrue(characters.startsWith("XFoo Bar"));
		assertFalse(characters.startsWith(" XFooBar"));
		
		// ends with
		assertTrue(characters.endsWith("Foo BarX"));
		assertFalse(characters.endsWith("Foo Barx"));
		
		// index of
		assertEquals(characters.indexOf("FooXBar"),3);
		assertEquals(characters.indexOf("FooXBarXBaz"),3);
		assertEquals(characters.indexOf("XFooBar"),0);
		assertEquals(characters.indexOf("FooBarx"),-1);
		
		// last index of
		assertEquals(characters.lastIndexOf("FooXBar"),3);
		assertEquals(characters.lastIndexOf("FooXBarXBaz"),7);
		assertEquals(characters.lastIndexOf("XFooBar"),0);
		assertEquals(characters.lastIndexOf("FooBarx"),-1);
		
		// replace
		assertEquals(characters.replace("FooXBar","Y"),"FooYBar");
		assertEquals(characters.replace("FooXBarXBaz",""),"FooBarBaz");
		
		// trim
		assertEquals(characters.trim("XFoo BarX"),"Foo Bar");
		assertEquals(characters.trim("XFooXBar Baz"),"FooXBar Baz");
	}
}
