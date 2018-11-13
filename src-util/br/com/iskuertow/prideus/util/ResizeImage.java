/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Thiago
 */
public class ResizeImage {

    public static ImageIcon resize(URL url, int width, int height, int length) {
        ImageIcon icon = new ImageIcon(url);
        icon.setImage(icon.getImage().getScaledInstance(width, height, length));
        return icon;
    }
}
