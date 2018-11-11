/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import java.io.File;

/**
 *
 * @author Thiago
 */
public class DeleteDir {

    // Deletes all files and subdirectories under dir.  
    // Returns true if all deletions were successful.  
    // If a deletion fails, the method stops attempting to delete and returns false.  
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so delete it  
        return dir.delete();
    }
}
