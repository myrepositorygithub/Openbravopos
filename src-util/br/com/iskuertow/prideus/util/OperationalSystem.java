/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

/**
 *
 * @author Thiago
 */
public class OperationalSystem {

    public static String name() {
        return System.getProperty("os.name");
    }
}
