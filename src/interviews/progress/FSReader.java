package interviews.progress;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FSReader {

	private static int contentPosition = 0;

	private static final String FIPATH = "C:\\Documents and Settings\\Anurag\\Desktop\\Progress_Programming_Assignment\\FI.txt";
	private static final String FSPATH = "C:\\Documents and Settings\\Anurag\\Desktop\\Progress_Programming_Assignment\\FS.txt";

	public static String read(String path) throws IOException {

		// Extract file name from the file path.
		String[] splittedPath = path.split("\\\\");
		String fileName = splittedPath[splittedPath.length -1 ];
		String dirName = splittedPath[splittedPath.length -2 ];

		// Read the meta file
		File metaFile = new File(FIPATH);
		FileInputStream in = new FileInputStream(metaFile);

		if (!metaFile.exists()) {
			System.err.println("Meta File doesn't exists");
			System.exit(1);
		}

		// Read MetaFile
		byte b[] = new byte[48];
		int len;
		while ((len = in.read(b)) > 0) {

			// Name of the files retrieved from FI.
			String name = getName(b);

			// If name matches with the fileName user want to read.
			if (name.startsWith(fileName)) {

				// Reading the Attributes from the FI.
				byte attribute = b[32];

				if(!isTextFile(attribute))	
				return null;

				// For IndexAt1Starts purpose only
				// System.out.println(Integer.toBinaryString(attribute));

				// Reading size from the FI.
				int size = getSize(b);

				// Reading dir entry
				byte[] dirEntryArray = new byte[2];
				dirEntryArray[0] = b[34];
				dirEntryArray[1] = b[35];

				int dirIndex = convertToNumFromArray(dirEntryArray);
				
				byte[] dirArray = readFI(dirIndex-1);
				if(!getName(dirArray).startsWith(dirName)){
					System.err.println("The parent directory is not same");
					return null;
				}
				
				if(!isDir(dirArray[32])){
					System.err.println("Parent directory is not a directory");
					return null;
				}
	
				// This array will contain the items of the bytes of the
				// blockList
				byte[] blockList = new byte[8];
				for (int i = 0; i < blockList.length; i++)
					blockList[i] = b[40 + i];

				// This array will store the contents of the File
				byte[] contentArray = new byte[size];

				//Index on FS
				int index = 0;

				byte[] indexArray = new byte[2];

				// Reading index from blockList and storing in contentArray.
				for (int i = 0; i < blockList.length; i = i + 2) {
					indexArray[0] = blockList[i];
					indexArray[1] = blockList[i + 1];

					// index on fileSystem
					index = convertToNumFromArray(indexArray);

					// Temporarily storing content in tmpContent
					byte[] tmpContent = readFS(index);

					// If the it is the last block of blockList then read upto
					// 128 bytes or else read upto 126 bytes.
					if (size > 512 && i == blockList.length - 2) {
						pushDataIntoContentArray(contentArray, tmpContent, 126);

						index = readIntFromLast2Bytes(tmpContent);
					} else
						pushDataIntoContentArray(contentArray, tmpContent, 128);
				}

				// As long as contentPosition is less than the size of the File
				// content, it will keep on reading the next blocks.
				while (contentPosition < size) {
					byte[] tmpContent = readFS(index);
					pushDataIntoContentArray(contentArray, tmpContent, 126);
					index = readIntFromLast2Bytes(tmpContent);
				}
				return new String(contentArray);
			}
		}
		in.close();
		return null;
	}

	/**
	 * This function is used to read the File System i.e. FS from my home
	 * desktop
	 * 
	 * @param index
	 * @return
	 * @throws IOException
	 */
	private static byte[] readFS(int index) throws IOException {
		return readFiles(FSPATH, index, 128);
	}

	/**
	 * This function is used to read the meta data file i.e. FI from my home
	 * desktop.
	 * 
	 * @param index
	 * @return
	 * @throws IOException
	 */
	private static byte[] readFI(int index) throws IOException {
		return readFiles(FIPATH, index, 48);
	}

	/**
	 * It will read the files in the chunks that are provided and it returns the
	 * byte array which is found at the index.
	 * 
	 * @param path
	 * @param index
	 * @return
	 * @throws IOException
	 */
	private static byte[] readFiles(String path, int index, int chunks)
			throws IOException {
		File fileSystem = new File(path);
		FileInputStream fsInputStream = new FileInputStream(fileSystem);

		byte[] fsByte = new byte[chunks];

		for (int i = 0; i <= index; i++) {
			fsInputStream.read(fsByte);
		}
		fsInputStream.close();
		return fsByte;

	}

	/**
	 * In this function, array upto size 4 only can be supplied. Because int can
	 * contain only 4 bytes.
	 */
	private static int convertToNumFromArray(byte[] b) {

		int val = 0;
		for (int i = b.length - 1, j = 0; i >= 0; i--, j++) {
			val += (b[i] & 0xff) << (8 * j);
		}
		return val;
	}

	/**
	 * This function is used to push dataArray into contentArray.
	 * 
	 * @param contentArray
	 * @param dataArray
	 * @param index
	 */
	private static void pushDataIntoContentArray(byte[] contentArray,
			byte[] dataArray, int index) {

		for (int i = 0; i < index; i++) {
			if (contentPosition >= contentArray.length)
				return;
			else
				contentArray[contentPosition] = dataArray[i];
			contentPosition++;
		}
	}

	/**
	 * This function is used to read the last 2 bytes from the byte array b and
	 * then get the index of next block from it.
	 * 
	 * @param b
	 * @return
	 */
	private static int readIntFromLast2Bytes(byte[] b) {
		byte[] indexArray = new byte[2];
		indexArray[0] = b[126];
		indexArray[1] = b[127];
		return convertToNumFromArray(indexArray);
	}

	/**
	 * To check if it is a text file or not
	 * @param attribute
	 * @return
	 */
	private static boolean isTextFile(byte attribute){
		return ((attribute & (1 << 7)) != 0 && (attribute & (1 << 5)) != 0);
	}
	
	private static boolean isDir(byte attribute){
		return ((attribute & (1<<7)) == 0);
	}
	
	/**
	 * 
	 * get size of the file.
	 * @param b
	 * @return
	 */
	private static int getSize(byte[] b){
		byte[] sizeArray = new byte[4];
		for (int i = 0; i < sizeArray.length; i++)
			sizeArray[i] = b[36 + i];
		int size = convertToNumFromArray(sizeArray);
		return size;
	}

	/**
	 * Read first 32 bytes of the FI block and retrieve name
	 * @param b
	 * @return
	 */
	private static String getName(byte[] b){
		byte[] nameByte = new byte[32];
		for (int i = 0; i < nameByte.length; i++) {
			nameByte[i] = b[i];
		}
		return new String(b);

	}
	/**
	 * main function
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		// This is the file, we wish to read from the file system.
		String path = "\\Progress\\OpenEdge\\OpenEdge.txt";

		FileOutputStream os = new FileOutputStream(new File("output.txt"));
		
		BufferedOutputStream bos = new BufferedOutputStream(os);
		
		String content = read(path);
		if(content == null)
			System.err.println("The requied file doesn't exist on the FS");
		
		bos.write(content.getBytes());
		bos.flush();
		bos.close();
		os.close();
		
	}
}
