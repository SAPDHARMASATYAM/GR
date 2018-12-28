package com.gateranker.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gateranker.Constants;
import com.gateranker.dto.Response;
import com.gateranker.jpa.model.Subject;
import com.gateranker.service.SubjectService;
/**
 * @author Sap Dharma Satyam
 */
@RestController
@RequestMapping("subject")
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@PostMapping("addSubject")
	public Response addSubject(@RequestBody @Valid Subject subject) throws Exception {
		Response response = new Response();
		try {
			Subject addSubjectResponse = subjectService.addSubject(subject);
			if(null != addSubjectResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" Subject addition is successfull!");
				response.setResponseContent(addSubjectResponse);
			}
			else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage("Adding subject not Successfull!");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@PutMapping("updateSubject/{subjectId}")
	public Response updateSubject(@PathVariable(name = "subjectId", required = true) String subjectId,
			@RequestBody Subject subject){
		Response response = new Response();
		try {
			Subject updateSubjectResponse = subjectService.updateSubject(subjectId, subject);
			if(null != updateSubjectResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" Subject update is successfull!");
				response.setResponseContent(updateSubjectResponse);
			}
			else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage("Adding subject not Successfull!");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();
		}
		return response;
	}

	@DeleteMapping("removeSubject/{subjectId}")
	public Response removeSubject(@PathVariable(name = "subjectId", required = true) String subjectId){
		Response response = new Response();
		try {
			boolean removeSubjectResponse = subjectService.removeSubject(subjectId);
			if(removeSubjectResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" Subject remove is successfull!");
				response.setResponseContent(removeSubjectResponse);
			}else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage("Removing subject not Successfull!");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();

		}
		return response;
	}

	@PutMapping("enableOrDisableSubject/{subjectId}/{activeIndicator}")
	public Response enableOrDisableSubject(@PathVariable(name = "subjectId", required = true) String subjectId,
			@PathVariable(name = "activeIndicator", required = true) boolean activeIndicator)  {
		Response response = new Response();

		try {
			Subject enableOrDisableSubjectResponse = subjectService.enableOrDisableSubject(subjectId, activeIndicator);

			if (null != enableOrDisableSubjectResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" Subject enableOrDisableSubject is successfull!");
				response.setResponseContent(enableOrDisableSubjectResponse);
			} else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage("enableOrDisableSubject not Successfull!");
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();

		}
		return response;
	}

	@GetMapping("getSubjectById/{subjectId}")
	public Response getSubjectById(@PathVariable(name = "subjectId", required = true) String subjectId)
			throws Exception {
		Response response = new Response();
		try {
			Subject subjectByIdResponse = subjectService.getSubjectById(subjectId);
			if (null != subjectByIdResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" Subject getSubjectById is successfull!");
				response.setResponseContent(subjectByIdResponse);
			} else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage(Constants.NO_DATA);
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();

		}
		return response;
	}

	@GetMapping("getAllSubjects")
	public Response getAllSubjects() throws Exception {
		Response response = new Response();
		try {
			List<Subject> allSubjectsResponse = subjectService.getAllSubjects();
			if (null != allSubjectsResponse) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" getAllSubjects is successfull!");
				response.setResponseContent(allSubjectsResponse);
			} else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage(Constants.NO_DATA);
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();

		}
		return response;
	}

	@GetMapping("getAllSubjectsByActiveIndicator/{activeIndicator}")
	public Response getAllSubjectsByActiveIndicator(
			@PathVariable(name = "activeIndicator", required = true) boolean activeIndicator) throws Exception {
		Response response = new Response();
		try {

			List<Subject> allSubjectsByActiveIndicator = subjectService.getAllSubjectsByActiveIndicator(activeIndicator);
			if (null != allSubjectsByActiveIndicator) {
				response.setResponseStatus(Constants.SUCCESS);
				response.setResponseMessage(" allSubjectsByActiveIndicator is successfull!");
				response.setResponseContent(allSubjectsByActiveIndicator);
			} else {
				response.setResponseStatus(Constants.FAIL);
				response.setResponseMessage(Constants.NO_DATA);
				response.setResponseContent(null);
			}
		} catch (Exception e) {
			response.setResponseStatus(Constants.ERROR);
			response.setResponseMessage(Constants.SERVICE_ERROR);
			response.setResponseContent(null);
			e.printStackTrace();

		}
		return response;
	}

}
