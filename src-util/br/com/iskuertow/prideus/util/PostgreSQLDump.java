/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.util;

import br.com.iskuertow.prideus.basic.adapter.BackupAdapter;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thiago Dias Gomes
 */
public class PostgreSQLDump extends BackupAdapter {

    /**
     * <p>Metodo de dump postgresql, e necessario passar os parametros correto para funcionar corretamente.<p>
     * @param path
     * @param host
     * @param port
     * @param user
     * @param password
     * @param bd
     * @param destiny
     * @return 
     */
    @Override
    public boolean newBackup(String path, String host, String port, String user, String password, String bd, String destiny) {
        return createTask(path, host, port, user, password, bd, destiny);
    }

    private boolean createTask(String path, String host, String port, String user, String password, String bd, String destiny) {
        final List<String> comandos = new ArrayList<>();
        comandos.add(path);   
        comandos.add("-i");
        comandos.add("-h");
        comandos.add(host);     
        comandos.add("-p");
        comandos.add(port);
        comandos.add("-U");
        comandos.add(user);
        comandos.add("-F");
        comandos.add("c");
        comandos.add("-b");
        comandos.add("-v");
        comandos.add("-f");
        comandos.add(destiny); 
        comandos.add(bd);
        ProcessBuilder pb = new ProcessBuilder(comandos);
        pb.environment().put("PGPASSWORD", password);     
        try {
            final Process process = pb.start();
            try (BufferedReader r = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()))) {
                String line = r.readLine();
                while (line != null) {
                    System.err.println(line);
                    line = r.readLine();
                }
            }
            process.waitFor();
            process.destroy();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }

        return false; 
    }

}
