package com.reebayroo.parsing;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class FaxCharExtractorTest {

	private FaxCharExtractor extractor;

	@Before
	public void setup() {
		this.extractor = new FaxCharExtractor();
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineOne() {
		extractor.parse(replicate("-", 23), replicate("-", 27), replicate("-", 27));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineThree() {
		extractor.parse(replicate("-", 27), replicate("-", 27), replicate("-", 23));
	}

	@Test(expected = IllegalArgumentException.class)
	public void validateThatFaxLineShouldHaveTwentySevenCharsOnLineTwo() {
		extractor.parse(replicate("-", 27), replicate("-", 23), replicate("-", 27));
	}

	private String replicate(String string, int j) {
		StringBuilder buffer = new StringBuilder();
		for (int i = 0; i < j; i++)
			buffer.append(string);
		return buffer.toString();
	}

	private void parseAndAssert(String lineOne, String lineTwo, String lineThree, int... expectedCodes) {
		List<FaxChar> actual = extractor.parse(lineOne, lineTwo, lineThree);
		List<FaxChar> expected = create(expectedCodes);
		assertThat(actual, equalTo(expected));
	}

	private List<FaxChar> create(int... expectedCodes) {
		List<FaxChar> result = new ArrayList<FaxChar>();
		for (int value : expectedCodes) {
			result.add(FaxCharBook.getInstance().getByValue(value));
		}
		return result;
	}

	@Test
	public void allZeros() {
		//@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "| || || || || || || || || |", //
                "|_||_||_||_||_||_||_||_||_|", //
                0, 0, 0, 0, 0, 0, 0, 0, 0 );
	}

    @Test
    public void allOnes() throws Exception {
        //@formatter:off
    	parseAndAssert(//
            "                           ", //
            "  |  |  |  |  |  |  |  |  |", //
            "  |  |  |  |  |  |  |  |  |", //
            1, 1, 1, 1, 1, 1, 1, 1, 1 );
    }

    @Test
    public void testAllTwos() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                " _| _| _| _| _| _| _| _| _|", //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", //
                2, 2, 2, 2, 2, 2, 2, 2, 2 );
    }
    
    @Test
    public void testAllThrees() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                " _| _| _| _| _| _| _| _| _|", //
                " _| _| _| _| _| _| _| _| _|", //
                3, 3, 3, 3, 3, 3, 3, 3, 3 );
    }
    
    @Test
    public void testAllFours() {
        //@formatter:off
        parseAndAssert(//
                "                           ", //
                "|_||_||_||_||_||_||_||_||_|", //
                "  |  |  |  |  |  |  |  |  |", //
                4, 4, 4, 4, 4, 4, 4, 4, 4 );
    }
    
    @Test
    public void testAllFives() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", //
                " _| _| _| _| _| _| _| _| _|", //
                5, 5, 5, 5, 5, 5, 5, 5, 5 );
    }
    
    @Test
    public void testAllSix() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "|_ |_ |_ |_ |_ |_ |_ |_ |_ ", //
                "|_||_||_||_||_||_||_||_||_|", //
                6, 6, 6, 6, 6, 6, 6, 6, 6 );
    }
    
    @Test
    public void testAllSeven() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "  |  |  |  |  |  |  |  |  |", //
                "  |  |  |  |  |  |  |  |  |", //
                7, 7, 7, 7, 7, 7, 7, 7, 7 );
    }
    
    @Test
    public void testAllEights() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "|_||_||_||_||_||_||_||_||_|", //
                "|_||_||_||_||_||_||_||_||_|", //
                8, 8, 8, 8, 8, 8, 8, 8, 8 );
    }
    
    @Test
    public void testAllNines() {
        //@formatter:off
        parseAndAssert(//
                " _  _  _  _  _  _  _  _  _ ", //
                "|_||_||_||_||_||_||_||_||_|", //
                " _| _| _| _| _| _| _| _| _|", //
                9, 9, 9, 9, 9, 9, 9, 9, 9 );
    }
    
    @Test
    public void fromOneToNine(){
        //@formatter:off
        parseAndAssert(//
                "    _  _     _  _  _  _  _ ", //
                "  | _| _||_||_ |_   ||_||_|", //
                "  ||_  _|  | _||_|  ||_| _|", //
                1,2,3,4,5,6,7,8,9 );
    
    }
        
}
