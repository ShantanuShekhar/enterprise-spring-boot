package com.kishanseva.services;

import org.springframework.web.multipart.MultipartFile;

import com.kishanseva.dto.CategoryDto;
import com.kishanseva.util.Response;

public interface ICategoryService {

	Response getFilteredCategory(CategoryDto reqbody);

	Response createCategorygorySellDetails(MultipartFile file, String username, String category_name,
			String category_type, String varity_name, String category_price);

}
