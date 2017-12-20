package org.mql.gc.actions;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.inject.Named;

import org.apache.commons.io.IOUtils;


/**
 * Re-usable file implementation.
 * @author Win7
 *
 */
@Named
public class FileSaver implements IFileSaver {

	public FileSaver() {
	}

	/* 
	 * Save data from an input stream to a file 
	 * @param inputSteam
	 * @param file
	 * @throws IOException
	 */
	@Override
	public void save(InputStream inputStream, File file) throws IOException {
		// we are preparing an output stream so that we can write data to the specified file.
		OutputStream output = new FileOutputStream(file);
		
		// copy the input stream to the output location.
		IOUtils.copy(inputStream, output);
}
	
}
