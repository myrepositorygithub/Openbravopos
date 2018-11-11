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
public class Mkdirs {

    public static boolean mkDirs(File file) {
        return file.mkdirs();
    }
}
