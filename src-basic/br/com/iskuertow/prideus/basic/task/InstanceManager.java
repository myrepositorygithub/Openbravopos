/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iskuertow.prideus.basic.task;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import br.com.iskuertow.prideus.basic.BasicAppMessage;

/**
 *
 * @author Thiago
 */
public class InstanceManager {

    private Registry m_registry;
    private BasicAppMessage m_message;

    public InstanceManager(BasicAppMessage message) throws RemoteException, AlreadyBoundException {
        m_registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
        m_message = message;
        BasicAppMessage stub = (BasicAppMessage) UnicastRemoteObject.exportObject(m_message, 0);
        m_registry.bind("AppMessage", stub);

    }
}
