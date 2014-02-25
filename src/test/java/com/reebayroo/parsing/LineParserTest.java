package com.reebayroo.parsing;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.reebayroo.parsing.LineParser;

public class LineParserTest {

	private LineParser parser;

	@Before
	public void setup() {
		this.parser = new LineParser();
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateEmpty() {
		parser.parse("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateNull() {
		parser.parse(null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveFourCarriageReturnsNotOne() {
		parser.parse("\n");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveFourCarriageReturnsNotTwo() {
		parser.parse("\n\n");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveFourCarriageReturnsNotThree() {
		parser.parse("\n");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineOne() {
		parser.parse(replicate("-", 23) + "\n" //
		        + replicate("-", 27) + "\n" //
		        + replicate("-", 27) + "\n" //
		        + "\n");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineThree() {
		parser.parse(replicate("-", 27) + "\n" //
		        + replicate("-", 27) + "\n" //
		        + replicate("-", 23) + "\n" //
		        + "\n");
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineTwo() {
		parser.parse(replicate("-", 27) + "\n" //
		        + replicate("-", 2) + "\n" //
		        + replicate("-", 27) + "\n" //
		        + "\n");
	}

	private String replicate(String string, int j) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < j; i++)
			buffer.append(string);
		return buffer.toString();
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveFourCarriageReturnsAndContent() {
		parser.parse("\n\n\n\n");
	}

	private void parseAndAssert(String text, int[] expected) {
		int[] actual = parser.parse(text);
		assertThat(actual, equalTo(expected));
	}

	@Test
	public void allZeros() {
		//@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "| || || || || || || || || |\n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                "\n",//
                new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0 });
    }

    @Test
    public void allOnes() throws Exception {
        //@formatter:off
        parseAndAssert(//
                "                           \n" + //
                "  |  |  |  |  |  |  |  |  |\n" + //
                "  |  |  |  |  |  |  |  |  |\n" + //
                "\n", new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1 });
    }

    @Test
    public void testAllTwos() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                " _| _| _| _| _| _| _| _| _|\n" + //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" + //
                "\n",//
                new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2 });
    }

    @Test
    public void testAllThrees() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                " _| _| _| _| _| _| _| _| _|\n" + //
                " _| _| _| _| _| _| _| _| _|\n" + //
                "\n",//
                new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 3 });
    }

    @Test
    public void testAllFours() {
        //@formatter:off
        parseAndAssert(//
                "                           \n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                "  |  |  |  |  |  |  |  |  |\n" + //
                "\n",//
                new int[] { 4, 4, 4, 4, 4, 4, 4, 4, 4 });
    }

    @Test
    public void testAllFives() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" + //
                " _| _| _| _| _| _| _| _| _|\n" + //
                "\n",//
                new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 5 });
    }

    @Test
    public void testAllSix() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                "\n",//
                new int[] { 6, 6, 6, 6, 6, 6, 6, 6, 6 });
    }

    @Test
    public void testAllSeven() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "  |  |  |  |  |  |  |  |  |\n" + //
                "  |  |  |  |  |  |  |  |  |\n" + //
                "\n",//
                new int[] { 7, 7, 7, 7, 7, 7, 7, 7, 7 });
    }

    @Test
    public void testAllEights() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                "\n",//
                new int[] { 8, 8, 8, 8, 8, 8, 8, 8, 8 });
    }

    @Test
    public void testAllNines() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ \n" + //
                "|_||_||_||_||_||_||_||_||_|\n" + //
                " _| _| _| _| _| _| _| _| _|\n" + //
                "\n",//
                new int[] { 9, 9, 9, 9, 9, 9, 9, 9, 9 });
    }

    @Test
    public void fromOneToNine(){
        //@formatter:off
        parseAndAssert(//
                "    _  _     _  _  _  _  _ \n" + //
                "  | _| _||_||_ |_   ||_||_|\n" + //
                "  ||_  _|  | _||_|  ||_| _|\n" + //
                "\n",//
                new int[] { 1,2,3,4,5,6,7,8,9 });

    }
}
