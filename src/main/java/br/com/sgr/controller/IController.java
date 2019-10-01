package br.com.sgr.controller;

import java.util.List;

public interface IController<T> {
	
	T get(Long id);
	
	List<T> list();
		
	void save(T t);
	
	void update(T t);
	
	void delete(Long id);

}
