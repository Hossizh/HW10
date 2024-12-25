package ir.maktabshrif.hw10.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
    private static EntityManagerFactory emf  = null;
    private JpaUtil(){

    }
    private static EntityManagerFactory getEmf(){
        if (emf == null){
            emf = Persistence.createEntityManagerFactory("jdbc-postgres");
        }
        return emf;
    }
    public static EntityManager getEm(){
        return getEmf().createEntityManager();
    }
}
