package kr.or.iei.todo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import kr.or.iei.todo.model.service.TodoService;
import kr.or.iei.user.model.dto.UserDto;

@Controller
@RequestMapping(value="/todo")
@Tag(name="TODO", description = "TODO API")
public class TodoController {
	@Autowired
	private TodoService todoService;
	
	@Operation(summary = "할일 목록 조회", description = "당일 할일 목록 조회")
	@GetMapping(value="/todoList")
	public String selectAllTodo(@SessionAttribute UserDto loginUser, Model model) {
		Map todoList = todoService.selectAllTodo(loginUser);
		model.addAttribute("parentList",todoList.get("parentList"));
		model.addAttribute("childList", todoList.get("childList"));
		return "/todo/todoList";
	}
	
}
