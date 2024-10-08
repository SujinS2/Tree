package kr.or.iei.todo.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import kr.or.iei.user.model.dto.UserDto;

@Mapper
public interface TodoDao {

	List selectAllParentTodo(UserDto loginUser);

	List selectAllChildTodo(UserDto loginUser);

}
