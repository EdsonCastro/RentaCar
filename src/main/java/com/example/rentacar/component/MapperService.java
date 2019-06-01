package com.example.rentacar.component;

import java.util.List;

public interface MapperService<T, S> {
	/**
	 * Mapper Object S to Object T
	 * @param gdoDto
	 * @return
	 */
	T mapToEntity(S gdoDto);
	
	/**
	 * Mapper List S to List T
	 * @param gdoDtoList
	 * @return
	 */
	List<T>mapToEntity(List<S> gdoDtoList);

	/**
	 * Mapper Object S to Object T
	 * @param gdoEntity
	 * @return
	 */
	S mapToDto(T gdoEntity);

	/**
	 * Mapper List S to List T
	 * @param gdoEntityList
	 * @return
	 */
	List<S>mapToDto(List<T> gdoEntityList);

}
