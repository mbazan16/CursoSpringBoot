package com.example.mvc.services.interfaces;

import java.util.List;

public interface Servicio<T,K> {
	
	public List<T> getElements();
	public T getElement(K id);
	public void save(T element);
	public void delete(K id);
	

}
