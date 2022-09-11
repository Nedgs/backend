package com.example.lma;

import com.example.lma.model.City;
import com.example.lma.model.Company;
import com.example.lma.repos.CityRepository;
import com.example.lma.repos.CompanyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class LmaApplicationTests {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private CityRepository cityRepository;
//	@Test
//	public void testCreateCompany(){
//		City city=  new City(1L, "Rennes",new ArrayList<>());
//		cityRepository.save(city);
//		Company company = new Company(1l,"Google",new Date(),"0747454745",city);
//		companyRepository.save(company);
//	}

	@Test
	public void testFindCompany(){
		Company company = companyRepository.findById(1L).get();
		System.out.println(company);
	}

	@Test
	public void testUpdateCompany(){
		Company company = companyRepository.findById(1L).get();
		company.setName("Facebook");
		companyRepository.save(company);
		System.out.println(company);
	}

	@Test
	public void testDeleteCompany(){
		companyRepository.deleteById(1L);
	}

	@Test
	public void testFindAllCompany(){
		List<Company> compnay = companyRepository.findAll();
		for (Company c:compnay)
			System.out.println(c);
	}

}
