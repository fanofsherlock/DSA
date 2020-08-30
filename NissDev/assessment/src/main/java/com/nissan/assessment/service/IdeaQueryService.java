package com.nissan.assessment.service;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import com.nissan.assessment.dto.response.CommonAssessmentResponse;
import com.nissan.assessment.dto.response.IdeaResponse;
import com.nissan.assessment.entities.Idea;

public interface IdeaQueryService {

	CommonAssessmentResponse<List<IdeaResponse>> ideas();

	CommonAssessmentResponse<List<IdeaResponse>> ideasWithFilter(String filterName, String filterId);

	CommonAssessmentResponse<Map<String, BigInteger>> ideasCount();

	CommonAssessmentResponse<List<IdeaResponse>> ideasById(String ideaId);

	CommonAssessmentResponse<List<IdeaResponse>> ideasByStatus(Long statusId);

	List<IdeaResponse> transformToIdeaResponse(List<Idea> ideas);

}
