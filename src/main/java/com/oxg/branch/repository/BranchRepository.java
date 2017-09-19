package com.oxg.branch.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.oxg.branch.documents.Branch;


public interface BranchRepository extends MongoRepository<Branch, Long> {
	Branch findById(int branchId);
	Branch save(BranchRepository branch);
	Branch findByName(String name);
	Branch findByStreetAddress(String streetAddress);
	void delete(Branch entity);
	void deleteById(int id);
	List<Branch> findAll();
}
