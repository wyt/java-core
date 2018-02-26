package org.wangyt.javase.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.wangyt.javase.nio.filelock.FileLockTest;

public class PathTest {

	public static void main(String[] args) {
		Path path = Paths.get(FileLockTest.FILEPATH);
		System.out.println("path里包含的路径数量: " + path.getNameCount());
		System.out.println("path的根路径: " + path.toAbsolutePath());
	}
}
