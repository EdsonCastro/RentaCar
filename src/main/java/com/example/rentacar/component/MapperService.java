package com.example.rentacar.component;

import java.util.List;

public interface MapperService<T, S> {
	/**
	 * Mapper Object S to Object T
	 * @param gdoDto
	 * @return
	 */
	T map(S gdoDto);
	
	/**
	 * Mapper List S to List T
	 * @param gdoDtoList
	 * @return
	 */
	List<T>map(List<S> gdoDtoList);
}
