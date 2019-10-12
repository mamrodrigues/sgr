package br.com.sgr.controller;

import java.util.List;

public interface IController<T> {
	
	T get(int id);
	
	List<T> list();
		
	void save(T t);
	
	void update(T t);
	
	void delete(int id);

}
