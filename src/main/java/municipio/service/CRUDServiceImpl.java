package municipio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import municipio.dao.CRUDDao;
import java.io.Serializable;
import java.util.Map;
import org.hibernate.LockMode;
import org.hibernate.Transaction;

@Service
public class CRUDServiceImpl implements CRUDService {

    @Autowired
    private CRUDDao CRUDDao;

    @Transactional(readOnly = true)
    public <T> List<T> getAll(Class<T> klass) {
        return CRUDDao.getAll(klass);
    }
    
    
    @Transactional(readOnly = true)
    public <T> List<T> getAllQuery(String s) {
        return CRUDDao.getAllQuery(s);
    }

    @Transactional
    public <T> void Save(T klass) {
        CRUDDao.Save(klass);
    }
    
    public <T> void Saves(T klass) {
        CRUDDao.Saves(klass);
    }

    @Transactional
    public <T> void delete(T klass) {
        CRUDDao.delete(klass);
    }
    
    public <T> void deletes(T klass) {
        CRUDDao.deletes(klass);
    }
    
    public <T> void lock(T klass) {
        CRUDDao.lock(klass);
    }
    
    @Transactional
    public <T> void update(T klass) {
        CRUDDao.update(klass);
    }
    
    public <T> void updates(T klass) {
        CRUDDao.updates(klass);
    }
    
    public <T> LockMode bloqueado(T klass) {
        return CRUDDao.bloqueado(klass);
    }

    @Transactional
    public <T> boolean exist(T klass) {
        return CRUDDao.exist(klass);
    }
    
    //@Transactional
    public <T> Transaction getTransacao() {
        return CRUDDao.getTransacao();
    }
    
    @Transactional
    public <T> int updateQuery(String query, Object... params){
       return CRUDDao.updateQuery(query, params);
    }
    
    @Transactional
    public <T> int count(Class<T> klass){
     return CRUDDao.count(klass);
    }
    
    @Transactional
    public <T> Long countJPQuery(String hql,Map<String, Object> namedParams){
        return CRUDDao.countJPQuery(hql, namedParams);
    }
            
    @Transactional
    public <T> T GetUniqueEntityByNamedQuery(String query, Object... params) {
        return CRUDDao.GetUniqueEntityByNamedQuery(query, params);
    }
    
    @Transactional
    public <T> List<T> GetAllEntityByNamedQuery(String query, Object... params){
        return CRUDDao.GetAllEntityByNamedQuery(query, params);
    }

    @Transactional
    public <T> List<T> findByQuery(String hql, Map<String, Object> entidade, Map<String, Object> namedParams) {
        return CRUDDao.findByQuery(hql, entidade, namedParams);
    }
    
    @Transactional
    public <T> List<T> findByQueryFilter(String hql, Map<String, Object> entidade, Map<String, Object> namedParams, int f, int m) {
        return CRUDDao.findByQueryFilter(hql, entidade, namedParams, f, m);
    }
    
   // @Transactional
    public <T> List<T> findByJPQuery(String hql, Map<String, Object> namedParams) {
        return CRUDDao.findByJPQuery(hql, namedParams);
    }
    
    //@Transactional
    public <T> T findEntByJPQuery(String hql, Map<String, Object> namedParams) {
        return CRUDDao.findEntByJPQuery(hql, namedParams);
    }
    
    //@Transactional
    public <T> T findEntByJPQueryLock(String hql, Map<String, Object> namedParams) {
        return CRUDDao.findEntByJPQueryLock(hql, namedParams);
    }
    
    @Transactional
    public <T> List<T> findByJPQueryFilter(String hql, Map<String, Object> namedParams, int f, int m) {
        return CRUDDao.findByJPQueryFilter(hql, namedParams, f, m);
    }
    
    //@Transactional
     public <T> T load(Class<T> klass,Serializable id) {
         return CRUDDao.load(klass, id);
     }
     
    // @Transactional
     public <T> T get(Class<T> klass,Serializable id) {
         return CRUDDao.get(klass, id);
     }
     
        //@Transactional
     public <T> T loadLocked(Class<T> klass,Serializable id) {
         return CRUDDao.loadLocked(klass, id);
     }
     
     //@Transactional
     public <T> T getLocked(Class<T> klass,Serializable id) {
         return CRUDDao.getLocked(klass, id);
     }
}
