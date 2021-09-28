package com.example.reCapProject.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.reCapProject.business.abstracts.ColorService;
import com.example.reCapProject.core.utilities.result.DataResult;
import com.example.reCapProject.core.utilities.result.Result;
import com.example.reCapProject.entities.concretes.Color;
import com.example.reCapProject.entities.request.create.CreateColorRequest;
import com.example.reCapProject.entities.request.delete.DeleteColorRequest;
import com.example.reCapProject.entities.request.update.UpdateColorRequest;

@RestController
@RequestMapping("api/colors")
public class ColorsController {

	ColorService colorService;

	@Autowired
	public ColorsController(ColorService colorService) {
		super();
		this.colorService = colorService;
	}

	@GetMapping("/getall")
	public DataResult<List<Color>> getAll() {
		return this.colorService.getAll();
	}

	@GetMapping("/getbyid")
	public DataResult<Color> getById(int colorId) {
		return this.colorService.getById(colorId);
	}

	@PostMapping("/add")
	public Result add(@Valid @RequestBody CreateColorRequest createColorRequest) {
		return this.colorService.add(createColorRequest);
	}

	@PostMapping("update")
	public Result update(@Valid @RequestBody UpdateColorRequest updateColorRequest) {
		return this.colorService.update(updateColorRequest);
	}

	@PutMapping("delete")
	public Result delete(@Valid @RequestBody DeleteColorRequest deleteColorRequest) {
		return this.colorService.delete(deleteColorRequest);
	}

}
