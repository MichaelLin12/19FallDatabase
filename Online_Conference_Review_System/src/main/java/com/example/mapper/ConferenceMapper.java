package com.example.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.entity.Participator;

@Mapper
public interface ConferenceMapper {

	@Select("SELECT EMAIL,PASSWORD FROM PARTICIPATOR WHERE EMAIL=#{email} and PASSWORD=#{password} ")
	public ArrayList<Participator> verify(Participator participator);

}
