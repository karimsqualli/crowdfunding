package org.mql.gc.actions;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public interface IFileSaver {

	void save(InputStream inputStream, File file) throws IOException;

}