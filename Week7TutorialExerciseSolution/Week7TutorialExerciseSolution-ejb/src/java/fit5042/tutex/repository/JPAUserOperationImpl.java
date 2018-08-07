/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.SysPermission;
import fit5042.tutex.repository.entities.SysUser;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author thinking
 */
@Stateless
public class JPAUserOperationImpl implements UserOperation {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public SysUser searchUserById(int id) throws Exception {
        SysUser sysUser = entityManager.createNamedQuery(SysUser.FIND_BY_ID, SysUser.class)
                .setParameter("userId", id).getSingleResult();
        return sysUser;
    }

    @Override
    public List<SysUser> searchUserByLastName(String lastName) throws Exception {
        List<SysUser> userList = entityManager.createNamedQuery(SysUser.FIND_BY_LASTNAME, SysUser.class)
                .setParameter("lastName", lastName).getResultList();
        return userList;
    }

    @Override
    public List<SysUser> searchUserByFirstName(String firstName) throws Exception {
        List<SysUser> userList = entityManager.createNamedQuery(SysUser.FIND_BY_FIRSTNAME, SysUser.class)
                .setParameter("firstName", firstName).getResultList();
        return userList;
    }

    @Override
    public List<SysUser> searchUserByPhoneNumber(String phoneNumber) throws Exception {
        List<SysUser> userList = entityManager.createNamedQuery(SysUser.FIND_BY_PHONENUMBER, SysUser.class)
                .setParameter("phoneNumber", phoneNumber).getResultList();
        return userList;
    }

    @Override
    public SysUser searchUserByEmail(String email) throws Exception {
        SysUser sysUser = entityManager.createNamedQuery(SysUser.FIND_BY_EMAIL, SysUser.class)
                .setParameter("email", email).getSingleResult();
        return sysUser;
    }

    @Override
    public void addUser(SysUser sysUser) throws Exception {
        entityManager.persist(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) throws Exception {
        entityManager.merge(sysUser);
        
    }

    @Override
    public void deleteUser(int userId) throws Exception {
        SysUser sysUser = this.searchUserById(userId);
        if(sysUser != null) {
            entityManager.remove(sysUser);
        }  
    }

    @Override
    public List<SysUser> getAllUsers() throws Exception {
        return entityManager.createNamedQuery(SysUser.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public List<SysPermission> findMenuListByUserId(int userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SysPermission> findPermissionListByUserId(int userId) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

        
    
}
