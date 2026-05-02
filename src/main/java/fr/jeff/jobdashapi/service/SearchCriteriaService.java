package fr.jeff.jobdashapi.service;

import fr.jeff.jobdashapi.dto.request.SearchCriteriaRequest;
import fr.jeff.jobdashapi.dto.response.SearchCriteriaResponse;
import fr.jeff.jobdashapi.mapper.SearchCriteriaMapper;
import fr.jeff.jobdashapi.model.entity.SearchCriteria;
import fr.jeff.jobdashapi.model.entity.Student;
import fr.jeff.jobdashapi.repository.SearchCriteriaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SearchCriteriaService {

    private final SearchCriteriaRepository searchCriteriaRepository;
    private final SearchCriteriaMapper searchCriteriaMapper;

    public List<SearchCriteriaResponse> getStudentCriteria(Student student) {
        return searchCriteriaRepository.findByStudent(student).stream()
                .map(searchCriteriaMapper::toResponse)
                .toList();
    }

    public SearchCriteriaResponse create(SearchCriteriaRequest request, Student student) {
        SearchCriteria criteria = SearchCriteria.builder()
                .student(student)
                .entitledPosition(request.entitledPosition())
                .location(request.location())
                .contractType(request.contractType())
                .build();
        return searchCriteriaMapper.toResponse(searchCriteriaRepository.save(criteria));
    }

    public SearchCriteriaResponse update(UUID id, SearchCriteriaRequest request, Student student) {
        SearchCriteria criteria = findByIdAndStudent(id, student);
        criteria.setEntitledPosition(request.entitledPosition());
        criteria.setLocation(request.location());
        criteria.setContractType(request.contractType());
        return searchCriteriaMapper.toResponse(searchCriteriaRepository.save(criteria));
    }

    public void delete(UUID id, Student student) {
        SearchCriteria criteria = findByIdAndStudent(id, student);
        searchCriteriaRepository.delete(criteria);
    }

    private SearchCriteria findByIdAndStudent(UUID id, Student student) {
        return searchCriteriaRepository.findById(id)
                .filter(c -> c.getStudent().getId().equals(student.getId()))
                .orElseThrow(() -> new EntityNotFoundException("SearchCriteria not found: " + id));
    }
}
