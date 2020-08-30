package com.nissan.assessment.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.nissan.assessment.dto.request.IdeaSaveRequest;
import com.nissan.assessment.dto.request.IdeaSubmitRequest;
import com.nissan.assessment.dto.response.CommonAssessmentResponse;
import com.nissan.assessment.dto.response.IdeaResponse;
import com.nissan.assessment.dto.response.SavedIdeaResponse;
import com.nissan.core.dto.SuccessStatus;

@Component
public interface IdeaUpsertService {

	CommonAssessmentResponse<List<IdeaResponse>> submitIdea(IdeaSubmitRequest ideaSubmitRequest);

	CommonAssessmentResponse<List<SavedIdeaResponse>> saveIdea(IdeaSaveRequest idea);

	CommonAssessmentResponse<List<SavedIdeaResponse>> latestSavedIdea();

	SuccessStatus updateIdeaStatus(String ideaId, Long ideaStatus);

	Object getApprovals();

}
