package br.com.iskuertow.prideus.factory;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerService {

    private EntityManager em;

    private static EntityManagerService instance = null;

    public static EntityManagerService getInstance() {
        if (instance == null) {
            instance = new EntityManagerService();
        }
        return instance;
    }

    private EntityManagerService() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PrideusPDVPU");
        em = emf.createEntityManager();

    }

    public EntityManager getEm() {
        return em;
    }

}
