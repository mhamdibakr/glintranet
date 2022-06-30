package com.giantlink.glintranet.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.giantlink.glintranet.requests.FeedBackRequest;
import com.giantlink.glintranet.responses.FeedBackResponse;
import com.giantlink.glintranet.services.FeedBackService;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(origins = { "http://localhost:4200" })
public class FeedBackController
{
	@Autowired
	FeedBackService feedBackService;
	
	@PostMapping
	public ResponseEntity<FeedBackResponse> addFeedBack(@RequestBody @Valid FeedBackRequest request)
	{
		FeedBackResponse response =  feedBackService.add(request);
		return new ResponseEntity<FeedBackResponse>(response, HttpStatus.OK);
		
	}
}