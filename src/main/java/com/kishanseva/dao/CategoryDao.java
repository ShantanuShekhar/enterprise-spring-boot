package com.kishanseva.dao;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.kishanseva.model.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, UUID> {

	@Query(value = "SELECT * FROM InventoryManagement t WHERE :category_name IS NULL or t.category_name = :category_name AND :category_type IS NULL or t.category_type = :category_type  AND  :varity_name IS NULL or t.varity_name = :varity_name", nativeQuery = true)
	List<Category> fecthRecordByFilterCategory(String category_name, String category_type, String varity_name);

}
