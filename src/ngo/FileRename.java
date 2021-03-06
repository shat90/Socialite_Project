package ngo;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shatadru
 */
import com.oreilly.servlet.*;
import com.oreilly.servlet.multipart.*;
import java.io.File;
import java.util.*;

public class FileRename implements FileRenamePolicy {
	String j = "";

	FileRename(String i) {
		j = i;
	}

	public File rename(File f) {

		String parentDir = f.getParent();

		// Get filename without its path location, such as 'index.txt'
		String fname = f.getName();

		// Get the extension if the file has one
		String fileExt = "";
		int i = -1;
		if ((i = fname.indexOf(".")) != -1) {

			fileExt = fname.substring(i);
			fname = fname.substring(0, i);
			if (fileExt.equals(".xls"))
				fname = "temp_" + j;
			else
				fname = "logo_" + j;
		}

		// add the timestamp

		// piece together the filename
		fname = parentDir + System.getProperty("file.separator") + fname
				+ fileExt;

		File temp = new File(fname);

		return temp;

	}

}
