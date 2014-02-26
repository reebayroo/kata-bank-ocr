package com.reebayroo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.ArrayUtils;

public class App {
	private static Launcher launcher = new Launcher();
	private App(){
		//Constructor never Called.
	}
	public static void main(String[] args) throws IOException {
		if (ArrayUtils.isEmpty(args)){
			System.out.println("Usage App [fileName]");
			return;
		}
		String fileName = args[0];
		if (!verifyFile(fileName)){
			System.out.printf("Invalid File %s", fileName);
			return;
		}
		File file = FileUtils.toFile(App.class.getResource(fileName));
		launcher.run(FileUtils.lineIterator(file));
	}

	public static boolean verifyFile(String fileName) {
		return App.class.getResource(fileName) != null;
    }

	public static void setLauncher(Launcher launcher) {
		App.launcher = launcher;
	}
	
}
