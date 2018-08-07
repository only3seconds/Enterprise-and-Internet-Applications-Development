/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.SysPermission;
import fit5042.tutex.repository.entities.SysUser;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author thinking
 */
@Remote
public interface UserOperation {
    
    public SysUser searchUserById(int id) throws Exception;
    
    public List<SysUser> searchUserByLastName(String lastName) throws Exception;
    
    public List<SysUser> searchUserByFirstName(String firstName) throws Exception;
    
    public List<SysUser> searchUserByPhoneNumber(String phoneNuber) throws Exception;
    
    public SysUser searchUserByEmail(String email) throws Exception;
    
    public void addUser(SysUser sysUser) throws Exception;
    
    public void updateUser(SysUser sysUser) throws Exception;
    
    public void deleteUser(int userId) throws Exception;
    
    public List<SysUser> getAllUsers() throws Exception;
    
    public List<SysPermission> findMenuListByUserId(int userId) throws Exception;
    
    public List<SysPermission> findPermissionListByUserId(int userId) throws Exception;
    
}
