package com.example.mapper;

import org.apache.ibatis.annotations.Select;

import com.example.entity.Participator;

public interface ConferenceMapper {

	@Select("SELECT #{email},#{password} FROM PARTICIPATOR")
	public void verify(Participator participator);

}
