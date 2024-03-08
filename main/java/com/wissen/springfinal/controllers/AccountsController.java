package com.wissen.springfinal.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wissen.springfinal.models.Accounts;
import com.wissen.springfinal.models.LoginBody;
import com.wissen.springfinal.models.TransactionBody;
import com.wissen.springfinal.repositories.AccountRepository;

@RestController
public class AccountsController {
	
	@Autowired
	private AccountRepository repo;
	
	@PostMapping("/login")
	public boolean Login(@RequestBody LoginBody lg) {
		if(!repo.existsById(lg.getCid())) {
			return false;
		}
		else {
			String password = repo.findPasswordByCid(lg.getCid()).getPassword();
			if(password.equals(lg.getPassword())) {
				return true;
			}
			return false;
		}
	}
	
	@PostMapping("/register")
	public String Register(@RequestBody Accounts a) {
		repo.save(a);
		return "Account added to the record";
	}
	
	@GetMapping("/changepwd/{cid}/{oldPass}/{newPass}")
	public String ChangePassword(@PathVariable int cid, 
			@PathVariable String oldPass, @PathVariable String newPass) {
		if(!repo.existsById(cid)) {
			return "No User found by this ID";
		}
		else {
			String password = repo.findPasswordByCid(cid).getPassword();
			if(password.equals(oldPass)) {
				Optional<Accounts> optionalAccounts = repo.findById(cid);
				Accounts accounts = optionalAccounts.orElse(null);
				accounts.setPassword(newPass);
				repo.save(accounts);
				return "Password Changed Successfully";
			}
			return "Old Password is Incorrect";
		}
	}
	
	@GetMapping("/balance")
	public String displayBalance(long accountno) {
		Accounts a = repo.findByAccountno(accountno);
		return "Your account has Rs. "+a.getAmount();
	}
	
	@GetMapping("/accounts/below")
	public List<Accounts> accountsBelow(long amount){
		return repo.findByAmountLessThan(amount);
	}
	
	@GetMapping("/accounts/above")
	public List<Accounts> accountsAbove(long amount){
		return repo.findByAmountGreaterThan(amount);
	}
	
	@PutMapping("/transfer")
	public String transaction(@RequestParam long amount, 
			@RequestBody TransactionBody t) {
		if(repo.existsByAccountno(t.getFromAccno())) {
			if(repo.existsByAccountno(t.getToAccno())) {
				if(repo.findByAccountno(t.getFromAccno()).getAmount() < amount) {
					return "Insufficient Balance";
				}
				else {
					Accounts a = repo.findByAccountno(t.getFromAccno());
					a.setAmount(a.getAmount()-amount);
					repo.save(a);
					Accounts a2 = repo.findByAccountno(t.getToAccno());
					a2.setAmount(a2.getAmount()+amount);
					repo.save(a2);
					return "Money transfered Successfully";
				}
			}
			else {
				return "To account numner does not exit";
			}
		}
		else {
			return "From account number does not exists";
		}
	}
	
}
