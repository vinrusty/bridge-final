package com.wissen.springfinal.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.wissen.springfinal.models.Accounts;

public interface AccountRepository extends JpaRepository<Accounts, Integer>{
	@Query("from Accounts where cid=?1")
	public Accounts findPasswordByCid(int id);
	public Accounts findByAccountno(long number);
	public boolean existsByAccountno(long number);
	public List<Accounts> findByAmountLessThan(long amount);
	public List<Accounts> findByAmountGreaterThan(long amount);
}
