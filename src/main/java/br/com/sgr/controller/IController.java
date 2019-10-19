package br.com.sgr.controller;

import java.util.List;

public interface IController<T> {
	
	T get(int id);
	
	List<T> list();
		
	boolean save(T t);
	
	boolean update(T t);
	
	boolean delete(int id);

}
