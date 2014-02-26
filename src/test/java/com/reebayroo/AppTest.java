package com.reebayroo;

import static org.junit.Assert.*;

import java.io.IOException;

import org.apache.commons.io.LineIterator;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AppTest {

	private Launcher launcher;

	@Before
	public void setup() {
		this.launcher = Mockito.mock(Launcher.class);
	}

	@Test
	public void verifyFileDoesNotExistDoesntRunLauncher() throws IOException {
		App.setLauncher(this.launcher);
		App.main(new String[]{"/fileName.txt"});
		Mockito.verify(this.launcher, Mockito.never()).run(Mockito.isA(LineIterator.class));
	}

	@Test
	public void verifyFileExists() throws IOException {
		App.setLauncher(this.launcher);
		App.main(new String[]{"/sample.txt"});
		Mockito.verify(this.launcher, Mockito.times(1)).run(Mockito.isA(LineIterator.class));
	}
	@Test
	public void leaveIfNoArguments() throws IOException {
		App.setLauncher(this.launcher);
		App.main(new String[]{});
		Mockito.verify(this.launcher, Mockito.never()).run(Mockito.isA(LineIterator.class));
	}
}
