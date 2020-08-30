package com.nissan.assessment.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.assessment.constants.AssessmentConstants;
import com.nissan.assessment.dto.response.CommonAssessmentResponse;
import com.nissan.assessment.dto.response.Data;
import com.nissan.assessment.dto.response.IdeaResponse;
import com.nissan.assessment.entities.Idea;
import com.nissan.assessment.repository.IdeaRepository;
import com.nissan.assessment.service.IdeaQueryService;
import com.nissan.core.codes.SuccessCodes;
import com.nissan.core.dto.SuccessStatus;
import com.nissan.core.util.JWTUtil;

@Service
public class IdeaQueryServiceImpl implements IdeaQueryService {

	@Autowired
	private IdeaRepository ideaRepository;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public CommonAssessmentResponse<List<IdeaResponse>> ideas() {
		List<IdeaResponse> list = transformToIdeaResponse(
				ideaRepository.findAllByUser(jwtUtil.getUserInfo().getUserId()));
		CommonAssessmentResponse<List<IdeaResponse>> response = new CommonAssessmentResponse<List<IdeaResponse>>();
		Data<List<IdeaResponse>> data = new Data<List<IdeaResponse>>();
		data.setIdeas(list);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonAssessmentResponse<List<IdeaResponse>> ideasWithFilter(String filterName, String filterId) {
		List<Idea> ideaList = new ArrayList<Idea>();

		switch (filterName.trim().toLowerCase()) {
		case "automationarea":
			ideaList = ideaRepository.findByAreaId(Long.valueOf(filterId.trim()), jwtUtil.getUserInfo().getUserId());
			break;
		}
		List<IdeaResponse> list = transformToIdeaResponse(ideaList);
		CommonAssessmentResponse<List<IdeaResponse>> response = new CommonAssessmentResponse<List<IdeaResponse>>();
		Data<List<IdeaResponse>> data = new Data<List<IdeaResponse>>();
		data.setIdeas(list);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonAssessmentResponse<Map<String, BigInteger>> ideasCount() {
		List<Object[]> result = (List<Object[]>) ideaRepository
				.returnIdeaStateCounts(jwtUtil.getUserInfo().getUserId());
		Map<String, BigInteger> map = new HashMap<String, BigInteger>();
		initializeMapCounts(map);
		if (result != null && !result.isEmpty()) {
			for (Object[] object : result) {
				map.put(((String) object[0]), ((BigInteger) object[1]));
			}
		}
		CommonAssessmentResponse<Map<String, BigInteger>> response = new CommonAssessmentResponse<>();
		Data<Map<String, BigInteger>> data = new Data<>();
		data.setIdeas(map);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	private void initializeMapCounts(Map<String, BigInteger> map) {
		map.put(AssessmentConstants.UNDER_REVIEW_STATUS, BigInteger.valueOf(0));
		map.put(AssessmentConstants.APPROVED_STATUS, BigInteger.valueOf(0));
		map.put(AssessmentConstants.ONHOLD_STATUS, BigInteger.valueOf(0));
		map.put(AssessmentConstants.REJECTED_STATUS, BigInteger.valueOf(0));
	}

	@Override
	public CommonAssessmentResponse<List<IdeaResponse>> ideasById(String ideaId) {
		Idea idea = ideaRepository.findByIdeaIdAndSubmittedBy(ideaId, jwtUtil.getUserInfo().getUserId()).get();
		List<Idea> ideas = new ArrayList<Idea>();
		ideas.add(idea);
		List<IdeaResponse> list = transformToIdeaResponse(ideas);
		CommonAssessmentResponse<List<IdeaResponse>> response = new CommonAssessmentResponse<List<IdeaResponse>>();
		Data<List<IdeaResponse>> data = new Data<List<IdeaResponse>>();
		data.setIdeas(list);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonAssessmentResponse<List<IdeaResponse>> ideasByStatus(Long statusId) {
		List<IdeaResponse> list = transformToIdeaResponse(
				ideaRepository.findByStatus(statusId, jwtUtil.getUserInfo().getUserId()));
		CommonAssessmentResponse<List<IdeaResponse>> response = new CommonAssessmentResponse<List<IdeaResponse>>();
		Data<List<IdeaResponse>> data = new Data<List<IdeaResponse>>();
		data.setIdeas(list);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public List<IdeaResponse> transformToIdeaResponse(List<Idea> ideas) {
		List<IdeaResponse> list = new ArrayList<IdeaResponse>();
		if (ideas != null && !ideas.isEmpty()) {
			for (Idea i : ideas) {
				IdeaResponse ir = new IdeaResponse();
				try {
					BeanUtils.copyProperties(ir, i);
				} catch (IllegalAccessException | InvocationTargetException e) {
					e.printStackTrace();
				}
				if (i.getPhaseDocument() != null) {
					ir.processPhaseDocs(i.getPhaseDocument());
				}

				list.add(ir);
			}
		}
		return list;
	}

}
