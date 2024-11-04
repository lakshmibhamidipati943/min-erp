package com.minerp.Admin.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.minerp.Admin.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{

	@Query(value="select * from category", nativeQuery=true)
	List<Category> getAllCategories(Pageable pageable);

	@Query(value="select * from category where id_category=?1", nativeQuery=true)
	Category getCategoryById(Long idCategory);

}
