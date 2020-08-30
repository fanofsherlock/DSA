package com.nissan.assessment.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nissan.assessment.dto.request.IdeaSaveRequest;
import com.nissan.assessment.dto.request.IdeaSubmitRequest;
import com.nissan.assessment.dto.response.CommonAssessmentResponse;
import com.nissan.assessment.dto.response.Data;
import com.nissan.assessment.dto.response.IdeaResponse;
import com.nissan.assessment.dto.response.SavedIdeaResponse;
import com.nissan.assessment.entities.Idea;
import com.nissan.assessment.entities.IdeaSave;
import com.nissan.assessment.repository.IdeaRepository;
import com.nissan.assessment.repository.IdeaSaveRepository;
import com.nissan.assessment.service.IdeaQueryService;
import com.nissan.assessment.service.IdeaUpsertService;
import com.nissan.assessment.util.IdeaSaveRequestConverter;
import com.nissan.assessment.util.IdeaSubRequestConverter;
import com.nissan.core.codes.SuccessCodes;
import com.nissan.core.dto.SuccessStatus;
import com.nissan.core.dto.response.CommonResponse;
import com.nissan.core.util.JWTUtil;

@Service
public class IdeaUpsertServiceImpl implements IdeaUpsertService {

	@Autowired
	IdeaRepository ideaRepo;

	@Autowired
	IdeaSaveRepository ideaSaveRepo;

	@Autowired
	private IdeaQueryService ideaQueryService;

	@Autowired
	private JWTUtil jwtUtil;

	@Override
	public CommonAssessmentResponse<List<IdeaResponse>> submitIdea(IdeaSubmitRequest ideaSubmitRequest) {
		Idea idea = ideaRepo
				.save(IdeaSubRequestConverter.getIdeaDomain(ideaSubmitRequest, jwtUtil.getUserInfo().getUserId()));
		ideaSaveRepo.deleteAll();
		List<Idea> ideas = new ArrayList<Idea>();
		ideas.add(idea);
		List<IdeaResponse> list = ideaQueryService.transformToIdeaResponse(ideas);
		CommonAssessmentResponse<List<IdeaResponse>> response = new CommonAssessmentResponse<List<IdeaResponse>>();
		Data<List<IdeaResponse>> data = new Data<List<IdeaResponse>>();
		data.setIdeas(list);
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonAssessmentResponse<List<SavedIdeaResponse>> saveIdea(IdeaSaveRequest idea) {
		IdeaSave ideaSave = null;
		if (idea.getIdeaId() == null) {
			ideaSave = ideaSaveRepo
					.save(IdeaSaveRequestConverter.getSavedIdeaDomain(idea, jwtUtil.getUserInfo().getUserId()));
		} else {
			IdeaSave domainToUpdate = ideaSaveRepo.findById(idea.getIdeaId()).get();
			ideaSave = ideaSaveRepo.save(
					IdeaSaveRequestConverter.updateIdeaDomain(domainToUpdate, idea, jwtUtil.getUserInfo().getUserId()));
		}
		CommonAssessmentResponse<List<SavedIdeaResponse>> response = new CommonAssessmentResponse<List<SavedIdeaResponse>>();
		Data<List<SavedIdeaResponse>> data = new Data<>();
		data.setIdeas(convertToSavedIdeaReponse(ideaSave));
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public CommonAssessmentResponse<List<SavedIdeaResponse>> latestSavedIdea() {
		IdeaSave ideaSave = ideaSaveRepo.findFirstBySavedByOrderBySavedDateDesc(jwtUtil.getUserInfo().getUserId());
		CommonAssessmentResponse<List<SavedIdeaResponse>> response = new CommonAssessmentResponse<List<SavedIdeaResponse>>();
		Data<List<SavedIdeaResponse>> data = new Data<>();
		data.setIdeas(convertToSavedIdeaReponse(ideaSave));
		response.setData(data);
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

	@Override
	public SuccessStatus updateIdeaStatus(String ideaId, Long ideaStatus) {

		ideaRepo.updateIdeaStatus(ideaId, ideaStatus, jwtUtil.getUserInfo().getUserId());
		return new SuccessStatus(SuccessCodes.GENERIC);
	}

	public List<SavedIdeaResponse> convertToSavedIdeaReponse(IdeaSave saveIdea) {
		List<SavedIdeaResponse> list = new ArrayList<SavedIdeaResponse>();
		if (saveIdea != null) {
			SavedIdeaResponse sir = new SavedIdeaResponse();
			try {
				BeanUtils.copyProperties(sir, saveIdea);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
			list.add(sir);
		}
		return list;
	}

	@Override
	public Object getApprovals() {
		CommonResponse<List<Idea>> response = new CommonResponse<List<Idea>>();
		response.setData(ideaRepo.getApprovals(jwtUtil.getUserInfo().getUserId()));
		response.setStatus(new SuccessStatus(SuccessCodes.GENERIC));
		return response;
	}

}
