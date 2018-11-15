/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Thiago
 */
public class ToConvertBytesInImage {

    public static ImageIcon convert(byte[] bytesImage) throws IOException {
        return new ImageIcon(ImageIO.read(new ByteArrayInputStream(bytesImage)));
    }
}
