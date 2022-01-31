package com.migrate.controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.migrate.entity.StudentDetails;
import com.migrate.entity.StudentRepository;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

@RestController
public class StudentController {

		
	@Autowired
	StudentRepository service;
		
		@PostMapping("/upload")
		public String uploadData(@RequestParam("file")MultipartFile file) throws Exception{
			List<StudentDetails> studentList=new ArrayList<>();
			InputStream inputStream= file.getInputStream();
			CsvParserSettings setting=new CsvParserSettings();
			setting.setHeaderExtractionEnabled(true);
			CsvParser parser=new CsvParser(setting);
			List<Record> parseAllRecords=parser.parseAllRecords(inputStream);
			parseAllRecords.forEach(record -> {
				StudentDetails s=new StudentDetails();
				s.setName(record.getString("Name"));
				s.setRoll(Integer.parseInt(record.getString("Roll")));
				s.setCourse(record.getString("course"));
				s.setMark1(Integer.parseInt(record.getString("Mark1")));
				s.setMark2(Integer.parseInt(record.getString("Mark2")));
				s.setMark3(Integer.parseInt(record.getString("Mark3")));
			
				studentList.add(s);
			});
			
			service.saveAll(studentList);
			return "Upload Sucessful !!!";
		}

	}


