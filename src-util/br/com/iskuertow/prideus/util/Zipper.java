/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 *
 * @author Thiago
 */
public class Zipper {

    public static void zip(File file) {
        byte[] buffer = new byte[1024];

        try {
            // Stream de saida
            FileOutputStream fos = new FileOutputStream(file);

            // Zip de saida
            ZipOutputStream zos = new ZipOutputStream(fos);

            // Arquivo a ser zipdo
            ZipEntry ze = new ZipEntry(file.getName());
            System.out.println("zipando...: " + file.getName());
            System.out.println("em: " + file.getAbsolutePath());
            // Adciona arquivo no Zip de saida
            zos.putNextEntry(ze);

            // Ler o Arquivo que sera Zipado
            FileInputStream in = new FileInputStream(file.getName());

            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }

            // Fecha Arquivos
            in.close();

            // Fecha Zip e entrada
            zos.closeEntry();
            zos.close();

            System.out.println("Done");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
