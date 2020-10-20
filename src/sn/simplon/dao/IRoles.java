package sn.simplon.dao;

import java.util.List;

import sn.simplon.entities.Roles;
import sn.simplon.entities.User;

public interface IRoles {

	public int add(Roles roles);
	public int update(Roles roles);
	public int delete(int id);
	public Roles get( int id);
	public List<Roles> getAll();
	public List<User> getAllUserRoles(int id);
	
}
