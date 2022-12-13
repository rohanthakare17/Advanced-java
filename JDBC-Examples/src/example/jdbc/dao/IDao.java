package example.jdbc.dao;

import java.util.Collection;

//This is generic(notation) interface meant for handling CRUD operations
public interface IDao<T, K> 
{
	void create(T t); //generic(notation) //Accept type	//Add new entity	
	Collection<T>getAll(); //Retrieves all entities 	//Retain type
	T getOne(K key); //Retrieves one entity against ID
	void update(T t); //Update the entity
	void deleteOne(K Key); //Delete the entity against ID
}
