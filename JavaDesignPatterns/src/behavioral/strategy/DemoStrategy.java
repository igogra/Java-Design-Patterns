package behavioral.strategy;

import java.util.ArrayList;
import java.util.List;

interface CompressionStrategy {
	public void compressFiles(List<String> files);
}

class ZipCompressionStrategy implements CompressionStrategy {
	@Override
	public void compressFiles(List<String> files) {
		System.out.println("Compressing using Zip strategy");
	}
}

class RarCompressionStrategy implements CompressionStrategy {
	@Override
	public void compressFiles(List<String> files) {
		System.out.println("Compressing using Rar strategy");
	}
}

class CompressionContext {
	private CompressionStrategy strategy;

	public void setCompressionStrategy(CompressionStrategy strategy) {
		this.strategy = strategy;
	}

	public void createArchive(List<String> files) {
		strategy.compressFiles(files);

		System.out.print("Files included: ");
		for (String file : files) {
			System.out.print(file + " ");
		}
		System.out.println();
	}
}

public class DemoStrategy {
	public static void main(String[] args) {
		String file1 = "File 1";
		String file2 = "File 2";
		String file3 = "File 3";

		CompressionContext compressionContext = new CompressionContext();
		List<String> filesList = new ArrayList<String>();
		filesList.add(file1);
		filesList.add(file2);
		filesList.add(file3);

		compressionContext.setCompressionStrategy(new RarCompressionStrategy());
		compressionContext.createArchive(filesList);
		
		compressionContext.setCompressionStrategy(new ZipCompressionStrategy());
		compressionContext.createArchive(filesList);
	}
}
