package com.spring.Student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.Student.dto.RequestDTO;
import com.spring.Student.dto.ResponseDTO;

import utility.FileUtil;

@Service
public class EmployeeService {

	public ResponseDTO processRequest(RequestDTO request) {
		ResponseDTO response = new ResponseDTO();

		response.setSuccess(true);
		response.setUserId("john_doe_17091999");
		response.setEmail("john@xyz.com");
		response.setRollNumber("ABCD123");

		List<String> numbers = new ArrayList<>();
		List<String> alphabets = new ArrayList<>();
		List<String> highestLowercaseAlphabet = new ArrayList<>();
		boolean isPrimeFound = false;

		for (String item : request.getData()) {
			if (item.matches("\\d+")) {
				numbers.add(item);
				if (isPrime(Integer.parseInt(item))) {
					isPrimeFound = true;
				}
			} else if (item.matches("[a-zA-Z]")) {
				alphabets.add(item);
				if (item.matches("[a-z]")) {
					highestLowercaseAlphabet.add(item);
				}
			}
		}

		response.setNumbers(numbers);
		response.setAlphabets(alphabets);
		response.setHighestLowercaseAlphabet(highestLowercaseAlphabet);
		response.setPrimeFound(isPrimeFound);

		// Process the file
		// Assuming you have a utility to handle the base64 file conversion
		if (request.getFileB64() != null && !request.getFileB64().isEmpty()) {
			// File handling code
			try {
				String base64String = request.getFileB64(); // Your Base64 encoded file content

				String mimeType = FileUtil.getFileMimeType(base64String);
				int fileSize = FileUtil.getFileSizeInKB(base64String);
				System.out.println("MIME Type: " + mimeType);
				System.out.println("File Size: " + fileSize + " KB");
			} catch (Exception e) {
				System.err.println("Error occurred while creating the file: " + e.getMessage());
			}
		} else {
			response.setFileValid(false);
			response.setFileMimeType("N/A");
			response.setFileSizeKb(0);
		}

		return response;
	}

	private boolean isPrime(int num) {
		if (num <= 1)
			return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}
}
